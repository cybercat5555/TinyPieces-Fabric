package tinypieces.tinypiecesfabric;

import io.github.vampirestudios.vampirelib.blocks.DoorBaseBlock;
import io.github.vampirestudios.vampirelib.blocks.SaplingBaseBlock;
import io.github.vampirestudios.vampirelib.blocks.TrapdoorBaseBlock;
import io.github.vampirestudios.vampirelib.utils.registry.RegistryHelper;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import tinypieces.tinypiecesfabric.utils.WorldGenCheatSheetFabric1162;

public class TinyPiecesMain implements ModInitializer{

    public static final String MOD_ID = "tinypiecesfabric";
    public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.createRegistryHelper(MOD_ID);

    public static final Block CHISELED_RED_NETHER_BRICK = new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).strength(2.0f, 6.0f));
    public static final Block CRACKED_RED_NETHER_BRICK = new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).strength(2.0f, 6.0f));
    public static final Block MOSSY_STONE = new Block(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).strength(1.5f, 6.0f));

    public static final Block PINK_CHERRY_LEAVES = createLeavesBlock("pink_cherry_leaves");
    public static final Block WHITE_CHERRY_LEAVES = createLeavesBlock("white_cherry_leaves");
    public static final Block CHERRY_LOG = REGISTRY_HELPER.registerLog("cherry_log", MaterialColor.PINK, MaterialColor.PINK);
    public static final Block CHERRY_WOOD = REGISTRY_HELPER.registerBlock(new Block(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).breakByHand(true).breakByTool(FabricToolTags.AXES)), "cherry_wood");
    public static final Block PINK_CHERRY_SAPLING = REGISTRY_HELPER.registerBlock(new SaplingBaseBlock(null), "pink_cherry_sapling");
    public static final Block WHITE_CHERRY_SAPLING = REGISTRY_HELPER.registerBlock(new SaplingBaseBlock(null), "white_cherry_sapling");
    public static final Block CHERRY_DOOR = REGISTRY_HELPER.registerBlock(new DoorBaseBlock(FabricBlockSettings.of(Material.STONE).breakByHand(true).breakByTool(FabricToolTags.AXES)), "cherry_door");
    public static final Block CHERRY_TRAPDOOR = REGISTRY_HELPER.registerBlock(new TrapdoorBaseBlock(FabricBlockSettings.of(Material.STONE).breakByHand(true).breakByTool(FabricToolTags.AXES)), "cherry_trapdoor");
    public static final Block CHERRY_PLANKS = REGISTRY_HELPER.registerBlock(new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).breakByHand(true).breakByTool(FabricToolTags.AXES)), "cherry_planks");
    public static final Block CHERRY = REGISTRY_HELPER.registerBlock(new Block(FabricBlockSettings.of(Material.STONE).breakByHand(true)), "cherry");
    public static final Block STRIPPED_CHERRY_LOG = REGISTRY_HELPER.registerLog("stripped_cherry_log", MaterialColor.PINK, MaterialColor.PINK);
    public static final Block STRIPPED_CHERRY_WOOD = REGISTRY_HELPER.registerBlock(new Block(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).breakByHand(true).breakByTool(FabricToolTags.AXES)), "stripped_cherry_wood");

    public static final Block GREEN_WILLOW_LEAVES = createLeavesBlock("green_willow_leaves");
    public static final Block YELLOW_WILLOW_LEAVES = createLeavesBlock("yellow_willow_leaves");
    public static final Block WILLOW_LOG = REGISTRY_HELPER.registerLog("willow_log", MaterialColor.BROWN, MaterialColor.BROWN);
    public static final Block WILLOW_WOOD = REGISTRY_HELPER.registerBlock(new Block(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).breakByHand(true).breakByTool(FabricToolTags.AXES)), "willow_wood");
    public static final Block GREEN_WILLOW_SAPLING = REGISTRY_HELPER.registerBlock(new SaplingBaseBlock(null), "green_willow_sapling");
    public static final Block YELLOW_WILLOW_SAPLING = REGISTRY_HELPER.registerBlock(new SaplingBaseBlock(null), "yellow_willow_sapling");
    public static final Block WILLOW_DOOR = REGISTRY_HELPER.registerBlock(new DoorBaseBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).breakByHand(true).breakByTool(FabricToolTags.AXES)), "willow_door");
    public static final Block WILLOW_TRAPDOOR = REGISTRY_HELPER.registerBlock(new TrapdoorBaseBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).breakByHand(true).breakByTool(FabricToolTags.AXES)), "willow_trapdoor");
    public static final Block WILLOW_PLANKS = REGISTRY_HELPER.registerBlock(new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).breakByHand(true).breakByTool(FabricToolTags.AXES)), "willow_planks");
    public static final Block STRIPPED_WILLOW_LOG = REGISTRY_HELPER.registerLog("stripped_willow_log", MaterialColor.BROWN, MaterialColor.BROWN);
    public static final Block STRIPPED_WILLOW_WOOD = REGISTRY_HELPER.registerBlock(new Block(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).breakByHand(true).breakByTool(FabricToolTags.AXES)), "stripped_willow_wood");

    private static final ConfiguredFeature<?, ?> feature = Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MOD_ID, "mossy_stone"), Feature.ORE.configure(new OreFeatureConfig(
            OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
            TinyPiecesMain.MOSSY_STONE.getDefaultState(), 33)
    ).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10, 0, 30))));
    public void handleBiome(Biome biome) {
        if(biome.getCategory() == Biome.Category.JUNGLE) {
            WorldGenCheatSheetFabric1162.addFeatureToBiome(
                    biome,
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    feature
            );/*
            biome.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Feature.ORE.configure(
                new OreFeatureConfig(
                    OreFeatureConfig.Target.NATURAL_STONE,
                    TinyPiecesMain.MOSSY_STONE.getDefaultState(), 33
               )).createDecoratedFeature(
                Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 30, 64))));*/
        }
    }


    @Override
    public void onInitialize() {
        REGISTRY_HELPER.registerBlock(CHISELED_RED_NETHER_BRICK, "chiseled_red_nether_bricks", ItemGroup.BUILDING_BLOCKS);
        REGISTRY_HELPER.registerBlock(CRACKED_RED_NETHER_BRICK, "cracked_red_nether_bricks", ItemGroup.BUILDING_BLOCKS);
        REGISTRY_HELPER.registerBlock(MOSSY_STONE, "mossy_stone", ItemGroup.BUILDING_BLOCKS);
        BuiltinRegistries.BIOME.forEach(this::handleBiome);
        RegistryEntryAddedCallback.event(BuiltinRegistries.BIOME).register((i, identifier, biome) -> handleBiome(biome));
    }

    private static Block createLeavesBlock(String name) {
        return REGISTRY_HELPER.registerBlock(new LeavesBlock(
                FabricBlockSettings.of(Material.LEAVES)
                        .breakByHand(true)
                        .breakByTool(FabricToolTags.SHEARS)
                        .strength(0.2F)
                        .ticksRandomly()
                        .sounds(BlockSoundGroup.GRASS)
                        .nonOpaque()
                        .allowsSpawning((state, world, pos, type) -> type == EntityType.OCELOT || type == EntityType.PARROT)
                        .suffocates((state, world, pos) -> false)
                        .blockVision((state, world, pos) -> false)
        ), name);
    }
    
}
