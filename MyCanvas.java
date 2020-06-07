package Paint.view;

import Paint.model.Shape;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class MyCanvas extends JPanel {
	protected ArrayList<Shape> ShapesList;
	public MyCanvas() {
		this.ShapesList = new ArrayList<>();
		
	}

	public ArrayList<Shape> getShapesList() {
		return ShapesList;
	}
        
		
	
        @Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
                ShapesList.stream().map((todraw) -> {
                    todraw.draw(g);
                return todraw;
            }).forEach((_item) -> {
               System.out.println(ShapesList.size());
                // System.out.println(todraw.getPosition()+"/////"+todraw.getPosition2());
            });
		
	}
}
	
	
	
	

