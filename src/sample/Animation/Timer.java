package sample.Animation;

public class Timer {

    protected long timerStart;
    protected long timerFinish;
    protected long timerDuration;

    public Timer(long timerDuration)
    {
      this.timerDuration = timerDuration;
    }

    public boolean isTime()
    {
        if(timerStart == 0)
        {
            timerStart = System.currentTimeMillis();
            timerFinish = timerStart+timerDuration;
            return true;
        }else if(timerFinish <= System.currentTimeMillis())
        {
            timerStart = 0;
            return true;
        }else
            return false;
    }
}

