public class Subscriber extends Node {

    public Subscriber(int nodeID) {
        super(nodeID);
    }

    // subscribe events from a particular node of a particular event type
    public void subscribe(Publisher publisher, int eventType) {
        MessageBroker messageBroker = publisher.getMessageBroker();
        messageBroker.subscribe(this, eventType);
    }

    // handle event when received
    public void receiveEvent(PubSubEvent pubSubEvent) {
        System.out.println("SubscriberID: " + getNodeID() + " PubSubEvent: " + pubSubEvent.getEventType() + " " + pubSubEvent.getPubSubString());
    }

}
