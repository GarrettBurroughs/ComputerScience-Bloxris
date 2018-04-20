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
public PFont f;

public void setup(){
  // Set global variables
  gameData = loadJSONObject("gameData.json");

  f = loadFont("bloxrisFont2.vlw");

  // Basic Processing enviornment setup
  
  background(0);
  frameRate(gameData.getInt("frameRate"));

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

public void keyPressed(){
  currentScreen.pressed(key);
  // println(key);
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
  int[] colors = {color(0),color(0,240,240), color(0,0,240), color(240,160,0), color(240,240,0), color(0,240,0), color(160,0,240), color(240,0,0)};
  private final float blockX = (3 * width / 5) / 10;
  private final float blockY = height / 20;
  private Bloxrominoe b;
  private int time = 0;
  private String debug = "";
  private int timePerTick = 500;

  public GameplayScreen(){
    b =  Bloxrominoe.randomBloxrominoe(0, 3);
    for(int i = 0; i < 10; i++){
      grid[17][i] = 1;
    }
  }


  @Override
  public void screenUpdate(){
    timePerTick = 500;
    if(keyPressed)
    {
      if(key == ' '){
        timePerTick = 50;
      }
    }
    if(millis()-time >= timePerTick)
    {

              unDrawShape();


              if(!b.moveDown(grid))
              {
                drawShape();
                b =  Bloxrominoe.randomBloxrominoe(0, 0);

              }


              drawShape();

      time = millis();
  }

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
    textAlign(CORNER);
    fill(255);
    text(debug, 0, 0);
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[i].length; j++)
      {
          fill(colors[grid[i][j]]);
          stroke(0);
        rect((width / 5 + j * blockX), (i * blockY), (blockX), (blockY));
      }
    }
  }

  @Override
  public int isDone(){
    return -1;
  }

  @Override
  public void pressed(char c)
  {
    switch(c)
    {
      case 'r':
        unDrawShape();
        b.rotatePiece();
        drawShape();
      break;
      case 'n':
        b = Bloxrominoe.randomBloxrominoe(0, 0);
      break;
      case 'a':
              unDrawShape();
              if(checkBounds(-1))
                b.move(-1);
              drawShape();
      break;
      case 'd':
            unDrawShape();
            if(checkBounds(1))
              b.move(1);
            drawShape();
      break;
      case 's':
        unDrawShape();
        b.moveDown(grid);
        drawShape();
      break;
    }
    println(c);
  }

  public boolean checkBounds(int dir)
{
  boolean canMove = false;
  int max = -1;
  if(dir>0)
  {
    for(int j = 0; j < 5; j++)
    {
       max = checkCol(b.shape, j) ? j : max;
    }
    debug = "MAX:" + (int)(b.xpos + max);
    if(b.xpos + max  < 10)
    {
      canMove = true;
    }
  }
  else
  {
    for(int j = 4; j > -1; j--)
    {
       max = checkCol(b.shape, j) ? j : max;
    }
    debug = "MAX:" + (int)(b.xpos + max);

    if(b.xpos + max -2 > -1)
    {
      canMove = true;
    }
  }
  return canMove;
}

  public boolean checkCol(int[][] shape, int col)
  {
    boolean contains = false;

    for(int[] tmp : shape)
    {
       contains = tmp[col]>=1?true:contains;
    }
    return contains;
  }


    public void drawShape()
  {
                for(int i = 0; i < 5; i++)
                {
                  for(int j = 0; j < 5; j++)
                  {
                    // Make sure it is in bounds
                    if(b.shape[i][j] != 0 && b.xpos + j-1 < 10 && b.xpos + j > 0 && b.xpos + j < 20)
                    {
                      if(i > b.shape.length)
                      {
                        if(b.shape[i + 1][j] == 1)
                        {
                          grid[b.ypos + i][b.xpos + j] = b.shape[i][j];
                        }
                      }
                      grid[b.ypos + i][b.xpos + j-1] = b.shape[i][j];

                    }
                  }
                }
  }

  public void unDrawShape()
  {
    for(int i = 0; i < 5; i++)
    {
              for(int j = 0; j < 5; j++)
              {
                // Make sure it is in bounds
                if(b.shape[i][j] != 0 && b.xpos + j-1 < 10 && b.xpos + j > 0 && b.xpos + j < 20)
                {
                  if(i > b.shape.length)
                  {
                    if(b.shape[i + 1][j] == 1)
                    {
                      grid[b.ypos + i][b.xpos + j] = 0;
                    }
                  }
                  grid[b.ypos + i][b.xpos + j-1] = 0;
                }
              }
            }
  }
}
class StartScreen extends Screen{

  public StartScreen(){
    addObjects(
      new screenSwitchButton(width/2, height/2, "Start", new GameplayScreen()),
      new screenSwitchButton(width/2, height/2 + 60, "Statistics", this),
      new screenSwitchButton(width/2, height/2 + 120, "Options", this),
      new quitButton(width/2, height/2 + 180, "Quit")
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

  @Override
  public void pressed(char c){

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
  @Override
  public void pressed(char c){

  }
}
public static abstract class Utils
{
  
}
public class quitButton extends Button
{
  public quitButton(int x, int y, String text)
  {
    super( x,  y,  text );
  }
  public void click()
  {
    if(mouseX<=x+boxWidth/2 && mouseX>=x-boxWidth/2 && mouseY<=y+boxHeight/2 && mouseY>=y-boxHeight/2)
    {
        exit();
    }
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
  public void settings() {  size(800,900); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Bloxris" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
