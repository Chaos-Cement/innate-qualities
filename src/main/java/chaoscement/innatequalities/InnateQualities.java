package chaoscement.innatequalities;


import org.apache.logging.log4j.Logger;

import chaoscement.innatequalities.init.ModBlocks;
import chaoscement.innatequalities.init.ModItems;
import chaoscement.innatequalities.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, version = Reference.VERSION, updateJSON = "https://raw.githubusercontent.com/Chaos-Cement/innate-qualities/master/update.json", useMetadata = true)
public class InnateQualities
{
	
	@Instance
    public static InnateQualities instance;
	
	 public static Logger logger;
    
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("Pre Init");
		logger = event.getModLog();
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println("Init");
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println("Post Init");
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
