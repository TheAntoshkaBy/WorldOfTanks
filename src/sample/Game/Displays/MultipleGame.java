package sample.Game.Displays;

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
    private MultipleGame(int level) throws IOException {
        super(level);
        initContent(level);
    }
}
