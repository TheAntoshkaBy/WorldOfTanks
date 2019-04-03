package sample.Game.MotionObjects.Motions.ConcreteMontions;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.Animation.SpriteAnimation;
import sample.Game.Displays.GameDisplays.MainGame;
import sample.Game.Displays.WaitClickDisplays;
import sample.Game.MotionObjects.Motions.ConcreteMontions.Bullet;
import sample.Game.MotionObjects.Motions.MotionObject;
import sample.Game.MotionObjects.Tank;

public class MotionTank extends MotionObject implements Tank {

    ImageView tankView;
    private long timerStart;
    private long timerFinish;
    private long timerDuration;

    public MotionTank(double x, double y, String handle)
    {
        super(handle);
        this.columns = 3;
        this.count = 3;
        this.offsetX = 0;
        this.offsetY = 0;
        this.width = 87;
        this.height = 87;
        this.setTranslateX(x);
        this.setTranslateY(y);
        timerFinish = 0;
        timerStart = 0;
        timerDuration = 500;
        setTankOnScreen();
    }

    public boolean timer()
    {
        if(timerStart == 0)
        {
            timerStart = System.currentTimeMillis();
            timerFinish = timerStart+timerDuration;
            return true;
        }else if(timerFinish <= System.currentTimeMillis())
        {
            timerStart = 0;
            return true;
        }else
            return false;

    }

    public void setTankOnScreen()
    {
        tankView = new ImageView(new Image(getClass().getResourceAsStream("../../../../Images/2.3.7.png")));
        tankView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(tankView, Duration.millis(500),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(tankView);// Добавляем объект на экран благодаря наследованию от Pane
        MainGame.getGameRoot().getChildren().add(this);
    }

    public void collisionReaction(){

    }

    //Прописываем направление картинки/движимого объекта если дело касается танка
    @Override
    public void objectAnimation()
    {
        switch (meaning){
            case "Up":
                this.animation.setOffsetY(261);
                break;
            case "Down":
                this.animation.setOffsetY(0);
                break;
            case "Left":
                this.animation.setOffsetY(174);
                break;
            case "Right":
                this.animation.setOffsetY(87);
                break;

        }
    }

    @Override
    public void fire() {
        if(timer())
            WaitClickDisplays.bullets.add(new Bullet(getTranslateX(),getTranslateY(),getMeaning()));
            //создаем снаряд на карте, добавляем его в список движимых снарядов.

    }
}
