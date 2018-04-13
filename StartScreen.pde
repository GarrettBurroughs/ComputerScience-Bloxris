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
