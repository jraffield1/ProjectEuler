package barnvonproto.projecteulermaven;


import com.mxgraph.layout.*;
import com.mxgraph.util.mxCellRenderer;
import com.mxgraph.util.mxConstants;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.jgrapht.*;
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm.SpanningTree;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jesse Raffield
 */
public class Problem_A 
{
    public static void problem_1()
    {
        int sum = 0;
        
        for(int i = 0; i < 1000; i++)
        {
            if(i%3 == 0 || i%5 == 0) 
                sum += i;
        }
        
        System.out.println(sum);
    }
    
    public static void problem_2()
    {
        int prev = 0;
        int curr = 1;
        int next = prev + curr;
        
        int sum = 0;
        
        while(curr <= 4000000)
        {
            if(curr % 2 == 0)
                sum += curr;
            
            prev = curr;
            curr = next;
            next = prev + curr;
        }
        
        System.out.println(sum);
    }

    public static void problem_3()
    {
        ArrayList<Long> list = Helper.factor(600851475143l);
        
        Collections.sort(list);
        
        for(int i = 0; i < list.size(); i++)
        {
            if(!Helper.isPrime(list.get(i)))
            {
                list.remove(i);
                i--;
            }
        }
        
        System.out.println(Arrays.toString(list.toArray()));
    }
    
    public static void problem_4()
    {
        int digits = 3;
        int upper = (int)Math.pow(10,digits)-1;
        int lower = (int)Math.pow(10,digits-1);
        
        System.out.println("Numbers between: " + lower + " and " + upper);
        
        ArrayList<Integer> palins = new ArrayList<>();
        
        for(int a = upper; a >= lower; a--)
        {
            for(int b = upper; b >= lower; b--)
            {
                int prod = a*b;
                
                if(Helper.isPalindrome(""+prod))
                {
                    palins.add(prod);
                }
            }
        }
        
        Collections.sort(palins);
        
        System.out.println(Arrays.toString(palins.toArray()));
        System.out.println("Largest = " + palins.get(palins.size()-1));
    }
    
    public static void problem_5()
    {
        for(int i = 100; i < 300000000; i++)
        {
            boolean divides = true;
            
            for(int j = 2; j <= 20; j++)
            {
                if(i%j != 0)
                {
                    divides = false;
                    break;
                }
            }
            
            if(divides)
            {
                System.out.println(i);
                break;
            }
        }
        
        System.out.println(1*2*3*2*5*7*2*3*11*13*2*17*19);
    }
    
    public static void problem_6()
    {
        int sum = 0;
        int sum2 = 0;
        
        int N = 100;
        
        for(int i = 1; i <= N; i++)
        {
            sum += i;
            sum2 += i*i;
        }
        
        System.out.println(sum*sum - sum2);
    }
    
    public static void problem_7()
    {
        int N = 10001;
        
        int p = 2;
        int x = p;
        int n = 1;
        
        while(n < N)
        {
            if(Helper.isPrime(x))
            {
                n++;
                p = x;
            }
            
            x++;
        }
        
        System.out.println(p);
    }
        
    public static void problem_8()
    {
        String bigNumString = "73167176531330624919225119674426574742355349194934" +
                            "96983520312774506326239578318016984801869478851843" +
                            "85861560789112949495459501737958331952853208805511" +
                            "12540698747158523863050715693290963295227443043557" +
                            "66896648950445244523161731856403098711121722383113" +
                            "62229893423380308135336276614282806444486645238749" +
                            "30358907296290491560440772390713810515859307960866" +
                            "70172427121883998797908792274921901699720888093776" +
                            "65727333001053367881220235421809751254540594752243" +
                            "52584907711670556013604839586446706324415722155397" +
                            "53697817977846174064955149290862569321978468622482" +
                            "83972241375657056057490261407972968652414535100474" +
                            "82166370484403199890008895243450658541227588666881" +
                            "16427171479924442928230863465674813919123162824586" +
                            "17866458359124566529476545682848912883142607690042" +
                            "24219022671055626321111109370544217506941658960408" +
                            "07198403850962455444362981230987879927244284909188" +
                            "84580156166097919133875499200524063689912560717606" +
                            "05886116467109405077541002256983155200055935729725" +
                            "71636269561882670428252483600823257530420752963450";
        
        int N = 13;
        
        int L = bigNumString.length();
        
        long biggest = 0;
        
        for(int i = 0; i < L-N; i++)
        {
            long prod = 1;
            
            for(int j = 0; j < N; j++)
            {
                //char digitChar = bigNumString.charAt(i+j);

                //int digit = Character.getNumericValue(digitChar);
                
                int digit = Integer.parseInt(bigNumString.substring(i+j,i+j+1));
                
                prod = prod * digit;
            }
            
            if(prod > biggest)
                biggest = prod;
        }
        
        System.out.println(biggest);
    }
    
