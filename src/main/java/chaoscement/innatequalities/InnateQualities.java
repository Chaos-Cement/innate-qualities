package chaoscement.innatequalities;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import chaoscement.innatequalities.init.ModBlocks;
import chaoscement.innatequalities.init.ModItems;
import chaoscement.innatequalities.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(useMetadata = true,
	 modid = InnateQualities.modID, 
	 version = InnateQualities.modVersion, 
	 updateJSON = "https://raw.githubusercontent.com/Chaos-Cement/innate-qualities/master/update.json")

public class InnateQualities
{
	
	public static final String modID = Reference.MODID;
	public static final String modVersion = "0.0.1";
	public static final String modName = "Innate Qualities";
	
	@Instance(modID)
    public static InnateQualities instance;
	 
	
	public static Logger logger = LogManager.getLogger(modID);
    
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	public static CreativeTabs CREATIVE_TAB = new ModTab();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger.warn("<" + modID + "> We should add a config just for fun!");
		logger.info("<" + modID + "> PreInit stage started");
		proxy.preInit(event);
		logger.info("<" + modID + "> PreInit stage finished");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		logger.info("<" + modID + "> Init stage started");
		proxy.init(event);
		logger.info("<" + modID + "> Init stage finished");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		logger.info("<" + modID + "> PostInit stage started");
		logger.info("<" + modID + "> PostInit stage finshed");
	}
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//    @SidedProxy
//    public static CommonProxy proxy;
//
//    @Mod.Instance
//    public static InnateQualities instance;
//
//    public static Logger logger;
//
//    @Mod.EventHandler
//    public void preInit(FMLPreInitializationEvent event) {
//        logger = event.getModLog();
//        proxy.preInit(event);
//    }
//
//    @Mod.EventHandler
//    public void init(FMLInitializationEvent e) {
//        proxy.init(e);
//    }
//
//    @Mod.EventHandler
//    public void postInit(FMLPostInitializationEvent e) {
//        proxy.postInit(e);
//    }
//
//    public static class CommonProxy {
//        public void preInit(FMLPreInitializationEvent e) {
//            // Initialization of blocks and items typically goes here:
//           // ModBlocks.init();
//           // ModItems.init();
//           // ModCrafting.init();
//        }
//
//        public void init(FMLInitializationEvent e) {
//    
//        }
//
//        public void postInit(FMLPostInitializationEvent e) {
//    
//        }
//    }
//
//
//    public static class ClientProxy extends CommonProxy {
//        @Override
//        public void preInit(FMLPreInitializationEvent e) {
//            super.preInit(e);
//            // Typically initialization of models and such goes here:
//           // ModRenderers.preInit();
//        }
//    }
//
//    public static class ServerProxy extends CommonProxy {
//    
//    }
}
