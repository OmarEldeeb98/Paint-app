package Paint.model;
import java.awt.Graphics;

public class SectorOfCircle extends Circle {

	float angle;




        public float getAngle() {
                return angle;
        }


        public void setAngle(float angle) {
                this.angle = angle;
        }
        @Override
        public void draw(Object canvas) { //taking canvas to draw on
                // TODO Auto-generated method stub
        Graphics CastedCanvas= (Graphics) canvas;
        CastedCanvas.setColor(this.color);
        CastedCanvas.drawArc(position.x, position.y, (int)radius, (int)radius, 0, (int)angle);

        }
        
	

}
