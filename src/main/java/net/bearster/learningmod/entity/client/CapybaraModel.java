package net.bearster.learningmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.bearster.learningmod.entity.client.animation.CapybaraAnimations;
import net.bearster.learningmod.entity.custom.CapybaraEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class CapybaraModel extends HierarchicalModel<CapybaraEntity> {

    private final ModelPart body;
    private final ModelPart head;

    public CapybaraModel(ModelPart root) {
        this.body = root.getChild("Body");
        this.head = body.getChild("MainBody").getChild("Head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.5F, 17.95F, -0.75F));

        PartDefinition MainBody = Body.addOrReplaceChild("MainBody", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -1.0F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, -3.5F));

        PartDefinition Fur = MainBody.addOrReplaceChild("Fur", CubeListBuilder.create(), PartPose.offset(-0.3714F, -0.7232F, 1.9786F));

        PartDefinition cube_r1 = Fur.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 20).mirror().addBox(-1.0F, -2.0F, -4.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.7286F, 3.3732F, 1.2714F, 0.0F, 0.0F, 0.0524F));

        PartDefinition cube_r2 = Fur.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 20).mirror().addBox(-1.0F, -2.0F, -4.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0286F, 2.9732F, 1.0714F, 0.0F, 0.0F, 0.3316F));

        PartDefinition cube_r3 = Fur.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 20).mirror().addBox(-1.0F, -2.0F, -4.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0286F, 2.5732F, 1.8714F, 0.0F, 0.0F, 0.2269F));

        PartDefinition cube_r4 = Fur.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(12, 20).addBox(1.0F, -2.0F, -4.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7714F, 2.9732F, 1.2714F, 0.0F, 0.0F, -0.3316F));

        PartDefinition cube_r5 = Fur.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(12, 20).mirror().addBox(-1.0F, -2.0F, -4.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.7286F, 3.7732F, 1.2714F, 0.0F, 0.0F, 0.1571F));

        PartDefinition cube_r6 = Fur.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(12, 20).addBox(1.0F, -2.0F, -4.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7714F, 2.5732F, 1.7714F, 0.0F, 0.0F, -0.2269F));

        PartDefinition cube_r7 = Fur.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(12, 20).addBox(1.0F, -2.0F, -4.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4714F, 3.3732F, 1.2714F, 0.0F, 0.0F, -0.0524F));

        PartDefinition cube_r8 = Fur.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(-2, 28).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2286F, -3.3268F, -1.5286F, 0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r9 = Fur.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(-2, 28).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5714F, -3.3268F, -1.5286F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r10 = Fur.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(-2, 28).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1714F, -3.3268F, -2.2286F, 0.2356F, 0.0F, 0.0F));

        PartDefinition cube_r11 = Fur.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(-2, 28).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5714F, -3.3268F, -2.0286F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r12 = Fur.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(-2, 28).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1714F, -3.3268F, -1.7286F, 0.4102F, 0.0F, 0.0F));

        PartDefinition cube_r13 = Fur.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(-2, 28).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2286F, -3.3268F, -2.0286F, 0.0F, 0.0F, 0.0F));

        PartDefinition cube_r14 = Fur.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(12, 20).addBox(1.0F, -2.0F, -4.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4714F, 3.7732F, 1.2714F, 0.0F, 0.0F, -0.1571F));

        PartDefinition Head = MainBody.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, -1.5F, -4.75F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -2.95F, -0.5F));

        PartDefinition EarL = Head.addOrReplaceChild("EarL", CubeListBuilder.create(), PartPose.offset(1.35F, -1.45F, -1.25F));

        PartDefinition EarL_r1 = EarL.addOrReplaceChild("EarL_r1", CubeListBuilder.create().texOffs(0, 1).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -0.35F, 0.0F, 0.0369F, -0.2062F, -0.1784F));

        PartDefinition EarR = Head.addOrReplaceChild("EarR", CubeListBuilder.create(), PartPose.offset(-1.35F, -1.45F, -1.25F));

        PartDefinition EarR_r1 = EarR.addOrReplaceChild("EarR_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -0.35F, 0.0F, 0.0369F, 0.2062F, 0.1784F));

        PartDefinition LegBR = Body.addOrReplaceChild("LegBR", CubeListBuilder.create().texOffs(16, 14).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 2.55F, 2.95F));

        PartDefinition LegBL = Body.addOrReplaceChild("LegBL", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.9F, 2.55F, 2.95F));

        PartDefinition LegFL = Body.addOrReplaceChild("LegFL", CubeListBuilder.create().texOffs(14, 20).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.9F, 2.55F, -2.35F));

        PartDefinition LegFR = Body.addOrReplaceChild("LegFR", CubeListBuilder.create().texOffs(19, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 2.55F, -2.35F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(CapybaraEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(CapybaraAnimations.ANIM_CAPYBARA_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, CapybaraAnimations.ANIM_CAPYBARA_IDLE, ageInTicks, 1f);

    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45f);

        this.head.xRot = headYaw * ((float)Math.PI / 180f);
        this.head.yRot = headPitch * ((float)Math.PI / 180f);

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }
}
