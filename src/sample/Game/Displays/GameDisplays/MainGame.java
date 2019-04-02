package sample.Game.Displays.GameDisplays;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sample.Game.Displays.WaitClickDisplays;
import sample.Game.MotionObjects.Bullet;
import sample.Game.MotionObjects.MotionTank;

import java.io.IOException;

public class MainGame extends WaitClickDisplays {

    private static MainGame mainGame;
    Bullet bullet;

    public static Pane getGameRoot()
    {
        return gameRoot;
    }

    protected MainGame(int level) throws IOException {
        super(level);
        motionTank = new MotionTank(900, 940, "UP");
        speed = 10;
        initContent(level);

    }

    public static synchronized MainGame getObject(int level) {

        if (mainGame == null) {
            try {
                mainGame = new MainGame(level);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mainGame;
    }

    public static synchronized MainGame getNewObject(int level) {

            try {
                mainGame = new MainGame(level);
            } catch (IOException e) {
                e.printStackTrace();
            }

        return mainGame;
    }

    @Override
    protected void initContent(int level) {
        super.initContent(level);
        appRoot.getChildren().addAll(motionTank);
    }



}