package net.CoffeDino.testmod.attributes;

import net.CoffeDino.testmod.Lunacy;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModAttributes {
    public static final DeferredRegister<Attribute> ATTRIBUTES =
            DeferredRegister.create(Registries.ATTRIBUTE, Lunacy.MOD_ID);

    public static final RegistryObject<Attribute> SWEEP_RANGE = ATTRIBUTES.register(
            "sweep_range",
            () -> new RangedAttribute(
                    "attribute.name.lunacy.sweep_range",
                    0.0,
                    0.0,
                    100.0
            ).setSyncable(true)
    );
}