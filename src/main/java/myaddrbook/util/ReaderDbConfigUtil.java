package myaddrbook.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ��ȡ���ݿ������ļ��Ĺ�����
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
			// ��־��¼
			e.printStackTrace();
		}
		
		return value;
	}
}
