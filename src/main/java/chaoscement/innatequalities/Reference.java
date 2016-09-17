package chaoscement.innatequalities;

public class Reference {

    public static final String MODID = "InnateQualities";
    
    public static final String CLIENT_PROXY_CLASS = "chaoscement.innatequalities.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "chaoscement.innatequalities.proxy.ServerProxy";

	public static enum InnateQualitiesItems {
		
		// Item declaration (ALL CAPS UNLOCALIZED NAME) with unlocalized name and registry name
		// Style: start unlocalized name with lower case; start registry name with Upper case Item
		ACORN("acorn", "ItemAcorn"),
		INGOTLIVINGIRON("ingotLivingIron", "ItemIngotLvingIron"),
		
		// Crop stuff
		SEEDFOXGLOVE("seedFoxglove", "ItemSeedFoxglove"),
		FLOWERFOXGLOVE("flowerFoxglove", "ItemFlowerFoxglove");
		
		private String unlocalizedName;
		private String registryName;
		
		InnateQualitiesItems(String unlocalizedName, String registryName) {
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getRegistryName() {
			return registryName;
		}
		
		public String getUnlocalizedName() {
			return unlocalizedName;
		}
	}
	
	public static enum InnateQualitiesBlocks {
		
		// Block declaration (ALL CAPS UNLOCALIZED NAME) with unlocalized name and registry name
		// Style: start unlocalized name with lower case; start registry name with Upper case Block
		ORELIVINGIRON("oreLivingIron", "BlockOreLivingIron");
		
		private String unlocalizedName;
		private String registryName;
		
		InnateQualitiesBlocks(String unlocalizedName, String registryName) {
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getRegistryName() {
			return registryName;
		}
		
		public String getUnlocalizedName() {
			return unlocalizedName;
		}
	}
	
	public static enum InnateQualitiesCrops {
		
		// Block declaration (ALL CAPS UNLOCALIZED NAME) with unlocalized name and registry name
		// Style: start unlocalized name with lower case; start registry name with Upper case Block
		CROPFOXGLOVE("cropFoxglove", "BlockCropFoxglove");
		
		private String unlocalizedName;
		private String registryName;
		
		InnateQualitiesCrops(String unlocalizedName, String registryName) {
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getRegistryName() {
			return registryName;
		}
		
		public String getUnlocalizedName() {
			return unlocalizedName;
		}
	}
}
