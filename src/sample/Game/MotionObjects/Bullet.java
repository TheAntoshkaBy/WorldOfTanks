package sample.Game.MotionObjects;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.Animation.SpriteAnimation;
import sample.Game.Displays.Display;

public class Bullet extends MotionObject
{
    final ImageView bulletView;

    public Bullet(double x, double y, String handle) {
        super( x, y, handle);
        bulletView = new ImageView(new Image(getClass().getResourceAsStream("../../Images/bullet.png")));
        bulletView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(bulletView, Duration.millis(500),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(bulletView);
        Display.appRoot.getChildren().add(this);
        System.out.println("New bullet!");
    }

}
