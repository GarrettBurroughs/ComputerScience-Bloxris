public class quitButton extends Button
{
  public quitButton(int x, int y, String text)
  {
    super( x,  y,  text );
  }
  public void click()
  {
    if(mouseX<=x+boxWidth/2 && mouseX>=x-boxWidth/2 && mouseY<=y+boxHeight/2 && mouseY>=y-boxHeight/2)
    {
        exit();
    }
  }
}
