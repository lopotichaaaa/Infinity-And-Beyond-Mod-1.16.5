package com.lopotichaaaa.infinitynbeyond.tileentities;

import com.lopotichaaaa.infinitynbeyond.InfinityAndBeyond;
import com.lopotichaaaa.infinitynbeyond.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, InfinityAndBeyond.MOD_ID);

    public static RegistryObject<TileEntityType<EndInfuserTile>> End_INFUSER_TILE =
            TILE_ENTITIES.register("end_infuser_tile", () -> TileEntityType.Builder.create(
                    EndInfuserTile::new, ModBlocks.END_INFUSER_BLOCK.get()).build(null));



    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
