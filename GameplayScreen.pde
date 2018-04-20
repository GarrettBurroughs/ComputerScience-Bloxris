public class GameplayScreen extends Screen{

  int[][] grid = new int[20][10];
  color[] colors = {color(0),color(0,240,240), color(0,0,240), color(240,160,0), color(240,240,0), color(0,240,0), color(160,0,240), color(240,0,0)};
  private final float blockX = (3 * width / 5) / 10;
  private final float blockY = height / 20;
  private Bloxrominoe b;
  private int time = 0;
  private String debug = "";
  private int initTime;
  private float timePerTick = 500;

  public GameplayScreen(){
    b =  Bloxrominoe.randomBloxrominoe(0, 3);
    initTime = millis();
    /*for(int i = 0; i < 10; i++){
      grid[17][i] = 1;
    }*/
  }


  @Override
  public void screenUpdate(){
    timePerTick = 500 - 0.001*(millis()-initTime);
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
                checkBloxris();
                b =  Bloxrominoe.randomBloxrominoe(0, 0);
              }


              drawShape();

      time = millis();
  }

  }
  
  public boolean checkBloxris()
  {
   boolean bloxris = false;
    for(int i = 0; i < 20; i++)
   {
     boolean colFull = true;
      for(int j = 0; j < 10; j++)
      {
          colFull = grid[i][j] < 1 ? false : colFull ;
        }
        if(colFull)
        {
          bloxris = true;
          for(int j = 0; j < 10; j++)
          {
              grid[i][j] = 0;
              
          }
          moveDown(i);
    }
   }
   return bloxris;
  }


  public void moveDown(int row)
  {
    for(int j = row - 1; j >=0 ; j--)
    {
      for(int i = 0; i < 10; i++)
      {
         grid[j + 1][i] =  grid[j][i];
      }
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
  
  /*
    public boolean checkCol(int[] col)
  {
    boolean contains = false;
    for(int tmp : col)
    {
       contains = tmp>=1?true:contains; 
    }
    return contains;
  }
  */
  
  
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