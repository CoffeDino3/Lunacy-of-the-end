package net.CoffeDino.testmod.item.Custom;

import net.CoffeDino.testmod.client.gui.RaceSelectionScreen;
import net.CoffeDino.testmod.races.races;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RaceResetScrollItem extends Item {
    public RaceResetScrollItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (level.isClientSide()) {
            races.setClientRace(null);
            races.resetClientRace();
            Minecraft.getInstance().setScreen(new RaceSelectionScreen());
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }
        } else {
            races.clearPlayerRace(player);
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }
            player.sendSystemMessage(net.minecraft.network.chat.Component.literal("Your race has been reset! Choose a new one."));
        }

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}