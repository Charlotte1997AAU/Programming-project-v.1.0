import processing.core.*;


public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Main");
	}
	
	//Makes space for the arrays
	Coin[] coinArray = new Coin [200];
	Enemy[] enemyArray = new Enemy[1000];
	//initializes the variables
	public int playerx = 300;
	public float enemyY = 0;
	public float enemySpeed= 4;
	public float coinSpeed = 6;
	public int points = 0;
	public int highscore = 0;
	public int hp = 3;
	public boolean hit = false;
	public int check = 1;
	public PImage Devil;
	
	
	public void settings() {
		//sets the size of the window
		size(600,800);
			
	}
	
	//Defining the classes
	Player myPlayer;
	Tree myTree;
	Hp myHp;
	Buildings myBuildings;
	
	//setup is run once, when the program i started
	public void setup() {
	//loading the images used in the program
	PImage character = loadImage("SwordsmanWalkFrame_1.png");	
	PImage devil = loadImage("DevilIdleFrame_1.png");
	PImage coinpic = loadImage("coin.png");
	PImage tree = loadImage("Universal-Trees.png");
	PImage heart = loadImage("heart.png");
	PImage house = loadImage("houses.png");
	
	//initializes the objects
	myPlayer = new Player(this, character);
	myTree = new Tree(this, tree);
	myHp = new Hp(this, heart);
	myBuildings = new Buildings(this, house);
	
	//sets frame rate
	frameRate(30);
	
	//initializes the objects in a for loop, and creates all of them, the 200 coins and 1000 enemies
	for(int i = 0; i < coinArray.length; i++) {
		coinArray[i] = new Coin(random(45,555), -500-(i*2500), this, coinpic);
	}
	for(int i = 0; i < enemyArray.length; i++) {
		enemyArray[i] = new Enemy(random(45,555),0-(i*550),this, devil);
	}	
}
	
	//draw is run multiple times while the program is running. 
	public void draw() {
	imageMode(CENTER);
		
		//creates a switch, which follows the variable "check"
		switch(check) {
		
		//case 1 displays the start screen.
		case 1:
		background(20,150,20);
		textAlign(CENTER);
		textSize(50);
		fill(0);
		text("DEFEND THE CITY!", 300, 200);
		//uses a method from the Player class
		myPlayer.startscreen();
		textSize(25);
		text("Press 'ENTER' to start", 300, 300);
		
		break;
		
		//case 2 is the main part of the game
		case 2:	
		background(20,150,20);
		//l 92-98 shows current number of points and highscore
		textAlign(CENTER,TOP);
		textSize(28);
		fill(255);
		text(points, 300, 10);
		textSize(18);
		text("Highscore:", 90, 10);
		text(highscore, 150, 12);
		
		//adds points to the highscore
		if(points > highscore) {
			highscore = points;
		}
		
		//methods from objects' the respective classes to display, myBuildings, myPlayer, myHp, and myTree objects. 
		myBuildings.display();
		myPlayer.display(playerx);
		myTree.display();
		textAlign(CENTER);
		rectMode(CORNER);
		myHp.display(hp);
	
		//determines the speed of the enemies falling. Goes faster the longer time the player survives. Also call the method display
		for(int i = 0; i < enemyArray.length; i++) {
			enemyArray[i].display();
			enemyArray[i].drop(enemySpeed);
			if(frameCount%30==0) {
				enemySpeed += 0.00005;			
			}
			
		}
		//determines the speed of the coins falling, which is faster than the enemies. Goes faster the longer time the player survives. Also call the method display 
		for(int i = 0; i < coinArray.length; i++) {
			coinArray[i].display();
			coinArray[i].drop(coinSpeed);
			if(frameCount%30==0) {
				coinSpeed += 0.0001;
			}
			
		}
		
		//calls functions to detect collision with enemy/player, enemy/wall/, coin/wall, and player/coin
		collision();
		wallCollision();
		coinCollision();
		
		break;
		
		//case 3 is the game over screen
		case 3:
			
			fill(0);
			rect(0,0,600,800);
			fill(255,100,0);
			textSize(50);
			text("GAME OVER", 300, 400);
			textSize(25);
			text("Press 'R' to restart", 300, 500);
			
			//resets speed of coin and enemy
			enemySpeed = 4;
			coinSpeed = 6;
			
			//both for loops, resets the arrays to start over when game is over.
			for(int i = 0; i < enemyArray.length; i++) {
				enemyArray[i].x = random(45,555);
				enemyArray[i].y = 0-(i*550);
				}
			for(int i = 0; i < coinArray.length; i++) {
				coinArray[i].x = random(45, 555);
				coinArray[i].y = -500-(i*2500);
			}
			break;
		}
		
		//simple if statements that says that if life reaches 0, the swicth should go to case 3 which is game over screen.
		if(hp == 0) {
			check = 3;
		}
		
		
}
	//functions used to move the player, and enter/restart game
	public void keyPressed() {
		if(key == 'a' && playerx > 40 && check == 2 || key == 'A' && playerx > 40 && check == 2|| keyCode == LEFT && playerx > 40 && check == 2) {
			playerx -= 10;
		}
		if(key == 'd' && playerx < 560 && check == 2 || key == 'D' && playerx < 560 && check == 2 || keyCode == RIGHT && playerx < 560 && check == 2) {
			playerx += 10;
		}
		if(keyCode == ENTER && check == 1) {
			check = 2;
		}
		if(key == 'r' && check == 3 || key == 'R'  && check == 3) {
			check = 1;
			hp = 3;
			points = 0;
		}
			
		}
	
	// check if the player has hit an enemy and removes him
	public void collision() {
		for(int i = 0; i < enemyArray.length; i++) {
			if(playerx <= enemyArray[i].x + 20 && playerx >= enemyArray[i].x - 20 && 660 <= enemyArray[i].y + 50 && 660 >= enemyArray[i].y -50){
				println("collison");
				enemyArray[i].x = 650;
				points += 1;
			}		
		}
	}
	
	// check if the enemy has hit the wall, and makes the player lose a life, also checks if the coin has hit the wall and makes it disappear
	public void wallCollision() {
		for(int i = 0; i < enemyArray.length; i++) {
			if(enemyArray[i].x < 600 && enemyArray[i].x > 0 && enemyArray[i].y + 25 > 745 && hp > 0) {
				println("av en væg");
				enemyArray[i].x = 650;
				hp -= 1;		
			}
		}
		for(int i = 0; i < coinArray.length; i++) {
			if(coinArray[i].x < 600 && coinArray[i].x > 0 && coinArray[i].y + 17 > 745) {
				coinArray[i].x = 650;
			}
		}
	}
	
	//checks if the player has touched a coin
	public void coinCollision() {
		for(int i = 0; i < coinArray.length; i++) {
			if(playerx <= coinArray[i].x + 40 && playerx >= coinArray[i].x - 40 && 660 <= coinArray[i].y + 35 && 660 >= coinArray[i].y - 35) {
				println("jaa mønt");
				coinArray[i].x = 650;
				points += 5;
			}
		}
	}
	
}

