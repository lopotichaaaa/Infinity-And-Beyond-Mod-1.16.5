package com.lopotichaaaa.world.gen;

import com.lopotichaaaa.infinitynbeyond.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OreType {

    //I set 5 for vein size because 2 creates no vein
    END_ESSENCE(Lazy.of(ModBlocks.END_ESSENCE_ORE), 5, 10, 100,8)
    ;

    private final Lazy<Block> block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;
    private final int veinsPerChunck;




    OreType(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight, int veinsPerChunck) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.veinsPerChunck = veinsPerChunck;
    }

    public int getVeinsPerChunck() {
        return veinsPerChunck;
    }

    public Lazy<Block> getBlock() {
        return block;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public static OreType get(Block block){
        for (OreType ore: values()){
            if (block==ore.block){
                return ore;
            }
        }
        return null;
    }
}
