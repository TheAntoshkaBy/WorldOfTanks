package sample.Game.InitContent;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sample.Game.Displays.Display;

public class InitBlocks extends Pane {

    Image blockImg;
    ImageView block;
    public static double blockSize;

    public enum BlockType{
        PLATFORM,BRICK
    }
    public InitBlocks(BlockType blockType,int x, int y)
    {
        blockImg = new Image(getClass().getResourceAsStream("../../Images/Wall.png"));
        block = new ImageView(blockImg);
        block.setFitWidth(55);
        block.setFitHeight(55);
        blockSize = 55;
        setTranslateX(x);
        setTranslateY(y);

        switch (blockType)
        {
            case PLATFORM:
                block.setViewport(new Rectangle2D(0,0,55,55));
                break;

            case BRICK:
                block.setViewport(new Rectangle2D(0,0,0,0));
        }

        getChildren().add(block);
        Display.blocks.add(this);
        //ParentGameDisplay.gameRoot.getChildren().add(this);
//        getChildren().add(block);
    }

}
