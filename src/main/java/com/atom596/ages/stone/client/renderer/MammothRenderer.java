package com.atom596.ages.stone.client.renderer;

import com.atom596.ages.stone.Reference;
import com.atom596.ages.stone.client.models.MammothModel;
import com.atom596.ages.stone.entities.MammothEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class MammothRenderer extends MobRenderer<MammothEntity, MammothModel> {
    private static final ResourceLocation MAMMOTH_TEXTURE = new ResourceLocation(Reference.MODID, "textures/entity/mammoth.png");

    private MammothRenderer(@Nonnull EntityRendererManager rendererManager) {
        super(rendererManager, new MammothModel(), 1.0f);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(@Nonnull MammothEntity entity) {
        return MAMMOTH_TEXTURE;
    }

    @Override
    protected boolean canRenderName(MammothEntity entity) {
        return entity.hasCustomName();
    }

    public static class RenderFactory implements IRenderFactory<MammothEntity> {

        @Override
        public EntityRenderer<? super MammothEntity> createRenderFor(EntityRendererManager manager) {
            return new MammothRenderer(manager);
        }
    }
}
