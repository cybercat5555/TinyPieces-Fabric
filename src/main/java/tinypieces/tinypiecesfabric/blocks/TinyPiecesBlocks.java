package tinypieces.tinypiecesfabric.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;
import tinypieces.tinypiecesfabric.TinyPieces;
import tinypieces.tinypiecesfabric.statistics.TinyPiecesStatistics;

public class TinyPiecesBlocks {

	public static final Block CHISELED_RED_NETHER_BRICKS = register("chiseled_red_nether_bricks", new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).strength(2.0f, 6.0f)), ItemGroup.BUILDING_BLOCKS);
	public static final Block CRACKED_RED_NETHER_BRICKS = register("cracked_red_nether_bricks", new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).strength(2.0f, 6.0f)), ItemGroup.BUILDING_BLOCKS);
	public static final Block MOSSY_STONE = register("mossy_stone", new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).strength(1.5f, 6.0f)), ItemGroup.BUILDING_BLOCKS);

	public static final Block PINK_CHERRY_LEAVES = register("pink_cherry_leaves", new DefaultLeavesBlock(), ItemGroup.DECORATIONS);
	public static final Block WHITE_CHERRY_LEAVES = register("white_cherry_leaves", new DefaultLeavesBlock(), ItemGroup.DECORATIONS);
	public static final Block CHERRY_LOG = register("cherry_log", new DefaultLogBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
	public static final Block CHERRY_WOOD = register("cherry_wood", new DefaultLogBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
	public static final Block PINK_CHERRY_SAPLING = register("pink_cherry_sapling", new DefaultSaplingBlock(null), ItemGroup.DECORATIONS);
	public static final Block WHITE_CHERRY_SAPLING = register("white_cherry_sapling", new DefaultSaplingBlock(null), ItemGroup.DECORATIONS);
	public static final Block CHERRY_DOOR = register("cherry_door", new DefaultDoorBlock(FabricBlockSettings.of(Material.WOOD)), ItemGroup.BUILDING_BLOCKS);
	public static final Block CHERRY_TRAPDOOR = register("cherry_trapdoor", new DefaultTrapdoorBlock(FabricBlockSettings.of(Material.WOOD)), ItemGroup.BUILDING_BLOCKS);
	public static final Block CHERRY_PLANKS = register("cherry_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
	public static final Block CHERRY = register("cherry", new Block(FabricBlockSettings.of(Material.STONE).breakByHand(true)), ItemGroup.DECORATIONS);
	public static final Block STRIPPED_CHERRY_LOG = register("stripped_cherry_log", new DefaultLogBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
	public static final Block STRIPPED_CHERRY_WOOD = register("stripped_cherry_wood", new DefaultLogBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);

	public static final Block GREEN_WILLOW_LEAVES = register("green_willow_leaves", new DefaultLeavesBlock(), ItemGroup.DECORATIONS);
	public static final Block YELLOW_WILLOW_LEAVES = register("yellow_willow_leaves", new DefaultLeavesBlock(), ItemGroup.DECORATIONS);
	public static final Block WILLOW_LOG = register("willow_log", new DefaultLogBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
	public static final Block WILLOW_WOOD = register("willow_wood", new DefaultLogBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
	public static final Block GREEN_WILLOW_SAPLING = register("green_willow_sapling", new DefaultSaplingBlock(null), ItemGroup.DECORATIONS);
	public static final Block YELLOW_WILLOW_SAPLING = register("yellow_willow_sapling", new DefaultSaplingBlock(null), ItemGroup.DECORATIONS);
	public static final Block WILLOW_DOOR = register("willow_door", new DefaultDoorBlock(FabricBlockSettings.of(Material.WOOD)), ItemGroup.BUILDING_BLOCKS);
	public static final Block WILLOW_TRAPDOOR = register("willow_trapdoor", new DefaultTrapdoorBlock(FabricBlockSettings.of(Material.WOOD)), ItemGroup.BUILDING_BLOCKS);
	public static final Block WILLOW_PLANKS = register("willow_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
	public static final Block STRIPPED_WILLOW_LOG = register("stripped_willow_log", new DefaultLogBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
	public static final Block STRIPPED_WILLOW_WOOD = register("stripped_willow_wood", new DefaultLogBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);

	public static final Block APPLE_PIE = register("apple_pie", new PieBlock(TinyPiecesStatistics.EAT_APPLE_PIE_SLICE, 3, 0.3f, new StatusEffectInstance(StatusEffects.REGENERATION, 10*20)), new FabricItemSettings().group(ItemGroup.FOOD).maxCount(1));
	public static final Block HONEY_PIE = register("honey_pie", new PieBlock(TinyPiecesStatistics.EAT_HONEY_PIE_SLICE, 3, 0.4f, new StatusEffectInstance(StatusEffects.SPEED, 2*60*20)), new FabricItemSettings().group(ItemGroup.FOOD).maxCount(1));
	public static final Block CHERRY_PIE = register("cherry_pie", new PieBlock(TinyPiecesStatistics.EAT_CHERRY_PIE_SLICE, 4, 0.4f, new StatusEffectInstance(StatusEffects.LUCK, 5*60*20)), new FabricItemSettings().group(ItemGroup.FOOD).maxCount(1));

	public static Block register(String name, Block block, ItemGroup itemGroup) {
		Registry.register(Registry.ITEM, TinyPieces.id(name), new BlockItem(block, new FabricItemSettings().group(itemGroup)));
		return Registry.register(Registry.BLOCK, TinyPieces.id(name), block);
	}

	public static Block register(String name, Block block, FabricItemSettings blockItemSettings) {
		Registry.register(Registry.ITEM, TinyPieces.id(name), new BlockItem(block, blockItemSettings));
		return Registry.register(Registry.BLOCK, TinyPieces.id(name), block);
	}

	public static Block register(String name, Block block) {
		return Registry.register(Registry.BLOCK, TinyPieces.id(name), block);
	}

	public static void init() {
	}
}
