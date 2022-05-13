package com.atom596.ages.api.subscribers;

import com.atom596.ages.api.utils.AgeUtils;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.atom596.ages.api.Reference.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber {

    @SubscribeEvent
    public static void setupPlayerAge(PlayerEvent.PlayerLoggedInEvent event) {
        AgeUtils.initPlayerAge(event.getPlayer());
    }
}
