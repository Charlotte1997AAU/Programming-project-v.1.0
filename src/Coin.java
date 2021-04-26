import processing.core.*;


public class Coin {
	//definition of variable for an image type 
	public PImage coinpic;
	//definition of variables
	public float x;
	public float y; 
	public float speed; 
	//PApplet allows us to acces all processing functions
	public PApplet c;

	//constructor for the coin, which requires, position values, PApplet and an image type
	public Coin(float x, float y, PApplet c, PImage coinpic) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.coinpic = coinpic;
	}
	
	public void display() {
		//uses the image of the coins, resize, and places it on the coordinates.
		coinpic.resize(40,50);
		c.image(coinpic,x,y);
	}
	
	//method that contributes to determine the speed of which the coins fall down
	public void drop(float speed) {
		this.speed = speed;
		y+=speed;
	}
	
}
