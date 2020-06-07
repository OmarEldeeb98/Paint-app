package Paint.controller;

//import paint.control.*;
import Paint.model.Circle;
import Paint.model.Elliptical;
import Paint.model.Line;
import Paint.model.Rectangle;
import java.util.List;
import paint.controller.Save;
import Paint.model.Shape;
import Paint.model.Square;
import Paint.model.Triangle;
import Paint.view.MyCanvas;
import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Controller implements DrawingEngine {

    MyCanvas canvas;  //canvas passed by view to model then returned
 private final ArrayList<Shape> clearedshape = new ArrayList();
    public void setCanvas(MyCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void refresh(Object canvas) {
        this.canvas.paintComponent(this.canvas.getGraphics());

    }

    @Override
    public void addShape(Shape shape) {
        this.canvas.getShapesList().add(shape);

    }

    @Override
    public void removeShape(Shape shape) {
        // TODO Auto-generated method stub

        canvas.remove(shape.index);

    }

    @Override
    public void updateShape(Shape oldShape, Shape newShape) {
        // TODO Auto-generated method stub

    }

    @Override
    public Shape[] getShapes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void undo() {
        // TODO Auto-generated method stub
      if(!canvas.getShapesList().isEmpty()){ 
       Shape c=canvas.getShapesList().remove(canvas.getShapesList().size()-1);
       clearedshape.add(c);}
//last index of shapes added 	
    }

    @Override
    public void redo() {
        // TODO Auto-generated method stub
        if(!clearedshape.isEmpty()){
addShape(clearedshape.get(clearedshape.size()-1));
clearedshape.remove(clearedshape.size()-1);}
    }

    @Override
    public void save(String path) {
        Save s;
        if (path.endsWith(".xml"))
        {
            s=new paint.controller.SaveXML();
            s.save(path, canvas.getShapesList());
        }
         
        else if(path.endsWith(".json"))
            //SaveJson(path);
        { s=new paint.controller.SaveJSON();
            s.save(path, canvas.getShapesList());
        }
        }

    @Override
    public void load(String path) {
            
        if (path.endsWith(".json"))
            try {
                loadJSON(path);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        else if (path.endsWith(".xml"))
            try {
                loadXML(path);
        } catch (ParserConfigurationException | JDOMException | IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        else JOptionPane.showMessageDialog(null, "Please select JSON or XML file");
        

    }
    public void cleardall(){
int i= canvas.getShapesList().size();
   while(!canvas.getShapesList().isEmpty())
   {i--;
   canvas.getShapesList().remove(i);
 
   }
   clearedshape.clear();
   

}

    @Override
    public List<Class<? extends Shape>> getSupportedShapes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void installPluginShape(String jarPath) {
        // TODO Auto-generated method stub

    }

    public Shape factory(String type) {
        Shape s = new Shape();
        switch (type) {
            case "circle":
                return new Circle();
            case "elliptical":
                return new Elliptical();
            case "line":
                return new Line();
            case "rectangle":
                return new Rectangle();
            case "square":
                return new Square();
            case "triangle":
                return new Triangle();
            default:
                return null;
        }
    }
public int Select(Point p){
            for(int j = canvas.getShapesList().size() - 1; j >= 0; j--){
                Shape s=canvas.getShapesList().get(j);
            if(s.contains(p)){
                return j;
            }
            
        }
    return -1;
    }
    public void delete(int j){
        canvas.getShapesList().remove(j);
    }

   public Shape getShape(int j){
       Shape s=canvas.getShapesList().get(j);
       return s;
   }
   public Shape move(Shape s,Point p){
       s.Filled(s.isFilled());
       return s.move(p);
   }
   public Shape resize(Shape s,Point p,Point center){
       return s.resize(p,center);
   }
   public Point getCenter(Shape s){
       return s.getCenter();
   }
   
    private void loadJSON(String path) throws FileNotFoundException, IOException, ParseException
    {
       JSONParser parser = new JSONParser();
        File file=new File(path);
                    try {
                        Object obj = parser.parse(new FileReader(file));
                        JSONObject shapes= (JSONObject) obj;
                        for (Object shapeKey:shapes.keySet())
                        {
                            Shape s=null;
                            Point position1 = new Point(0,0);
                            Point position2= new Point(0,0);
                            int red,blue,green;
                            String shapeskey=(String)shapeKey;
                            JSONObject shapeJSONObject=(JSONObject) shapes.get(shapeskey);
                            if(shapeJSONObject.get("type").equals("circle"))
                               s=new Circle();
                            else if(shapeJSONObject.get("type").equals("elliptical"))
                               s=new Elliptical();
                            else if(shapeJSONObject.get("type").equals("triangle"))
                               s=new Triangle();
                            else if(shapeJSONObject.get("type").equals("rectangle"))
                               s=new Rectangle();
                            else if(shapeJSONObject.get("type").equals("square"))
                               s=new Square();
                            else if(shapeJSONObject.get("type").equals("line"))
                               s=new Line();
                            boolean x = false;
                            x= Boolean.valueOf((String) shapeJSONObject.get("filled"));
                            position1.x=Integer.parseInt((String) shapeJSONObject.get("x1"));
                            System.out.println(shapeJSONObject.get("x1"));
                            position1.y=Integer.parseInt((String) shapeJSONObject.get("y1"));
                            position2.x=Integer.parseInt((String) shapeJSONObject.get("x2"));
                            position2.y=Integer.parseInt((String) shapeJSONObject.get("y2"));
                            green=Integer.parseInt((String) shapeJSONObject.get("green"));
                            blue=Integer.parseInt((String) shapeJSONObject.get("blue"));
                            red=Integer.parseInt((String) shapeJSONObject.get("red"));
                            s.setPosition(position1);
                            s.setPosition2(position2);
                            s.Filled(x);
                            Color c=new Color(red,green,blue);
                            s.setColor(c);
                            canvas.getShapesList().add(s);
                        }
                        } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | org.json.simple.parser.ParseException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private void loadXML(String path) throws ParserConfigurationException, JDOMException, IOException
    {
        SAXBuilder builder = new SAXBuilder();
        try{
        org.jdom2.Document xmlReader = builder.build(new File(path));
         org.jdom2.Element root = xmlReader.getRootElement();
            Shape shape;
            for (org.jdom2.Element element : root.getChildren()){
                System.out.println(element.getAttributeValue("type"));
                 shape = factory((String)element.getAttributeValue("type"));
                 System.out.println(element.getName());
                int red,green,blue;
                boolean x;
                x = Boolean.valueOf(element.getChildText("filled"));
                Point position1=new Point(0,0);
                Point position2=new Point(0,0);
                position1.x=Integer.parseInt(element.getChildText("x1"));
                position1.y=Integer.parseInt(element.getChildText("y1"));
                position2.x=Integer.parseInt(element.getChildText("x2"));
                position2.y=Integer.parseInt(element.getChildText("y2"));
                red=Integer.parseInt(element.getChildText("red"));
                green=Integer.parseInt(element.getChildText("green"));
                blue=Integer.parseInt(element.getChildText("blue"));
                System.out.println(blue);
                Color c= new Color(red,green,blue);
                System.out.println(c);
                shape.Filled(x);
                shape.setColor(c);
                shape.setPosition(position1);
                shape.setPosition2(position2);
                canvas.getShapesList().add(shape);}}
                catch (JDOMException | IOException e) {
        }
        // TODO Auto-generated catch block

}}
