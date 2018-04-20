import java.util.ArrayList;

/**
 *
 */

static ArrayList<Screen> screens = new ArrayList();
static Screen currentScreen;
// A file to store information about the game
JSONObject gameData;
public PFont f;

void setup(){
  // Set global variables
  gameData = loadJSONObject("gameData.json");

  f = loadFont("bloxrisFont2.vlw");

  // Basic Processing enviornment setup
  size(800,900);
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

void draw(){
  currentScreen.update();
  currentScreen.display();
  currentScreen.renderObjects();
}


void mousePressed()
{
  for(GameObject o : currentScreen.getObjects())
  {
     o.click();
   }
}

void keyPressed(){
  currentScreen.pressed(key);
  // println(key);
}
