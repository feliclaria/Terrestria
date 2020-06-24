package com.terraformersmc.terrestria.feature.volcano;

import com.mojang.serialization.Codec;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

import java.util.Random;

//TODO: fix this
public class VolcanoStructureFeature extends StructureFeature<DefaultFeatureConfig> {
	//
	private static final int VOLCANO_SPACING = 6;

	// How many chunks should be in between each volcano at least
	private static final int VOLCANO_SEPARATION = 3;
	private static final int SEED_MODIFIER = 0x0401C480;

	public VolcanoStructureFeature(Codec<DefaultFeatureConfig> codec) {
		super(codec);
	}



//	@Override
//	protected boolean shouldStartAt(BiomeAccess biomeAccess, ChunkGenerator generator, ChunkRandom random, int chunkX, int chunkZ, Biome biome, ChunkPos chunkPos) {
//		ChunkPos start = this.getStart(generator, random, chunkX, chunkZ, 0, 0);
//
//		if (chunkX == start.x && chunkZ == start.z) {
//			Biome biome1 = biomeAccess.getBiome(new BlockPos(chunkX * 16 + 9, 0, chunkZ * 16 + 9));
//
//			if (biome1.getCategory() == Biome.Category.OCEAN && random.nextInt(4) != 0) {
//				return false;
//			} else if (biome1 == TerrestriaBiomes.VOLCANIC_ISLAND_SHORE && random.nextInt(2) != 0) {
//				return false;
//			}
//
//			return generator.hasStructure(biome1, this);
//		}
//
//		return false;
//	}

	protected ChunkPos getStart(ChunkGenerator chunkGenerator_1, Random random_1, int chunkX, int chunkZ, int scaleX, int scaleZ) {
		chunkX += VOLCANO_SPACING * scaleX;
		chunkZ += VOLCANO_SPACING * scaleZ;

		// Adjust to grid position
		chunkX = chunkX < 0 ? chunkX - VOLCANO_SPACING + 1 : chunkX;
		chunkZ = chunkZ < 0 ? chunkZ - VOLCANO_SPACING + 1 : chunkZ;

		int finalChunkX = chunkX / VOLCANO_SPACING;
		int finalChunkZ = chunkZ / VOLCANO_SPACING;

		((ChunkRandom) random_1).setRegionSeed(random_1.nextLong(), finalChunkX, finalChunkZ, SEED_MODIFIER);

		// Get random position within grid area
		finalChunkX *= VOLCANO_SPACING;
		finalChunkZ *= VOLCANO_SPACING;
		finalChunkX += random_1.nextInt(VOLCANO_SPACING - VOLCANO_SEPARATION);
		finalChunkZ += random_1.nextInt(VOLCANO_SPACING - VOLCANO_SEPARATION);

		return new ChunkPos(finalChunkX, finalChunkZ);
	}

	@Override
	public StructureFeature.StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
		return VolcanoStructureStart::new;
	}

	@Override
	public String getName() {
		return "Volcano";
	}


	public static class VolcanoStructureStart extends StructureStart<DefaultFeatureConfig> {
		VolcanoStructureStart(StructureFeature<DefaultFeatureConfig> feature, int chunkX, int chunkZ, BlockBox box, int references, long baseSeed) {
			super(feature, chunkX, chunkZ, box, references, baseSeed);
		}

		@Override
		public void init(ChunkGenerator chunkGenerator, StructureManager structureManager, int chunkX, int chunkZ, Biome biome, DefaultFeatureConfig featureConfig) {
			VolcanoGenerator volcano = new VolcanoGenerator(this.random, chunkX * 16, chunkZ * 16, biome);

			this.children.add(volcano);
			this.setBoundingBoxFromChildren();
		}
	}
}
