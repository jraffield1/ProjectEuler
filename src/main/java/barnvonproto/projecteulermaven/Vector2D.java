/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barnvonproto.projecteulermaven;

/**
 *
 * @author jraff
 */
public class Vector2D 
{
    public double x, y;
    
    public Vector2D()
    {
        x = 0.0;
        y = 0.0;
    }
    
    public Vector2D(double a, double b)
    {
        x = a;
        y = b;
    }
    
    public double angle()
    {
        return Math.atan2(y, x) + 2*Math.PI;
    }
    
    public double magnitude()
    {
        return Math.sqrt(x*x + y*y);
    }
    
    public Vector2D subtract(Vector2D v)
    {
        return new Vector2D(x-v.x, y-v.y);
    }
    
    public Vector2D normalize()
    {
        double m = magnitude();
        return new Vector2D(x/m, y/m);
    }
    
    public Vector2D add(Vector2D v)
    {
        return new Vector2D(x+v.x, y+v.y);
    }
    
    public Vector2D scale(double d)
    {
        return new Vector2D(x*d, y*d);
    }
    
    public double dot(Vector2D v)
    {
        return x*v.x + y*v.y;
    }
    
    public Vector2D negate()
    {
        return new Vector2D(-x, -y);
    }
    
    public Vector2D rotate(double theta)
    {
        double c = Math.cos(theta);
        double s = Math.sin(theta);
        
        return new Vector2D(x*c - y*s, x*s + y*c);
    }
    
    public String toString()
    {
        return "(" + x + "," + y + ")";
    }
}
