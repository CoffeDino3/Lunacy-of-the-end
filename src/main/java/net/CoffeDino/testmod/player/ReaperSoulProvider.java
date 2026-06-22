package net.CoffeDino.testmod.player;

import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

public class ReaperSoulProvider implements ICapabilityProvider {

    public static final Capability<ReaperSoulData> SOUL_CAP =
            CapabilityManager.get(new CapabilityToken<>() {});

    private final ReaperSoulData data = new ReaperSoulData();
    private final LazyOptional<ReaperSoulData> optional = LazyOptional.of(() -> data);

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == SOUL_CAP ? optional.cast() : LazyOptional.empty();
    }
}