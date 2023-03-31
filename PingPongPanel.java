
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PingPongPanel extends JPanel implements KeyListener {
    public static Raket r1=new Raket(30,Screen.heigth/2-Raket.raketUzunlugu/2);
    public static Raket r2=new Raket(Screen.width-30-Raket.raketKalinligi,Screen.heigth/2-Raket.raketUzunlugu/2);
    public static Ball ball=new Ball(Screen.width/2-Ball.yariCap,Screen.heigth/2-Ball.yariCap);

    public static boolean raketeDeydimi(int x){
        System.out.println("raket 1");
        System.out.println(r1.y+"      "+ball.y);
        System.out.println(r1.y+Raket.raketUzunlugu+"      "+(ball.y+Ball.yariCap));
        System.out.println("---------------");
        System.out.println("raket 2");
        System.out.println(r2.y+"      "+ball.y);
        System.out.println(r2.y+Raket.raketUzunlugu+"      "+(ball.y+Ball.yariCap));
        System.out.println("---------------");
        if (x==1){
            if (r1.y<=ball.y+Ball.yariCap && r1.y+Raket.raketUzunlugu>=ball.y+Ball.yariCap){
                System.out.println("sol raket vurdu");
                return true;
            }
        }
        else{
            if (r2.y<=ball.y+Ball.yariCap && r2.y+Raket.raketUzunlugu>=ball.y+Ball.yariCap){
                System.out.println("sag raket vurdu");
                return true;
            }
        }
        return false;
    }

    public static int yukariAsagiBirimDegistir(int x){
        if (x==1){
            if (ball.y+Ball.yariCap-r1.y<8)
                return -6;
            else if (ball.y+Ball.yariCap-r1.y<17)
                return -4;
            else if (ball.y+Ball.yariCap-r1.y<30)
                return -3;
            else if (ball.y+Ball.yariCap-r1.y<40)
                return 0;
            else if (ball.y+Ball.yariCap-r1.y<53)
                return 3;
            else if (ball.y+Ball.yariCap-r1.y<62)
                return 4;
            else if (ball.y+Ball.yariCap-r1.y<70)
                return 6;
        }
        if (x==2){
            if (ball.y+Ball.yariCap-r2.y<8)
                return -6;
            else if (ball.y+Ball.yariCap-r2.y<17)
                return -4;
            else if (ball.y+Ball.yariCap-r2.y<30)
                return -3;
            else if (ball.y+Ball.yariCap-r2.y<40)
                return 0;
            else if (ball.y+Ball.yariCap-r2.y<53)
                return 3;
            else if (ball.y+Ball.yariCap-r2.y<62)
                return 4;
            else if (ball.y+Ball.yariCap-r2.y<70)
                return 6;
        }




        return 0;
    }

    public PingPongPanel(){
        setSize(Screen.width, Screen.heigth);

        Thread raketThread1=new Thread(r1);
        Thread raketThread2=new Thread(r2);
        Thread ballThread=new Thread(ball);



        raketThread1.start();
        raketThread2.start();
        ballThread.start();



        addKeyListener(this);
        setFocusable(true);
        setVisible(true);
    }


    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.GREEN);
        g.fillRect(r1.x,r1.y,Raket.raketKalinligi,Raket.raketUzunlugu);
        g.fillRect(r2.x,r2.y,Raket.raketKalinligi,Raket.raketUzunlugu);

        g.setColor(Color.RED);
        g.fillOval(ball.x,ball.y,Ball.Cap,Ball.Cap);

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            r2.moveUP();
        }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            r2.moveDOWN();
        }else if(e.getKeyCode()==KeyEvent.VK_W){
            r1.moveUP();
        }else if(e.getKeyCode()==KeyEvent.VK_S){
            r1.moveDOWN();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            r2.moveSTOP();
        }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            r2.moveSTOP();
        }else if(e.getKeyCode()==KeyEvent.VK_W){
            r1.moveSTOP();
        }else if(e.getKeyCode()==KeyEvent.VK_S){
            r1.moveSTOP();
        }
    }
}
