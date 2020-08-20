package tinypieces.tinypiecesfabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;

public class TinyPiecesMain implements ModInitializer{
    public static final Block CHISELED_RED_NETHER_BRICK =  new Block (FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).strength(2.0f, 6.0f));
    public static final Block CRACKED_RED_NETHER_BRICK =  new Block (FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).strength(2.0f, 6.0f));
    public static final Block MOSSY_STONE =  new Block (FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).strength(1.5f, 6.0f));
    public void handleBiome(Biome biome) {
        if(biome.getCategory() == Biome.Category.JUNGLE) {
            biome.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Feature.ORE.configure(
                new OreFeatureConfig(
                    OreFeatureConfig.Target.NATURAL_STONE,
                    TinyPiecesMain.MOSSY_STONE.getDefaultState(), 33
               )).createDecoratedFeature(
                Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 30, 64))));
        }
    }


    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("tinypiecesfabric", "chiseled_red_nether_bricks"), CHISELED_RED_NETHER_BRICK);
        Registry.register(Registry.ITEM, new Identifier("tinypiecesfabric", "chiseled_red_nether_bricks"), new BlockItem(CHISELED_RED_NETHER_BRICK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("tinypiecesfabric", "cracked_red_nether_bricks"), CRACKED_RED_NETHER_BRICK);
        Registry.register(Registry.ITEM, new Identifier("tinypiecesfabric", "cracked_red_nether_bricks"), new BlockItem(CRACKED_RED_NETHER_BRICK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("tinypiecesfabric", "mossy_stone"), MOSSY_STONE);
        Registry.register(Registry.ITEM, new Identifier("tinypiecesfabric", "mossy_stone"), new BlockItem(MOSSY_STONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.BIOME.forEach(this::handleBiome);
        RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> handleBiome(biome));
    }
    
}
