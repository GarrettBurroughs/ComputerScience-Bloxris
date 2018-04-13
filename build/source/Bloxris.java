import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.ArrayList; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Bloxris extends PApplet {



/**
 *
 */

static ArrayList<Screen> screens = new ArrayList();
Screen currentScreen;
// A file to store information about the game
JSONObject gameData;
int tickRate;
public PFont f;

public void setup(){
  // Set global variables
  gameData = loadJSONObject("gameData.json");
  tickRate = gameData.getInt("tickRate");

  f = loadFont("bloxrisFont2.vlw");

  // Basic Processing enviornment setup
  
  background(0);
  frameRate(tickRate);

  screens.add(new StartScreen()); // Screen 1

  // Set up screens
  currentScreen = screens.get(0);
  for(Screen s : screens){
    for(GameObject o : s.getObjects()){
      o.initialize();
    }
  }
}

public void draw(){
  currentScreen.update();
  currentScreen.display();
  currentScreen.renderObjects();
}
class Block implements GameObject{

  int blockDimensions = 10;
  int x;
  int y;

  public Block(int x, int y){
    this.x = y;
    this.y = y;
  }

  @Override
  public void initialize(){
      // x = height/2;
      // y = width/2;
  }

  @Override
  public void update(){

  }

  @Override
  public void render(){
    rectMode(CENTER);
    rect(x, y, blockDimensions, blockDimensions);
  }
}
class StartScreen extends Screen{

  public StartScreen(){

  }

  @Override
  public void screenUpdate(){

  }

  @Override
  public void display(){
    noStroke();
    fill(21, 26, 79);
    rect(0, 0, width/5, height);
    fill(63, 72, 204);
    rect(width/5, 0, 3 * width / 5, height);
    fill(21, 26, 79);
    rect(4 * width/5, 0, width, height);
    textFont(f, 64);
    textAlign(CENTER);
    fill(255);
    text("Bloxris", width/2, height/4);
  }

  @Override
  public int isDone(){
    return -1;
  }
}
public class TestScreen extends Screen{

  public TestScreen(){
    for(int i = 0; i < 10; i++){
      println(i);
      addObject(new Block(i * 10, i * 10));
    }
  }


  @Override
  public void screenUpdate(){

  }

  @Override
  public void display(){

  }

  @Override
  public int isDone(){
    return -1;
  }
}
  public void settings() {  size(720, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Bloxris" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
