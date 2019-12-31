package myaddrbook.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取数据库配置文件的工具类
 * @author Think
 *
 */
public class ReaderDbConfigUtil {
	public static String getValue(String key) {
		String value = null;
		Properties prop = new Properties();
		
		Class c = ReaderDbConfigUtil.class;
		InputStream inStream = c.getResourceAsStream("db_config.properties");
		try {
			prop.load(inStream);
			value=prop.getProperty(key);
		} catch (IOException e) {
			// 日志记录
			e.printStackTrace();
		}
		
		return value;
	}
}
