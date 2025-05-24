package model;

public class Subscription {
    private String subscriptionId;
    private String url;
    private NotificationPreference preference;

    public Subscription(String subscriptionId, String url, NotificationPreference preference) {
        this.subscriptionId = subscriptionId;
        this.url = url;
        this.preference = preference;
    }

    public String getSubscriptionId() { return subscriptionId; }
    public String getUrl() { return url; }
    public NotificationPreference getPreference() { return preference; }
}
