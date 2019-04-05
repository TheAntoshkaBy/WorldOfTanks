package sample.Game.MotionObjects.Motions.ConcreteMontions.ConcreteMontionObjects;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.Animation.SpriteAnimation;
import sample.Game.Displays.Display;
import sample.Game.Displays.WaitClickDisplays;
import sample.Game.MotionObjects.Motions.MotionObject;

public class Bullet extends MotionObject
{
    final ImageView bulletView;

    public Bullet(double x, double y, String handle) {
        super(x,y,handle);
        switch (meaning)
        {
            case "Left":
            {
                this.setTranslateX(x - 60);
                this.setTranslateY(y+17);
                offsetX = 120;
            }break;
            case "Right":
            {
                this.setTranslateX(x + 100);
                this.setTranslateY(y + 23);
                offsetX = 0;
            }break;
            case "Up":
            {
                this.setTranslateX(x + 23);
                this.setTranslateY(y - 50);
                offsetX = 80;
            }break;
            case "Down":
            {
                this.setTranslateX(x + 23);
                this.setTranslateY(y + 100);
                offsetX = 40;
            }
        }
        bulletView = new ImageView(new Image(getClass().getResourceAsStream("../../../../../Images/bullet2.png")));
        bulletView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(bulletView, Duration.millis(500),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(bulletView);
        Display.appRoot.getChildren().add(this);
    }

    public void Go()
    {
        switch (meaning) {
            case "Up":
                moveY(-20);
                break;
            case "Down":
                moveY(20);
                break;
            case "Left":
                moveX(-20);
                break;
            case "Right":
                moveX(20);
                break;

        }

    }

    public void collisionReaction()
    {
        Display.appRoot.getChildren().remove(this);
        WaitClickDisplays.bullets.remove(this);
    }




    @Override
    public void objectAnimation()
    {
        this.animation.stop();
    }
}
