package barnvonproto.projecteulermaven;

import java.math.BigInteger;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jesse Raffield
 */
public class Helper 
{
    public static int fibbi(int n)
    {
        if(n == 0)
            return 0;
        
        int prev = 0;
        int curr = 1;
        int next = prev + curr;
        
        for(int i = 0; i < n; i++)
        {
            prev = curr;
            curr = next;
            next = prev + curr;
        }
        
        return curr;
    }
    
    public static long sum(ArrayList<Long> list)
    {
        long sum = 0;
        
        for(long n : list)
            sum += n;
        
        return sum;
    }
    
    public static double totient(int n)
    {
        ArrayList<int[]> factors = primeFactorize(n);
        
        double prod = n;
        
        for(int[] f : factors)
        {
            prod *= (1.0 - 1.0/f[0]);
        }
        
        return prod;
    }
    
    public static double totient(int n, ArrayList<Integer> primes)
    {
        ArrayList<int[]> factors = primeFactorize(n, primes);
        
        double prod = n;
        
        for(int[] f : factors)
        {
            prod *= (1.0 - 1.0/f[0]);
        }
        
        //System.out.println("\t" + factors.size());
        
        return prod;
    }
    
    public static ArrayList<int[]> primeFactorize(int n, ArrayList<Integer> primes)
    {
        ArrayList<int[]> factors = new ArrayList<>();
        
        for(int p : primes)
        {
            if(p > n)
                break;
            
            int[] f = {p, 0};

            while(n%p == 0)
            {
                f[1]++;
                n = n/p;
            }

            if(f[1] > 0)
                factors.add(f);
        }
        
        /*for(int[] f : factors)
            System.out.print(f[0] + " ");
        System.out.println();
        */
        
        return factors;
    }
    
    public static ArrayList<int[]> primeFactorize(int n)
    {
        ArrayList<int[]> factors = new ArrayList<>();
        
        for(int k = 2; k < n; k++)
        {
            if(isPrime(k))
            {
                int[] f = {k, 0};
                
                while(n%k == 0)
                {
                    f[1]++;
                    n = n/k;
                }
                
                factors.add(f);
            }
        }
        
        return factors;
    }
    
    public static ArrayList<Long> properDivisors(long n)
    {
        ArrayList<Long> list = new ArrayList<>();
        
        for(long i = 1; i < n; i++)
        {
            if(n%i == 0)
            {
                list.add(i);
            }
        }
        
        return list;
    }
    
    public static long sumDivisors(long n)
    {
        return sum(properDivisors(n));
    }
    
    public static ArrayList<Long> factor(long n)
    {
        long sqrtn = (int)Math.sqrt(n) + 1;
        
        ArrayList<Long> list = new ArrayList<>();
        
        for(long i = 2; i < sqrtn; i++)
        {
            if(n%i == 0)
            {
                list.add(i);
                list.add(n/i);
            }
        }
        
        if(isSquare(n))
            list.add((long)Math.sqrt(n));
        
        return list;
    }

    public static int shapeNumber(int k, int n)
    {
        return n*(n*k - 2*n - k + 4)/2;
    }
    
    public static int indexOfShapeNumber(int k, int p)
    {
        int rad = integerSquareRoot(k*k - 8*k + 16 + 8*p*k - 16*p);
        
        if(rad != -1)
        {
            int num = k - 4 + rad;
            int den = 2*(k-2);
            
            if(num%den == 0)
                return num/den;
        }
        
        return -1;
    }
    
    public static boolean isPrime(long n)
    {
        if(n == 2)
            return true;
        
        if(n%2 == 0 || n < 0)
            return false;
        
        long sqrtn = (int)Math.sqrt(n) + 1;
        
        for(long i = 3; i <= sqrtn; i+=2)
        {
            if(n%i == 0)
                return false;
        }
        
        return true;
    }
    
    public static boolean isCurious(int n)
    {
        String s = ""+n;
        
        int sum = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            int k = Character.getNumericValue(s.charAt(i));
            
            sum += factorial(k);
        }
        
