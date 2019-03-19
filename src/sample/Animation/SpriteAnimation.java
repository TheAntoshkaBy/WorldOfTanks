package sample.Animation;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation extends Transition{


    private final ImageView imageView; //Наша картинка
    private final int count; //количество кадров
    private final int columns; // количество столбцов
    private  int offsetX; //смещение в кадре по оси Х
    private  int offsetY; //
    private final int width; // Размер нашего кадра
    private final int height; // рахмер

    /**
     *  Конструктор + параметр duration, отвечает за продолжительность нашей анимации.
     **/
    public SpriteAnimation(ImageView imageView, Duration duration, int count, int columns, int offsetX, int offsetY, int width, int height)
    {

        this.imageView = imageView;
        this.count = count;
        this.offsetX  = offsetX;
        this.offsetY = offsetY;
        this.height = height;
        this.width = width;
        this.columns = columns;

        setCycleDuration(duration);
        setCycleCount(Animation.INDEFINITE);
        setInterpolator(Interpolator.LINEAR);
        this.imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));


    }

    public void setOffsetX(int x){

        this.offsetX = x;

    }

    public void setOffsetY(int y) {

        this.offsetY = y;

    }

    /** Вызывается в каждом кажое анимации пока она действует
     * определяет поведение операции.
     * @param k принимает значения от 0 до 1
     * 0 - начало анимации
     * 1 - конец анимации
     */
    protected void interpolate(double k)
    {

        final int index = Math.min((int)Math.floor(k*count),count - 1);//Выбираем к какой картигке обратимся mathfloor округляет наше число
        final int x = (index % columns) * width + offsetX;
        final int y = (index / columns) * height + offsetY;

        imageView.setViewport(new Rectangle2D(x,y,width,height));
    }
}
