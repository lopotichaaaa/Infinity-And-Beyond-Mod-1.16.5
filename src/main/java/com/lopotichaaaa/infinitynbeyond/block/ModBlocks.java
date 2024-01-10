package com.lopotichaaaa.infinitynbeyond.block;

import com.lopotichaaaa.infinitynbeyond.InfinityAndBeyond;
import com.lopotichaaaa.infinitynbeyond.block.custom.EndInfuserBlock;
import com.lopotichaaaa.infinitynbeyond.item.ModItems;
import com.lopotichaaaa.infinitynbeyond.item.ModItemsGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InfinityAndBeyond.MOD_ID);

    public static final RegistryObject<Block> END_ESSENCE_ORE = registerBlock("end_essence_ore",
            ()-> new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(8f)));

    public static final RegistryObject<Block> END_INFUSER_BLOCK = registerBlock("end_infuser",
            ()-> new EndInfuserBlock(AbstractBlock.Properties.create(Material.IRON).harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE).hardnessAndResistance(4f)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name,() -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemsGroup.INFINITY_AND_BEYOND)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
