package sample.Game.MotionObjects.Motions.ConcreteMontions;

import sample.Animation.Timer;
import sample.Game.Displays.WaitClickDisplays;
import sample.Game.MotionObjects.Motions.ConcreteMontions.ConcreteMontionObjects.Bullet;
import sample.Game.MotionObjects.Motions.MotionObject;
import sample.Game.MotionObjects.TankI;

public abstract class Tank extends MotionObject implements TankI {

    protected long timerStart;
    protected long timerFinish;
    protected long timerDuration;
    protected Timer timer;
    public Tank(double x, double y, String handle) {
        super(x, y, handle);
        this.columns = 3;
        this.count = 3;
        this.offsetX = 0;
        this.offsetY = 0;
        this.width = 87;
        this.height = 87;
        this.setTranslateX(x);
        this.setTranslateY(y);
        timerFinish = 0;
        timerStart = 0;
        timerDuration = 500;
        timer = new Timer(500);
    }

    protected void setDuration(long timerDuration)
    {
        this.timerDuration = timerDuration;
    }


    //Прописываем направление картинки/движимого объекта если дело касается танка
    @Override
    public void objectAnimation()
    {
        switch (meaning){
            case "Up":
                this.animation.setOffsetY(261);
                break;
            case "Down":
                this.animation.setOffsetY(0);
                break;
            case "Left":
                this.animation.setOffsetY(174);
                break;
            case "Right":
                this.animation.setOffsetY(87);
                break;

        }
    }

    @Override
    public void fire() {

        if(timer.isTime())
            WaitClickDisplays.bullets.add(new Bullet(getTranslateX(),getTranslateY(),getMeaning()));
        //создаем снаряд на карте, добавляем его в список движимых снарядов.

    }

}
