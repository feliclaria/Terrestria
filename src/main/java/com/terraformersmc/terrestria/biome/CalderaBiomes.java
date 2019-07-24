package com.terraformersmc.terrestria.biome;

import com.terraformersmc.terrestria.biome.builder.DefaultFeature;
import com.terraformersmc.terrestria.biome.builder.TerrestriaBiome;
import com.terraformersmc.terrestria.init.TerrestriaBiomes;
import com.terraformersmc.terrestria.init.TerrestriaFeatures;
import com.terraformersmc.terrestria.init.TerrestriaSurfaces;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MineshaftFeature;
import net.minecraft.world.gen.feature.MineshaftFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class CalderaBiomes {
	public static void register() {
		TerrestriaBiomes.CALDERA = TerrestriaBiomes.register("caldera", TerrestriaBiome.builder()
				.configureSurfaceBuilder(TerrestriaSurfaces.CALDERA, SurfaceBuilder.GRASS_SAND_UNDERWATER_CONFIG)
				.precipitation(Biome.Precipitation.RAIN).category(Biome.Category.OCEAN)
				.depth(1.5F)
				.scale(0.05F)
				.temperature(0.7F)
				.downfall(0.7F)
				.waterColor(0x54d3c0)
				.waterFogColor(0x24a0b0)
				.addDefaultFeatures(DefaultFeature.LAND_CARVERS, DefaultFeature.STRUCTURES, DefaultFeature.LAKES, DefaultFeature.DUNGEONS, DefaultFeature.MINEABLES, DefaultFeature.ORES, DefaultFeature.DISKS, DefaultFeature.DEFAULT_FLOWERS,
						DefaultFeature.DEFAULT_GRASS, DefaultFeature.DEFAULT_MUSHROOMS, DefaultFeature.DEFAULT_VEGETATION, DefaultFeature.SPRINGS, DefaultFeature.FROZEN_TOP_LAYER)
				.addStructureFeature(Feature.STRONGHOLD)
				.addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL))
				.addDefaultSpawnEntries()
				.addSpawnEntry(new Biome.SpawnEntry(EntityType.SQUID, 3, 1, 4))
				.addSpawnEntry(new Biome.SpawnEntry(EntityType.SALMON, 15, 3, 6))
				.addSpawnEntry(new Biome.SpawnEntry(EntityType.COD, 15, 1, 5))
				.build());

		TerrestriaBiomes.CALDERA_BEACH = TerrestriaBiomes.register("caldera_beach", TerrestriaBiome.builder()
				.configureSurfaceBuilder(TerrestriaSurfaces.CALDERA, SurfaceBuilder.GRASS_SAND_UNDERWATER_CONFIG)
				.precipitation(Biome.Precipitation.RAIN).category(Biome.Category.BEACH)
				.depth(2.25F)
				.scale(0F)
				.temperature(0.7F)
				.downfall(0.7F)
				.waterColor(0x54d3c0)
				.waterFogColor(0x24a0b0)
				.addDefaultFeatures(DefaultFeature.LAND_CARVERS, DefaultFeature.STRUCTURES, DefaultFeature.LAKES, DefaultFeature.DUNGEONS, DefaultFeature.MINEABLES, DefaultFeature.ORES, DefaultFeature.DISKS, DefaultFeature.DEFAULT_FLOWERS,
						DefaultFeature.DEFAULT_GRASS, DefaultFeature.DEFAULT_MUSHROOMS, DefaultFeature.DEFAULT_VEGETATION, DefaultFeature.SPRINGS, DefaultFeature.FROZEN_TOP_LAYER)
				.addStructureFeature(Feature.STRONGHOLD)
				.addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL))
				.addDefaultSpawnEntries()
				.addSpawnEntry(new Biome.SpawnEntry(EntityType.SQUID, 3, 1, 4))
				.addSpawnEntry(new Biome.SpawnEntry(EntityType.SALMON, 15, 3, 6))
				.addSpawnEntry(new Biome.SpawnEntry(EntityType.COD, 15, 1, 5))
				.build());

		TerrestriaBiomes.CALDERA_FOOTHILLS = TerrestriaBiomes.register("caldera_foothills", TerrestriaBiome.builder()
				.configureSurfaceBuilder(SurfaceBuilder.MOUNTAIN, SurfaceBuilder.GRASS_CONFIG)
				.precipitation(Biome.Precipitation.SNOW).category(Biome.Category.EXTREME_HILLS)
				.depth(1.7F)
				.scale(0.4F)
				.temperature(0.0F)
				.downfall(0.1F)
				.waterColor(4159204)
				.waterFogColor(329011)
				.addDefaultFeatures(DefaultFeature.LAND_CARVERS, DefaultFeature.STRUCTURES, DefaultFeature.LAKES, DefaultFeature.DUNGEONS, DefaultFeature.MINEABLES, DefaultFeature.ORES, DefaultFeature.DISKS, DefaultFeature.DEFAULT_MUSHROOMS,
						DefaultFeature.DEFAULT_VEGETATION, DefaultFeature.SPRINGS, DefaultFeature.EMERALD_ORE, DefaultFeature.INFECTED_STONE, DefaultFeature.FROZEN_TOP_LAYER)
				.addRareTreeFeature(TerrestriaFeatures.REDWOOD_TREE, 2)
				.addRareTreeFeature(TerrestriaFeatures.HEMLOCK_TREE, 2)
				.addTreeFeature(TerrestriaFeatures.TINY_REDWOOD_TREE, 1)
				.addTreeFeature(TerrestriaFeatures.TINY_HEMLOCK_TREE, 1)
				.addStructureFeature(Feature.STRONGHOLD)
				.addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL))
				.addDefaultSpawnEntries()
				.addSpawnEntry(new Biome.SpawnEntry(EntityType.WOLF, 5, 4, 4))
				.build());

		TerrestriaBiomes.CALDERA_RIDGE = TerrestriaBiomes.register("caldera_ridge", TerrestriaBiome.builder()
				.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
				.precipitation(Biome.Precipitation.RAIN).category(Biome.Category.EXTREME_HILLS)
				.depth(4F)
				.scale(0F)
				.temperature(0F)
				.downfall(1F)
				.waterColor(4159204)
				.waterFogColor(329011)
				.addDefaultFeatures(DefaultFeature.LAND_CARVERS, DefaultFeature.STRUCTURES, DefaultFeature.LAKES, DefaultFeature.DUNGEONS, DefaultFeature.MINEABLES, DefaultFeature.ORES, DefaultFeature.DISKS, DefaultFeature.DEFAULT_FLOWERS,
						DefaultFeature.DEFAULT_GRASS, DefaultFeature.DEFAULT_MUSHROOMS, DefaultFeature.DEFAULT_VEGETATION, DefaultFeature.SPRINGS, DefaultFeature.FROZEN_TOP_LAYER)
				.addStructureFeature(Feature.STRONGHOLD)
				.addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL))
				.addTreeFeature(TerrestriaFeatures.TINY_REDWOOD_TREE, 1)
				.addTreeFeature(TerrestriaFeatures.TINY_HEMLOCK_TREE, 1)
				.addDefaultSpawnEntries()
				.addSpawnEntry(new Biome.SpawnEntry(EntityType.SQUID, 3, 1, 4))
				.addSpawnEntry(new Biome.SpawnEntry(EntityType.SALMON, 15, 3, 6))
				.addSpawnEntry(new Biome.SpawnEntry(EntityType.COD, 15, 1, 5))
				.build());
	}
}