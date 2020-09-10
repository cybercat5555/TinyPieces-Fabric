package tinypieces.tinypiecesfabric.utils;/*
MIT License
Copyright (c) 2020 Corgi Taco
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BuiltinBiomes;
import net.minecraft.world.biome.layer.SetBaseBiomesLayer;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import tinypieces.tinypiecesfabric.TinyPiecesMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class WorldGenCheatSheetFabric1162 {

    /***************************************Adding Features to vanilla(or any other biomes outside the scope of your mod) - Credit: Linguardium***************************************/
    //
    public static void addFeatureToBiome(Biome biome, GenerationStep.Feature feature, ConfiguredFeature<?, ?> configuredFeature) {
        convertImmutableFeatures(biome);
        List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = biome.getGenerationSettings().features;
        while (biomeFeatures.size() <= feature.ordinal()) {
            biomeFeatures.add(Lists.newArrayList());
        }
        biomeFeatures.get(feature.ordinal()).add(() -> configuredFeature);
    }


    //Swap the list to mutable in order for us to add our features with ease.
    private static void convertImmutableFeatures(Biome biome) {
        if (biome.getGenerationSettings().features instanceof ImmutableList) {
            biome.getGenerationSettings().features = biome.getGenerationSettings().features.stream().map(Lists::newArrayList).collect(Collectors.toList());
        }
    }

    /***************************************Adding Biomes to the vanilla overworld/***************************************/
    //Add biomes/Biome keys you register to a list like this or similar.  
    public static List<Biome> biomeList = new ArrayList<>();
    
    //Sorted Lists used for adding biomes to vanilla worldtype's.
    public static List<Integer> HOT = new ArrayList<>();
    public static List<Integer> COOL = new ArrayList<>();
    public static List<Integer> WARM = new ArrayList<>();
    public static List<Integer> ICY = new ArrayList<>();

    //Why? This is how worldtype's using the BiomeLayerSampler get the numerical ID's from the biome's key to sample.
    //Reason: Biomes available for the Layer sampler only contain vanilla values so we add to this list by mapping the key w/ the numerical ID.
    public static void addBiomeNumericalIDs() {
        for (Biome biome : biomeList) {
            Optional<RegistryKey<Biome>> key = BuiltinRegistries.BIOME.getKey(biome);
            key.ifPresent(biomeRegistryKey -> BuiltinBiomes.BY_RAW_ID.put(BuiltinRegistries.BIOME.getRawId(biome), biomeRegistryKey));
        }
    }

    //Enum used for sorting our biomes into their appropriate lists/biome categories.
    public enum OverworldClimate {SNOWY, COOL, TEMPERATE, DRY}

    //This registers biomes using the biome's object.
    private static void registerBiome(Biome biome, String id, boolean spawn, float weight, OverworldClimate type) {
        Registry.register(BuiltinRegistries.BIOME, new Identifier(TinyPiecesMain.MOD_ID, id), biome);
        biomeList.add(biome);
        if (weight > 0) {
            if (type == OverworldClimate.TEMPERATE)
                WARM.add(BuiltinRegistries.BIOME.getRawId(biome));
            if (type == OverworldClimate.COOL)
                COOL.add(BuiltinRegistries.BIOME.getRawId(biome));
            if (type == OverworldClimate.DRY)
            HOT.add(BuiltinRegistries.BIOME.getRawId(biome));
            if (type == OverworldClimate.SNOWY)
                ICY.add(BuiltinRegistries.BIOME.getRawId(biome));
        }
    }

    //Reason: We add our biomes to the public static int arrays for each category and this lets us spawn our biomes in vanilla worldtypes.
    //Why: This should only ever be used if the mod api you're using is outdated.
    public static void addBiomesToVanillaOverworld() {
        for (int dryID : HOT)
            SetBaseBiomesLayer.DRY_BIOMES = addBiomeElement(SetBaseBiomesLayer.DRY_BIOMES, dryID);
        for (int temperateID : WARM)
            SetBaseBiomesLayer.TEMPERATE_BIOMES = addBiomeElement(SetBaseBiomesLayer.TEMPERATE_BIOMES, temperateID);
        for (int coolID : COOL)
            SetBaseBiomesLayer.COOL_BIOMES = addBiomeElement(SetBaseBiomesLayer.COOL_BIOMES, coolID);
        for (int snowyID : ICY)
            SetBaseBiomesLayer.SNOWY_BIOMES = addBiomeElement(SetBaseBiomesLayer.SNOWY_BIOMES, snowyID);
    }


    static int[] addBiomeElement(int[] a, int e) {
        a = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }
}