package net.CoffeDino.testmod.events;

import net.CoffeDino.testmod.effects.ModEffects;
import net.CoffeDino.testmod.item.Custom.SoulScytheItem;
import net.CoffeDino.testmod.player.ReaperSoulProvider;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ReaperSoulEvents {

    private static final int MAX_STACKS = 10;
    private static final int COOLDOWN = 40;
    private static final float CHANCE = 0.4f;

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (!(event.getEntity().level() instanceof ServerLevel level)) return;
        LivingEntity dead = event.getEntity();
        for (ServerPlayer player : level.players()) {
            if (player.distanceTo(dead) > 32) continue;
            ItemStack stack = player.getMainHandItem();
            if (!(stack.getItem() instanceof SoulScytheItem)) continue;
            player.getCapability(ReaperSoulProvider.SOUL_CAP).ifPresent(data -> {
                long time = level.getGameTime();
                if (time - data.getLastGainTime() < COOLDOWN) return;
                if (player.getRandom().nextFloat() > CHANCE) return;
                data.addStack(MAX_STACKS);
                data.setLastGainTime(time);
                applySoulEffect(player, data.getSoulStacks());
            });
        }
    }

    private static void applySoulEffect(ServerPlayer player, int stacks) {

        int amplifier = Math.min(stacks - 1, 9);

        player.addEffect(new MobEffectInstance(
                ModEffects.SOUL_CLAIM.getHolder().get(),
                300,
                amplifier,
                false,
                true,
                true
        ));
    }
}