        return sum == n;
    }
    
    public static long choose(int n, int k)
    {
        if(k == 0)
            return 1;
        if(k > n/2)
            return choose(n,n-k);
        return n * choose(n-1,k-1) / k;
    }
    
    public static BigInteger bigChoose(int n, int k)
    {
        BigInteger A = bigFactorial(n);
        BigInteger B = bigFactorial(k);
        BigInteger C = bigFactorial(n-k);
        
        return A.divide(B.multiply(C));
    }
    
    public static boolean isPalindrome(String s)
    {
        int L = s.length();
        
        for(int i = 0; i < L/2; i++)
        {
            if(s.charAt(i) != s.charAt(L-i-1))
                return false;
        }
        
        return true;
    }
    
    public static boolean isPandigital(int n, int digits)
    {
        char[] list = {'1','2','3','4','5','6','7','8','9'};
        
        String s = ""+n;
        
        for(int i = 0; i < digits; i++)
        {
            int index = s.indexOf(list[i]);
            
            if(index == -1)
                return false;
        }
        
        return true;
    }
    
    public static boolean isSquare(long n)
    {
        double d = Math.sqrt(n);
        
        return (d - (int)d < 0.0001);
            
    }

    public static int integerSquareRoot(int n)
    {
        double d = Math.sqrt(n);
        
        if(d - (int)d < 0.0001)
            return (int)d;
        
        return -1;
    }
    
    public static int CollatzLength(long N, Map<Long,Integer> map)
    {     
        int k = map.getOrDefault(N, -1);
        if(k != -1)
            return k;
        
        long n = N;
        int length = 0;
        
        while(n != 1)
        {
            if(n%2 == 0)
                n = n/2;
            else
                n = 3*n+1;
            
            k = map.getOrDefault(n, -1);
            if(k != -1)
            {
                map.put(N, length+k+1);
                return length+k+1;
            }

            length++;
        }
        
        map.put(N, length+1);
        return length+1;
    }
    
    public static BigInteger bigFactorial(int n)
    {
        BigInteger prod = BigInteger.ONE;
        
        for(int i = 2; i <= n; i++)
        {
            prod = prod.multiply(BigInteger.valueOf(i));
        }
        
        return prod;
    }
    
    public static long factorial(long n)
    {
        long prod = 1;
        
        for(long i = 2; i <= n; i++)
        {
            prod *= i;
        }
        
        return prod;
    }
    
    public static String numberToWord(int number, boolean compound) 
    {
        // variable to hold string representation of number 
        String words = "";
        String unitsArray[] = { "zero", "one", "two", "three", "four", "five", "six", 
                        "seven", "eight", "nine", "ten", "eleven", "twelve",
                        "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", 
                        "eighteen", "nineteen" };
        String tensArray[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty",
                         "sixty", "seventy", "eighty", "ninety" };

        if (number == 0) 
        {
            return "zero";
        }
        // add minus before conversion if the number is less than 0
        if (number < 0) 
        { 
            // convert the number to a string
            String numberStr = "" + number;
            // remove minus before the number 
            numberStr = numberStr.substring(1);
            // add minus before the number and convert the rest of number
            return "minus " + numberToWord(Integer.parseInt(numberStr),false);
        } 
        // check if number is divisible by 1 million
        if ((number / 1000000) > 0) 
        {
            words += numberToWord(number / 1000000, false) + " million ";
            number %= 1000000;
        }
        // check if number is divisible by 1 thousand
        if ((number / 1000) > 0) 
        {
            words += numberToWord(number / 1000, false) + " thousand ";
            number %= 1000;
        }
        // check if number is divisible by 1 hundred
        if ((number / 100) > 0) 
        {
            words += numberToWord(number / 100, false) + " hundred ";
            number %= 100;
            
            if(number != 0)
                words += " and ";
        }

        if (number > 0) 
        {
            //if(compound)
            //words += " and ";
            
            // check if number is within teens
            if (number < 20) {
                     // fetch the appropriate value from unit array
                     words += unitsArray[number];
            } else { 
                    // fetch the appropriate value from tens array
                    words += tensArray[number / 10]; 
                    if ((number % 10) > 0) {
                       words += "-" + unitsArray[number % 10];
                }  
            }
        }

        return words;
    }
    
    public static ArrayList<Integer> listPrimes(int n)
    {
        return listPrimes(2, n);
    }
    
    public static ArrayList<Integer> listPrimes(int a, int b)
    {
        ArrayList<Integer> list = new ArrayList<>();
        
        if(a <= 2)
            list.add(2);
        
        for(int i = a; i <= b; i++)
        {
            if(isPrime(i))
                list.add(i);
        }
        
        return list;
    }
    
    public static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static char[] ALPHABET_ARRAY = ALPHABET.toCharArray();
    public static String DIGITS = "0123456789";
    public static char[] DIGITS_ARRAY = DIGITS.toCharArray();
    
    public static boolean isPermutation(int a, int b)
    {
        String sA = ""+a;
        String sB = ""+b;
        
        if(sA.length() != sB.length())
            return false;
        
        int[] countA = new int[DIGITS_ARRAY.length];
        int[] countB = new int[DIGITS_ARRAY.length];
        
        for(char c : sA.toCharArray())
        {
            countA[DIGITS.indexOf(c)]++;
        }
        
        for(char c : sB.toCharArray())
        {
            countB[DIGITS.indexOf(c)]++;
        }
        
        for(int i = 0; i < DIGITS_ARRAY.length; i++)
        {
            if(countA[i] != countB[i])
                return false;
        }
        
        return true;
    }
    
    public static boolean goldbachPair(int n, ArrayList<Integer> primes)
    {
        boolean ranOut = true;
        
        for(int i = 0; i < primes.size(); i++)
        {
            int p = primes.get(i);
            
            if(p >= n)
            {
                ranOut = false;
                break;
            }
            
            int s = (n-p)/2;
            
            //System.out.println(p + "\t" + s);
            
            if(isSquare(s))
            {
                return true;
            }
        }
        
        if(ranOut)
            System.out.println("Ran out of primes...");
        
        return false;
    }
    
    public static double[] polyFitter(double[] x, double[] y, int n)
    {
        int N = x.length;
        
        double X[] = new double[2 * n + 1];
        for (int i = 0; i < 2 * n + 1; i++) 
        {
            X[i] = 0;
            for (int j = 0; j < N; j++)
            {
                X[i] = X[i] + Math.pow(x[j], i);        //consecutive positions of the array will store N,sigma(xi),sigma(xi^2),sigma(xi^3)....sigma(xi^2n)
            }
        }
        
        double B[][] = new double[n + 1][n + 2], a[] = new double[n + 1];            //B is the Normal matrix(augmented) that will store the equations, 'a' is for value of the final coefficients
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                B[i][j] = X[i + j];            //Build the Normal matrix by storing the corresponding coefficients at the right positions except the last column of the matrix
            }
        }
        
        double Y[] = new double[n + 1];                    //Array to store the values of sigma(yi),sigma(xi*yi),sigma(xi^2*yi)...sigma(xi^n*yi)
        for (int i = 0; i < n + 1; i++) 
        {
            Y[i] = 0;
            for (int j = 0; j < N; j++)
            {
                Y[i] = Y[i] + Math.pow(x[j], i) * y[j];        //consecutive positions will store sigma(yi),sigma(xi*yi),sigma(xi^2*yi)...sigma(xi^n*yi)
            }
        }
        
        for (int i = 0; i <= n; i++)
        {
            B[i][n + 1] = Y[i];                //load the values of Y as the last column of B(Normal Matrix but augmented)
        }
        
        n = n + 1;
        for (int i = 0; i < n; i++)                    //From now Gaussian Elimination starts(can be ignored) to solve the set of linear equations (Pivotisation)
        {
            for (int k = i + 1; k < n; k++)
            {
                if (B[i][i] < B[k][i])
                {
                    for (int j = 0; j <= n; j++) 
                    {
                        double temp = B[i][j];
                        B[i][j] = B[k][j];
                        B[k][j] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < n - 1; i++)            //loop to perform the gauss elimination
        {
            for (int k = i + 1; k < n; k++) 
            {
                double t = B[k][i] / B[i][i];
                for (int j = 0; j <= n; j++)
                {
                    B[k][j] = B[k][j] - t * B[i][j];    //make the elements below the pivot elements equal to zero or elimnate the variables
                }
            }
        }
        
        for (int i = n - 1; i >= 0; i--)                //back-substitution
        {                        //x is an array whose values correspond to the values of x,y,z..
            a[i] = B[i][n];                //make the variable to be calculated equal to the rhs of the last equation
            for (int j = 0; j < n; j++)
            {
                if (j != i)            //then subtract all the lhs values except the coefficient of the variable whose value                                   is being calculated
                {
                    a[i] = a[i] - B[i][j] * a[j];
                }
            }
            a[i] = a[i] / B[i][i];            //now finally divide the rhs by the coefficient of the variable to be calculated
        }
        
        return a;
    }
}
