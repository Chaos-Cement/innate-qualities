package chaoscement.innatequalities.util.gen;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import chaoscement.innatequalities.blocks.BlockTreeLeavesElder;
import chaoscement.innatequalities.blocks.BlockTreeLogsElder;
// import chaoscement.innatequalities.util.gen.GenHelper.EnumReplaceMode;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public abstract class TreeGenElder extends TreeGenAbstract {
	

	private static final int height = 12;
	private static final int girth = 3;

	public TreeGenElder() {
	
	}

	@Nonnull
	@Override
	public Set<BlockPos> generateTrunk(World world, Random rand, BlockTreeLogsElder wood, BlockPos startPos) {
		Direction leanDirection = Direction.getRandom(rand);

		float leanAmount = height / 4.0f;

		Set<BlockPos> treeTops = generateTreeTrunk(world, rand, wood, startPos, height, girth, 0, 0, leanDirection.facing, leanAmount);
		if (height > 5 && rand.nextBoolean()) {
			Direction branchDirection = Direction.getRandomOther(rand, leanDirection);
			Set<BlockPos> treeTops2 = generateTreeTrunk(world, rand, wood, startPos, Math.round(height * 0.66f), girth, 0, 0, branchDirection.facing, leanAmount);
			treeTops.addAll(treeTops2);
		}

		Set<BlockPos> branchEnds = new HashSet<>(treeTops);

		for (BlockPos treeTop : treeTops) {
			int xOffset = treeTop.getX();
			int yOffset = treeTop.getY() + 1;
			int zOffset = treeTop.getZ();
			float canopyMultiplier = (1.5f * height - yOffset + 2) / 4.0f;
			int canopyThickness = Math.max(1, Math.round(yOffset / 10.0f));

			yOffset--;

			float canopyWidth = rand.nextBoolean() ? 3.0f : 2.5f;
			int radius = Math.round(canopyMultiplier * canopyWidth - 4);
			BlockPos pos = startPos.add(xOffset, yOffset - canopyThickness, zOffset);
			branchEnds.addAll(generateBranches(world, rand, wood, pos, girth, 0.0f, 0.1f, radius, 2, 1.0f));
		}

		return branchEnds;
	}

	@Override
	protected void generateLeaves(World world, Random rand, BlockTreeLeavesElder leaf, List<BlockPos> branchEnds, BlockPos startPos) {
		for (BlockPos branchEnd : branchEnds) {
			int leafSpawn = branchEnd.getY();
			int canopyThickness = Math.max(1, Math.round(leafSpawn / 10.0f));
			float canopyMultiplier = (1.5f * height - leafSpawn + 2) / 4.0f;
			float canopyWidth = rand.nextBoolean() ? 2.0f : 4.5f;
			BlockPos center = new BlockPos(branchEnd.getX(), leafSpawn - canopyThickness + 1, branchEnd.getZ());
			float radius = Math.max(1, canopyMultiplier * canopyWidth + girth);
			generateCylinderFromPos(world, leaf, center, radius, canopyThickness, EnumReplaceMode.AIR);
		}
	}
	
	public static void generateCylinderFromPos(World world, BlockTreeLogsElder block, BlockPos center, float radius, int height, EnumReplaceMode replace) {
	BlockPos start = new BlockPos(center.getX() - radius, center.getY(), center.getZ() - radius);
	for (int x = 0; x < radius * 2 + 1; x++) {
		for (int y = height - 1; y >= 0; y--) { // generating top-down is faster for lighting calculations
			for (int z = 0; z < radius * 2 + 1; z++) {
				BlockPos position = start.add(x, y, z);
				Vec3i treeCenter = new Vec3i(center.getX(), position.getY(), center.getZ());
				if (position.distanceSq(treeCenter) <= radius * radius + 0.01) {
					EnumFacing direction = VectUtil.direction(position, treeCenter);
					block.setDirection(direction);
					addBlock(world, position, block, replace);
				}
			}
		}
	}
}
	
	public static Set<BlockPos> generateTreeTrunk(
			@Nonnull World world,
			Random rand,
			@Nonnull BlockTreeLogsElder wood,
			@Nonnull BlockPos startPos,
			int height,
			int girth,
			int yStart,
			float vinesChance,
			@Nullable EnumFacing leanDirection,
			float leanScale
	) {
		Set<BlockPos> treeTops = new HashSet<>();

		final int leanStartY = (int) Math.floor(height * 0.33f);
		int prevXOffset = 0;
		int prevZOffset = 0;

		int leanX = 0;
		int leanZ = 0;

		if (leanDirection != null) {
			leanX = leanDirection.getFrontOffsetX();
			leanZ = leanDirection.getFrontOffsetZ();
		}

		for (int x = 0; x < girth; x++) {
			for (int z = 0; z < girth; z++) {
				for (int y = height - 1; y >= yStart; y--) { // generating top-down is faster for lighting calculations
					float lean;
					if (y < leanStartY) {
						lean = 0;
					} else {
						lean = leanScale * (y - leanStartY) / (height - leanStartY);
					}
					int xOffset = (int) Math.floor(leanX * lean);
					int zOffset = (int) Math.floor(leanZ * lean);

					if (xOffset != prevXOffset || zOffset != prevZOffset) {
						prevXOffset = xOffset;
						prevZOffset = zOffset;
						if (y > 0) {
							wood.setDirection(leanDirection);
							addBlock(world, startPos.add(x + xOffset, y - 1, z + zOffset), wood, EnumReplaceMode.ALL);
							wood.setDirection(EnumFacing.UP);
						}
					}

					BlockPos pos = startPos.add(x + xOffset, y, z + zOffset);
					addBlock(world, pos, wood, EnumReplaceMode.ALL);
					if (y + 1 == height) {
						treeTops.add(pos);
					}
				}
			}
		}

		return treeTops;
	}
	
	public static Set<BlockPos> generateBranches(final World world, final Random rand, final BlockTreeLogsElder wood, final BlockPos startPos, final int girth, final float spreadY, final float spreadXZ, int radius, final int count, final float chance) {
		Set<BlockPos> branchEnds = new HashSet<>();
		if (radius < 1) {
			radius = 1;
		}

		for (final EnumFacing branchDirection : EnumFacing.HORIZONTALS) {
			wood.setDirection(branchDirection);

			BlockPos branchStart = startPos;

			int offsetX = branchDirection.getFrontOffsetX();
			int offsetZ = branchDirection.getFrontOffsetZ();
			if (offsetX > 0) {
				branchStart = branchStart.add(girth - 1, 0, 0);
			}
			if (offsetZ > 0) {
				branchStart = branchStart.add(0, 0, girth - 1);
			}

			for (int i = 0; i < count; i++) {
				if (rand.nextFloat() > chance) {
					continue;
				}
				int y = 0;
				int x = 0;
				int z = 0;

				BlockPos branchEnd = null;
				for (int r = 0; r < radius; r++) {
					if (rand.nextFloat() < spreadY) {
						// make branches only spread up, not down
						y++;
						wood.setDirection(EnumFacing.UP);
					} else {
						if (rand.nextFloat() < spreadXZ) {
							if (branchDirection.getAxis() == EnumFacing.Axis.Z) {
								if (rand.nextBoolean()) {
									x++;
								} else {
									x--;
								}
								wood.setDirection(EnumFacing.EAST);
							} else if (branchDirection.getAxis() == EnumFacing.Axis.X) {
								if (rand.nextBoolean()) {
									z++;
								} else {
									z--;
								}
								wood.setDirection(EnumFacing.SOUTH);
							}
						} else {
							x += offsetX;
							z += offsetZ;
							wood.setDirection(branchDirection);
						}
					}

					BlockPos pos = branchStart.add(x, y, z);
					if (addBlock(world, pos, wood, EnumReplaceMode.SOFT)) {
						branchEnd = pos;
					} else {
						break;
					}
				}

				if (branchEnd != null) {
					branchEnds.add(branchEnd);
				}
			}
		}

		return branchEnds;
	}
	
	public enum Direction {
	NORTH(EnumFacing.NORTH),
	SOUTH(EnumFacing.SOUTH),
	WEST(EnumFacing.WEST),
	EAST(EnumFacing.EAST);

	public final EnumFacing facing;

	Direction(EnumFacing forgeDirection) {
		this.facing = forgeDirection;
	}

	public static Direction getRandom(Random random) {
		return values()[random.nextInt(values().length)];
	}

	public static Direction getRandomOther(Random random, Direction direction) {
		EnumSet<Direction> directions = EnumSet.allOf(Direction.class);
		directions.remove(direction);
		int size = directions.size();
		return directions.toArray(new Direction[size])[random.nextInt(size)];
	}
	}
	
	public enum EnumReplaceMode {
	AIR {
		@Override
		public boolean canReplace(IBlockState blockState, World world, BlockPos pos) {
			return world.isAirBlock(pos);
		}
	},
	ALL {
		@Override
		public boolean canReplace(IBlockState blockState, World world, BlockPos pos) {
			return true;
		}
	},
	SOFT {
		@Override
		public boolean canReplace(IBlockState blockState, World world, BlockPos pos) {
			return blockState.getBlock().isReplaceable(world, pos);
		}
	};

	public abstract boolean canReplace(IBlockState blockState, World world, BlockPos pos);
}

}
