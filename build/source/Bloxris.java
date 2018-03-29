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

ArrayList<GameObject> gameObjects = new ArrayList();

public void setup(){
  
  gameObjects.add(new Block());
  background(0);
  for(GameObject o : gameObjects){
    o.initialize();
  }
}

public void draw(){
  for(GameObject o : gameObjects){
    o.update();
    o.render();
  }
}
class Block implements GameObject{

  int blockDimensions = 10;
  int x;
  int y;

  @Override
  public void initialize(){
      x = height/2;
      y = width/2;
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
interface Screen{
  public void update();
  public void display();
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
