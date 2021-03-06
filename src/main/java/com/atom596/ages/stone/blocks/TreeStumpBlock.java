package com.atom596.ages.stone.blocks;

import com.atom596.ages.stone.compatibility.top.TopBlockInfoProvider;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemTier;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TreeStumpBlock extends Block implements TopBlockInfoProvider {
    private static final VoxelShape SHAPE = VoxelShapes.or(Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
            Block.makeCuboidShape(2, 1, 2, 14, 12, 14));

    public TreeStumpBlock() {
        super(Properties.create(Material.WOOD).harvestLevel(ItemTier.WOOD.getHarvestLevel()).harvestTool(ToolType.AXE).hardnessAndResistance(2.0f));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TreeStumpTileEntity();
    }

    @Nonnull
    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        return SHAPE;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onBlockClicked(@Nonnull BlockState state, World worldIn, @Nonnull BlockPos pos, @Nonnull PlayerEntity player) {
        if (!worldIn.isRemote) {
            TreeStumpTileEntity tileEntity = (TreeStumpTileEntity) worldIn.getTileEntity(pos);

            if (tileEntity != null) {
                tileEntity.onBlockRightClicked(player);
                return;
            }
        }

        super.onBlockClicked(state, worldIn, pos, player);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onBlockActivated(@Nonnull BlockState state, World worldIn, @Nonnull BlockPos pos, @Nonnull PlayerEntity player,
                                    @Nonnull Hand handIn, @Nonnull BlockRayTraceResult hit) {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if ((tileentity instanceof TreeStumpTileEntity) && !worldIn.isRemote && (handIn == Hand.MAIN_HAND)) {
            ((TreeStumpTileEntity) tileentity).blockActivated(player);
        }

        return true; // do not show ghost item
    }

    @SuppressWarnings("deprecation")
    @OnlyIn(Dist.CLIENT)
    @Override
    public boolean hasCustomBreakingProgress(@Nonnull BlockState state) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    public float getPlayerRelativeBlockHardness(@Nonnull BlockState state, @Nonnull PlayerEntity player, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if ((tileentity instanceof TreeStumpTileEntity) && ((TreeStumpTileEntity) tileentity).hasTool(player.getHeldItemMainhand())) {
            return 0.0f;
        }

        return super.getPlayerRelativeBlockHardness(state, player, worldIn, pos);
    }

    @Override
    public void addProbeInfo(@Nonnull ProbeMode probeMode, @Nonnull IProbeInfo iProbeInfo, @Nonnull PlayerEntity playerEntity,
                             @Nonnull World world, @Nonnull BlockState blockState, @Nonnull IProbeHitData iProbeHitData) {
        TileEntity te = world.getTileEntity(iProbeHitData.getPos());

        if (te instanceof TreeStumpTileEntity) {
            TreeStumpTileEntity treeStump = (TreeStumpTileEntity) te;

            if (!treeStump.getResult().isEmpty()) {
                iProbeInfo.horizontal().item(treeStump.getResult()).progress(treeStump.getProgress(), 100, iProbeInfo.defaultProgressStyle().suffix("%"));
            }
        }
    }
}
