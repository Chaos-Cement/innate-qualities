package chaoscement.innatequalities.blocks;

import chaoscement.innatequalities.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockFirePit extends Block{

		public BlockFirePit() {
			super(Material.ROCK);
			setUnlocalizedName(Reference.InnateQualitiesBlocks.FIREPIT.getUnlocalizedName());
			setRegistryName(Reference.InnateQualitiesBlocks.FIREPIT.getRegistryName());
			setHardness(3.0F);
		}
		
		@Override
		public boolean isFullCube(IBlockState state) {
			return false;
		}
		
		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

}
