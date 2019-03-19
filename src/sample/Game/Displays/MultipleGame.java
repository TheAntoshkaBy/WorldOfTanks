package sample.Game.Displays;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Game.MotionObjects.Element;

import java.io.IOException;

    public class MultipleGame extends ParentGameDisplay {

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
            Element bossTank = new Element(new ImageView(new Image(getClass().getResourceAsStream("../../Images/2.3.7.png"))),900,100, "UP");
            appRoot.getChildren().add(bossTank);
        }


        private MultipleGame(int level) throws IOException {
        super(level);
        initContent(level);
    }
}
