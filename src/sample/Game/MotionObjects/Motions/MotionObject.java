package sample.Game.MotionObjects.Motions;

import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import sample.Animation.SpriteAnimation;
import sample.Game.Displays.Display;
import sample.Game.MotionObjects.MotionObjects;

public class MotionObject extends Pane implements MotionObjects
{
    protected int columns;//кол-во столбцов в спрайтовой картинке
    protected int count;//количество картинок
    protected int offsetX;//смещение по картике
    protected int offsetY;
    protected int width;//ширина картинки
    protected int height;//длинна картинки
    protected final int widthScreen;
    protected final int heightScreen;
    protected int lifes;
    protected boolean ifLife;
    protected String meaning;
    protected String side;

    public SpriteAnimation animation;

    public MotionObject(String handle)
    {
        this.columns = 4;
        this.count = 3;
        this.offsetX = 0;
        this.offsetY = 0;
        this.width = 40;
        this.height = 40;
        this.widthScreen = 1470;
        this.heightScreen = 765;
        this.lifes = 3;
        this.ifLife = true;
        this.meaning = handle;

    }

    public void moveX(int x)
    {
        this.animation.play();
        boolean movingRight = x>0;
        for(int i = 0;i<Math.abs(x);i++) {
            for(Node platform : Display.blocks) {
                if((this.getBoundsInParent().intersects(platform.getBoundsInParent()))) {
                    if (!movingRight) {
                        collisionReaction();
                        this.setTranslateX(this.getTranslateX() + 1);//отталкивает нас от стены
                        this.animation.stop();
                        return;
                    } else {
                        collisionReaction();
                        this.setTranslateX(this.getTranslateX() - 1);
                        this.animation.stop();
                        return;
                    }
                }
            }
            objectAnimation();
            this.setTranslateX(this.getTranslateX() + (movingRight ? 1 : -1));
        }
    }


    public void moveY(int y)
    {
        this.animation.play();
        boolean movingDown = y > 0;
        for (int i = 0; i < Math.abs(y); i++) {
            for (Node platform : Display.blocks) {
                if ((this.getBoundsInParent().intersects(platform.getBoundsInParent()))) {
                    if (!movingDown) {
                        this.setTranslateY(this.getTranslateY() + 1);
                        collisionReaction();
                        this.animation.stop();
                        return;
                    } else {
                        collisionReaction();
                        this.setTranslateY(this.getTranslateY() - 1);
                        this.animation.stop();
                        return;
                    }
                }
            }
            objectAnimation();
            this.setTranslateY(this.getTranslateY() + (movingDown ? 1 : -1));
        }
    }

    @Override
    public void setElementInDisplay(int x, int y) {
        this.setTranslateX(x);
        this.setTranslateY(y);
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning)
    {
        this.meaning = meaning;
    }

    public void collisionReaction()
    {

    }

    public void objectAnimation()
    {}
}
