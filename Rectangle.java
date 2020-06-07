package Paint.model;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.Map;
import static java.lang.Math.abs;


public class Rectangle extends Polygons {


	float Length2=abs(this.position.y-this.position2.y);

Color fillColor;

    public Rectangle() {
       super();
    }

	public float getLength2() {
		return Length2;
	}


	float Length1=abs(this.position.x-this.position2.x);

	public float getLength1() {
		return Length1;
	}

	public void setLength1(float length) {
		this.Length1 = length;
	}
	


	@Override
	public void setPosition(Point position) {
		// TODO Auto-generated method stub
		this.position=position;
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
        public void setPosition2(Point position2) {
        this.position2 = position2;
        Length1=abs(this.position.x-this.position2.x);
        Length2=abs(this.position.y-this.position2.y);
        }

	@Override
	public Map<String, Double> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		this.color=color;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}

	@Override
	public void setFillColor(Color color) {
		// TODO Auto-generated method stub
		this.fillColor=color;
	}

	@Override
	public Color getFillColor() {
		// TODO Auto-generated method stub
		return this.fillColor;
	}

	@Override
	public void draw(Object canvas) { //taking canvas to draw on
		// TODO Auto-generated method stub
                if(isFilled()){
	Graphics2D CastedCanvas= (Graphics2D) canvas;
	CastedCanvas.setColor(this.color);
	CastedCanvas.fillRect(Math.min(position.x,position2.x),Math.min(position.y,position2.y),(int)this.Length1,(int)this.Length2);
                }
                else
                {
                
                
	Graphics2D CastedCanvas= (Graphics2D) canvas;
	CastedCanvas.setColor(this.color);
	CastedCanvas.drawRect(Math.min(position.x,position2.x),Math.min(position.y,position2.y),(int)this.Length1,(int)this.Length2);
              
                }
	}
        @Override
        public boolean contains(Point p){
           //Object rect = createInstance("java.awt.Graphics2D","MyAttributeValue");
           Rectangle2D.Double rect;
           rect = new Rectangle2D.Double(Math.min(position.x,position2.x),Math.min(position.y,position2.y),(int)this.Length1,(int)this.Length2);
           return rect.contains(p.getX(),p.getY());
        }
        @Override
	public Shape move(Point p) {
            Shape c= new Rectangle();
            c.Filled(this.fill);
            Point upperL=new Point((int)(p.getX()-this.Length1/2),(int)(p.getY()-this.Length2/2));
            Point lowerR=new Point((int)(p.getX()+this.Length1/2),(int)(p.getY()+this.Length2/2));
            c.setPosition(upperL);
            c.setPosition2(lowerR);
            return c;    
	}
        @Override
        public Point getCenter(){
            Point center = new Point((int)(this.position.getX()+Length1/2),(int)(this.position.getY()+Length2/2));
            return center;
        }
        
        @Override
        public Shape resize(Point p,Point center){
        Shape c= new Rectangle();
        c.Filled(this.fill);
        c.setPosition(this.position);
        c.setPosition2(p);
        return c;    
    }
}
