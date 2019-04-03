package sample.Game.MotionObjects.Motions.ConcreteMontions;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.Animation.SpriteAnimation;
import sample.Game.Displays.Display;
import sample.Game.Displays.GameDisplays.MainGame;

import java.util.Date;

public class BotTank extends MotionTank {

    boolean ifCollision;

    public BotTank(double x, double y, String handle) {
        super(x, y, handle);
        ifCollision = false;
        this.setMeaning("left");
    }

    public void goAlgorithm()
    {
        if(!ifCollision)
        {
            this.setMeaning("Down");
            moveY(Display.speed);
        }
        else
        {
            this.setMeaning("Up");
            moveY(-Display.speed);
        }
    }

    @Override
    public void setTankOnScreen()
    {
        tankView = new ImageView(new Image(getClass().getResourceAsStream("../../../../Images/2.3.6.png")));
        tankView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(tankView, Duration.millis(500),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(tankView);// Добавляем объект на экран благодаря наследованию от Pane
        MainGame.getGameRoot().getChildren().add(this);
    }

    @Override
    public void collisionReaction() {
        super.collisionReaction();
        if(ifCollision)
            ifCollision = false;
                    else
                        ifCollision =true;

    }
}