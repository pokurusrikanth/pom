package threadLocal;

import org.testng.annotations.BeforeTest;

import listener.Data;

public class Configuration {

	@BeforeTest
	public void beforetest() {
		Data.set(new Data());
		Commonmethods.set(new Commonmethods());

	}

}
