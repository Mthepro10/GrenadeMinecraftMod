package com.fightingms;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class GrenadeEntity extends ThrowableItemProjectile {

    public GrenadeEntity(EntityType<GrenadeEntity> type, Level level) {
        super(type, level);
    }

    public GrenadeEntity(Level level, LivingEntity owner, ItemStack stack) {
        super(ModEntities.GRENADE, owner, level, stack);
    }

    public GrenadeEntity(Level level, double x, double y, double z, ItemStack stack) {
        super(ModEntities.GRENADE, x, y, z, level, stack);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.GRENADE;
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        explode();
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        explode();
    }

    private void explode() {
        if (!this.level().isClientSide()) {
            this.level().explode(
                    this,
                    this.getX(),
                    this.getY(),
                    this.getZ(),
                    3.0F,
                    Level.ExplosionInteraction.MOB
            );
            this.discard();
        }
    }

    @Override
    public void handleEntityEvent(byte b) {
        if (b == 3) {
            for (int i = 0; i < 20; i++) {
                this.level().addParticle(
                        ParticleTypes.EXPLOSION,
                        this.getX(),
                        this.getY(),
                        this.getZ(),
                        0.0, 0.0, 0.0
                );
            }
        }
    }
}
