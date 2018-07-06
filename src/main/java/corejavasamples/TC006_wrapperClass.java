package corejavasamples;

public class TC006_wrapperClass {
	public static void main(String[] args) {
		
		String x = "100";
		System.out.println(x+20);//output 10020
		
		//data conversion: String to int
		int i = Integer.parseInt(x);
		System.out.println(i+20);//output 120
		
		//String to double conversion
		String y = "12.33";
		double d = Double.parseDouble(y);
		System.out.println(d+10);
		
		//String to boolean
		String k = "true";
		boolean b = Boolean.parseBoolean(k); 
		System.out.println(b);
		
		//int to String 
		int j = 200;
		String s = String.valueOf(j); 
		System.out.println(s+20);//output 20020

	}

}

