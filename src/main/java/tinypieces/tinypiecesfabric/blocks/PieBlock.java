package tinypieces.tinypiecesfabric.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("deprecation")
public class PieBlock extends Block {
	public static final IntProperty SLICES = IntProperty.of("slices", 1, 4);
	private static final ArrayList<VoxelShape> SHAPES = new ArrayList<>(4);
	private final Identifier eatStatistic;
	private final int hungerPoints;
	private final float saturationModifier;
	private final List<StatusEffectInstance> effects;

	static {
		SHAPES.add(Block.createCuboidShape(8d, 0d, 8d, 15d, 8d, 15d));
		SHAPES.add(Block.createCuboidShape(1d, 0d, 8d, 8d, 8d, 15d));
		SHAPES.add(Block.createCuboidShape(8d, 0d, 1d, 15d, 8d, 8d));
		SHAPES.add(Block.createCuboidShape(1d, 0d, 1d, 8d, 8d, 8d));
	}

	public PieBlock(Settings settings, Identifier eatStatistic, int hungerPoints, float saturationModifier, StatusEffectInstance... effects) {
		super(settings.nonOpaque().sounds(BlockSoundGroup.WOOL));
		this.eatStatistic = eatStatistic;
		this.hungerPoints = hungerPoints;
		this.saturationModifier = saturationModifier;
		this.effects = Arrays.asList(effects);
		setDefaultState(getStateManager().getDefaultState().with(SLICES, 4));
	}

	public PieBlock(Identifier eatStatistic, int hungerPoints, float saturationModifier, StatusEffectInstance... effects) {
		this(FabricBlockSettings.of(Material.CAKE), eatStatistic, hungerPoints, saturationModifier, effects);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(SLICES);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (player.canConsume(false)) {
			player.incrementStat(eatStatistic);
			player.getHungerManager().add(hungerPoints, saturationModifier);
			for (StatusEffectInstance effect : effects)
				player.addStatusEffect(new StatusEffectInstance(effect));

			// Removing slice
			if (state.get(SLICES) > 1)
				world.setBlockState(pos, state.with(SLICES, state.get(SLICES) - 1));
			else
				world.removeBlock(pos, false);

			return ActionResult.SUCCESS;
		}

		if (world.isClient && player.getStackInHand(hand).isEmpty())
			return ActionResult.CONSUME;

		return ActionResult.PASS;
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		VoxelShape voxelShape = SHAPES.get(0);
		for (int i = 1; i < state.get(SLICES); i++) {
			voxelShape = VoxelShapes.union(voxelShape, SHAPES.get(i));
		}
		return voxelShape;
	}

	@Override
	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		return world.getBlockState(pos.down()).getMaterial().isSolid();
	}

	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
		return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
	}
}
