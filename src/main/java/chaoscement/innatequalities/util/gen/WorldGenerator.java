package chaoscement.innatequalities.util.gen;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class WorldGenerator extends GenerationHandler {
	
	@Override
	public final boolean generate(World world, Random random, BlockPos pos) {
		return generate(world, random, pos, false);
	}

	public boolean generate(World world, Random random, BlockPos pos, boolean forced) {
		return false;
	}

}
