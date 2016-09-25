package chaoscement.innatequalities.util;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import chaoscement.innatequalities.InnateQualities;
import chaoscement.innatequalities.init.ModBlocks;
import chaoscement.innatequalities.util.features.TestTree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class GenerationHandler implements IWorldGenerator {

	//Overworld generators
    private WorldGenMinable genOreLivingIron;
    private TestTree treeTest;
 
    @Override
    public void generate(Random rnd, int chunk_X, int chunk_Z, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimension()) {
            case 0: //Overworld
                this.runGeneration(genOreLivingIron, world, rnd, chunk_X, chunk_Z, 20, 0, 64);
                this.generateSurface(world, rnd, chunk_X, chunk_Z, 20);
                break;
            case 1: //Nether
 
                break;
            case 2: //End
 
                break;
        }
    }
    
    private void generateSurface(World world, Random random, int x, int z, int chancesToSpawn)
    {
    	for(int i = 0; i < chancesToSpawn; i++)
    	{
    	    int randPosX = x + random.nextInt(16);
    	    int randPosY = 50 + random.nextInt(50); //Max Y coordinate
    	    int randPosZ = z + random.nextInt(16);
    	    // int randPosY = ;
    	    //System.out.println("Trying to make a tree at X:" + randPosX + " Y:" + randPosY + " Z:" +randPosZ);
    	    InnateQualities.logger.warn("Trying to make a tree at X:" + randPosX + " Y:" + randPosY + " Z:" +randPosZ);
    	    boolean tree = treeTest.generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
    	    if (tree) {
    	    	InnateQualities.logger.warn("Made a tree at X:" + randPosX + " Y:" + randPosY + " Z:" +randPosZ);
    	    }
    	}
    }
 
    public GenerationHandler() {
        genOreLivingIron = new WorldGenMinable(ModBlocks.oreLivingIron.getDefaultState(), 8);
        treeTest = new TestTree(true);
    }
 
    private void runGeneration(WorldGenerator gen, World world, Random rnd, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
        if(minHeight < 0 || maxHeight > 256 || minHeight > maxHeight) {
            throw new IllegalArgumentException("Illegal height argument for genration!");
        }
 
        int heightDiff = maxHeight - minHeight + 1;
 
        for(int i = 0; i < chancesToSpawn; i++) {
            int x = chunk_X * 16 + rnd.nextInt(16);
            int y = minHeight + rnd.nextInt(heightDiff);
            int z = chunk_Z * 16 + rnd.nextInt(16);
            gen.generate(world, rnd, new BlockPos(x, y, z));
        }
    }
        
        
        
}
