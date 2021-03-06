package com.atom596.ages.stone.subscribers;

import com.atom596.ages.stone.blocks.FeederContainer;
import com.atom596.ages.stone.blocks.FishingNetContainer;
import com.atom596.ages.stone.blocks.MillstoneContainer;
import com.atom596.ages.stone.blocks.StoneChestContainer;
import com.atom596.ages.stone.items.BackpakcContainer;
import com.atom596.ages.stone.items.StoneTabletContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nonnull;

import static com.atom596.ages.stone.Reference.*;

@ObjectHolder(MODID)
@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ContainerSubscriber {
    public static final ContainerType<StoneChestContainer> stone_chest = IForgeContainerType.create(StoneChestContainer::new);
    public static final ContainerType<FeederContainer> feeder = IForgeContainerType.create(FeederContainer::new);
    public static final ContainerType<MillstoneContainer> millstone = IForgeContainerType.create(MillstoneContainer::new);
    public static final ContainerType<BackpakcContainer> backpack = IForgeContainerType.create(BackpakcContainer::new);
    public static final ContainerType<StoneTabletContainer> stone_tablet = IForgeContainerType.create(StoneTabletContainer::new);
    public static final ContainerType<FishingNetContainer> fishing_net = IForgeContainerType.create(FishingNetContainer::new);

    @SubscribeEvent
    public static void registerContainer(@Nonnull RegistryEvent.Register<ContainerType<?>> event) {
        IForgeRegistry<ContainerType<?>> registry = event.getRegistry();
        registry.register(stone_chest.setRegistryName(MODID, "stone_chest"));
        registry.register(feeder.setRegistryName(MODID, "feeder"));
        registry.register(millstone.setRegistryName(MODID, "millstone"));
        registry.register(backpack.setRegistryName(MODID, "backpack"));
        registry.register(stone_tablet.setRegistryName(MODID, "stone_tablet"));
        registry.register(fishing_net.setRegistryName(MODID, "fishing_net"));
    }
}