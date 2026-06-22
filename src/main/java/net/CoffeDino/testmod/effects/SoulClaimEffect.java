package net.CoffeDino.testmod.effects;

import net.CoffeDino.testmod.Lunacy;
import net.CoffeDino.testmod.attributes.ModAttributes;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.HashMap;
import java.util.Map;

public class SoulClaimEffect extends MobEffect {

    private static final ResourceLocation DAMAGE_MODIFIER_ID =
            ResourceLocation.fromNamespaceAndPath(Lunacy.MOD_ID, "soul_claim_damage");

    private static final ResourceLocation ARMOR_MODIFIER_ID =
            ResourceLocation.fromNamespaceAndPath(Lunacy.MOD_ID, "soul_claim_armor");

    private static final ResourceLocation SPEED_MODIFIER_ID =
            ResourceLocation.fromNamespaceAndPath(Lunacy.MOD_ID, "soul_claim_speed");

    private static final ResourceLocation SWEEP_MODIFIER_ID =
            ResourceLocation.fromNamespaceAndPath(Lunacy.MOD_ID, "soul_claim_sweep");

    public SoulClaimEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x4B0082);

        this.addAttributeModifier(
                Attributes.ATTACK_DAMAGE,
                DAMAGE_MODIFIER_ID,
                0.05,
                AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
        );

        this.addAttributeModifier(
                Attributes.ARMOR,
                ARMOR_MODIFIER_ID,
                1.0,
                AttributeModifier.Operation.ADD_VALUE
        );

        this.addAttributeModifier(
                Attributes.MOVEMENT_SPEED,
                SPEED_MODIFIER_ID,
                0.02,
                AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
        );

        this.addAttributeModifier(
                ModAttributes.SWEEP_RANGE.getHolder().get(),
                SWEEP_MODIFIER_ID,
                0.5,
                AttributeModifier.Operation.ADD_VALUE
        );
    }
}