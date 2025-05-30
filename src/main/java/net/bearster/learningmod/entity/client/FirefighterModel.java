package net.bearster.learningmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.bearster.learningmod.entity.client.animation.CapybaraAnimations;
import net.bearster.learningmod.entity.client.animation.FirefighterAnimations;
import net.bearster.learningmod.entity.custom.FirefighterEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class FirefighterModel extends HierarchicalModel<FirefighterEntity> {

    private final ModelPart body;
    private final ModelPart head;

    public FirefighterModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = body.getChild("neck").getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create(), PartPose.offset(-5.0F, -16.0F, 1.0F));

        PartDefinition cube_r1 = rightarm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 16).addBox(-9.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -1.3526F));

        PartDefinition leftarm = body.addOrReplaceChild("leftarm", CubeListBuilder.create(), PartPose.offset(5.0F, -17.0F, 1.0F));

        PartDefinition cube_r2 = leftarm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(24, 20).addBox(-1.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.309F));

        PartDefinition leftleg = body.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(24, 24).addBox(-1.0F, 5.0F, -4.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(14, 27).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -7.0F, 1.0F));

        PartDefinition rightleg = body.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, 5.0F, -4.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(28, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -7.0F, 1.0F));

        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(6, 46).addBox(-1.0F, -20.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(30, 52).addBox(-4.0F, -7.0F, -5.0F, 8.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 57).addBox(-3.0F, -9.0F, -4.0F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -19.0F, 1.0F));

        PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -19.0F, -1.0F, 10.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(FirefighterEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(FirefighterAnimations.ANIM_FIREFIGHTER_WALKING, limbSwing, limbSwingAmount, 1f, 2.5f);
        // this.animate(entity.idleAnimationState, FirefighterAnimations.ANIM_FIREFIGHTER_IDLE, ageInTicks, 1f);
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
