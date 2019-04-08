package sample.Game.MotionObjects.Motions;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sample.Animation.SpriteAnimation;
import sample.Game.Displays.Display;
import sample.Game.Displays.WaitClickDisplays;
import sample.Game.InitContent.InitBlocks;
import sample.Game.MotionObjects.MotionObjects;
import sample.Game.MotionObjects.Motions.ConcreteMontions.ConcreteMontionObjects.BotTank;
import sample.Game.MotionObjects.Motions.ConcreteMontions.ConcreteMontionObjects.Bullet;
import sample.Game.MotionObjects.Motions.ConcreteMontions.ConcreteMontionObjects.MotionTank;
import sample.Game.MotionObjects.Motions.ConcreteMontions.Tank;

public abstract class MotionObject extends Pane implements MotionObjects
{
    protected int columns;//кол-во столбцов в спрайтовой картинке
    protected int count;//количество картинок
    protected int offsetX;//смещение по картике
    protected int offsetY;
    protected int width;//ширина картинки
    protected int height;//длинна картинки
    protected final int widthScreen;
    protected final int heightScreen;
    protected int life;
    protected boolean ifLife;
    protected String meaning;
    protected String side;
    protected ImageView tankView;

    public SpriteAnimation animation;

    public MotionObject(double x, double y, String handle)
    {
        this.columns = 4;
        this.count = 3;
        this.offsetX = 0;
        this.offsetY = 0;
        this.width = 40;
        this.height = 40;
        this.widthScreen = 1470;
        this.heightScreen = 765;
        this.life = 3;
        this.ifLife = true;
        this.meaning = handle;

    }

    public boolean isIfLife() {
        return ifLife;
    }

    public void moveX(int x)
    {
        this.animation.play();
        boolean movingRight = x>0;
        for(int i = 0;i<Math.abs(x);i++) {

            if(ifBlockCollision(false,movingRight) || ifTankCollision(false,movingRight) || ifActionCollision(false,movingRight) || ifBulletCollision(false,movingRight)) {
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

            objectAnimation();
            this.setTranslateX(this.getTranslateX() + (movingRight ? 1 : -1));
        }
    }


    public void moveY(int y)
    {
        this.animation.play();
        boolean movingDown = y > 0;
        for (int i = 0; i < Math.abs(y); i++) {

            if(ifBlockCollision(true,!movingDown) || ifTankCollision(true,!movingDown) || ifActionCollision(true,!movingDown) || ifBulletCollision(true,!movingDown)) {
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
            objectAnimation();
            this.setTranslateY(this.getTranslateY() + (movingDown ? 1 : -1));
        }
    }

    //Объект движимый всегда - Object, объект в который движемся - платформа
    protected double getObjectPosition(boolean XY, boolean side)
    {
        if (XY) {
            if(side)
            {
                return this.getTranslateY();
            }else{
               return this.getTranslateY() + this.width;
                }
        }else {
            if(side)
            {
                return this.getTranslateX() + this.width;
            }else
            {
                return this.getTranslateX();
            }

        }
    }
    protected double getPlatformPosition(boolean XY, boolean side, double sizeOfPlatform, Node platform)
    {
        if (XY) {
            if(side)
            {
                return platform.getTranslateY() + sizeOfPlatform;
            }else{
                return platform.getTranslateY();
            }
        }else {
            if(side)
            {
                return platform.getTranslateX();
            }else
            {
                return platform.getTranslateX() + sizeOfPlatform;
            }

        }
    }
    //if up == XY == true && side == true Down == XY == true && side == false Left == XY == false && side == false Right == XY == false && side == true
    protected boolean ifBlockCollision(boolean XY,boolean side)
    {
        double objectPosition = 0, platformPosition = 0;
        for (Node platform : Display.blocks) {
            objectPosition = getObjectPosition(XY,side);
            platformPosition = getPlatformPosition(XY,side,InitBlocks.blockSize,platform);
            if ((this.getBoundsInParent().intersects(platform.getBoundsInParent()))) {
                if(objectPosition == platformPosition) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean ifTankCollision(boolean XY,boolean side)
    {
        double objectPosition = 0, platformPosition = 0;
        for (Node platform : Display.tanks) {
            objectPosition = getObjectPosition(XY,side);
            platformPosition = getPlatformPosition(XY,side,87,platform);
            if ((this.getBoundsInParent().intersects(platform.getBoundsInParent()))) {
                if(objectPosition == platformPosition) {
                    if(this instanceof Bullet)
                    {
                        BotTank botTank = (BotTank) platform;
                        botTank.life--;
                        if(botTank.life<=0)
                            botTank.ifLife = false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean ifActionCollision(boolean XY,boolean side)
    {
        double objectPosition = 0, platformPosition = 0;
        objectPosition = getObjectPosition(XY,side);
        platformPosition = getPlatformPosition(XY,side,width,Display.motionTank);
        if ((this.getBoundsInParent().intersects(Display.motionTank.getBoundsInParent()))) {
            if(objectPosition == platformPosition) {
                if(this instanceof Bullet)
                {
                    Display.motionTank.life--;
                    if(Display.motionTank.life<=0)
                        Display.motionTank.ifLife = false;
                }
                return true;
            }
        }
        return false;
    }

    protected boolean ifBulletCollision(boolean XY,boolean side)
    {
        double objectPosition = 0, platformPosition = 0;
        for (Node platform : WaitClickDisplays.bullets) {
            objectPosition = getObjectPosition(XY,side);
            platformPosition = getPlatformPosition(XY,side,width,platform);
            if ((this.getBoundsInParent().intersects(platform.getBoundsInParent()))) {
                if(objectPosition == platformPosition) {
                    return true;
                }
            }
        }
        return false;
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
