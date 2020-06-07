package Paint.model;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import static java.lang.Math.abs;

public class Circle extends Elliptical {



	float radius=(float) Math.hypot(this.position.x-this.position2.x, this.position.y-this.position2.y);

    public Circle() {
        super();    }


	public float getRadius() {
		return radius;
	}


	public void setRadius(float radius) {
		this.radius = radius;
	}

     @Override
	public void draw(Object canvas) {
            if(isFilled()==true){
		Graphics CastedCanvas= (Graphics) canvas;
		CastedCanvas.setColor(this.color);
		CastedCanvas.fillOval(Math.min(position.x,position2.x),Math.min(position.y,position2.y),(int) radius,(int) radius);
            }else{
            Graphics CastedCanvas= (Graphics) canvas;
		CastedCanvas.setColor(this.color);
		CastedCanvas.drawOval(Math.min(position.x,position2.x),Math.min(position.y,position2.y),(int) radius,(int) radius);
           
            }
	}
        
        @Override
        public void setPosition2(Point position2) {
        this.position2 = position2;
        radius=(float) Math.hypot(this.position.x-this.position2.x, this.position.y-this.position2.y);
    }
        
      @Override
        public boolean contains(Point p){
            Ellipse2D.Double iEllipse; 
            iEllipse = new Ellipse2D.Double(Math.min(position.x,position2.x),Math.min(position.y,position2.y),(int) radius,(int) radius);
            return iEllipse.contains(p.getX(),p.getY());
        }
     
          @Override
        public Shape move(Point p){
            Shape c= new Circle();
            c.Filled(this.fill);
            float D=(float) abs(this.position.x-this.position2.x);
            Point p1=new Point((int)(p.getX()-D/2),(int)(p.getY()-D/2));
            Point p2=new Point((int)(p.getX()+D/2),(int)(p.getY()+D/2));
            c.setPosition(p1);
            c.setPosition2(p2);
            return c;    
        }
        @Override
        public Point getCenter(){
            double r=this.radius/2;
            Point center = new Point((int)(this.position.getX()+r),(int)(this.position.getY()+r));
            return center;
        }
      @Override
        public Shape resize(Point p,Point center){
        Shape c= new Circle();
        float R=(float) abs(p.x-center.x);
        c.Filled(this.fill);
        Point p1=new Point((int)(center.getX()-R),(int)(center.getY()-R));
        Point p2=new Point((int)(center.getX()+R),(int)(center.getY()+R));
        c.setPosition(p1);
        c.setPosition2(p2);
        return c;
        }
}


