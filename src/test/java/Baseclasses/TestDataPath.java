package Baseclasses;

import java.io.File;
import common.DriverBase;

public class TestDataPath
{
	private static String TestData = "D:\\workspace\\MarketLive\\src\\test\\resources\\TestData\\TestData.xlsx";
	public TestDataPath() {
	}

	
	public void setTestData(String BaseURL)
	{
		if(BaseURL.toLowerCase().contains("onekingslane"))
		{
			TestData = new File("src/test/resources/TestData/onekingslane/onekingslane.xlsx").getAbsolutePath();
			if(TestData.contains("target"))
			{
				TestData = handleTarget(TestData);
			}
		}
		if(BaseURL.toLowerCase().contains("countrycurtains"))
		{
			TestData = new File("src/test/resources/TestData/countrycurtains/countrycurtainsTestData.xlsx").getAbsolutePath();
			if(TestData.contains("target"))
			{
				TestData = handleTarget(TestData);
			}
		}
		if(BaseURL.toLowerCase().contains("frenchtoast"))
		{
			TestData = new File("src/test/resources/TestData/frenchtoast/frenchtoastTestData.xlsx").getAbsolutePath();
			if(TestData.contains("target"))
			{
				TestData = handleTarget(TestData);
			}
		}
		if(BaseURL.toLowerCase().contains("learningresources.co.uk") || BaseURL.toLowerCase().contains("learningresourcesuk"))
		{
			TestData = new File("src/test/resources/TestData/LRUK/LRUKTestData.xlsx").getAbsolutePath();
			if(TestData.contains("target"))
			{
				TestData = handleTarget(TestData);
			}
		}
		if((BaseURL.toLowerCase().contains("learningresources.com"))|| BaseURL.toLowerCase().contains("learningresources-v161"))
		{
			TestData = new File("src/test/resources/TestData/LRUS/LRUSTestData.xlsx").getAbsolutePath();
			if(TestData.contains("target"))
			{
				TestData = handleTarget(TestData);
			}
		}
		if(BaseURL.toLowerCase().contains("paulayoung"))
		{
			TestData = new File("src/test/resources/TestData/paulayoung/paulayoungTestData.xlsx").getAbsolutePath();
			if(TestData.contains("target"))
			{
				TestData = handleTarget(TestData);
			}
		}
		if(BaseURL.toLowerCase().contains("wig.com"))
		{
			TestData = new File("src/test/resources/TestData/wig/wigTestData.xlsx").getAbsolutePath();
			if(TestData.contains("target"))
			{
				TestData = handleTarget(TestData);
			}
		}
		if(BaseURL.toLowerCase().contains("beautybrands"))
		{
			TestData = new File("src/test/resources/TestData/BeautyBrands/beautybrands.xlsx").getAbsolutePath();
			if(TestData.contains("target"))
			{
				TestData = handleTarget(TestData);
			}
		}
		if(BaseURL.toLowerCase().contains("worldmarket"))
		{
			TestData = new File("src/test/resources/TestData/WorldMarket/worldmarketTestData.xlsx").getAbsolutePath();
			if(TestData.contains("target"))
			{
				TestData = handleTarget(TestData);
			}
		}
	}
	
	public String getTestDataPath()
	{
		setTestData(new DriverBase().GetBaseUrl());
		System.out.println(TestData);
		return TestData;
	}
	
	public String handleTarget(String Test)
	{
		String[] test2 = Test.split("target");
		test2[0] = test2[0].substring(0, test2[0].length()-1);
		System.out.println(test2[0]+test2[1]);
		Test = test2[0]+test2[1];
		return Test;
	}

}