    public static void problem_9()
    {
        int N = 1000;
        
        for(int a = N-2; a > 0; a--)
        {
            for(int b = N-a; b > 0; b--)
            {
                int c = N - (a + b);
                
                if(a*a + b*b == c*c)
                    System.out.println(a*b*c);
            }
        }
    }
    
    public static void problem_10()
    {
        BigInteger sum = BigInteger.ZERO;
        
        for(int n = 2; n < 2000000; n++)
        {
            if(Helper.isPrime(n))
                sum = sum.add(BigInteger.valueOf(n));
        }
        
        System.out.println(sum);
    }
    
    public static void problem_11()
    {
        int N = 20;
        
        int[][] grid = new int[N][N];
        
        try
        {
            Scanner in = new Scanner(new File("problem11.txt"));
            
            int n = 0;
            while(in.hasNextLine())
            {
                int k = in.nextInt();
                
                int i = n/N;
                int j = n%N;
                n++;
                
                grid[i][j] = k;
            }
            
            in.close();
            
        }catch(IOException e){}
        
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        
        int biggest = 0;
        
        int M = 4;
        
        for(int i = 0; i < N-M; i++)
        {
            for(int j = M; j < N-M; j++)
            {
                int a = 1;
                for(int k = 0; k < M; k++)
                {
                    a = a*grid[i+k][j];
                }
                
                int b = 1;
                for(int k = 0; k < M; k++)
                {
                    b = b*grid[i][j+k];
                }
                
                int c = 1;
                for(int k = 0; k < M; k++)
                {
                    c = c*grid[i+k][j+k];
                }
                
                int d = 1;
                for(int k = 0; k < M; k++)
                {
                    d = d*grid[i+k][j-k];
                }
                
                if(a > biggest)
                    biggest = a;
                
                if(b > biggest)
                    biggest = b;
                
                if(c > biggest)
                    biggest = c;
                
                if(d > biggest)
                    biggest = d;
            }
        }
        
        System.out.println(biggest);
    }
    
    public static void problem_12()
    {
        int N = 500;
        
        long T = 0;
        
        boolean found = false;
        
        for(long i = 1; !found; i++)
        {
            T += i;
            
            int fn = Helper.factor(T).size();
            
            if(fn+2 > N)
            {
                System.out.println(T);
                found = true;
            }
        }
    }
    
    public static void problem_13()
    {
        try
        {
            BigInteger sum = BigInteger.ZERO;
            
            Scanner in = new Scanner(new File("problem13.txt"));
            while(in.hasNextLine())
            {
                String s = in.next();
                
                BigInteger bi = new BigInteger(s);
                
                sum = sum.add(bi);
            }
            in.close();
            
            System.out.println(sum);
        }
        catch(IOException e){}
    }
    
    public static void problem_14()
    {
        Map<Long,Integer> collatzMap = new HashMap<Long,Integer>(); 
        
        int bigNum = 0;
        int biggest = 0;
        
        for(int i = 1; i < 10000000; i++)
        {
            int k = Helper.CollatzLength(i, collatzMap);
            
            if(k > biggest)
            {
                biggest = k;
                bigNum = i;
            }
        }
        
        System.out.println(bigNum);
        System.out.println(biggest);
        System.out.println(collatzMap.size());
    }
    
