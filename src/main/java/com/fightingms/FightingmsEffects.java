package com.fightingms;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;

public class FightingmsEffects implements ModInitializer {
    public static final Holder<MobEffect> FRIEND_OF_THE_BOMBS =
            Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(Fightingms.MOD_ID, "friend_of_the_bombs"), new FriendOfTheBombsEff());

    @Override
    public void onInitialize() {
    }
}