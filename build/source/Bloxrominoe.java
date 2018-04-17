import java.util.Random;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.lang.NullPointerException;




public class Bloxrominoe implements GameObject{

  public int xpos;
  public int ypos;

  private boolean done = false;
  private int timeStopped = 0;
  public int[][] shape = new int[5][5];

  private static final int[][] SSchematic = {
    {0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0},
    {0, 0, 1, 1, 0},
    {0, 0, 1, 0, 0},
    {0, 1, 1, 0, 0}
  };

  private static final int[][] ZSchematic = {
    {0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0},
    {0, 1, 1, 0, 0},
    {0, 0, 1, 0, 0},
    {0, 0, 1, 1, 0}
  };

  private static final int[][] TSchematic = {
    {0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0},
    {0, 0, 1, 0, 0},
    {0, 1, 1, 1, 0}
  };

  private static final int[][] LineSchematic = {
    {0, 0, 0, 0, 0},
    {0, 0, 0, 1, 0},
    {0, 0, 0, 1, 0},
    {0, 0, 0, 1, 0},
    {0, 0, 0, 1, 0}
  };


  private static final int[][] MirroredLSchematic = {
    {0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0},
    {0, 0, 1, 0, 0},
    {0, 0, 1, 0, 0},
    {0, 0, 1, 1, 0}
  };

  private static final int[][] LSchematic = {
    {0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0},
    {0, 0, 1, 0, 0},
    {0, 0, 1, 0, 0},
    {0, 1, 1, 0, 0}
  };

  private static final int[][] SquareSchematic = {
    {0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0},
    {0, 0, 1, 1, 0},
    {0, 0, 1, 1, 0}
  };

  public enum Shape{
    S(0),
    Z(1),
    T(2),
    L(3),
    MIRRORED_L(4),
    LINE(5),
    SQUARE(6);

    int i;

    private Shape(int i){
      this.i = i;
    }

    public int get(){
      return i;
    }

    private static final List<Shape> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Shape random()  {
      return VALUES.get(RANDOM.nextInt(SIZE));
    }
  }

  public static Bloxrominoe randomBloxrominoe(int xpos, int ypos){
      return getBloxrominoe(Shape.random(), xpos, ypos);
  }

  public static Bloxrominoe getBloxrominoe(Shape s, int xpos, int ypos){
    switch(s){
      case S:
        return new Bloxrominoe(SSchematic, xpos, ypos);

      case Z:
        return new Bloxrominoe(ZSchematic, xpos, ypos);


      case T:
        return new Bloxrominoe(TSchematic, xpos, ypos);

      case L:
        return new Bloxrominoe(LSchematic, xpos, ypos);

      case MIRRORED_L:
        return new Bloxrominoe(MirroredLSchematic, xpos, ypos);

      case LINE:
        return new Bloxrominoe(LineSchematic, xpos, ypos);

      case SQUARE:
        return new Bloxrominoe(SquareSchematic, xpos, ypos);
      default:
      return null;
    }
  }

  private Bloxrominoe(int[][] shape, int xpos, int ypos){
    this.shape = shape;
    this.xpos = xpos;
    this.ypos = ypos;
  }


  public void rotatePiece()
  {
    int[][] tempShape = new int[5][5];
    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            tempShape[j][4-i] = shape[i][j];
        }
    }
    this.shape = tempShape;
    /*
    if(getLowestRow() != 0){
      int[] tempRow = int[5];
      for(int i = 0; i < 5 - getLowestRow(); i++){

      }
      // make bottom row top row
      // Repeat untill bottom row is top getLowestRow
      // If lowest row = 4, 1 time, if lowest row = 3,2times
      // 5 - Lowest Row
    }*/
  }



  public void moveDown(int[][] grid){
    boolean canMoveDown = true;
    for(int i = 0; i < 5; i++){
      try{
        System.out.println(getLowestRow());
        System.out.println("Grid Value: " + grid[ypos + i + 2][xpos + i]);
        System.out.println("Y value: " + (ypos + i + 2));
        System.out.println("X Value: " + (xpos + i));
        if(shape[getLowestRow()][i] >= 1 && grid[ypos + getLowestRow() + 1][xpos + i] >= 1){
          canMoveDown = false;
        }
      } catch(NullPointerException e) {
        canMoveDown = false;
      }
    }
    if(canMoveDown){
      ypos++;
    }
    else{

    }
    // Check if can moveDown
    // Yes -> Move moveDown
    // No -> start timer
    // if Timer exceeds time
    // Stop
  }

  public void move(int direction){
    xpos += direction;
  }


  private int getLowestRow(){
    for(int i = shape.length - 1; i > 0; i--){
      for(int j = 0; j < shape.length; j++){
        if(shape[i][j] == 1){
          return i;
        }
      }
    }
    return 0;
  }

  public void initialize(){

  }

  public void update(){

  }

  public void click(){

  }

  public void render(){

  }

}