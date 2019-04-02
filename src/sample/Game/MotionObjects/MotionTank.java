package sample.Game.MotionObjects;

import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import sample.Animation.SpriteAnimation;
import sample.Game.Displays.GameDisplays.MainGame;

public class MotionTank extends MotionObject implements Tank {

    ImageView tankView;
    public MotionTank(double x, double y, String handle)
    {
        super(x,y,handle);
        tankView = new ImageView(new Image(getClass().getResourceAsStream("../../Images/2.3.7.png")));
        tankView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(tankView, Duration.millis(500),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(tankView);// Добавляем объект на экран благодаря наследованию от Pane
        MainGame.getGameRoot().getChildren().add(this);
    }


    @Override
    public void fire() {

    }
}
