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
    //Map  für jeden Benutzer (Key: User) eine Liste von Subscriptions (Value) speichert
    private Map<User, List<Subscription>> subscriptions = new HashMap<>();
    private int notificationCounter = 0;
    //
    private Map<String, String> previousWebsiteContents = new HashMap<>();
    private WebsiteContentChecker contentChecker = new WebsiteContentChecker();


    // zum hinzufügen eines Observers
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }
// zum entfernen einnes Observes
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }
    // Methode, um alle Observer über eine neue Notification zu informieren
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
        String currentContent = contentChecker.fetchWebsiteContent(url);
        String previousContent = previousWebsiteContents.get(url);

        boolean changed = previousContent == null || !previousContent.equals(currentContent);

        previousWebsiteContents.put(url, currentContent); // neuen Inhalt speichern
        return changed;
    }

    private Notification generateNotification(Subscription sub, NotificationPreference.Channel channel) {
        String msg = "Website updated: " + sub.getUrl();
        return new Notification(notificationCounter++, sub.getSubscriptionId(), msg, channel);
    }
}
