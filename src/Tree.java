import processing.core.*;

public class Tree {
	//definition of variable for an image type 
	public PImage tree;
	//definition of variable, PApplet allows us to acces all processing functions
	public PApplet t;
	
	//constructor for tree, which requires PApplet and and image type
	public Tree(PApplet t, PImage tree) {
		this.t = t;
		this.tree = tree;
	}
	
	//display method, that makes the trees one by one in a for loop, first on the "left" side, and a for loop for the "right" side of the screen.
	public void display() {
		tree.resize(30,50);
		for(int i = 650; i > 0; i -= 100) {	
			t.image(tree,25,i);
		}
		for(int i = 650; i > 0; i -= 100) {	
			t.image(tree, 575, i);
		}
	}
	
}
