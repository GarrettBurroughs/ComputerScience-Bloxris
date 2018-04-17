public class Bloxrominoe implements GameObject{

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
    {0, 0, 0, 0},
    {0, 0, 0, 0},
    {0, 0, 0, 0}
  };

  private static final int[][] TSchematic = {
    {0, 0, 0, 0},
    {0, 0, 0, 0},
    {0, 0, 0, 0},
    {0, 0, 0, 0}
  };

  private static final int[][] LineSchematic = {
    {0, 0, 0, 0},
    {0, 0, 0, 0},
    {0, 0, 0, 0},
    {0, 0, 0, 0}
  };

  private static final int[][] MirroredLSchematic = {
    {0, 0, 0, 0},
    {0, 0, 0, 0},
    {0, 0, 0, 0},
    {0, 0, 0, 0}
  };

  private static final int[][] SquareSchematic = {
    {0, 0, 0, 0},
    {0, 0, 0, 0},
    {0, 0, 0, 0},
    {0, 0, 0, 0}
  };


  public static Bloxrominoe SShape = new Bloxrominoe(SSchematic);
  public static Bloxrominoe ZShape = new Bloxrominoe(ZSchematic);
  public static Bloxrominoe TShape = new Bloxrominoe(TSchematic);
  public static Bloxrominoe LineShape = new Bloxrominoe(LineSchematic);
  public static Bloxrominoe MirroredLShape = new Bloxrominoe(MirroredLSchematic);
  public static Bloxrominoe SquareShape = new Bloxrominoe(SquareSchematic);


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
