import processing.core.*;


public class Enemy {
	//definition of variable for an image type 
	public PImage devil;
	//definition of variables
	public float speed;
	public float x;
	public float y;
	//PApplet allows us to acces all processing functions
	public PApplet r;

	//constructor for the enemy, which requires, position values, PApplet and an image type
	public Enemy(float x, float y, PApplet r, PImage devil) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.devil = devil;
	}
	
	public void display() {	
		//uses the image of the enemies, resize, and places it on the coordinates.
		devil.resize(30,50);
		r.image(devil,x ,y);	
	}
	
	//method that contributes to determine the speed of which the enemies fall down
	public void drop(float speed) {
		this.speed = speed;
		y+=speed;	
	}
	
}
