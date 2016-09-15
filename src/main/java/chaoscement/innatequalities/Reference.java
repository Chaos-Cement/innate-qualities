package chaoscement.innatequalities;

public class Reference {

    public static final String MODID = "innatequalities";
    public static final String VERSION = "0.0.1";
    
    public static final String CLIENT_PROXY_CLASS = "chaoscement.innatequalities.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "chaoscement.innatequalities.proxy.ServerProxy";

	public static enum InnateQualitiesItems {
		
		// Item declaration (ALL CAPS UNLOCALIZED NAME) with unlocalized name and registry name
		// Style: start unlocalized name with lower case; start registry name with Upper case Item
		ACORN("acorn", "ItemAcorn"),
		INGOTLIVINGIRON("ingotLivingIron", "ItemIngotLvingIron");
		
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
}
