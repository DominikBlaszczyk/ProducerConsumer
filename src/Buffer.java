public class Buffer {
    private int amount;
    private final int MAX = 50;
    static int zmienna;
    public Buffer()
    {
        amount = 0;
    }


    public synchronized void get() {
        try {
            if (amount > 10) {
                amount -= 10;
                System.out.println("Consumer get 10, currently in buffer: " + amount);
                notify();
            }
            else {
                System.out.println("Insufficient amount in buffer!");
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void put(int n)
    {
        try {
            if (amount <= 10) {
                amount += n;
                System.out.println("Producer put: "+ n +" , currently in buffer: " + amount);
                notify();
            }
            else if (amount + n > MAX)
            {
                System.out.println("Buffer is full!");
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
