package sample.Game.Displays;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import sample.Game.MotionObjects.Element;

import java.io.IOException;

public class MainGame extends ParentGameDisplay {

    AnimationTimer timer;
    private static MainGame mainGame;
    private Element element;
    private int speed;

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

    @Override
    protected void initContent(int level) {
        super.initContent(level);

        appRoot.getChildren().add(element);
    }

    public void update() throws IOException {

            if (isPressed(KeyCode.UP)) {
                /*
                 * 1. Добавляем в список нажатую клавишу
                 * 2. Заносим номер итерации в список чисел
                 *
                 * */
                element.animation.play();
                element.animation.setOffsetY(261);
                element.moveY(-speed,element);
                //sideOfTank = "UP";

            } else if (isPressed(KeyCode.DOWN)) {
                element.animation.play();
                element.animation.setOffsetY(0);
                element.moveY(speed,element);

            } else if (isPressed(KeyCode.RIGHT)) {
                element.animation.play();
                element.animation.setOffsetY(87);
                element.moveX(speed,element);
                //sideOfTank = "RIGHT";

            } else if (isPressed(KeyCode.LEFT)) {
                element.animation.play();
                element.animation.setOffsetY(174);
                element.moveX(-speed,element);
                //sideOfTank = "LEFT";

            } else if (isPressed(KeyCode.SPACE)) {

            } else {
                element.animation.stop();
            }

    }
    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);

        timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                try {
                    update();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        timer.start();

    }
}