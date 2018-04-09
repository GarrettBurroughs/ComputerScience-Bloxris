import java.util.ArrayList;

/**
 *
 */

ArrayList<Screen> screens = new ArrayList();

void setup(){
  size(720, 480);
  gameObjects.add(new Block());
  background(0);
  for(GameObject o : gameObjects){
    o.initialize();
  }
}

void draw(){
  for(GameObject o : gameObjects){
    o.update();
    o.render();
  }
}
