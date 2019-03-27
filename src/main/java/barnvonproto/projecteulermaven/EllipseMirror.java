/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barnvonproto.projecteulermaven;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author jraff
 */
public class EllipseMirror 
{
    public double const_A;
    public double const_B;
    
    public int draw_x_offset, draw_y_offset;
    public double draw_scale;
    
    public EllipseMirror(double a, double b)
    {
        const_A = a;
        const_B = b;
    }
    
    public Vector2D getPoint(double theta)
    {
        return new Vector2D(const_A*Math.cos(theta), const_B*Math.sin(theta));
    }
    
    public Vector2D getNorm(Vector2D r)
    {
        return getNorm(r.x, r.y);
    }
    
    public Vector2D getNorm(double x, double y)
    {
        return new Vector2D(const_B*x/const_A, const_A*y/const_B).normalize();
    }
    
    public Vector2D getNextPoint(Vector2D r0, Vector2D r1)
    {
        Vector2D r01 = r1.subtract(r0).normalize();
        
        Vector2D n = getNorm(r1);
        
        double alpha = Math.acos(r01.dot(n));
        
        Vector2D rf1 = r01.rotate(-Math.PI + 2*alpha);
        
        double x0 = r1.x;
        double y0 = r1.y;
        double rx = rf1.x;
        double ry = rf1.y;
        
        double a = const_A*ry;
        double b = const_B*rx;
        double c = x0*ry - y0*rx;
        
        double theta = 2*Math.atan2((Math.sqrt(a*a + b*b - c*c) - b),(a+c));
        
        return getPoint(theta);
    }
    
    public void drawNormAt(Graphics2D g, Vector2D p)
    {
        Vector2D n = getNorm(p);
        
        drawLine(g, p, p.add(n.negate()));
    }
    
    public void drawBoundary(Graphics2D g, int N)
    {
        double d_theta = 2*Math.PI/N;
        for(int n = 0; n < N; n++)
        {
            double x0 = 5*Math.cos(d_theta*n);
            double y0 = 10*Math.sin(d_theta*n);
            
            double x1 = 5*Math.cos(d_theta*(n+1));
            double y1 = 10*Math.sin(d_theta*(n+1));
            
            g.drawLine((int)(draw_scale*x0 + draw_x_offset), (int)(draw_scale*y0 + draw_y_offset), (int)(draw_scale*x1 + draw_x_offset), (int)(draw_scale*y1 + draw_y_offset));
        }
    }
    
    public void drawLine(Graphics2D g, double x0, double y0, double x1, double y1)
    {
        g.drawLine((int)(draw_scale*x0 + draw_x_offset), (int)(draw_scale*y0 + draw_y_offset), (int)(draw_scale*x1 + draw_x_offset), (int)(draw_scale*y1 + draw_y_offset));
    }
    
    public void drawLine(Graphics2D g, Vector2D r1, Vector2D r2)
    {
        drawLine(g, r1.x, r1.y, r2.x, r2.y);
    }
}
