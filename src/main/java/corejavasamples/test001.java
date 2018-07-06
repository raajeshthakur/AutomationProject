package corejavasamples;

public class test001 {
	
public static void main(String[] args) {
	
		// TODO Auto-generated method stub
	
test001 obj= new test001();
obj.simpleprint();
//---
int secmethod=obj.TestSum();
System.out.println(secmethod);

String st=obj.teststring();
System.out.println(st);

int fthmthod=obj.sumint(100, 200);
System.out.println(fthmthod);
}
public void simpleprint() 
{
	System.out.println("simple selenium method");
}
//this is the second method and here we are returning integer value as output
public int TestSum() {
	int a=20;
	int b=30;
	int c=a+b;
	return c;
	
}
//this is third method and here we are returning string value as output
public String teststring()
	{
		String S ="Selenium is good tool to automate";
		
	return S;
}
//this is 4th method and here we are entering int values from method
public int sumint(int x, int y)
{
	int z= x+y;
	return z;
}
}
