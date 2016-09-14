package chaoscement.innatequalities;

public class Reference {

    public static final String MODID = "innatequalities";
    public static final String VERSION = "0.0.1";
    
    public static final String CLIENT_PROXY_CLASS = "chaoscement.innatequalities.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "chaoscement.innatequalities.proxy.ServerProxy";

	public static enum InnateQualitiesItems {
		ACORN("acorn", "ItemAcorn");
		
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