    public static void problem_15()
    {
        BigInteger a = Helper.bigFactorial(40);
        BigInteger b = Helper.bigFactorial(20);
        
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.divide(b.multiply(b)));
    }
    
    public static void problem_16()
    {
        BigInteger b = BigInteger.valueOf(2).pow(1000);
        
        String s = b + "";
        
        int sum = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            int d = Character.getNumericValue(s.charAt(i));

            sum += d;
        }
        
        System.out.println(s);
        System.out.println(sum);
    }
    
    public static void problem_17()
    {
        System.out.println(Helper.numberToWord(3546, false));
        
        int sum = 0;
        
        for(int i = 1; i <= 1000; i++)
        {
            String s = Helper.numberToWord(i, false).replace(" ", "").replace("-","");
            
            sum += s.length();
        }
        
        System.out.println(sum);
    }
    
    public static void problem_18_67()
    {
        ArrayList<Node[]> graph = new ArrayList<>();
        
        int R = 0;
        
        try
        {
            Scanner in = new Scanner(new File("problem67.txt"));
            while(in.hasNext())
            {
                String[] set = in.nextLine().split(" ");
                Node[] list = new Node[set.length];
                
                for(int i = 0; i < set.length; i++)
                {
                    list[i] = new Node(Integer.parseInt(set[i]), R);
                }
                
                R++;
                graph.add(list);
            }
            in.close();
        }
        catch(IOException e){}
        
        System.out.println("Elements: " + graph.size());
        
        int last = graph.size()-1;
        
        for(int row = 0; row < graph.size()-1; row++)
        {
            Node[] rowA = graph.get(row);
            Node[] rowB = graph.get(row+1);
            
            for(int i = 0; i < rowA.length; i++)
            {
                rowA[i].connect(rowB[i]);
                rowA[i].connect(rowB[i+1]);
            }
        }
        
        ArrayList<Node> flatGraph = new ArrayList<>();
        for(int i = 0; i < graph.size(); i++)
        {
            for(int j = 0; j < graph.get(i).length; j++)
            {
                flatGraph.add(graph.get(i)[j]);
            }
        }
        
        Map<Node,Integer> sumMap = new HashMap<Node,Integer>();
        
        for(int i = 0; i < flatGraph.size(); i++)
        {
            int max = traverseGraph(flatGraph.get(i), flatGraph, sumMap);
            sumMap.put(flatGraph.get(i), max);
        }
        
        ArrayList<Integer> vals = new ArrayList<Integer>(sumMap.values());
        Collections.sort(vals);
        Collections.reverse(vals);
        
        System.out.println(vals.get(0));
    }
    
    public static int traverseGraph(Node n, ArrayList<Node> graph, Map<Node,Integer> sumMap)
    {
        if(n.row == 0)
            return n.value;
        
        if(sumMap.containsKey(n))
        {
            return sumMap.get(n);
        }
        
        int biggest = -1;
        
        ArrayList<Node> neighbors = n.nodeList;
        
        for(Node m : neighbors)
        {
            if(m.row < n.row)
            {
                int sum = traverseGraph(m, graph, sumMap) + n.value;
                
                if(sum > biggest)
                    biggest = sum;
            }
        }
        
        return biggest;
    }
    
    public static void problem_20()
    {
        BigInteger bi = Helper.bigFactorial(100);
        
        int sum = 0;
        
        String s = bi.toString();
        
        for(int i = 0; i < s.length(); i++)
        {
            int k = Character.getNumericValue(s.charAt(i));
            
            sum += k;
        }
        
        System.out.println(sum);
    }
    
    public static void problem_21()
    {
        ArrayList<Long> friends = new ArrayList<>();
        
        for(long a = 1; a < 10000; a++)
        {
            if(friends.contains(a))
                continue;
            
            long b = Helper.sum(Helper.properDivisors(a));
            
            if(a == b)
                continue;
            
            long c = Helper.sum(Helper.properDivisors(b));
            
            if(a == c)
            {
                if(!friends.contains(a))
                    friends.add(a);
                
                if(b < 10000)
                    if(!friends.contains(b))
                            friends.add(b);
            }
        }
        
        System.out.println(Helper.sum(friends));

        System.out.println(Arrays.toString(Helper.properDivisors(220).toArray()));
        System.out.println();
    }
    
    public static void problem_22()
    {
        ArrayList<String> names = new ArrayList<>();
        
        try
        {
            Scanner in = new Scanner(new File("problem22.txt"));
            while(in.hasNext())
            {
                names.add(in.next().toLowerCase());
            }
            in.close();
        }
        catch(IOException e){}
        
        Collections.sort(names);

        int sum = 0;
        
        for(int i = 0; i < names.size(); i++)
        {
            String s = names.get(i);
            
            for(int j = 0; j < s.length(); j++)
            {
                int k = (int)s.charAt(j) - 96;
                sum += k*(i+1);
            }
        }
        System.out.println(sum);
    }
    
    public static void problem_23()
    {
        long sum = 0;
        
        ArrayList<Integer> abundantList = new ArrayList<>();
        
        for(int n = 12; n < 28123; n++)
        {
            if(n%100 == 0)
                System.out.println("n1: " + n);
            
            int d = (int)Helper.sumDivisors(n);
            
            if(d > n)
                abundantList.add(n);
        }
        
        for(int n = 12; n < 28123; n++)
        {
            if(n%100 == 0)
                System.out.println("n2: " + n);
            
            for(int na : abundantList)
            {
                int diff = n-na;
                
                if(diff <= 0)
                    break;
                
                if(abundantList.contains(diff))
                {
                    sum += n;
                    break;
                }
            }
        }
        
        System.out.println(sum);
    }

    public static void problem_25()
    {
        BigInteger prev = BigInteger.ZERO;
        BigInteger curr = BigInteger.ONE;
        BigInteger next = prev.add(curr);
        
        int index = 1;
        while(true)
        {
            prev = curr;
            curr = next;
            next = prev.add(curr);
            
            index++;
            
            if(curr.toString().length() >= 1000)
            {
                break;
            }
        }
        
        System.out.println(index);
    }
    
    public static void problem_26()
    {
        ArrayList<Integer> elements = new ArrayList<Integer>();
        
        for(int n = 0; n <= 2; n++)
            elements.add(n);
        
        int num = 4;
        
        ArrayList<Integer> combo = new ArrayList<Integer>();
        
        /*while(num >= 0)
        {
            int fact = (int)Helper.factorial(elements.size()-1);
            
            int a = num/fact;
            
            System.out.println(a);
            
            combo.add(elements.get(a));
            elements.remove(a);
            
            num -= a*fact;
        }*/
        
        int fact = (int)Helper.factorial(elements.size()-1);
        
        int a = num/fact;
        
        combo.add(elements.get(a-1));
        
        num -= a*fact;
        
        System.out.println(num);
        System.out.println(fact);
        System.out.println(a);
        System.out.println(combo);
    }
    
    public static void problem_27()
    {
        int A = -1;
        int B = -1;
        int nmax = 0;
        
        for(int a = -1000; a < 1000; a++)
        {    
            for(int b = -1000; b < 1000; b++)
            {
                int n = 0;
                
                int p = n*n + a*n + b;
                
                while(Helper.isPrime(p))
                {
                    n++;
                    p = n*n + a*n + b;
                }
                
                if(n > nmax)
                {
                    nmax = n;
                    A = a;
                    B = b;
                }
            }
        }
        
        System.out.println(nmax + "\t" + A + "\t" + B + "\t" + (A*B));
        
        for(int n = 0; n <= nmax; n++)
        {
            int p = n*n + A*n + B;
            
            System.out.println(n + "\t" + p + "\t" + Helper.isPrime(p));
        }
    }
    
    public static void problem_28()
    {
        int sum = 1;
        
        int N = 1001;
        
        for(int n = 3; n <= N; n += 2)
        {
            int k = 4*n*n - 6*n + 6;
            sum += k;
        }
        
        System.out.println(sum);
    }

    public static void problem_30()
    {
        int total = 0;
        
        for(int n = 100; n < 1000000; n++)
        {
            int sum = 0;
            
            String s = ""+n;
            
            for(char c : s.toCharArray())
            {
                int k = Character.getNumericValue(c);
                
                sum += Math.pow(k, 5);
                
                if(sum > n)
                    break;
            }
            
            if(sum == n)
            {
                total += n;
                System.out.println(n);
            }
        }
        
        System.out.println("Sum: " + total);
    }
    
    public static void problem_34()
    {
        System.out.println(Helper.isCurious(145));
        
        long sum = 0;
        
        for(int i = 3; i < 1000000; i++)
        {
            if(Helper.isCurious(i))
                sum += i;
        }
        
        System.out.println(sum);
    }
      
    public static void problem_36()
    {
        int sum = 0;
        
        for(int i = 1; i < 1000000; i++)
        {
            String A = ""+i;
            String B = Integer.toBinaryString(i);
            
            if(Helper.isPalindrome(A) && Helper.isPalindrome(B))
                sum += i;
        }
        
        System.out.println(sum);
    }
    
    public static void problem_37()
    {
        System.out.println(Helper.isCurious(145));
        
        long sum = 0;
        
        for(int i = 3; i < 1000000; i++)
        {
            if(Helper.isCurious(i))
                sum += i;
        }
        
        System.out.println(sum);
    }
    
    public static void problem_39()
    {
        int max_p = -1;
        int max = -1;
        
        for(int p = 10; p <= 1000; p++)
        {
            System.out.println(p);
            
            ArrayList<int[]> list = new ArrayList<>();

            for(int a = 1; a < p/2; a++)
            {
                int num = p*(p-2*a);
                int den = 2*(p-a);

                int b = num/den;

                if(b < a)
                    continue;

                if(num%den == 0)
                {
                    int c = p-a-b;
                    list.add(new int[]{a, b, c});
                }
            }
            
            if(list.size() > max)
            {
                max = list.size();
                max_p = p;
            }
        }
        
        System.out.println(max_p + " : " + max);
        
        /*for(int[] n : list)
        {
            for(int k : n)
                System.out.print(k + " ");
            System.out.println();
        }*/
    }
    
    public static void problem_40()
    {
        String s = ".";
        
        int c = 1;
        int limit = 1000000;
        
        while(s.length() < limit+2)
        {
            s += ""+c;
            c++;
            
            if(s.length()% 1000 == 0)
                System.out.println(s.length());
        }
        
        int prod = 1;
        
        for(int n = 1; n <= 1000000; n *= 10)
        {
            prod *= Character.getNumericValue(s.charAt(n));
        }
        
        System.out.println(prod);
    }
    
    public static void problem_41()
    {
        for(int n = 7654321; n > 0; n--)
        {
            if(Helper.isPandigital(n, 7))
            {
                if(Helper.isPrime(n))
                {
                    System.out.println(n);
                    break;
                }
            }
        }
    }
    
    public static void problem_42()
    {
        String alph = "abcdefghijklmnopqrstuvwxyz";

        int count = 0;
        
        try
        {
            Scanner in = new Scanner(new File("problem42.txt"));
            
            while(in.hasNext())
            {
                String s = in.next().toLowerCase();
                
                char[] list = s.toCharArray();
                
                int sum = 0;
                
                for(char c : list)
                {
                    sum += alph.indexOf(c)+1;
                }
                
                if(Helper.isSquare(8*sum+1))
                    count++;
            }
            
            in.close();
        }
        catch(IOException e){System.out.println(e);}
        
        System.out.println(count);
    }
    
    public static void problem_44()
    {
        int N = 100000;
        
        ArrayList<Integer> list = new ArrayList<>(N);
        
        for(int i = 1; i < N; i++)
        {
            list.add(i*(3*i-1)/2);
        }
        
        ArrayList<Integer> newList = new ArrayList<>();
        
        for(int i = 0; i < list.size()-1; i++)
        {
            int nA = list.get(i);
            
            for(int j = i+1; j < list.size(); j++)
            {
                int nB = list.get(j);
                
                int n1 = nB + nA;
                int n2 = nB - nA;
                
                if(Helper.indexOfShapeNumber(5, n1) != -1 && Helper.indexOfShapeNumber(5, n2) != -1)
                {
                    newList.add(n2);
                    System.out.println(n2);
                }
            }
        }
    }
    
    public static void problem_46()
    {
        int N = 1000000;
        
        ArrayList<Integer> primes = Helper.listPrimes(N);
        
        for(int i = 3; i < N; i++)
        {
            if(primes.contains(i))
                continue;
            
            if(!Helper.goldbachPair(i, primes))
            {
                System.out.println(i);
                break;
            }
        }
    }
    
    public static void problem_48()
    {
        BigInteger sum = BigInteger.ZERO;
        
        for(int i = 1; i <= 1000; i++)
        {
            System.out.println(i);
            sum = sum.add(BigInteger.valueOf(i).pow(i));
        }
        
        System.out.println(sum);
    }
    
    public static void problem_49()
    {
        System.out.println(Helper.isPermutation(1487, 8174));
        
        ArrayList<Integer> p_list = Helper.listPrimes(1000, 9999);
        
        for(int i = 0; i < p_list.size()-2; i++)
        {
            int pA = p_list.get(i);
            
            for(int j = i+1; j < p_list.size(); j++)
            {
                int pB = p_list.get(j);
                
                if(Helper.isPermutation(pA, pB))
                {
                    int c = pB - pA;
                    
                    int pC = pB + c;
                    
                    if(p_list.contains(pC) && Helper.isPermutation(pA, pC))
                    {
                        System.out.println(pA + " : " + pB + " : " + pC);
                    }
                }
            }
        }
    }
    
    public static void problem_50()
    {
        int nMax = 1000000;
        
        ArrayList<Integer> p_list = Helper.listPrimes(nMax);
        
        Map<Integer,Boolean> isPrimeMap = new HashMap<>();
        
        for(int p : p_list)
            isPrimeMap.put(p, true);
        
        ArrayList<int[]> chainList = new ArrayList<int[]>();
        
        for(int i = 0; i < p_list.size()-1; i++)
        {
            int pA = i;
            int pB = -1;
            int sum = p_list.get(i);
            for(int j = i+1; j < p_list.size(); j++)
            {
                sum += p_list.get(j);
                
                if(sum >= nMax)
                    break;
                
                if(isPrimeMap.getOrDefault(sum, false))
                {
                    pB = j;
                    chainList.add(new int[]{sum,pA,pB});
                }
            }
        }
        
        Comparator<int[]> comp = new Comparator<int[]>()
        {
            public int compare(int[] A, int[] B) 
            {
                int k = (A[2]-A[1]) - (B[2]-B[1]);
                
                if(k > 0)
                    return 1;
                else if(k < 0)
                    return -1;
                else
                    return 0;
            }
        };
        
        Collections.sort(chainList, new Comparator<int[]>()
        {
            public int compare(int[] A, int[] B) 
            {
                int k = (A[2]-A[1]) - (B[2]-B[1]);
                
                if(k > 0)
                    return 1;
                else if(k < 0)
                    return -1;
                else
                    return 0;
            }
        });
        
        Collections.reverse(chainList);
        
        /*for(int[] k : chainList)
        {
            System.out.print(k[0] + ") ");
            for(int j = k[1]; j <= k[2]; j++)
            {
                System.out.print(p_list.get(j) + ", ");
            }
            System.out.println();
        }*/
        
        System.out.println(chainList.get(0)[0]);
    }
    
    public static void problem_53()
    {
        int count = 0;
        
        BigInteger limit = BigInteger.valueOf(1000000);
        
        for(int n = 2; n <= 100; n++)
        {
            //System.out.println("C: " + n);
            
            for(int k = 0; k <= n; k++)
            {
                long c = Helper.choose(n, k);
                
                BigInteger d = Helper.bigChoose(n, k);
                
                if(d.compareTo(limit) > 0)
                {
                    //System.out.println(n + " C " + k);
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }
    
    public static void problem_58()
    {
        int nTotal = 1;
        double nPrimes = 0.0;
        
        for(int n = 3; n <= 1000000; n += 2)
        {
            nTotal += 4;
            
            for(int k = 0; k < 4; k++)
            {
                int p = n*n - k*(n-1);
                
                if(Helper.isPrime(p))
                    nPrimes++;
            }
            
            if(nPrimes/nTotal < 0.1)
            {
                System.out.println(n);
                break;
            }
        }
    }
    
    public static void problem_61()
    {
        int N = 3;
        
        for(int k = 2; k <= 8; k++)
        {
            for(int i = 1; i <= 5; i++)
            {
                System.out.print(Helper.shapeNumber(k, i) + ", ");
            }
            System.out.println();
        }
        
        ArrayList<ArrayList<Integer>> shapeList = new ArrayList<>();
        
        long prod = 1;
        
        for(int k = 3; k < N+3; k++)
        {
            ArrayList<Integer> list = new ArrayList<>();
            
            int S = 0;
            int n = 1;

            while(S < 10000)
            {
                S = Helper.shapeNumber(k, n);
                n++;

                if(S >= 1000 && S < 10000)
                {
                    if((""+S).charAt(2) != '0')
                        list.add(S);
                }
            }

            shapeList.add(list);
            
            prod *= list.size();
            
            System.out.println(k + " " + list.size());
        }
        
        System.out.println(prod);
        
        
    }
    
    public static void problem_69()
    {
        ArrayList<Integer> primes = Helper.listPrimes(1000000);
        
        //for(int i = 2; i <= 10; i++)
        //    System.out.println(i + "\t" + (int)Helper.totient(i, primes));
        
        double max = -1;
        int nmax = -1;
        
        for(int n = 2; n <= 1000000; n++)
        {
            if(n%10000 == 0)
                System.out.println(n);
            
            double m = n/Helper.totient(n, primes);
            
            if(m > max)
            {
                nmax = n;
                max = m;
            }
        }
        
        System.out.println(nmax);
    }
    
    public static void problem_85()
    {
        int rects = 2000000;
        
        int n_close = 3;
        int m_close = 2;
        int closest = 18;
        
        for(int N = 1; N < 1000; N++)
        {
            for(int M = 1; M <= N; M++)
            {
                int sum = 0;

                for(int n = 1; n <= N; n++)
                {
                    for(int m = 1; m <= M; m++)
                    {
                        sum += (N-n+1)*(M-m+1);
                    }
                }
                
                //System.out.println(N + " : " + M + " : " + sum);
                
                if(Math.abs(sum-rects) < Math.abs(closest-rects))
                {
                    closest = sum;
                    n_close = N;
                    m_close = M;
                    
                    System.out.println(closest + "\t" + n_close + "\t" + m_close + "\t" + (n_close*m_close));
                }
            }
        }
    }
    
    public static void problem_101()
    {
        PolySequence seq = new PolySequence(new double[]{1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1});
        
        long sum = 0;
        
        for(int k = 1; k <= 9; k++)
        {
            double[] x = new double[k];
            double[] y = new double[k];

            for(int n = 0; n < k; n++)
            {
                x[n] = n+1;
                y[n] = seq.val(n+1);
            }

            double[] coeffs = Helper.polyFitter(x, y, k-1);

            PolySequence seq2 = new PolySequence(coeffs);

            long p2 = Math.round(seq2.val(k+1));

            sum += p2;
        }
        
        System.out.println(sum);
    }
    
    public static void problem_107()
    {
        int N = 40;
        int[][] matrix = new int[N][N];
        
        try
        {
            Scanner in = new Scanner(new File("problem107.txt"));
            
            int r = 0;
            while(in.hasNextLine())
            {
                String[] list = in.nextLine().split(",");
                
                for(int c = 0; c < list.length; c++)
                {
                    if(list[c].equals("-"))
                    {
                        matrix[r][c] = -1;
                    }
                    else
                    {
                        matrix[r][c] = Integer.parseInt(list[c]);
                    }
                }
                
                r++;
            }
            
            in.close();
        }
        catch(IOException e){System.out.println(e);}
        
        int edges = 0;
        
        int sum = 0;
        for(int i = 0; i < N-1; i++)
        {
            for(int j = i+1; j < N; j++)
            {
                if(matrix[i][j] != -1)
                {
                    sum += matrix[i][j];
                    edges++;
                }
            }
        }
        
        System.out.println(edges);
        System.out.println(sum);
        
        SimpleWeightedGraph<Integer, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        
        for(int i = 0; i < N; i++)
        {
            graph.addVertex(i);
        }
        
        for(int i = 0; i < N-1; i++)
        {
            for(int j = i+1; j < N; j++)
            {
                if(matrix[i][j] != -1)
                {
                    DefaultWeightedEdge e = graph.addEdge(i, j); 
                    graph.setEdgeWeight(e, matrix[i][j]); 
                }
            }
        }
        
        KruskalMinimumSpanningTree<Integer,DefaultWeightedEdge> tree = new KruskalMinimumSpanningTree<>(graph);
        
        SpanningTree<DefaultWeightedEdge> span = tree.getSpanningTree();
        
        System.out.println(sum-span.getWeight());
        
        SimpleWeightedGraph<Integer, DefaultWeightedEdge> graph2 = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        
        for(int i = 0; i < N; i++)
        {
            graph2.addVertex(i);
        }
        
        
        JGraphXAdapter<Integer, DefaultWeightedEdge> graphAdapter = new JGraphXAdapter<Integer, DefaultWeightedEdge>(graph);
        graphAdapter.getStylesheet().getDefaultEdgeStyle().put(mxConstants.STYLE_NOLABEL, "1");
        //graphAdapter.getStylesheet().getDefaultEdgeStyle().put(mxConstants.STYLE_SHAPE, "1");
        
        mxOrganicLayout layout = new mxOrganicLayout(graphAdapter);

        layout.setEdgeCrossingCostFactor(5);
        //layout.setEdgeDistanceCostFactor(20);
        layout.setOptimizeEdgeCrossing(true);
    layout.setMaxIterations(100000);
        
        layout.execute(graphAdapter.getDefaultParent());

        BufferedImage image = 
          mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
        File imgFile = new File("graph.png");
        try {
            ImageIO.write(image, "PNG", imgFile);
        } catch (IOException ex) {
            Logger.getLogger(Problem_A.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void problem_144() throws IOException
    {
        int w = 1000;
        int h = 1000;
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D)bi.getGraphics();
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, w, h);
        
        double A = 5.0;
        double B = 10.0;
        EllipseMirror mirror = new EllipseMirror(A, B);
        mirror.draw_scale = 45.0;
        mirror.draw_x_offset = w/2;
        mirror.draw_y_offset = h/2;
        
        g.setColor(Color.BLACK);
        mirror.drawBoundary(g, 400);

        Vector2D r0 = new Vector2D(0.0, 10.1);
        Vector2D r1 = new Vector2D(1.4, -9.6);
        mirror.drawLine(g, r0, r1);
        
        int N = 100000;

        for(int n = 1; n < N; n++)
        {
            if(n%10000 == 0)
                System.out.println(n);
            
            Vector2D r2 = mirror.getNextPoint(r0, r1);
            
            if(Math.abs(r2.x) <= 0.01 && r2.y > 0)
            {
                System.out.println("FOUND: " + n);
                break;
            }
            
            mirror.drawLine(g, r1, r2);
            r0 = r1;
            r1 = r2;
        }

        ImageIO.write(bi, "PNG", new File("problem_144.png"));
    }
    
    public static void problem_144b()
    {
        int result = 0;
 
        double xA = 0.0;
        double yA = 10.1;

        double xO = 1.4;
        double yO = -9.6;

        
        
        while(xO > 0.01 || xO < -0.01 || yO < 0){

            //Calculate the slope of A
            double slopeA = (yO - yA) / (xO - xA);

            //Calculate the slope of the ellipse tangent
            double slopeO = -4*xO/yO;

            //Calculate the slope of B
            double tanA = (slopeA - slopeO)/(1+slopeA*slopeO);
            double slopeB = (slopeO- tanA)/ (1+ tanA*slopeO);

            //calculate intercept of line B
            double interceptB = yO - slopeB * xO;

            //solve the quadratic equation for finding
            // the intersection of B and the ellipse
            // a*x^2 + b*x + c = 0
            double a = 4 + slopeB*slopeB;
            double b = 2 * slopeB * interceptB;
            double c = interceptB * interceptB - 100;

            double ans1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            double ans2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);

            xA = xO;
            yA = yO;

            //Take the solution which is furtherst from x0
            xO = (Math.abs(ans1 - xO) > Math.abs(ans2 - xO)) ? ans1 : ans2;
            yO = slopeB * xO + interceptB;

            result++;
        }

        System.out.println(result);
    }
    
    public static void main(String[] args) throws IOException
    {
        problem_101();
    }
}
