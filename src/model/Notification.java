package model;

import java.util.Date;

public class Notification {
    private int notificationId;
    private String subscriptionId;
    private String message;
    private Date timestamp;
    private NotificationPreference.Channel channel; // Hinzugefügt!

    public Notification(int notificationId, String subscriptionId, String message, NotificationPreference.Channel channel) {
        this.notificationId = notificationId;
        this.subscriptionId = subscriptionId;
        this.message = message;
        this.channel = channel;
        this.timestamp = new Date();
    }

    public int getNotificationId() { return notificationId; }
    public String getSubscriptionId() { return subscriptionId; }
    public String getMessage() { return message; }
    public Date getTimestamp() { return timestamp; }
    public NotificationPreference.Channel getChannel() { return channel; }
}
