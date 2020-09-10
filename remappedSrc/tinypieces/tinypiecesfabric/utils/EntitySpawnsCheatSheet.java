package tinypieces.tinypiecesfabric.utils;/*
MIT License
Copyright (c) 2020 CorgiTaco
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
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class EntitySpawnsCheatSheet {
    
    //Iterate through all registered biomes in the WorldGenRegistries.
    public static void addSpawnEntries() {
        for (Biome biome : BuiltinRegistries.BIOME) {
            if (biome.getBiomeCategory() != Biome.BiomeCategory.NETHER && biome.getBiomeCategory() != Biome.BiomeCategory.THEEND && biome.getBiomeCategory() != Biome.BiomeCategory.NONE) {
                addMobSpawnToBiome(biome, MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 100, 100, 100));
            }
        }
    }

    //Add the normal info along with a list of "Spawners"
    public static void addMobSpawnToBiome(Biome biome, MobCategory classification, MobSpawnSettings.SpawnerData... spawners) {
        convertImmutableSpawners(biome);
        //Copy the list of spawners that already exist for the given biome.
        List<MobSpawnSettings.SpawnerData> spawnersList = new ArrayList<>(biome.getMobSettings().spawners.get(classification));
        //Add all the spawners within our list.
        spawnersList.addAll(Arrays.asList(spawners));
        //Overwrite the list for the given classification with the old list and our new entries.
        biome.getMobSettings().spawners.put(classification, spawnersList);
    }

    //Convert the immutable map to a mutable HashMap in order for us to change the data stored in these maps
    private static void convertImmutableSpawners(Biome biome) {
        if (biome.getMobSettings().spawners instanceof ImmutableMap) {
            biome.getMobSettings().spawners = new HashMap<>(biome.getMobSettings().spawners);
        }
    }
}