public class TestScreen extends Screen{

  public TestScreen(){
    for(int i = 0; i < 10; i++){
      println(i);
      addObject(new Block(i * 10, i * 10));
    }
  }


  @Override
  public void screenUpdate(){

  }

  @Override
  public void display(){

  }

  @Override
  public int isDone(){
    return -1;
  }
  @Override
  public void pressed(char c){

  }
}
