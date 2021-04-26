import processing.core.*;

public class Hp {
	//definition of variable for an image type 
	public PImage heart;
	//initialization of variables
	public int life1 = 460;
	public int life2 = 500;
	public int life3 = 540;
	public int hp = 3;
	//definition of variable PApplet type, PApplet allows us to acces all processing functions
	public PApplet h;
	
	//constructor for tree, which requires PApplet and and image type
	public Hp(PApplet h, PImage heart) {
		this.h = h;
		this.heart = heart;
		
	}
	
	//display method that takes the images of hearts, and if the player loses a life, they disappear from the screen.
	public void display(int hp) {
		heart.resize(30,30);
		h.image(heart, life1, 30);
		h.image(heart, life2, 30);
		h.image(heart, life3, 30);
	
		//makes life go down
		if(hp == 3) {
			life2 = 500;
			life3 = 540;
		}		
		else if(hp == 2) {
			life3 = 650;
		}
		else if(hp == 1) {
			life2 = 650;
		}
		
	}
		
}
