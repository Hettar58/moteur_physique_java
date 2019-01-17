public class Floor extends Sprite{
    public Floor(int x, int y){
        super(x, y);
        this.x = x;
        this.y = y;
        loadImage("src/res/floor.png");
        getImageDimensions();
        System.out.println("created floor x=0 y=570");
    }
}
