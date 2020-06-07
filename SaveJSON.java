/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import Paint.model.Circle;
import Paint.model.Elliptical;
import Paint.model.Line;
import Paint.model.Rectangle;
import Paint.model.Shape;
import Paint.model.Square;
import Paint.model.Triangle;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;

/**
 *
 * @author omar_
 */
public class SaveJSON extends Save {

    
    @Override
    public void save(String path, ArrayList<Shape> shapes) {
        int counter =0;
        JSONObject shapesList = new JSONObject();
                       for  (Shape shape: shapes) {
                           JSONObject element = new JSONObject();
                           if(shape instanceof Circle)
                           {
                               element.put("type", "circle");
                              
                           }
                           else if (shape instanceof Elliptical)
                           {
                               element.put("type", "elliptical");
                               
                           }
                           else if (shape instanceof Line)
                           {
                               element.put("type", "line");
                               
                           }
                           else if (shape instanceof Square)
                           {
                               element.put("type", "square");
                               
                           }
			   else if (shape instanceof Rectangle)
                           {
                               element.put("type", "rectangle");
                               
                           }
                           if(shape instanceof Triangle)
                           {
                               element.put("type", "triangle");
                               
                           }
                            element.put("x1", ""+shape.getPosition().x);
                            element.put("y1", ""+shape.getPosition().y);
                            element.put("x2", ""+shape.getPosition2().x);
                            element.put("y2", ""+shape.getPosition2().y);
                            element.put("filled", ""+shape.isFilled());
                            //element.put("Color", shape.getColor());
                            element.put("blue",""+shape.getColor().getBlue());
                            element.put("red",""+shape.getColor().getRed());
                            element.put("green",""+shape.getColor().getGreen());
                            //element.put("FillColor", shape.getFillColor());
                            shapesList.put(counter,element);
                            counter++;
		}
                try (FileWriter file = new FileWriter(path)) {
 
                    file.write(shapesList.toJSONString());
                    file.flush();

                } catch (IOException e) {
                    e.printStackTrace();
        }
        
    }
    
    /*void saveJSON(String path, ArrayList<Shape> shapes)
    {
        int counter =0;
        JSONObject shapesList = new JSONObject();
                       for  (Shape shape: shapes) {
                           JSONObject element = new JSONObject();
                           if(shape instanceof Circle)
                           {
                               element.put("type", "circle");
                              
                           }
                           else if (shape instanceof Elliptical)
                           {
                               element.put("type", "elliptical");
                               
                           }
                           else if (shape instanceof Line)
                           {
                               element.put("type", "line");
                               
                           }
                           else if (shape instanceof Square)
                           {
                               element.put("type", "square");
                               
                           }
			   else if (shape instanceof Rectangle)
                           {
                               element.put("type", "rectangle");
                               
                           }
                           if(shape instanceof Triangle)
                           {
                               element.put("type", "triangle");
                               
                           }
                            element.put("x1", ""+shape.getPosition().x);
                            element.put("y1", ""+shape.getPosition().y);
                            element.put("x2", ""+shape.getPosition2().x);
                            element.put("y2", ""+shape.getPosition2().y);
                            //element.put("Color", shape.getColor());
                            element.put("blue",""+shape.getColor().getBlue());
                            element.put("red",""+shape.getColor().getRed());
                            element.put("green",""+shape.getColor().getGreen());
                            //element.put("FillColor", shape.getFillColor());
                            shapesList.put(counter,element);
                            counter++;
		}
                try (FileWriter file = new FileWriter(path)) {
 
                    file.write(shapesList.toJSONString());
                    file.flush();

                } catch (IOException e) {
                    e.printStackTrace();
        }*/
    }
    

