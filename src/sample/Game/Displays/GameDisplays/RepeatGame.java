package sample.Game.Displays.GameDisplays;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Game.Displays.Display;
import sample.Game.Displays.WaitClickDisplays;
import sample.Game.MotionObjects.MotionTank;


import java.io.DataInputStream;
import java.io.IOException;

public class RepeatGame extends Display {

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
        MotionTank bossTank = new MotionTank(100,100, "UP");
        appRoot.getChildren().add(bossTank);
    }

    private RepeatGame(int level) throws IOException {
        super(level);
        initContent(level);
    }
}
