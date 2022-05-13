package com.atom596.ages.stone.proxy;

import com.atom596.ages.stone.blocks.*;
import com.atom596.ages.stone.client.renderer.*;
import com.atom596.ages.stone.entities.*;
import com.atom596.ages.stone.items.BackpackGui;
import com.atom596.ages.stone.items.StoneTabletGui;
import com.atom596.ages.stone.subscribers.ContainerSubscriber;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import javax.annotation.Nullable;

public class ClientProxy implements IProxy {

    @Override
    public void init() {
        ScreenManager.registerFactory(ContainerSubscriber.stone_chest, StoneChestGui::new);
        ScreenManager.registerFactory(ContainerSubscriber.feeder, FeederGui::new);
        ScreenManager.registerFactory(ContainerSubscriber.millstone, MillstoneGui::new);
        ScreenManager.registerFactory(ContainerSubscriber.backpack, BackpackGui::new);
        ScreenManager.registerFactory(ContainerSubscriber.stone_tablet, StoneTabletGui::new);
        ScreenManager.registerFactory(ContainerSubscriber.fishing_net, FishingNetGui::new);

        RenderingRegistry.registerEntityRenderingHandler(DeerEntity.class, new DeerRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(BoarEntity.class, new BoarRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(AurochEntity.class, new AurochRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(FowlEntity.class, new FowlRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(MouflonEntity.class, new MouflonRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(FlintSpearEntity.class, new FlintSpearRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(MammothEntity.class, new MammothRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(SaberToothTigerEntity.class, new SaberToothTigerRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(WoollyRhinoEntity.class, new WoollyRhinoRenderer.RenderFactory());

        ClientRegistry.bindTileEntitySpecialRenderer(FlintWorkbenchTileEntity.class, new FlintWorkbenchRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(DryingRackTileEntity.class, new DryingRackRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TanningRackTileEntity.class, new TanningRackRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(StoneChestTileEntity.class, new StoneChestRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TreeStumpTileEntity.class, new TreeStumpRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(AqueductTileEntity.class, new AqueductRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(FeederTileEntity.class, new FeederRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(MillstoneTileEntity.class, new MillstoneRenderer());
    }

    @Override
    @Nullable
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

    @Override
    @Nullable
    public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
    }
}
