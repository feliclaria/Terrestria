package com.terraformersmc.terrestria.feature.tree.trunkplacers;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.terraformersmc.terrestria.init.TerrestriaTrunkPlacerTypes;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class BentTrunkPlacer extends TrunkPlacer {

	public static final Codec<BentTrunkPlacer> CODEC = RecordCodecBuilder.create((bentTrunkPlacerInstance) ->
			method_28904(bentTrunkPlacerInstance).apply(bentTrunkPlacerInstance, BentTrunkPlacer::new));

	public BentTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
		super(baseHeight, firstRandomHeight, secondRandomHeight);
	}

	@Override
	protected TrunkPlacerType<?> getType() {
		return TerrestriaTrunkPlacerTypes.BENT;
	}

	@Override
	public List<FoliagePlacer.TreeNode> generate(ModifiableTestableWorld world, Random random, int trunkHeight, BlockPos pos, Set<BlockPos> set, BlockBox blockBox, TreeFeatureConfig treeFeatureConfig) {
		//Decide the direction at which the tree will bend
		Direction bendDirection = Direction.Type.HORIZONTAL.random(random);

		//Check and set the block below to dirt
		method_27400(world, pos.down());

		//Create the Mutable version of our block position so that we can procedurally create the trunk
		BlockPos.Mutable currentPosition = pos.mutableCopy().move(Direction.DOWN);

		//Place the first few blocks
		for (int i = 0; i < 4 + random.nextInt(3); i++) {
			method_27402(world, random, currentPosition.move(Direction.UP), set, blockBox, treeFeatureConfig);
		}

		//Offset in the lean direction and also move it down to keep the trunk solid
		currentPosition.move(bendDirection).move(Direction.DOWN);

		//Place a few more blocks
		for (int i = 0; i < 4 + random.nextInt(1); i++) {
			method_27402(world, random, currentPosition.move(Direction.UP), set, blockBox, treeFeatureConfig);
		}

		//50% of the time make a 3rd set of blocks the same as the step before
		if (random.nextBoolean()) {
			currentPosition.move(bendDirection).move(Direction.DOWN);

			for (int i = 0; i < 3; i++) {
				method_27402(world, random, currentPosition.move(Direction.UP), set, blockBox, treeFeatureConfig);
			}
		}

		//Return the top as the valid foliage placer location
		return ImmutableList.of(new FoliagePlacer.TreeNode(currentPosition.toImmutable(), 0, false));
	}
}
