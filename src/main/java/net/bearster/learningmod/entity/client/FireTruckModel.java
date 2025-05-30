package net.bearster.learningmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.bearster.learningmod.entity.client.animation.FireTruckAnimations;
import net.bearster.learningmod.entity.client.animation.GiraffeAnimations;
import net.bearster.learningmod.entity.custom.FireTruckEntity;
import net.bearster.learningmod.entity.custom.FirefighterEntity;
import net.bearster.learningmod.entity.custom.GiraffeEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class FireTruckModel<T extends  FireTruckEntity> extends HierarchicalModel<T>  {

    private final ModelPart body;

    public FireTruckModel(ModelPart root) {
        this.body = root.getChild("body");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition leftwheel = body.addOrReplaceChild("leftwheel", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 3.0F));

        PartDefinition leftfrontwheel = leftwheel.addOrReplaceChild("leftfrontwheel", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 0.0F, -1.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition leftfrontwheelrim = leftfrontwheel.addOrReplaceChild("leftfrontwheelrim", CubeListBuilder.create().texOffs(16, 31).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 27).addBox(-4.0F, -3.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 27).addBox(-4.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 27).addBox(-4.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, 0.0F));

        PartDefinition leftfrontwheelwheel = leftfrontwheel.addOrReplaceChild("leftfrontwheelwheel", CubeListBuilder.create().texOffs(24, 25).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -1.5F, -0.5F));

        PartDefinition leftbackwheel = leftwheel.addOrReplaceChild("leftbackwheel", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leftbackwheelrim = leftbackwheel.addOrReplaceChild("leftbackwheelrim", CubeListBuilder.create().texOffs(20, 31).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 27).addBox(-5.0F, -4.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 29).addBox(-5.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 31).addBox(-5.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leftbackwheelwheel = leftbackwheel.addOrReplaceChild("leftbackwheelwheel", CubeListBuilder.create().texOffs(0, 29).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -1.5F, -0.5F));

        PartDefinition rightwheel = body.addOrReplaceChild("rightwheel", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -3.0F));

        PartDefinition rightfrontwheel = rightwheel.addOrReplaceChild("rightfrontwheel", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 0.0F, -1.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition rightfrontwheelrim = rightfrontwheel.addOrReplaceChild("rightfrontwheelrim", CubeListBuilder.create().texOffs(32, 23).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 29).addBox(-5.0F, -4.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 10).addBox(-5.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 36).addBox(-5.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightfrontwheelwheel = rightfrontwheel.addOrReplaceChild("rightfrontwheelwheel", CubeListBuilder.create().texOffs(26, 29).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -1.5F, -0.5F));

        PartDefinition rightbackwheel = rightwheel.addOrReplaceChild("rightbackwheel", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightbackwheelrim = rightbackwheel.addOrReplaceChild("rightbackwheelrim", CubeListBuilder.create().texOffs(12, 36).addBox(-5.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 12).addBox(-5.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(30, 17).addBox(-5.0F, -4.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 33).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightbackwheelwheel = rightbackwheel.addOrReplaceChild("rightbackwheelwheel", CubeListBuilder.create().texOffs(30, 19).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -1.5F, -0.5F));

        PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 10).addBox(-6.0F, -2.0F, -3.0F, 13.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(16, 35).addBox(-6.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-6.0F, -5.0F, -4.0F, 13.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 17).addBox(-1.0F, -6.0F, -4.0F, 8.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(8, 29).addBox(6.0F, -7.0F, -2.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(12, 33).addBox(-6.0F, -2.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 33).addBox(-6.0F, -2.0F, -4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 33).addBox(6.0F, -2.0F, -4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 33).addBox(6.0F, -2.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 33).addBox(0.0F, -2.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 33).addBox(0.0F, -2.0F, -4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

        PartDefinition ladder = body.addOrReplaceChild("ladder", CubeListBuilder.create().texOffs(0, 25).addBox(-2.5F, -0.5F, -1.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 25).addBox(-2.5F, -0.5F, 0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 35).addBox(0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 36).addBox(-1.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -7.5F, -0.5F));

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(2, 1).addBox(2.0F, -8.0F, -1.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(FireTruckEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animateWalk(FireTruckAnimations.ANIM_FIRE_TRUCK_WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
        // this.animate(entity.idleAnimationState, FireTruckAnimations.ANIM_FIRE_TRUCK_IDLE, ageInTicks, 1f);
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
