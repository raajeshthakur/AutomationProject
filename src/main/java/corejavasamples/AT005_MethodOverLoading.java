package corejavasamples;

public class AT005_MethodOverLoading {

	public static void main(String[] args) {
		
			//object created 
			AT005_MethodOverLoading mo= new AT005_MethodOverLoading();
			mo.sum();
			mo.sum(100);
			mo.sum(100,200);
			mo.sum(9);
			}
		
		//Here we have created same method but with diffrent input parameters 
		//and this concept is called as method overloading
		//similar to this sub method we can also create in main method too
		public void sum()
		{
			System.out.println("this is first method");
			
		}
		public void sum(int i)
		{
			System.out.println("this is second method");
			System.out.println(i);
		}
		public void sum(int i , int j)
		{
			
			System.out.println("this is third method");
			System.out.println(i+j);
		}
		public void sum(double d){
			System.out.println("this is fourth method");
			System.out.println(d);
		}
	}
