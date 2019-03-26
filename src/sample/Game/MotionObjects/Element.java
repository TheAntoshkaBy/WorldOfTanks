package sample.Game.MotionObjects;

import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import sample.Animation.SpriteAnimation;

public class Element extends Pane implements MotionObjects {

    protected final int columns;//кол-во столбцов в спрайтовой картинке
    public final int count;//количество картинок
    public final int offsetX;//смещение по картике
    public final int offsetY;
    public int width;//ширина картинки
    public int height;//длинна картинки
    public final int widthScreen;
    public final int heightScreen;
    public int lifes;
    public boolean ifLife;
    String meaning;
    private String side;

    ImageView imageView;

    public SpriteAnimation animation;


    public Element(ImageView imageView,double x, double y, String handle)
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
        this.imageView = imageView;
        this.imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(imageView, Duration.millis(500),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(imageView);// Добавляем объект на экран благодаря наследованию от Pane
        this.setTranslateX(x);
        this.setTranslateY(y);
        this.meaning = handle;

    }

    public void moveX(int x, Element element)
    {
        int pogreshnost = 10;
        boolean movingRight = x>0;
        for(int i = 0;i<Math.abs(x);i++)
        {

            /**Check for Block's*/


            /**End Check Blocks*/
            /**Start check bots*/


            /**End check of Bots*/
            /**Start check Element*/
            if(this.getBoundsInParent().intersects(element.getBoundsInParent()))
            {
                if (movingRight) {

                    if(this.getTranslateX()+ element.width - pogreshnost == element.getTranslateX()){
                        this.setTranslateX(this.getTranslateX()- 1);
                        //  GameDisplay.gameRoot.getChildren().remove(this);
                        return;
                    }

                }else{
                    if(this.getTranslateX() + pogreshnost==element.getTranslateX()+element.width ){
                        this.setTranslateX(this.getTranslateX()+1);
                        return;
                    }
                }
            }
            /**End check of element*/
            this.setTranslateX(this.getTranslateX() + (movingRight ? 1 : -1));
        }
    }

    public void moveY(int y, Element element)
    {
        int greh = 10;
        boolean movingDown = y > 0;
        for (int i = 0; i < Math.abs(y); i++) {

            /**Start check platforms*/

            /**End of check platforms*/
            /**Start check bots*/


            /**End of check bots*/
            /**Start check Elements*/
            if (this.getBoundsInParent().intersects(element.getBoundsInParent()))
            {
                if (movingDown)
                {
                    if (this.getTranslateY() + element.width - greh == element.getTranslateY())
                    {
                        this.setTranslateY(this.getTranslateY() - 1);
                        return;
                    }
                }

                else
                {
                    if (this.getTranslateY() + greh == element.getTranslateY() +element.width)
                    {
                        this.setTranslateY(this.getTranslateY() + 1);
                        return;
                    }
                }
            }

            this.setTranslateY(this.getTranslateY() + (movingDown ? 1 : -1));
        }
    }

    @Override
    public void setElementInDisplay(int x, int y) {
        this.setTranslateX(x);
        this.setTranslateY(y);
    }
}
