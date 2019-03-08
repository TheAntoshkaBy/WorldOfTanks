package sample.Game.Displays;

import java.io.IOException;

public class MainGame extends ParentGameDisplay {

    private static MainGame mainGame;

    public static synchronized MainGame getObject(int level) {

        if(mainGame == null)
        {
            try {
                mainGame = new MainGame(level);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mainGame;
    }

    private MainGame(int level) throws IOException {
        super(level);
        initContent(level);
    }
}
