package MiscProb;

public class PowOfN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.pow(-2, -4));
		
		float x = -2; 
        int y = -4; 
        System.out.printf("%f", power(x, y));
        x = 2; 
        y = 2; 
        System.out.printf("%f", power(x, y));

	}
	
	static float power(float x, int y) 
	{ 
		float temp; 
		if( y == 0) 
			return 1; 
		temp = power(x, y/2); 
		
		if (y%2 == 0) 
			return temp*temp; 
		else
		{ 
			if(y > 0) 
				return x * temp * temp; 
			else
				return (temp * temp) / x; 
		} 
	} 

}
