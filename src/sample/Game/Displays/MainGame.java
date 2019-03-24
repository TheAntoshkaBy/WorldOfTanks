package sample.Game.Displays;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import sample.Game.MotionObjects.Element;

import java.io.IOException;

public class MainGame extends FatherMainAndMultipleDisplays {

    private static MainGame mainGame;

    protected MainGame(int level) throws IOException {
        super(level);
        element = new Element(new ImageView(new Image(getClass().getResourceAsStream("../../Images/2.3.7.png"))), 900, 940, "UP");
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

        appRoot.getChildren().add(element);
    }



}