package Paint.model;
import java.awt.Color;
import java.awt.Point;
import java.util.Map;

public  class Shape implements ShapeInterface ,Cloneable  {
Point position=new Point(50,50);
Point position2=new Point (120,200);
public int index;
Color color;
boolean fill;
Map<String, Double> properties;
	
        	public Shape() {
        
                }
@Override
	public Object clone()throws CloneNotSupportedException{  // cloning object of this type
		return super.clone();  
		}   

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Point getPosition2() {
        return position2;
    }
    public boolean isFilled()
    {
    return fill;
    }

    public void Filled(boolean fill)
        {
        this.fill=fill;
        }
    public void setPosition2(Point position2) {
        this.position2 = position2;
    }

    @Override
    public void setPosition(Point position) {
       this.position=position;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        this.properties=properties; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Double> getProperties() {
        return properties;
    }

    @Override
    public void setColor(Color color) {
        this.color=color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setFillColor(Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getFillColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Object canvas) {
        
    }

    public boolean contains(Point p) {
        return false;
    }
    public Shape move(Point p){
        Shape c= new Shape();
        c.setPosition(p);
        return c;    
    }
    public Shape resize(Point p,Point center){
        Shape c= new Shape();
        
        c.setPosition(this.position);
        c.setPosition2(p);
        return c;    
    }
        public Point getCenter(){
            Point center = new Point((int)(this.position.getX()),(int)(this.position.getY()));
            return center;
        }
        
}
