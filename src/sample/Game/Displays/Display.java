package sample.Game.Displays;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import sample.Controllers.MenuController;
import sample.Game.InitContent.InitBlocks;
import sample.Game.LevelContent.Level;
import sample.Game.MotionObjects.Bullet;
import sample.Game.MotionObjects.MotionTank;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


abstract public class Display extends Application
{
    /**Реализация паттерна Singleton*/
    private static Display parentGameDisplay;

    /**Переменные работающие с нашим отображением*/
    public static Pane appRoot;
    public static Pane gameRoot;

    public FXMLLoader loader;

    protected final int width;
    protected final int  height;

    protected Scene scene;

    protected Image backGroundImg;

    protected AnimationTimer timer;

    protected MotionTank motionTank;
    protected ArrayList<Bullet> bullets = new ArrayList<>();

    protected int speed;

    protected Stage menuStage;
    protected Stage mainStage;


    /**Переменные работающая с контекстом игры*/
    final int blockSize;

    /** Управляющие списки.*/
    private HashMap<KeyCode,Boolean> keys = new java.util.HashMap<>();

    protected boolean isPressed(KeyCode key)
    {
        return keys.getOrDefault(key,false);
    }
    //метод предоставляющий доступ к нашему объекту.

    protected Display(int level) throws IOException {
        //Установка основной сцены
        this.width = 1920;
        this.height = 1045;
        this.menuStage = MenuController.getStage();
        this.loader = new FXMLLoader(getClass().getResource("../../../FXMLs/PlayScreen.fxml"));
        appRoot = new Pane();
        appRoot = (Pane) loader.load();
        gameRoot = new Pane();
        scene = new Scene(appRoot,width,height);
        this.blockSize = 55;
        backGroundImg = new Image(getClass().getResourceAsStream("../../../Images/back.png"));

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
        /**When key click */
        scene.setOnKeyPressed(event -> keys.put(event.getCode(),true));
        this.mainStage = stage;
        /**When key released*/
        scene.setOnKeyReleased(event -> keys.put(event.getCode(),false));
        //отображение
        this.mainStage.setTitle("World Of Tanks");
        this.mainStage.getIcons().add(new Image(getClass().getResourceAsStream("../../../Images/WoT.png")));
        this.mainStage.setScene(scene);
        this.mainStage.show();
    }

}
