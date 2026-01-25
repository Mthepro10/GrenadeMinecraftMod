package com.fightingms;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class FriendOfTheBombsEff extends MobEffect {
    protected FriendOfTheBombsEff() {
        super(MobEffectCategory.BENEFICIAL, 0xcac8ca);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(ServerLevel world, LivingEntity entity, int amplifier) {
        if (entity instanceof Player) {
            ((Player) entity).giveExperiencePoints(1 << amplifier);
        }

        return super.applyEffectTick(world, entity, amplifier);
    }
}