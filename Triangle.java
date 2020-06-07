package Paint.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

public class Triangle extends Polygons {

    int[] x = new int[3];
    int[] y = new int[3];
    Color fillColor;

    public Triangle() {
        super();
    }

    @Override
    public void setPosition(Point position) {
        this.position=position;
    }
    
    @Override
    public void setPosition2(Point position2) {
        this.position2 = position2;
        x[0] = (position2.x + position.x) / 2;
        x[1] = position.x;
        x[2] = position2.x;
        y[0] = position.y;
        y[1] = position2.y;
        y[2] = position2.y;
    }
   
    @Override
    public Point getPosition() {
        // TODO Auto-generated method stub
        return this.position;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        // TODO Auto-generated method stub

    }

    @Override
    public Map<String, Double> getProperties() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setColor(Color color) {
        // TODO Auto-generated method stub
        this.color = color;
    }

    @Override
    public Color getColor() {
        // TODO Auto-generated method stub
        return this.color;
    }

    @Override
    public void setFillColor(Color color) {
        // TODO Auto-generated method stub
        this.fillColor = color;
    }

    @Override
    public Color getFillColor() {
        // TODO Auto-generated method stub
        return this.fillColor;
    }

    @Override
    public void draw(Object canvas) {
        if(isFilled()){
        Graphics CastedCanvas = (Graphics) canvas;
        CastedCanvas.setColor(this.color);
        CastedCanvas.fillPolygon(x, y, 3);
        }
        else
        {
            Graphics CastedCanvas = (Graphics) canvas;
        CastedCanvas.setColor(this.color);
        CastedCanvas.drawPolygon(x, y, 3);
        
        }
    }

    @Override
    public boolean contains(Point p) {
        double xp=p.getX();
        double yp=p.getY();
        double x1 = x[0];
        double x2 = x[1];
        double x3 = x[2];
        double y1 = y[0];
        double y2 = y[1];
        double y3 = y[2];
        double ABC = Math.abs (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        double ABP = Math.abs (x1 * (y2 - yp) + x2 * (yp - y1) + xp * (y1 - y2));
        double APC = Math.abs (x1 * (yp - y3) + xp * (y3 - y1) + x3 * (y1 - yp));
        double PBC = Math.abs (xp * (y2 - y3) + x2 * (y3 - yp) + x3 * (yp - y2));
        boolean isInTriangle = ABP + APC + PBC == ABC;
        return isInTriangle;
    }
    
    @Override
    public Shape move(Point p) {
        Shape c=new Triangle();
        c.Filled(this.fill);
        int  h=Math.abs(y[0]-y[1]);
        int  b=Math.abs(x[1]-x[2]);
        Point position=new Point((int)p.getX()-b/2,(int)p.getY());
        Point position2=new Point((int)p.getX()+b/2,(int)p.getY()+h);
        c.setPosition(position);
        c.setPosition2(position2);
        return c;
    }
    @Override
    public Point getCenter(){
        int xp=(int)((this.position2.x + this.position.x) / 2);
        Point peak=new Point(xp,(int)this.position.getY());
        return peak;
    }
    @Override
    public Shape resize(Point p,Point peak){
        Shape c= new Triangle();
        c.Filled(this.fill);
        double  h=p.getY()-peak.getY();
        double  b=Math.abs(peak.getX()-p.getX());
        Point position=new Point((int)(peak.getX()-b),(int)(peak.getY()));
        Point position2=new Point((int)(peak.getX()+b),(int)(peak.getY()+h));
        c.setPosition(position);
        c.setPosition2(position2);
        return c;    
    }

}
