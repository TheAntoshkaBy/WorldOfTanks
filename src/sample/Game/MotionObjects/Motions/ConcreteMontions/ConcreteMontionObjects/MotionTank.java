package sample.Game.MotionObjects.Motions.ConcreteMontions.ConcreteMontionObjects;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.Animation.SpriteAnimation;
import sample.Game.Displays.GameDisplays.MainGame;
import sample.Game.Displays.WaitClickDisplays;
import sample.Game.MotionObjects.Motions.ConcreteMontions.Tank;
import sample.Game.MotionObjects.Motions.MotionObject;
import sample.Game.MotionObjects.TankI;

public class MotionTank extends Tank implements TankI {

    public MotionTank(double x, double y, String handle)
    {
        super(x, y, handle);
        setTankOnScreen();
    }


    public void setTankOnScreen()
    {
        tankView = new ImageView(new Image(getClass().getResourceAsStream("../../../../../Images/2.3.7.png")));
        tankView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(tankView, Duration.millis(500),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(tankView);// Добавляем объект на экран благодаря наследованию от Pane
        MainGame.getGameRoot().getChildren().add(this);
    }

    public void collisionReaction(){

    }



    @Override
    protected boolean ifActionCollision(boolean XY,boolean side)
    {
        return false;
    }


}
