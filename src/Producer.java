import java.util.Random;

public class Producer implements Runnable{
    private Thread producer;
    private Buffer buffer;
    private Random x;

    public Producer (Buffer buffer)
    {
        this.buffer = buffer;
        x = new Random();
        producer = new Thread(this);
        producer.start();

    }

    @Override
    public void run() {
        while(true)
            try {
        buffer.put(x.nextInt(30));
        Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
