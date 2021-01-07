package propertyReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import commonFile.ConstantKey;

public class Objectproperty {

	Properties propObj = null;
	FileInputStream fileObject = null;

	public Properties propertyFileRead() throws IOException {

		propObj = new Properties();
		fileObject = new FileInputStream(ConstantKey.PROPERTY_FILE_NAME);

		propObj.load(fileObject);

		return propObj;
	}
	public String getReportConfigPath(){
	 String reportConfigPath = propObj.getProperty("/AmazonAssignment/src/test/resources/extent-config.xml");
	 if(reportConfigPath!= null) return reportConfigPath;
	 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
	}
}
