package com.atom596.ages.stone.items;

import com.mojang.blaze3d.platform.GlStateManager;
import com.atom596.ages.stone.Reference;
import com.atom596.ages.api.manual.ManualWidget;
import com.atom596.ages.stone.recipes.handlers.*;
import com.atom596.ages.stone.subscribers.RecipeSubscriber;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nonnull;

public class StoneTabletGui extends ContainerScreen<Container> {
    private final ResourceLocation GUI = new ResourceLocation(Reference.MODID, "textures/gui/manual/stone_tablet.png");

    private final ManualWidget manual;

    public StoneTabletGui(@Nonnull Container screenContainer, @Nonnull PlayerInventory inv, @Nonnull ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        xSize = 210;
        ySize = 240;

        manual = new ManualWidget(this, 210, 220);

        manual.addRecipeHandler(RecipeSubscriber.flint_workbench, new FlintWorkbenchRecipeHandler());
        manual.addRecipeHandler(RecipeSubscriber.drying_rack, new DryingRackRecipeHandler());
        manual.addRecipeHandler(RecipeSubscriber.tanning_rack, new TanningRackRecipeHandler());
        manual.addRecipeHandler(RecipeSubscriber.tree_stump, new TreeStumpRecipeHandler());
        manual.addRecipeHandler(RecipeSubscriber.millstone, new MillstoneRecipeHandler());

        manual.buildFromResources(new ResourceLocation(Reference.MODID, "lang/book_en_us.json"));
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
        manual.render(this, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        if (minecraft == null) {
            return;
        }

        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        minecraft.getTextureManager().bindTexture(GUI);
        blit(guiLeft, guiTop, 0, 0, 0, 210, 220, 255, 255);

        manual.drawBackgroundLayer(this, mouseX, mouseY);
    }

    @Override
    public boolean mouseClicked(double x, double y, int button) {
        if (!manual.mouseClicked((int) Math.round(x), (int) Math.round(y), button)) {
            return super.mouseClicked(x, y, button);
        }

        return true;
    }

    @Override
    public void mouseMoved(double x, double y) {
        super.mouseMoved(x, y);
        manual.mouseMoved((int) Math.round(x), (int) Math.round(y));
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int p_keyPressed_3_) {
        return super.keyPressed(keyCode, scanCode, p_keyPressed_3_);
    }

    @Override
    public void init(@Nonnull Minecraft minecraft, int width, int height) {
        super.init(minecraft, width, height);
        manual.setPos(guiLeft, guiTop);
    }
}
