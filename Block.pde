class Block implements GameObject{

  int blockDimensions = 10;
  int x;
  int y;
  
  @Override
  public void initialize(){
      x = height/2;
      y = width/2;
  }

  @Override
  public void update(){

  }

  @Override
  public void render(){
    rectMode(CENTER);
    rect(x, y, blockDimensions, blockDimensions);
  }
}
