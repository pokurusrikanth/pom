package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class UtilityMethods {

	public static HashMap<String, String> getPropertiesData(String filepath) {

		HashMap<String, String> data = new HashMap<>();
		try {
			FileInputStream fis = new FileInputStream(filepath);
			Properties properties = new Properties();
			properties.load(fis);
			Set<Object> allproperties = properties.keySet();
			for (Object props : allproperties) {
				data.putIfAbsent(props.toString(), properties.getProperty(props.toString()));

			}

		} catch (IOException e) {
			System.out.println("exeception while reading poperties file" + filepath);
			System.exit(0);
		}

		return data;

	}

	public static void closeBrowser() {
		System.exit(0);

	}

	public static String gettimestamp() {
		String timestamp = "";
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR);
		int min = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		timestamp = timestamp + month + day + hour + min + second;

		return timestamp;

	}

	public static void creat_Folder(String folderpath) {
		File f = new File(folderpath);
		if (!f.exists()) {
			f.mkdirs();
		}
	}

}
