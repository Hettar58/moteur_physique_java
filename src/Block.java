import java.awt.Image;

public class Block extends Sprite{
    public Block(int x, int y){
        super(x, y);
        loadImage("src/res/block.png");
        image.getScaledInstance(50, 50, Image.SCALE_FAST);
        getImageDimensions();
        System.out.println("created block x="+x+" y="+y);
    }
}
