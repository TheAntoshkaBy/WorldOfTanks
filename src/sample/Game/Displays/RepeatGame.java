package sample.Game.Displays;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Game.MotionObjects.Element;

import java.io.IOException;

public class RepeatGame extends ParentGameDisplay {

    private static RepeatGame repeatGame;

    public static synchronized RepeatGame getObject(int level) {

        if(repeatGame == null)
        {
            try {
                repeatGame = new RepeatGame(level);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return repeatGame;
    }

    @Override
    protected void initContent(int level)
    {
        super.initContent(level);
        Element bossTank = new Element(new ImageView(new Image(getClass().getResourceAsStream("../../Images/2.3.7.png"))),100,100, "UP");
        appRoot.getChildren().add(bossTank);
    }

    private RepeatGame(int level) throws IOException {
        super(level);
        initContent(level);
    }
}
