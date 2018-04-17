import java.util.ArrayList;

/**
 *
 */

static ArrayList<Screen> screens = new ArrayList();
static Screen currentScreen;
// A file to store information about the game
JSONObject gameData;
int tickRate;
public PFont f;

void setup(){
  // Set global variables
  gameData = loadJSONObject("gameData.json");
  tickRate = gameData.getInt("tickRate");

  f = loadFont("bloxrisFont2.vlw");

  // Basic Processing enviornment setup
  size(1000,1000);
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
