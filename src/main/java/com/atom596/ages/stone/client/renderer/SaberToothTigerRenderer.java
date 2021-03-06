package com.atom596.ages.stone.client.renderer;

import com.atom596.ages.stone.Reference;
import com.atom596.ages.stone.client.models.SaberToothTigerModel;
import com.atom596.ages.stone.entities.SaberToothTigerEntity;
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
public class SaberToothTigerRenderer extends MobRenderer<SaberToothTigerEntity, SaberToothTigerModel> {
    private static final ResourceLocation SABER_TOOTH_TIGER_TEXTURE = new ResourceLocation(Reference.MODID, "textures/entity/saber_tooth_tiger.png");

    private SaberToothTigerRenderer(@Nonnull EntityRendererManager rendererManager) {
        super(rendererManager, new SaberToothTigerModel(), 0.5f);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(@Nonnull SaberToothTigerEntity entity) {
        return SABER_TOOTH_TIGER_TEXTURE;
    }

    @Override
    protected boolean canRenderName(SaberToothTigerEntity entity) {
        return entity.hasCustomName();
    }

    public static class RenderFactory implements IRenderFactory<SaberToothTigerEntity> {

        @Override
        public EntityRenderer<? super SaberToothTigerEntity> createRenderFor(EntityRendererManager manager) {
            return new SaberToothTigerRenderer(manager);
        }
    }
}
