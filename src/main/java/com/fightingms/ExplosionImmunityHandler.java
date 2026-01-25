package com.fightingms;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

public class ExplosionImmunityHandler {

    public static void register() {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((LivingEntity entity, DamageSource source, float amount) -> {
            if (source.is(DamageTypeTags.IS_EXPLOSION)) {
                if (entity.hasEffect(FightingmsEffects.FRIEND_OF_THE_BOMBS)) {
                    return false;
                }
            }
            return true;
        });
    }
}
