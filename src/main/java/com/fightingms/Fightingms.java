package com.fightingms;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;

public class Fightingms implements ModInitializer {

    public static final String MOD_ID = "fightingms";

    public static final Potion FRIEND_OF_THE_BOMBS =
            Registry.register(
                    BuiltInRegistries.POTION,
                    Identifier.fromNamespaceAndPath(Fightingms.MOD_ID, "friend_of_the_bombs"),
                    new Potion("friend_of_the_bombs",
                            new MobEffectInstance(
                                    FightingmsEffects.FRIEND_OF_THE_BOMBS,
                                    40,
                                    0)));

    @Override
    public void onInitialize() {
        ExplosionImmunityHandler.register();
        ModItems.initialize();
        ModEntities.initialize();

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT)
                .register(entries -> entries.accept(ModItems.GRENADE));

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((itemGroup) -> itemGroup.accept(ModItems.WHISTLE));

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.addMix(
                    Potions.AWKWARD,
                    Items.FLINT,
                    BuiltInRegistries.POTION.wrapAsHolder(FRIEND_OF_THE_BOMBS)
            );
        });
    }
}
