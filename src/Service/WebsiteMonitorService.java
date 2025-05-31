package Service;

import model.Observer;
import model.Subject;
import model.Notification;
import model.Subscription;
import model.User;
import model.NotificationPreference;


import java.util.*;

public class WebsiteMonitorService implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private Map<User, List<Subscription>> subscriptions = new HashMap<>();

    private int notificationCounter = 0;


    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Notification notification) {
        for (Observer observer : observers) {
            observer.update(notification);
        }
    }


    public void registerSubscription(User user, Subscription subscription) {
       // Wenn Benutzer noch nicht existierd neue Liste für Subscriptions & Subsription in die Liste einfügen
        subscriptions.computeIfAbsent(user, k -> new ArrayList<>()).add(subscription);
        //  User als Observer registrieren
        attach(user);
    }

    public void checkAllSubscriptions() {
        for (User user : subscriptions.keySet()) {
            List<Subscription> userSubs = subscriptions.get(user);
            // Wenn der Benutzer keine Subscriptions hat, nächsten Benutzer prüfen
            if (userSubs == null) continue;

            for (Subscription sub : userSubs) {
                // Prüfe, ob es auf der Website ein Update gibt (Demo: immer true)
                if (detectUpdate(sub.getUrl())) {
                    Notification notification = generateNotification(sub, sub.getPreference().getCommunicationChannel());
                    notifyObservers(notification);
                }
            }
        }
    }

    private boolean detectUpdate(String url) {
        // Simuliere Update-Erkenung (immer true für Demo)
        return true;
    }
    private Notification generateNotification(Subscription sub, NotificationPreference.Channel channel) {
        String msg = "Website updated: " + sub.getUrl();
        return new Notification(notificationCounter++, sub.getSubscriptionId(), msg, channel);
    }
}
