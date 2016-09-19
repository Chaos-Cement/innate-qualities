package chaoscement.innatequalities.util.gen;

import java.util.Random;

import chaoscement.innatequalities.init.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

// Remove abstract
public abstract class GenerationHandler implements IWorldGenerator {

	//Overworld generators
    private WorldGenMinable genOreLivingIron;
    
    public GenerationHandler() {
        genOreLivingIron = new WorldGenMinable(ModBlocks.oreLivingIron.getDefaultState(), 8);
    }
 
    @Override
    public void generate(Random rnd, int chunk_X, int chunk_Z, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimension()) {
            case 0: //Overworld
                this.runGeneration(genOreLivingIron, world, rnd, chunk_X, chunk_Z, 20, 0, 64);
                break;
            case 1: //Nether
 
                break;
            case 2: //End
 
                break;
        }
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
    
    // Remove abstract
	public abstract boolean generate(World world, Random random, BlockPos pos);


	
        
        
        
}
