package sample.Game.MotionObjects;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import sample.Animation.SpriteAnimation;

public class MotionObject extends Pane implements MotionObjects
{
    protected final int columns;//кол-во столбцов в спрайтовой картинке
    protected final int count;//количество картинок
    protected final int offsetX;//смещение по картике
    protected final int offsetY;
    protected int width;//ширина картинки
    protected int height;//длинна картинки
    protected final int widthScreen;
    protected final int heightScreen;
    protected int lifes;
    protected boolean ifLife;
    String meaning;
    protected String side;

    public SpriteAnimation animation;

    public MotionObject(double x, double y, String handle)
    {
        this.columns = 3;
        this.count = 3;
        this.offsetX = 0;
        this.offsetY = 0;
        this.width = 87;
        this.height = 87;
        this.widthScreen = 1470;
        this.heightScreen = 765;
        this.lifes = 3;
        this.ifLife = true;
        this.setTranslateX(x);
        this.setTranslateY(y);
        this.meaning = handle;

    }

    public void moveX(int x)
    {
        int pogreshnost = 10;
        boolean movingRight = x>0;
        for(int i = 0;i<Math.abs(x);i++) {
            if (!movingRight) {
                this.setTranslateX(this.getTranslateX() - 1);
                meaning = "Left";
            } else {

                this.setTranslateX(this.getTranslateX() + 1);
                meaning = "Right";
            }

        }
        /**End check of element*/
        this.setTranslateX(this.getTranslateX() + (movingRight ? 1 : -1));
    }


    public void moveY(int y)
    {
        int greh = 10;
        boolean movingDown = y > 0;
        for (int i = 0; i < Math.abs(y); i++) {

            if (!movingDown) {
                this.setTranslateY(this.getTranslateY() - 1);
                meaning = "Up";
            }
            else
            {
                this.setTranslateY(this.getTranslateY() + 1);
                meaning = "Down";
            }
        }
        this.setTranslateY(this.getTranslateY() + (movingDown ? 1 : -1));
    }

    @Override
    public void setElementInDisplay(int x, int y) {
        this.setTranslateX(x);
        this.setTranslateY(y);
    }

    public String getMeaning() {
        return meaning;
    }
}
