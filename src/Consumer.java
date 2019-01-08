
public class Consumer implements Runnable {
    Thread consumer;
    Buffer buffer;

    public Consumer(Buffer m)
    {
        this.buffer = m;
        consumer = new Thread(this);
        consumer.start();
    }


    @Override
    public void run() {
        while(true) {
            buffer.get();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
