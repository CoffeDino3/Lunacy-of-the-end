package net.CoffeDino.testmod.events;

import net.CoffeDino.testmod.player.ReaperSoulProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CapabilityEvents {

    @SubscribeEvent
    public static void attachCaps(AttachCapabilitiesEvent<Entity> event) {

        if (event.getObject() instanceof Player player) {
            event.addCapability(
                    ResourceLocation.fromNamespaceAndPath("lunacy","reaper_souls"),
                    new ReaperSoulProvider()
            );
        }
    }
}