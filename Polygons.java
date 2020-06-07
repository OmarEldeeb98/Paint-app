package Paint.model;

public abstract class Polygons extends Shape {
     
        
        public Polygons()
        {
            
        }

	float numOfSides;

	public float getNumOfSides() {
		return numOfSides;
	}

	public void setNumOfSides(float numOfSides) {
		this.numOfSides = numOfSides;
	}

}
