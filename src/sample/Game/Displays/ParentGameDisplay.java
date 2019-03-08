package sample.Game.Displays;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import sample.Game.InitContent.InitBlocks;
import sample.Game.Level;

import java.io.IOException;


public class ParentGameDisplay extends Application
{
    /**Реализация паттерна Singleton*/
    private static ParentGameDisplay parentGameDisplay;

    //Переменные работающие с нашим отображением
    public Pane appRoot;
    public Pane gameRoot;
    public FXMLLoader loader;
    protected final int width;
    protected final int  height;
    protected Scene scene;
    protected Image backGroundImg;

    /**Переменные работающая с контекстом игры*/
    final int blockSize;

    //метод предоставляющий доступ к нашему объекту.
    public static synchronized ParentGameDisplay getObject(int level){

        if(parentGameDisplay == null)
        {
            try {
                parentGameDisplay = new ParentGameDisplay(level);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return parentGameDisplay;
    }

    protected ParentGameDisplay(int level) throws IOException {
        //Установка основной сцены
        this.width = 1920;
        this.height = 1045;
        this.loader = new FXMLLoader(getClass().getResource("../../FXMLs/PlayScreen.fxml"));
        appRoot = new Pane();
        appRoot = (Pane) loader.load();
        gameRoot = new Pane();
        scene = new Scene(appRoot,width,height);
        this.blockSize = 55;
        backGroundImg = new Image(getClass().getResourceAsStream("../../Images/back.png"));


    }

    /**
     * Функция отвечающая за добавление элементов на поле
     * 1. Добавляет фоновое изображение
     * 2. По уровню ссылается на конкретную отрисовку элементов на поле
     * 3. Тут же будут добавляться и наши танки
    */
    protected void initContent(int level)
    {
        ImageView backGround = new ImageView(backGroundImg);
        int levelNumber = level;

        backGround.setFitHeight(19 * blockSize);
        backGround.setFitWidth(36 * blockSize);

        for(int i = 0; i< Level.levels[levelNumber].length; i++){
            String line = Level.levels[levelNumber][i];
            for(int j= 0;j<line.length();j++){

                switch (line.charAt(j)){
                    case '0':
                        break;

                    case '1':
                        InitBlocks platform = new InitBlocks(InitBlocks.BlockType.PLATFORM,j*blockSize,i*blockSize);
                        gameRoot.getChildren().add(platform);
                        break;
                }
            }
        }

        appRoot.getChildren().addAll(backGround,gameRoot);
    }


    @Override
    public void start(Stage stage) throws Exception
    {


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            }
        };


        timer.start();

        //отображение
        stage.setTitle("World Of Tanks");
        //stage.getIcons().add(new Image(getClass().getResourceAsStream("../sample/Images/WoT.png")));
        stage.setScene(scene);
        stage.show();
    }

}
