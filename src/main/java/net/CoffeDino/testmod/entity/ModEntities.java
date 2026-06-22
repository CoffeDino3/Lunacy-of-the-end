package net.CoffeDino.testmod.entity;

import net.CoffeDino.testmod.Lunacy;
import net.CoffeDino.testmod.entity.abilities.AngelbornAbilityEntity;
import net.CoffeDino.testmod.entity.abilities.GatekeeperPortalEntity;
import net.CoffeDino.testmod.entity.abilities.GatekeeperProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraftforge.registries.ForgeRegistries.Keys.ENTITY_TYPES;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Lunacy.MOD_ID);

    public static final RegistryObject<EntityType<AngelbornAbilityEntity>> ANGELBORN_ABILITY =
            ENTITIES.register("angelborn_ability",
                    () -> EntityType.Builder.<AngelbornAbilityEntity>of(AngelbornAbilityEntity::new, MobCategory.MISC)
                            .sized(1.0f, 0.1f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("angelborn_ability"));
    public static final RegistryObject<EntityType<LamentBulletEntity>> LAMENT_BULLET =
            ENTITIES.register("lament_bullet",
                    () -> EntityType.Builder.<LamentBulletEntity>of(LamentBulletEntity::new, MobCategory.MISC)
                            .sized(0.25f, 0.25f)
                            .clientTrackingRange(4)
                            .updateInterval(1)
                            .build("lament_bullet"));
    public static final RegistryObject<EntityType<FireSpearEntity>> FIRE_SPEAR = ENTITIES.register("fire_spear",
            () -> EntityType.Builder.<FireSpearEntity>of(FireSpearEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build("fire_spear"));
    public static final RegistryObject<EntityType<GatekeeperPortalEntity>> GATEKEEPER_PORTAL =
            ENTITIES.register("gatekeeper_portal",
                    () -> EntityType.Builder.<GatekeeperPortalEntity>of(GatekeeperPortalEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(64)
                            .updateInterval(1)
                            .build("gatekeeper_portal"));

    public static final RegistryObject<EntityType<GatekeeperProjectileEntity>> GATEKEEPER_PROJECTILE =
            ENTITIES.register("gatekeeper_projectile",
                    () -> EntityType.Builder.<GatekeeperProjectileEntity>of(GatekeeperProjectileEntity::new, MobCategory.MISC)
                            .sized(0.25f, 0.25f)
                            .clientTrackingRange(64)
                            .updateInterval(1)
                            .build("gatekeeper_projectile"));
    public static final RegistryObject<EntityType<ShiArrowEntity>> SHI_ARROW =
            ENTITIES.register("shi_arrow",
                    () -> EntityType.Builder.<ShiArrowEntity>of(ShiArrowEntity::new, MobCategory.MISC)
                            .sized(0.5F, 0.5F)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("shi_arrow"));
}