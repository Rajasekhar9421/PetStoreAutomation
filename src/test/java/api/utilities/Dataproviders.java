package api.utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class Dataproviders 
{
	@DataProvider(name="Object")
	public String[][] getAllData() throws IOException
	{
		String path = System.getProperty("user.dir")+"//TestData//testData.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum =xl.getRowCount("RESTAPI");
		int colcount = xl.getCellCount("RESTAPI", 1);
		
		String apidata[][] = new String[rownum][colcount];
		
		for(int i= 1; i<=rownum;i++)
		{
			for(int j=0; j<colcount; j++)
			{
				apidata[i-1][j]=xl.getCellData("RESTAPI", i, j);
			}
		}
		
		return apidata;
		
	}
	
	@DataProvider(name="UserName")
	public String[] getUserData() throws IOException
	{
		String path = System.getProperty("user.dir")+"//TestData//testData.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum =xl.getRowCount("RESTAPI");
		
		String apidata[] = new String[rownum];
		
		for(int i =1;i<=rownum;i++)
		{
			apidata[i-1]=xl.getCellData("RESTAPI", i, 1);
		}
		
		return apidata;
		
	}
}
