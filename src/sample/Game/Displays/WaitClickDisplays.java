package sample.Game.Displays;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import sample.Game.MotionObjects.Bullet;

import java.io.IOException;

abstract public class WaitClickDisplays extends Display{

    protected WaitClickDisplays(int level) throws IOException {
        super(level);
    }

    public void update() throws IOException {


        if (isPressed(KeyCode.UP)) {
            /*
             * 1. Добавляем в список нажатую клавишу
             * 2. Заносим номер итерации в список чисел
             *
             * */
            motionTank.animation.play();
            motionTank.animation.setOffsetY(261);
            motionTank.moveY(-speed);
            //sideOfTank = "UP";

        } else if (isPressed(KeyCode.DOWN)) {
            motionTank.animation.play();
            motionTank.animation.setOffsetY(0);
            motionTank.moveY(speed);

        } else if (isPressed(KeyCode.RIGHT)) {
            motionTank.animation.play();
            motionTank.animation.setOffsetY(87);
            motionTank.moveX(speed);
            //sideOfTank = "RIGHT";

        } else if (isPressed(KeyCode.LEFT)) {
            motionTank.animation.play();
            motionTank.animation.setOffsetY(174);
            motionTank.moveX(-speed);
            //sideOfTank = "LEFT";

        } else if (isPressed(KeyCode.SPACE)) {
            Bullet bullet = new Bullet(motionTank.getTranslateX(),motionTank.getTranslateY(),motionTank.getMeaning());
        } else if (isPressed(KeyCode.ESCAPE)){
            timer.stop();
            mainStage.close();
            menuStage.show();
        }else {
            motionTank.animation.stop();
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
