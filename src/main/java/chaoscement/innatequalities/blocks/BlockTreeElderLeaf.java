package chaoscement.innatequalities.blocks;

import chaoscement.innatequalities.InnateQualities;
import chaoscement.innatequalities.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;

public class BlockTreeElderLeaf extends Block{

	public BlockTreeElderLeaf() {
		super(Material.LEAVES);
		setUnlocalizedName(Reference.InnateQualitiesBlocks.TREEELDERLEAF.getUnlocalizedName());
		setRegistryName(Reference.InnateQualitiesBlocks.TREEELDERLEAF.getRegistryName());
		setHardness(1.0F);
		setCreativeTab(InnateQualities.CREATIVE_TAB);
	}

}
