package chaoscement.innatequalities.util.gen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import chaoscement.innatequalities.util.TopDownBlockPosComparator;
import chaoscement.innatequalities.blocks.*;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.TerrainGen;

public abstract class TreeGenAbstract extends WorldGenerator {
	

	protected static final int minPodHeight = 3;

	@Override
	public boolean generate(World world, Random rand, BlockPos pos, boolean forced) {
		if (!TerrainGen.saplingGrowTree(world, rand, pos)) {
			return false;
		}

		BlockTreeLeavesElder leaf = new BlockTreeLeavesElder();
		BlockTreeLogsElder wood = new BlockTreeLogsElder();

		preGenerate(world, rand, pos);

		BlockPos genPos;
		if (forced) {
			genPos = pos;
		} else {
			genPos = getValidGrowthPos(world, pos);
		}

		if (genPos != null) {
			List<BlockPos> branchEnds = new ArrayList<>(generateTrunk(world, rand, wood, genPos));
			Collections.sort(branchEnds, TopDownBlockPosComparator.INSTANCE);
			generateLeaves(world, rand, leaf, branchEnds, genPos);
			generateExtras(world, rand, genPos);
			return true;
		}

		return false;
	}

	

	public void preGenerate(World world, Random rand, BlockPos startPos) {

	}

	/**
	 * Generate the tree's trunk. Returns a list of positions of branch ends for leaves to generate at.
	 */
	@Nonnull
	protected abstract Set<BlockPos> generateTrunk(World world, Random rand, BlockTreeLogsElder wood, BlockPos startPos);

	protected abstract void generateLeaves(World world, Random rand, BlockTreeLeavesElder leaf, List<BlockPos> branchEnds, BlockPos startPos);

	protected abstract void generateExtras(World world, Random rand, BlockPos startPos);

	@Nullable
	public abstract BlockPos getValidGrowthPos(World world, BlockPos pos);



}
