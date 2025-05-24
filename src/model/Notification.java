package model;

import java.util.Date;

public class Notification {
    private int notificationId;
    private String subscriptionId;
    private String message;
    private Date timestamp;

    public Notification(int notificationId, String subscriptionId, String message) {
        this.notificationId = notificationId;
        this.subscriptionId = subscriptionId;
        this.message = message;
        this.timestamp = new Date();
    }

    public void deliverNotification(NotificationPreference.Channel channel, User user) {
        switch (channel) {
            case EMAIL:
                System.out.println("EMAIL an " + user.getEmail() + ": " + message);
                break;
            case SMS:
                System.out.println("SMS an " + user.getMobileNumber() + ": " + message);
                break;
        }
    }
}
