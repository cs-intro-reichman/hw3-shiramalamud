// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6   
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) 
	{
		if(x1>0)
		{
			for(int i=0; i<x1; i++)
			{
				x2++;
			}

		}
		else
		{
			for (int j=0; j>x1; j--) 
			{
					x2--;
			}
		}
		return x2;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) 
	{
		if (x2 > 0) {
			for (int i = 0; i < x2; i++)
			 {
				x1--;  
			}
		}
		else 
		{
			if (x2 < 0)
			 {
				for (int i = 0; i < Math.abs(x2); i++) {
					x1++;  
				}
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) 
	{
	
        int result=0;
        boolean b= false;
        if((x1==0)|| (x2==0))
        {
            return 0;
        }
        else if ((x1>0 && x2<0)|| (x1<0 && x2>0))
        {
            b=true;

        }
        x1= Math.abs(x1);
        x2=Math.abs(x2);
        for(int i=0;i<x2;i++)
        {
            result=plus(result,x1);
        }
        if(b)
        {
            result=minus(0,result);
        }
            return result;
	}

	
    // Returns x^n (for n >= 0)
    public static int pow(int x, int n) 
	{
        int sum = 1;
        for (int i =0; i<n; i++)
        {
          sum = times(sum, x);
        }
        return sum;
	}
    

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2)
	 {
		int count=0;
        if(x1>=x2)
        {
            while(x1>=x2)
            {
                x1=minus(x1,x2);
                count++;
            }
        }
    if(x1<0 && x2<0)
    {
        x1= times(x1,-1);
        x2= times(x2,-1);
        if(x1>=x2)
        {
            while(x1>=x2)
            {
                x1=minus(x1,x2);
                 count++;
        }
        }
    }
    if(x1<0 && x2>0)
    {
        x1= times(x1,-1);
        if(x1>=x2)
        {
                 while(x1>=x2)
            {
                 x1=minus(x1,x2);
                count++;
            }
            count= times(count,-1);
        }
		
    if(x1>0 && x2<0)
    {
        x2= times(x2,-1);
        if(x1>=x2)
        {
            while(x1>=x2)
        {
            x1=minus(x1,x2);
            count++;
        }
        count= times(count,-1);
        }
    }
    }
          return count;
    }
	

	// Returns x1 % x2
	public static int mod(int x1, int x2)
	 {
		int count = 0;
        int n = x1;
        while (n >= x2)
		 {
               n = minus(n, x2);
         }
         return n;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) 
	{
		int sq=0;
		if(x==1)
		{
			sq=1;
		}
		for(int i=1;i<x;i++)
		{
			if(pow(i,2)==x)
			{
				sq=i;
			}
			if(x-pow(i, 2)<0)
			{
				sq=minus(i, 1);
				break;
			}
		}
		return sq;
	}	  	  
}