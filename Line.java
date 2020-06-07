package Paint.model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

public class Line extends Shape {





Color fillColor=super.color;

    /**
     *
     */
    public Line(){
super();
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
	public void draw(Object canvas) {
		// TODO Auto-generated method stub
		Graphics CastedCanvas= (Graphics) canvas;
		CastedCanvas.setColor(this.color);
		CastedCanvas.drawLine(position.x, position.y, position2.x, position2.y);
                
	}
         private double distance(Point p1,Point p2){
        double x1=p1.getX();
        double x2=p2.getX();
        double y1=p1.getY();
        double y2=p2.getY();
        double d=Math.hypot(x1-x2, y1-y2);
        return d;
    }

    @Override
    public boolean contains(Point p) {
        return distance(position, p) + distance(position2, p) == distance(position, position2);
    }

}
