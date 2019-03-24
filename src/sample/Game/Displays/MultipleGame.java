package sample.Game.Displays;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Game.MotionObjects.Element;

import java.io.IOException;

    public class MultipleGame extends FatherMainAndMultipleDisplays {

        private static MultipleGame multipleGame;

        public static synchronized MultipleGame getObject(int level) {

        if(multipleGame == null)
        {
            try {
                multipleGame = new MultipleGame(level);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return multipleGame;
    }

        @Override
        protected void initContent(int level)
        {
            super.initContent(level);
            appRoot.getChildren().add(element);
        }

        private MultipleGame(int level) throws IOException {
        super(level);
        element = new Element(new ImageView(new Image(getClass().getResourceAsStream("../../Images/2.3.7.png"))), 900,100, "UP");
        speed = 10;
        initContent(level);
    }
}
