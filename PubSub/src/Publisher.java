public class Publisher extends Node {

    private MessageBroker messageBroker;

    public Publisher(int nodeID) {
        super(nodeID);
        messageBroker = new MessageBroker();
    }

    public void publish(PubSubEvent pubSubEvent) {
        messageBroker.addEvent(pubSubEvent);
    }

    public MessageBroker getMessageBroker() {
        return messageBroker;
    }
}
