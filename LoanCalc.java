// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment)
	 {	
		double newloan=loan;
		rate=(rate/100)+1;
		for(int i=0; i<n; i++)
		{
			newloan-=payment;
			newloan*=rate;
		}
		return newloan;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) 
	{
	    iterationCounter=0;
		double g=loan/n;
		double newsum=(endBalance(loan, rate, n, g));
		while(Math.abs(newsum)>=epsilon)
		{
			iterationCounter++;
			g+=epsilon;
			newsum=(endBalance(loan, rate, n, g));
		}
		return g;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
	public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        
        double payment = bruteForceSolver(loan, rate, n, epsilon) -10;
        double L = endBalance(loan, rate, n, loan/n);
        double H = endBalance(loan, rate, n, payment);
        double g = (H+L)/2.0;
        iterationCounter = 0;

        while ((H - L) > epsilon) {
             //L++;
            //H++;
			iterationCounter++;
        if (endBalance(loan, rate, n, g)*L > 0) {
            L = g;
            g = (H+L)/2.0;
        }
        else {
           H = g;
           g = (H+L)/2.0;
        }
    }
        
        return g;
    }
}