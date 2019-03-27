/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barnvonproto.projecteulermaven;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author jraff
 */
public class PolySequence 
{
    public double[] coefficients;
    
    public PolySequence(ArrayList<Double> coeff)
    {
        coefficients = new double[coeff.size()];
        
        for(int i = 0; i < coeff.size(); i++)
            coefficients[i] = coeff.get(i);
    }
    
    public PolySequence(double[] coeff)
    {
        coefficients = coeff;
    }
    
    public PolySequence(int n)
    {
        coefficients = new double[n+1];
        
        for(int i = 0; i < n+1; i++)
            coefficients[i] = 0.0;
    }
    
    public double val(double x)
    {
        double sum = 0.0;
        
        for(int i = 0; i < coefficients.length; i++)
        {
            sum += coefficients[i]*Math.pow(x,i);
        }
        
        return sum;
    }
}
