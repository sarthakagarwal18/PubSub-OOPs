public class PubSubEvent {
    private int eventType;
    private String pubSubString;

    public PubSubEvent(int eventType, String pubSubString) {
        this.eventType = eventType;
        this.pubSubString = pubSubString;
    }

    public String getPubSubString() {
        return pubSubString;
    }

    public int getEventType() {
        return eventType;
    }
}
