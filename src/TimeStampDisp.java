import javax.swing.*;
import java.time.Instant;
import java.util.Random;

public class TimeStampDisp extends JTextArea implements Runnable{
    private boolean isSuspended = false;

    public void sleep(){
        isSuspended = true;
    }

    public void resume(){
        isSuspended = false;
        synchronized (this){
            notify();
        }
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true){
            synchronized (this){
                while (isSuspended){
                    try {
                        wait();
                    }catch (InterruptedException ignore){

                    }
                }
                setText(this.getText() + "\n" + Instant.now());
                setCaretPosition(this.getDocument().getLength());
            }
            try {
                Thread.sleep(random.nextInt(901)+100);
            }catch (InterruptedException ignore){

            }
        }
    }
}
