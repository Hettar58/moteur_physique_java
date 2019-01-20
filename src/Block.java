import javax.swing.*;
import java.awt.Image;

public class Block extends Sprite{
    public Block(int x, int y){
        super(x, y);
        loadImage("src/res/block.png");
        getImageDimensions();
        System.out.println("created block x="+x+" y="+y);
        System.out.println(this.getWidth());
        System.out.println(this.getHeight());
    }
}
