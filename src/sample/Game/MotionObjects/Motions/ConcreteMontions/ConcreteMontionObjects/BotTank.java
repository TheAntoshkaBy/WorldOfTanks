package sample.Game.MotionObjects.Motions.ConcreteMontions.ConcreteMontionObjects;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.Animation.SpriteAnimation;
import sample.Game.Displays.Display;
import sample.Game.Displays.GameDisplays.MainGame;
import sample.Game.MotionObjects.Motions.ConcreteMontions.Tank;

public class BotTank extends Tank {

    boolean ifUpper;
    boolean ifRighter;
    String nextStep;

    public BotTank(double x, double y, String handle) {
        super(x,y,handle);
        ifUpper = false;
        ifRighter = false;
        this.setMeaning("Down");
        setTankOnScreen();
        life = 1;
        nextStep = "Down";
    }

    public void goAlgorithm()
    {
        System.out.println(nextStep + "  " +meaning);
        switch (nextStep)
        {
            case"Down": {
            moveY(Display.speed);
            this.meaning = "Down";
            }break;

            case "Up":
            {
                moveY(-Display.speed);
                this.meaning = "Up";
            }break;

            case "Right":

            {
                moveX(Display.speed);
                this.meaning = "Right";
            }break;

            case "Left":
            {
                moveX(-Display.speed);
                this.meaning = "Left";
            }break;
        }
        setDuration(700);
        fire();

    }


    public void setTankOnScreen()
    {
        tankView = new ImageView(new Image(getClass().getResourceAsStream("../../../../../Images/2.3.6.png")));
        tankView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(tankView, Duration.millis(500),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(tankView);// Добавляем объект на экран благодаря наследованию от Pane
        MainGame.getGameRoot().getChildren().add(this);
    }

//определяем движение танка
    @Override
    public void collisionReaction() {
        super.collisionReaction();
        System.out.println("Collision!!!");
        switch (meaning)
        {
            case"Down":
                nextStep = "Up";
                break;

            case "Up":
                nextStep = "Right";
                break;

            case "Right":
                nextStep = "Left";
                break;

            case "Left":
                nextStep = "Down";
                break;
        }
    }
}
