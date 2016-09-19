package chaoscement.innatequalities.blocks;

import chaoscement.innatequalities.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class BlockTreeLeavesElder extends Block {
	public BlockTreeLeavesElder() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.InnateQualitiesBlocks.ORELIVINGIRON.getUnlocalizedName());
		setRegistryName(Reference.InnateQualitiesBlocks.ORELIVINGIRON.getRegistryName());
		setHardness(3.0F);
	}

}
