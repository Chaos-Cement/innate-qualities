package chaoscement.innatequalities;

import org.apache.logging.log4j.Logger;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = InnateQualities.MODID, version = InnateQualities.VERSION, updateJSON = "https://raw.githubusercontent.com/Chaos-Cement/innate-qualities/master/update.json", useMetadata = true)
public class InnateQualities
{
    public static final String MODID = "innatequalities";
    public static final String VERSION = "0.0.1";
    
//    @EventHandler
//    public void init(FMLInitializationEvent event)
//    {
//        // some example code
//        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
//    }
    
    @SidedProxy
    public static CommonProxy proxy;

    @Mod.Instance
    public static InnateQualities instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    public static class CommonProxy {
        public void preInit(FMLPreInitializationEvent e) {
            // Initialization of blocks and items typically goes here:
           // ModBlocks.init();
           // ModItems.init();
           // ModCrafting.init();
        }

        public void init(FMLInitializationEvent e) {
    
        }

        public void postInit(FMLPostInitializationEvent e) {
    
        }
    }


    public static class ClientProxy extends CommonProxy {
        @Override
        public void preInit(FMLPreInitializationEvent e) {
            super.preInit(e);
            // Typically initialization of models and such goes here:
           // ModRenderers.preInit();
        }
    }

    public static class ServerProxy extends CommonProxy {
    
    }
}
