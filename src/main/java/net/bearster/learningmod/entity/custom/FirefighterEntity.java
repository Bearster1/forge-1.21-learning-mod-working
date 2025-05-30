package net.bearster.learningmod.entity.custom;

import net.bearster.learningmod.block.ModBlocks;
import net.bearster.learningmod.entity.ModEntities;
import net.bearster.learningmod.entity.client.CapybaraVariant;
import net.bearster.learningmod.sound.ModSounds;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class FirefighterEntity extends Animal {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public FirefighterEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new PanicGoal(this, (double)2.0F));
        this.goalSelector.addGoal(2, new BreedGoal(this, (double)1.0F));
        this.goalSelector.addGoal(3, new TemptGoal(this, (double)1.25F, (p_332367_) -> p_332367_.is(ModBlocks.TRIFORCE.get().asItem()), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, (double)1.25F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, (double)1.0F));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes().add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(ModBlocks.TRIFORCE.get().asItem());
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return ModEntities.FIREFIGHTER.get().create(serverLevel);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 20;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    public InteractionResult interactAt(Player pPlayer, Vec3 pVec, InteractionHand pHand) {

        playSound(ModSounds.FIREFIGHTER.get(), 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }


    Random hasFireTruck = new Random();
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pSpawnType, @Nullable SpawnGroupData pSpawnGroupData) {
        if (hasFireTruck.nextBoolean()) {
            ServerLevel level = (ServerLevel) pLevel;

            FireTruckEntity fireTruck = ModEntities.FIRE_TRUCK.get().create(level); // Use your registered entity
            fireTruck.finalizeSpawn(level, level.getCurrentDifficultyAt(BlockPos.containing(this.getX(), this.getY(), this.getZ())), MobSpawnType.SPAWN_EGG, null);

            if (fireTruck != null) {
                fireTruck.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
                level.addFreshEntity(fireTruck);
                this.startRiding(fireTruck);
            }
        }

        return super.finalizeSpawn(pLevel, pDifficulty, pSpawnType, pSpawnGroupData);
    }

    public void ride(FireTruckEntity fireTruck) {
        this.startRiding(fireTruck);
    }
}
