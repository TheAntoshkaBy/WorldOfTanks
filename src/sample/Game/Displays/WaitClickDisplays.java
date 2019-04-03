package sample.Game.Displays;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import sample.Game.MotionObjects.Motions.ConcreteMontions.Bullet;

import java.io.IOException;
import java.util.ArrayList;

abstract public class WaitClickDisplays extends Display{

    public static ArrayList<Bullet> bullets;

    protected WaitClickDisplays(int level) throws IOException {
        super(level);
        bullets = new ArrayList<>();
    }

    public void update() throws IOException {

        for(int i = 0;  i< bullets.size();i++)
            bullets.get(i).Go();


        if (isPressed(KeyCode.UP)) {
            /*
             * 1. Добавляем в список нажатую клавишу
             * 2. Заносим номер итерации в список чисел
             *
             * */
            motionTank.setMeaning("Up");
            motionTank.moveY(-speed);
            if (isPressed(KeyCode.SPACE))
            {
                motionTank.fire();
            }
            //sideOfTank = "UP";

        } else if (isPressed(KeyCode.DOWN)) {
            motionTank.setMeaning("Down");
            motionTank.moveY(speed);
            if (isPressed(KeyCode.SPACE))
            {
                motionTank.fire();
            }

        } else if (isPressed(KeyCode.RIGHT)) {
            motionTank.setMeaning("Right");
            motionTank.moveX(speed);
            if (isPressed(KeyCode.SPACE))
            {
                motionTank.fire();
            }
            //sideOfTank = "RIGHT";

        } else if (isPressed(KeyCode.LEFT)) {
            motionTank.setMeaning("Left");
            motionTank.moveX(-speed);
            if (isPressed(KeyCode.SPACE))
            {
                motionTank.fire();
            }
            //sideOfTank = "LEFT";

        } else if (isPressed(KeyCode.SPACE)) {
            motionTank.fire();
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
