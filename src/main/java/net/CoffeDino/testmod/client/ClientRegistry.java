package net.CoffeDino.testmod.client;

import net.CoffeDino.testmod.Lunacy;
import net.CoffeDino.testmod.client.gui.SculkStorageScreen;
import net.CoffeDino.testmod.client.model.Shi_arrows;
import net.CoffeDino.testmod.entity.ModEntities;
import net.CoffeDino.testmod.item.ModItems;
import net.CoffeDino.testmod.menu.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.CoffeDino.testmod.renderer.ShiArrowRenderer;

@Mod.EventBusSubscriber(modid = Lunacy.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRegistry {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(ModMenuTypes.SCULK_STORAGE.get(), SculkStorageScreen::new);

            ItemProperties.register(ModItems.SHI_BOW.get(),
                    ResourceLocation.fromNamespaceAndPath("minecraft", "pull"),
                    (stack, level, entity, seed) -> {
                        if (entity == null) return 0.0F;
                        return entity.getUseItem() != stack ? 0.0F
                                : (float)(stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / 20.0F;
                    });

            ItemProperties.register(ModItems.SHI_BOW.get(),
                    ResourceLocation.fromNamespaceAndPath("minecraft", "pulling"),
                    (stack, level, entity, seed) ->
                            entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);
            EntityRenderers.register(ModEntities.SHI_ARROW.get(), ShiArrowRenderer::new);

        });
    }
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(Shi_arrows.LAYER_LOCATION, Shi_arrows::createBodyLayer);
    }
}