package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertyFileUtility {
	
	
	public String readDataFromPropertyFile(String dataTobeRead) throws IOException{
	
	FileInputStream fisP= new FileInputStream(IConstantUtility.prop);
	Properties pObj= new Properties();
	pObj.load(fisP);
	
	String value= pObj.getProperty(dataTobeRead);
	
	return value;
	}
}
