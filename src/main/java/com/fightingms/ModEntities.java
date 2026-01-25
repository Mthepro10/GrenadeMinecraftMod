package com.fightingms;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {

    public static final ResourceKey<EntityType<?>> GRENADE_KEY =
            ResourceKey.create(
                    Registries.ENTITY_TYPE,
                    Identifier.fromNamespaceAndPath(Fightingms.MOD_ID, "grenade")
            );

    public static final EntityType<GrenadeEntity> GRENADE =
            Registry.register(
                    BuiltInRegistries.ENTITY_TYPE,
                    GRENADE_KEY,
                    FabricEntityTypeBuilder
                            .<GrenadeEntity>create(
                                    MobCategory.MISC,
                                    (type, level) -> new GrenadeEntity(type, level)
                            )
                            .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                            .trackRangeBlocks(4)
                            .trackedUpdateRate(10)
                            .build(GRENADE_KEY)
            );

    public static void initialize() {}
}
