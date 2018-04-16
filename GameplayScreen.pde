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
