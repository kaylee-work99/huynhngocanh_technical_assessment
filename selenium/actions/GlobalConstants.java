package actions;

import java.io.File;

public class GlobalConstants {
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 10;
	public static String ROOT_FOLDER = System.getProperty("user.dir");
	public static String UPLOAD_FOLDER = ROOT_FOLDER + File.separator + "selenium" + File.separator + "resources" + File.separator;
}
