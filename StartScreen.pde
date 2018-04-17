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

  @Override
  public void pressed(char c){

  }
}
