package com.lopotichaaaa.infinitynbeyond.screan;

import com.lopotichaaaa.infinitynbeyond.InfinityAndBeyond;
import com.lopotichaaaa.infinitynbeyond.container.EndInfuserContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class EndInfuserScreen extends ContainerScreen<EndInfuserContainer> {


    private final ResourceLocation GUI = new ResourceLocation(InfinityAndBeyond.MOD_ID,
            "textures/gui/end_infuser_gui.png");
    public EndInfuserScreen(EndInfuserContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {

        super(screenContainer, inv, titleIn);
        this.ySize = 184;
        this.playerInventoryTitleY = this.ySize - 94;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX,mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1f,1f,1f,1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, i, j, 0, 0, this.xSize, this.ySize);

    }
}
