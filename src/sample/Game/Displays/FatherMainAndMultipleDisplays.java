package sample.Game.Displays;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;

abstract public class FatherMainAndMultipleDisplays extends ParentGameDisplay{

    protected FatherMainAndMultipleDisplays(int level) throws IOException {
        super(level);
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
