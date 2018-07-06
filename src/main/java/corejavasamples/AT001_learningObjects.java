package corejavasamples;

import org.testng.annotations.Test;

//import org.testng.annotations.Test;


public class AT001_learningObjects {
	

//these are global variable or class level variables
int a;
int b;
@Test
public static void main(String[] args) {
//this is how we represent a object in java
	// we use class name to represent a object
	//here c is the object reference variable
	//new learningAboutObjects() is the new object we have created
	AT001_learningObjects c = new AT001_learningObjects();
	
	//this is how we represent global variables inside a method
	c.a=10;
		System.out.println(c.a);	
	c.b =20;
	System.out.println(c.b);
}

}