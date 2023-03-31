

public class Ball implements Runnable {
    public int x;
    public int y;
    public static final int yariCap=15;
    public static final int Cap=30;
    public int yon=1; // 1--->SAG   2--->SOL
    public int yukariAsagiGitmeBirimi=0;

    public Ball(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getY(){
        return y+Ball.yariCap;
    }

    public void reverseY() {
        yukariAsagiGitmeBirimi = -1 * yukariAsagiGitmeBirimi;
    }

    public void run(){
        while(true) {
            if (yon == 1) {    //SAG hareket
                x=x+5;
            } else {           //SOL hareket
                x=x-5;
            }
            if (y+yukariAsagiGitmeBirimi<=0)
                reverseY();
            else if (y+Cap+yukariAsagiGitmeBirimi>=Screen.heigth)
                reverseY();

            y=y+yukariAsagiGitmeBirimi;

            if (x==30+Raket.raketKalinligi){
                if (PingPongPanel.raketeDeydimi(1)){
                    yukariAsagiGitmeBirimi=PingPongPanel.yukariAsagiBirimDegistir(1);
                    yon=1;
                }
            }
            else if (x+Ball.Cap==Screen.width-30-Raket.raketKalinligi){
                if (PingPongPanel.raketeDeydimi(2)){
                    yukariAsagiGitmeBirimi=PingPongPanel.yukariAsagiBirimDegistir(2);
                    yon=2;
                }
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }

}
