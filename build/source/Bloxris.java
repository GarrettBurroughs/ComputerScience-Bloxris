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
static Screen currentScreen;
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


public void mousePressed()
{
  for(GameObject o : currentScreen.getObjects())
  {
     o.click();
   }
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
  public void click(){

  }

  @Override
  public void render(){
    rectMode(CENTER);
    rect(x, y, blockDimensions, blockDimensions);
  }
}
public class Bloxrominoe implements GameObject{
  private void moveDown(){
    // Perform a check
  }

  private void move(int direction){

  }
  public void initialize(){

  }

  public void update(){

  }

  public void click(){

  }

  public void render(){

  }

}
public abstract class Button implements GameObject
{
   String text;
   int x;
   int y;
   int boxWidth;
   int boxHeight;
   int fontSize = 24;
   Screen targetScreen;
   
   public Button(int x, int y, String text )
   {
     this.x = x;
     this.y = y;
     this.text = text;
     //this.targetScreen = targetScreen;
     calcBoxDimensions();
   }
   
   public void calcBoxDimensions()
   {
     textFont(f, fontSize);
     boxWidth = (int) textWidth(text) + 20;
     boxHeight = fontSize + 16 ;
   }
   
   public void initialize()
   {
     
   }
   
  public void update()
  {
  
  }
  
  public void click()
  {
     //<>//
  }

  @Override
  public void render(){
    strokeWeight(1);
    stroke(0);
    rectMode(CENTER);
    textAlign(CENTER);
    textFont(f, fontSize);
    if(mouseX<=x+boxWidth/2 && mouseX>=x-boxWidth/2 && mouseY<=y+boxHeight/2 && mouseY>=y-boxHeight/2)
    {
      fill(50);
    }
    else
    {
        fill(127);
    }
    rect(x, y, boxWidth, boxHeight);
    fill(255);
    text(text, x, y + 8);
  }
   
}
public class GameplayScreen extends Screen{

  int[][] grid = new int[20][10];
  private final float blockX = (3 * width / 5) / 10;
  private final float blockY = height / 20;
  public GameplayScreen(){
  }

  @Override
  public void screenUpdate(){

  }

  @Override
  public void display(){
    noStroke();
    rectMode(CORNER);
    fill(21, 26, 79);
    rect(0, 0, width/5, height);
    fill(63, 72, 204);
    rect(width/5, 0, 3 * width / 5, height);
    fill(21, 26, 79);
    rect(4 * width/5, 0, width, height);
    textFont(f, 104);
    textAlign(CENTER);
    fill(255);
    stroke(255);
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[i].length; j++){
        if(grid[i][j] == 1){
          fill(255);
        }else{
          fill(0);
        }
        // TODO: figure out block scaling
        rect((width / 5 + j * blockX), (i * blockY), (blockX), (blockY));
      }
    }
  }

  @Override
  public int isDone(){
    return -1;
  }
}
class StartScreen extends Screen{

  public StartScreen(){
    addObjects(
      new screenSwitchButton(width/2, height/2, "Start", new GameplayScreen()),
      new screenSwitchButton(width/2, height/2 + 60, "Statistics", currentScreen),
      new screenSwitchButton(width/2, height/2 + 120, "Options", currentScreen),
      new screenSwitchButton(width/2, height/2 + 180, "Quit", currentScreen)
    );
  }

  @Override
  public void screenUpdate(){

  }

  @Override
  public void display(){
    noStroke();
    rectMode(CORNER);
    fill(21, 26, 79);
    rect(0, 0, width/5, height);
    fill(63, 72, 204);
    rect(width/5, 0, 3 * width / 5, height);
    fill(21, 26, 79);
    rect(4 * width/5, 0, width, height);
    textFont(f, 104);
    textAlign(CENTER);
    fill(255);
    text("Bloxris", width/2, height/4);
    //Button testButton = new Button(width/2, height/2, "Options");

    //testButton.render();
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
public class screenSwitchButton extends Button
{
  Screen targetScreen;
  public screenSwitchButton(int x, int y, String text, Screen targetScreen )
  {
    super( x,  y,  text );
    this.targetScreen = targetScreen;
  }
  public void click()
  {
    if(mouseX<=x+boxWidth/2 && mouseX>=x-boxWidth/2 && mouseY<=y+boxHeight/2 && mouseY>=y-boxHeight/2)
    {
        Bloxris.currentScreen = targetScreen;
    }
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
