package com.lopotichaaaa.infinitynbeyond.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;

public class EndInfuserBlock extends Block {

    static final BooleanProperty INFUSING = BooleanProperty.create("infusing");
    public EndInfuserBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(INFUSING,Boolean.valueOf(false)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(INFUSING);
    }

}
