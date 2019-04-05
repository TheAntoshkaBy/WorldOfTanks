package sample.Game.Displays.GameDisplays;

import sample.Game.Displays.WaitClickDisplays;
import sample.Game.MotionObjects.Motions.ConcreteMontions.ConcreteMontionObjects.MotionTank;

import java.io.IOException;

    public class MultipleGame extends WaitClickDisplays {

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
            appRoot.getChildren().add(motionTank);
        }

        private MultipleGame(int level) throws IOException {
        super(level);
        motionTank = new MotionTank(900,100, "UP");
        speed = 10;
        initContent(level);
    }
}
