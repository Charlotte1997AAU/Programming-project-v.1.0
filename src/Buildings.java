import processing.core.*;

public class Buildings {
	//definition of variable for an image type 
	public PImage house;
	//definition of variable PApplet type
	public PApplet b;
	
	//constructor for tree, which requires PApplet and and image type
	public Buildings(PApplet b, PImage house) {
		this.b = b;
		this.house = house;
	}
	
	
	public void display() {
		//draws the background for the buildings. 
		b.noStroke();
		b.fill(125);
		b.rect(0,740,600,60);
		//uses the image of the houses, resize, and places it on the coordinates.
		house.resize(615, 50);
		b.image(house, 300, 775);
	}
}
