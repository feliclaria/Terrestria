package com.terraformersmc.terrestria.biome;

import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import com.terraformersmc.terrestria.init.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.*;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;
import static net.minecraft.world.gen.feature.MineshaftFeature.Type.NORMAL;

public class CanyonBiomes {

	public static void register() {
		TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
			.precipitation(Biome.Precipitation.NONE).category(Biome.Category.DESERT)
			.depth(0.2F)
			.scale(0.1F)
			.temperature(0.9F)
			.downfall(0.1F)
			.waterColor(0x4da5e3)
			.waterFogColor(0x24a0b0)
			.addDefaultFeatures(LAND_CARVERS, STRUCTURES, DESERT_LAKES, DUNGEONS, MINEABLES, ORES, DISKS, DESERT_DEAD_BUSHES,
				DEFAULT_GRASS, DEFAULT_MUSHROOMS, DESERT_VEGETATION, FROZEN_TOP_LAYER)
			.addStructureFeature(DefaultBiomeFeatures.STRONGHOLD)
			.addStructureFeature(DefaultBiomeFeatures.NORMAL_MINESHAFT)
			.addDefaultSpawnEntries()
		);

		TerrestriaBiomes.CANYON_ARCHES = TerrestriaBiomes.register("canyon_arches", template.builder()
				.configureSurfaceBuilder(TerrestriaSurfaces.SANDSTONE_CLIFF, TerrestriaSurfaces.SANDSTONE_CONFIG)
				.addStructureFeature(TerrestriaStructures.CANYON_ARCH)
				.build());

		TerrestriaBiomes.CANYON_CLIFFS = TerrestriaBiomes.register("canyon_cliffs", template.builder()
			.configureSurfaceBuilder(TerrestriaSurfaces.CANYON_CLIFF, TerrestriaSurfaces.SANDSTONE_CLIFF_CONFIG)
			.addRareTreeFeature(Feature.TREE.configure(TerrestriaFeatureConfigs.BRYCE_TREE), 12)
			.build());

		TerrestriaBiomes.CANYON_EDGE = TerrestriaBiomes.register("canyon_edge", template.builder()
			.configureSurfaceBuilder(TerrestriaSurfaces.SANDSTONE_CLIFF, TerrestriaSurfaces.SANDSTONE_CONFIG)
			.build());
	}
}
