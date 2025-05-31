package net.bearster.learningmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.entity.custom.WarturtleEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WarturtleRenderer extends MobRenderer<WarturtleEntity, WarturtleModel<WarturtleEntity>> {
    public WarturtleRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new WarturtleModel<>(pContext.bakeLayer(ModModelLayers.WARTURTLE)), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(WarturtleEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "textures/entity/warturtle/warturtle.png");
    }

    @Override
    public void render(WarturtleEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.45f, 0.45f, 0.45f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
