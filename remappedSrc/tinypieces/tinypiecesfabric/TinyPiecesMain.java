package tinypieces.tinypiecesfabric;

import io.github.vampirestudios.vampirelib.utils.registry.RegistryHelper;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;
import net.minecraft.world.level.material.Material;
import tinypieces.tinypiecesfabric.utils.WorldGenCheatSheetFabric1162;

public class TinyPiecesMain implements ModInitializer{

    public static final String MOD_ID = "tinypiecesfabric";
    public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.createRegistryHelper(MOD_ID);

    public static final Block CHISELED_RED_NETHER_BRICK =  new Block (FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).strength(2.0f, 6.0f));
    public static final Block CRACKED_RED_NETHER_BRICK =  new Block (FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).strength(2.0f, 6.0f));
    public static final Block MOSSY_STONE =  new Block (FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).strength(1.5f, 6.0f));
    public void handleBiome(Biome biome) {
        if(biome.getBiomeCategory() == Biome.BiomeCategory.JUNGLE) {
            WorldGenCheatSheetFabric1162.addFeatureToBiome(
                    biome,
                    GenerationStep.Decoration.UNDERGROUND_ORES,
                    Feature.ORE.configured(new OreConfiguration(
                            OreConfiguration.Predicates.NATURAL_STONE,
                            TinyPiecesMain.MOSSY_STONE.defaultBlockState(), 33)
                    ).decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(10, 0, 30)))

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
        REGISTRY_HELPER.registerBlock(CHISELED_RED_NETHER_BRICK, "chiseled_red_nether_bricks", CreativeModeTab.TAB_BUILDING_BLOCKS);
        REGISTRY_HELPER.registerBlock(CRACKED_RED_NETHER_BRICK, "cracked_red_nether_bricks", CreativeModeTab.TAB_BUILDING_BLOCKS);
        REGISTRY_HELPER.registerBlock(MOSSY_STONE, "mossy_stone", CreativeModeTab.TAB_BUILDING_BLOCKS);
        BuiltinRegistries.BIOME.forEach(this::handleBiome);
        RegistryEntryAddedCallback.event(BuiltinRegistries.BIOME).register((i, identifier, biome) -> handleBiome(biome));
    }
    
}
