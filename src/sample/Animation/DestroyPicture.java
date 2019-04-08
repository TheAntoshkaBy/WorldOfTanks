package sample.Animation;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import sample.Game.Displays.Display;

public class DestroyPicture extends Pane {

    protected long timerStart;
    protected long timerFinish;
    protected long timerDuration;
    protected int columns;//кол-во столбцов в спрайтовой картинке
    protected int count;//количество картинок
    protected int offsetX;//смещение по картике
    protected int offsetY;
    protected int width;//ширина картинки
    protected int height;//длинна картинки
    protected ImageView iView;
    Timer timer;

    public SpriteAnimation animation;

    public DestroyPicture(double PositionX, double PositionY)
    {
        this.columns = 8;
        this.count = 42;
        this.offsetX = 0;
        this.offsetY = 0;
        this.width = 125;
        this.height = 125;
        iView = new ImageView(new Image(getClass().getResourceAsStream("../Images/Destroy2.png")));
        iView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        iView.setTranslateX(PositionX);
        iView.setTranslateY(PositionY);
        animation = new SpriteAnimation(iView, Duration.millis(500),count,columns,offsetX,offsetY,width,height);
        Display.appRoot.getChildren().addAll(iView);// Добавляем объект на экран благодаря наследованию от Pane
        animation.play();
        timer = new Timer(400);
        timer.isTime();
    }

    public Timer getTimer() {
        return timer;
    }

    public void remove()
    {
        Display.appRoot.getChildren().remove(this.iView);
        Display.destroys.remove(this);
    }
}
