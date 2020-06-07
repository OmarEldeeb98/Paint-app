package Paint.model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.Map;
import static java.lang.Math.abs;

public class Square extends Rectangle {


    Color FillColor;
	float Length=abs(this.position.x-this.position2.x);

    public Square() {
super();
    }

	public float getLength() {
		return Length;
	}

	public void setLength(float length) {
		this.Length = length;
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
		this.FillColor=color;
	}

	@Override
	public Color getFillColor() {
		// TODO Auto-generated method stub
		return this.FillColor;
	}

	@Override
		public void draw(Object canvas) { //taking canvas to draw on
			// TODO Auto-generated method stub
                        if(isFilled()){
		Graphics CastedCanvas= (Graphics) canvas;
		CastedCanvas.setColor(this.color);
		CastedCanvas.fillRect(Math.min(position.x,position2.x),Math.min(position.y,position2.y),(int)this.Length,(int)this.Length);
		}
                else
                        {
                        
                        Graphics CastedCanvas= (Graphics) canvas;
		CastedCanvas.setColor(this.color);
		CastedCanvas.drawRect(Math.min(position.x,position2.x),Math.min(position.y,position2.y),(int)this.Length,(int)this.Length);
		
                        }
                }
                
                
                 @Override
        public void setPosition2(Point position2) {
        this.position2 = position2;
        Length=abs(this.position.x-this.position2.x);
            }
    @Override
        public boolean contains(Point p){
           Rectangle2D.Double rect;
           rect = new Rectangle2D.Double(Math.min(position.x,position2.x),Math.min(position.y,position2.y),(int)this.Length,(int)this.Length);
           return rect.contains(p.getX(),p.getY());
        }
      @Override
	public Shape move(Point p) {
            Shape c= new Square();
            c.Filled(this.fill);
            Point upperL=new Point((int)(p.getX()-this.Length/2),(int)(p.getY()-this.Length/2));
            Point lowerR=new Point((int)(p.getX()+this.Length/2),(int)(p.getY()+this.Length/2));
            c.setPosition(upperL);
            c.setPosition2(lowerR);
            return c;    
	} 
        @Override
        public Point getCenter(){
            Point center = new Point((int)(this.position.getX()+Length/2),(int)(this.position.getY()+Length/2));
            return center;
        }
        @Override
        public Shape resize(Point p,Point center){
        Shape c= new Square();
        c.Filled(this.fill);
        c.setPosition(this.position);
        c.setPosition2(p);
        return c;    
    }
}