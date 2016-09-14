package chaoscement.innatequalities.proxy;

import chaoscement.innatequalities.init.ModItems;

public class ClientProxy implements CommonProxy{

	@Override
	public void init() {
		ModItems.registerRenders();
	}
}
