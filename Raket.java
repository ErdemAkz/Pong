

import java.util.concurrent.locks.ReentrantLock;

public class Raket implements Runnable {
    public int x;
    public int y;
    public final static int raketUzunlugu=70;
    public final static int raketKalinligi=10;
    public int yon; // 0--->STOP    1--->UP      2--->DOWN

    public Raket(int x,int y){
        this.x=x;
        this.y=y;
    }

    public void moveUP(){
        yon=1;
    }
    public void moveDOWN(){
        yon=2;
    }
    public void moveSTOP(){
        yon=0;
    }

    public void run(){
        while (true){

            if (y>=-1 && y+Raket.raketUzunlugu<=Screen.heigth+1) {
                if (yon == 1) {
                    if (y>0)
                        y = y - 5;
                } else if (yon == 2) {
                    if (y+Raket.raketUzunlugu<Screen.heigth)
                        y = y + 5;
                }
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


    }


}
