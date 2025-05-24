package Service;

import model.Notification;
import model.Subscription;
import model.User;

import java.util.*;

public class WebsiteMonitorService {
    private List<User> users = new ArrayList<>();
    private Map<User, List<Subscription>> subscriptions = new HashMap<>();
    private List<Notification> notifications = new ArrayList<>();
    private int notificationCounter = 0;

    public void addUser(User user) {
        users.add(user);
    }

    public void registerSubscription(User user, Subscription subscription) {
        subscriptions.computeIfAbsent(user, k -> new ArrayList<>()).add(subscription);
    }

    public void checkAllSubscriptions() {
        for (User user : users) {
            List<Subscription> userSubs = subscriptions.get(user);
            if (userSubs == null) continue;

            for (Subscription sub : userSubs) {
                if (detectUpdate(sub.getUrl())) {
                    Notification notification = generateNotification(sub);
                    notifications.add(notification);
                    notification.deliverNotification(sub.getPreference().getCommunicationChannel(), user);
                }
            }
        }
    }

    private boolean detectUpdate(String url) {
        // Simuliere Update-Erkennung (immer true für Demo)
        return true;
    }

    private Notification generateNotification(Subscription sub) {
        String msg = "Website updated: " + sub.getUrl();
        return new Notification(notificationCounter++, sub.getSubscriptionId(), msg);
    }
}
