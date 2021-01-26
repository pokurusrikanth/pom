package listener;

import org.openqa.selenium.WebDriver;

public class Data {

	private static ThreadLocal<Data> threaddata = new ThreadLocal<Data>();

	public static void set(Data data) {
		threaddata.set(data);
	}

	public static Data get() {
		return threaddata.get();
	}

	public WebDriver driver;

}
