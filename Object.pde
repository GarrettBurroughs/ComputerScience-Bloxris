/**
  * The object interface outlines the basic activity of an object in the bloxris game,
  * All objects have to be rendered to show up on screen in the </code>draw<code>
  */
interface Object{
  public double x = 0, y = 0;
  public void initialize();
  public void update();
  public void render();
}