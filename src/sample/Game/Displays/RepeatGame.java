package sample.Game.Displays;

import java.io.IOException;

public class RepeatGame extends ParentGameDisplay {

    private static RepeatGame repeatGame;

    public static synchronized RepeatGame getObject(int level) {

        if(repeatGame == null)
        {
            try {
                repeatGame = new RepeatGame(level);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return repeatGame;
    }

    private RepeatGame(int level) throws IOException {
        super(level);
        initContent(level);
    }
}
