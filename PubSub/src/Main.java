public class Main {

    public static void main(String[] args) {

        Publisher n1 = new Publisher(1);
        Subscriber n2 = new Subscriber(2);
        Subscriber n3 = new Subscriber(3);
        Subscriber n4 = new Subscriber(4);
        Subscriber n5 = new Subscriber(5);
        Subscriber n6 = new Subscriber(6);

        n2.subscribe(n1,2);
        n3.subscribe(n1,1);
        n4.subscribe(n1,2);
        n5.subscribe(n1,1);
        n6.subscribe(n1,2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                n1.publish(new PubSubEvent(1, "Event1"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                n1.publish(new PubSubEvent(2, "Event2"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                n1.publish(new PubSubEvent(1, "Event3"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                n1.publish(new PubSubEvent(2, "Event4"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                n1.publish(new PubSubEvent(3, "Event5"));
            }
        }).start();

    }
}
