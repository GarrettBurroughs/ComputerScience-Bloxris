public class GameplayScreen extends Screen{

  int[][] grid = new int[20][10];
  private final float blockX = (3 * width / 5) / 10;
  private final float blockY = height / 20;
  private Bloxrominoe b;

  public GameplayScreen(){
    b =  Bloxrominoe.randomBloxrominoe(3, 3);
    for(int i = 0; i < 10; i++){
      grid[17][i] = 1;
    }
  }

  @Override
  public void screenUpdate(){
    for(int i = 0; i < 5; i++){
      for(int j = 0; j < 5; j++){
        // Make sure it is in bounds
        if(b.shape[i][j] != 0 && b.xpos + j > 0 && b.xpos + j < 20){
          if(i > b.shape.length){
            if(b.shape[i + 1][j] == 1){
              grid[b.ypos + i][b.xpos + j] = b.shape[i][j];
            }
          }
          grid[b.ypos + i][b.xpos + j] = b.shape[i][j];
        }
      }
    }
    b.moveDown(grid);
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
          stroke(0);
        }else{
          fill(0);
          stroke(255);
        }
        rect((width / 5 + j * blockX), (i * blockY), (blockX), (blockY));
      }
    }
  }

  @Override
  public int isDone(){
    return -1;
  }

  @Override
  public void pressed(char c){
    if(c == 'r'){
      b.rotatePiece();
    }
    if(c == 'n'){
      b = Bloxrominoe.randomBloxrominoe(3, 3);
    }
    if(c == 'a'){
      b.move(1);
    }
    if(c == 'd'){
      b.move(-1);
    }

    println(c);
  }
}
