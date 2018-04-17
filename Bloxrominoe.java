import java.util.Random;


public class Bloxrominoe implements GameObject{

  int xpos;
  int ypos;

  private boolean done = false;
  private int timeStopped = 0;
  private int[][] shape = new int[4][4];

  private static final int[][] SSchematic = {
    {0, 0, 0, 0},
    {0, 0, 1, 1},
    {0, 0, 1, 0},
    {0, 1, 1, 0}
  };

  private static final int[][] ZSchematic = {
    {0, 0, 0, 0},
    {0, 1, 1, 0},
    {0, 0, 1, 0},
    {0, 0, 1, 1}
  };

  private static final int[][] TSchematic = {
    {0, 0, 0, 0},
    {0, 0, 0, 0},
    {0, 0, 1, 0},
    {0, 1, 1, 1}
  };

  private static final int[][] LineSchematic = {
    {0, 0, 0, 1},
    {0, 0, 0, 1},
    {0, 0, 0, 1},
    {0, 0, 0, 1}
  };


  private static final int[][] MirroredLSchematic = {
    {0, 0, 1, 0},
    {0, 0, 1, 0},
    {0, 0, 1, 0},
    {0, 0, 1, 1}
  };

  private static final int[][] LSchematic = {
    {0, 0, 0, 1},
    {0, 0, 0, 1},
    {0, 0, 0, 1},
    {0, 0, 1, 1}
  };

  private static final int[][] SquareSchematic = {
    {0, 0, 0, 0},
    {0, 0, 0, 0},
    {0, 1, 1, 0},
    {0, 1, 1, 0}
  };


  public final Bloxrominoe S_SHAPE = new Bloxrominoe(SSchematic);
  public final Bloxrominoe Z_SHAPE = new Bloxrominoe(ZSchematic);
  public final Bloxrominoe T_SHAPE = new Bloxrominoe(TSchematic);
  public final Bloxrominoe LINE_SHAPE = new Bloxrominoe(LineSchematic);
  public final Bloxrominoe L_SHAPE = new Bloxrominoe(LSchematic);
  public final Bloxrominoe MIRRORED_L_SHAPE = new Bloxrominoe(MirroredLSchematic);
  public final Bloxrominoe SQUARE_SHAPE = new Bloxrominoe(SquareSchematic);

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

    public static Shape random(){
      Random r = new Random();
      return this(random.nextInt(7));
    }
  }

  public Bloxrominoe(int index, int xpos, int ypos){

  }

  private Bloxrominoe(int[][] shape){
    this.shape = shape;
  }



  private void moveDown(int[][] grid){
    // Check if can moveDown
    // Yes -> Move moveDown
    // No -> start timer
    // if Timer exceeds time
    // Stop
  }

  private void move(int direction){

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
