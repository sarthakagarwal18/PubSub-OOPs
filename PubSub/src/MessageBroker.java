import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class MessageBroker {

    private ConcurrentHashMap<Integer, ArrayList<Subscriber> > subscriberMap;

    public MessageBroker() {
        subscriberMap = new ConcurrentHashMap<>();
    }

    // take event from publisher, add to queue
    public void addEvent(PubSubEvent pubSubEvent) {
        synchronized (this) {
            sendToSubscribers(pubSubEvent);
        }
    }

    // register subscribers
    public void subscribe(Subscriber subscriber, int eventType) {
        ArrayList<Subscriber> subscriberList = new ArrayList<>();
        if (subscriberMap.containsKey(eventType)) {
            subscriberList = subscriberMap.get(eventType);
        }
        subscriberList.add(subscriber);
        subscriberMap.put(eventType, subscriberList);
    }

    private void sendToSubscribers(PubSubEvent pubSubEvent) {
        if (!subscriberMap.containsKey(pubSubEvent.getEventType())) {
            return;
        }
        ArrayList<Subscriber> subscriberList = subscriberMap.get(pubSubEvent.getEventType());
        for (Subscriber subscriber : subscriberList) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    subscriber.receiveEvent(pubSubEvent);
                }
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (Exception e){}
    }

    // handle failure/callbacks

}
