package corejavasamples;

public class AT003_learnmethodOrFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AT003_learnmethodOrFunction obj = new AT003_learnmethodOrFunction();
		//1
		obj.test1();
		//2
		int secondMethod=obj.test2();
		System.out.println(secondMethod);
	    //3
		String thirdMethod=obj.test3();
		System.out.println(thirdMethod);
		//4
		int fourthMethod=obj.test4(100,200);
		System.out.println(fourthMethod);
	}
	//---------------------------------------------------------------------------
	//this method had void in it meaning we are not returning anything
	public void test1(){
		System.out.println("this is first method");
	}
	//--------------------------------------------------------------------------------
	// this is the second method and here we are returning integer value as output
	public int test2(){
		int a = 10;
		int b = 20;
		int c = a+b;
		return c;
	}
	//---------------------------------------------------------------------------------
	// this is third method and here we are returning string value as output
	public String test3(){
		String f = "SeleniumTraining";
		return f;
	}	
	//---------------------------------------------------------------------------------
	// this is 4th method and here we are entering int values from method
	public int test4(int x, int y)
	{
		int z = x+y;
		return z;
	}		
}
