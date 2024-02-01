package com.lopotichaaaa.infinitynbeyond.tileentities;

import com.lopotichaaaa.infinitynbeyond.data.recipes.EndInfusionRecipe;
import com.lopotichaaaa.infinitynbeyond.data.recipes.ModRecipeTypes;
import com.lopotichaaaa.infinitynbeyond.item.ModItems;
import com.lopotichaaaa.infinitynbeyond.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IIntArray;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.lwjgl.system.CallbackI;

import javax.annotation.Nonnull;
import java.util.Optional;

public class EndInfuserTile extends TileEntity implements ITickableTileEntity {

    private final ItemStackHandler itemHandler = createHandler();
    private int infusionTime;
    private int infusionTimeTotal;
    private int essenceStored;
    private static final int maxEssence = 1024;

    public final IIntArray data = new IIntArray() {
        @Override
        public int get(int index) {
            switch (index){
                case 0: return infusionTime;
                case 1: return infusionTimeTotal;
                case 2: return essenceStored;
                default: return maxEssence;
            }
        }

        @Override
        public void set(int index, int value) {

        }

        @Override
        public int size() {
            return 4;
        }
    };

    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public EndInfuserTile(TileEntityType<?> typeIn) {
        super(typeIn);
    }
    public EndInfuserTile(){
        this(ModTileEntities.End_INFUSER_TILE.get());
    }


    private ItemStackHandler createHandler() {
        return new ItemStackHandler(3){
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                switch (slot){
                    case 0: return stack.getItem() == ModItems.END_ESSENCE.get();
                    case 1:
                    case 2:
                        return stack.getItem().isIn(ModTags.Items.INFUSABLE);
                    default: return false;
                }

            }

            @Override
            public int getSlotLimit(int slot) {
                switch (slot){
                    case 0: return 64;
                    case 1:
                    case 2:
                        return 1;
                    default: return 0;
                }
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if(!isItemValid(slot,stack)){
                    return stack;
                }

                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return handler.cast();
        }

        return super.getCapability(cap);
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        essenceStored = nbt.getInt("essence");
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inv",itemHandler.serializeNBT());
        compound.putInt("essence",essenceStored);
        return super.write(compound);
    }


    public void infuse(){

        Inventory inv = new Inventory(itemHandler.getSlots());
        for (int i=0; i<itemHandler.getSlots();i++){
            inv.setInventorySlotContents(i, itemHandler.getStackInSlot(i));
        }

        Optional<EndInfusionRecipe> recipe = world.getRecipeManager()
                .getRecipe(ModRecipeTypes.END_INFUSION_RECIPE,inv,world);

        recipe.ifPresent(iRecipe -> {
            if (iRecipe.getEssence()>essenceStored || !itemHandler.getStackInSlot(2).isEmpty()){
                return;
            }
            ItemStack output = iRecipe.getRecipeOutput();

            infuseTheItem(output, iRecipe.getEssence());

            playInfusingSond();
            markDirty();
        });
    }

    private void playInfusingSond(){
        world.playSound(null,pos, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.BLOCKS,1f,1f);
    }

    private void infuseTheItem(ItemStack output,int essenceConsumed) {
        itemHandler.extractItem(1,1,false);
        essenceStored -= essenceConsumed;
        itemHandler.insertItem(2,output,false);

    }

    @Override
    public void tick() {
        if (world.isRemote){
            return;
        }
        if(itemHandler.getStackInSlot(0).getCount()>0 && essenceStored<maxEssence){
            itemHandler.getStackInSlot(0).shrink(1);
            essenceStored++;
        }

        infuse();
    }
}
