package chaoscement.innatequalities;


import org.apache.logging.log4j.LogManager;
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
}
