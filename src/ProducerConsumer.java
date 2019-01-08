
public class ProducerConsumer {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        new Consumer(buffer);
        new Producer(buffer);
    }

}
