package com.lopotichaaaa.infinitynbeyond.container;

import com.lopotichaaaa.infinitynbeyond.InfinityAndBeyond;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers {

    public static DeferredRegister<ContainerType<?>> CONTAINERS
            = DeferredRegister.create(ForgeRegistries.CONTAINERS, InfinityAndBeyond.MOD_ID);

    public static final RegistryObject<ContainerType<EndInfuserContainer>> END_INFUSER_CONTAINER
            = CONTAINERS.register("end_infuser_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                System.out.println(data==null);
                assert data != null;
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new EndInfuserContainer(windowId, world, pos, inv, inv.player);
            })));


    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
