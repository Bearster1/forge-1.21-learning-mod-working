package net.bearster.learningmod.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.entity.custom.FirefighterEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FirefighterRenderer extends MobRenderer<FirefighterEntity, FirefighterModel> {

    public FirefighterRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FirefighterModel(pContext.bakeLayer(ModModelLayers.FIREFIGHTER)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(FirefighterEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "textures/entity/firefighter/firefighter.png");
    }

    @Override
    public void render(FirefighterEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
