package com.lopotichaaaa.world;

import com.lopotichaaaa.infinitynbeyond.InfinityAndBeyond;
import com.lopotichaaaa.world.gen.ModOreGeneration;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InfinityAndBeyond.MOD_ID,bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModWorldEvents {



    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event){
        ModOreGeneration.generateOres(event);
    }
}
