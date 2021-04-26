import processing.core.*;


public class Player{        
	//definition of variable for an image type
	public PImage character; 
	//definition of variables
    public int x;
    public int y;
   //PApplet allows us to acces all processing functions
    public PApplet p;
    
    //constructor for the player, 
    public Player(PApplet p, PImage character) {
    	this.p = p;
        this.character = character;
    }
    
    public void startscreen() {
    	//uses the image of the character, resize, and places it on the coordinates.
    	character.resize(60, 100);
    	p.image(character, 300, 450);
    }
    
    public void display(int tempX) {
    	//has an x variable, to control the character on the x-axis 
        x = tempX;
        
        //uses the image of the character, resize, and places it on the coordinates.
        character.resize(30, 50); 
        p.image(character,x,650);
    }
   
}