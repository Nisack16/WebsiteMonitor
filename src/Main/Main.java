package Main;

import Service.WebsiteMonitorService;
import model.*;

public class Main {
    public static void main(String[] args) {
        WebsiteMonitorService service = new WebsiteMonitorService();

        User nisa = new User("Nisa", 22, "nisa@example.com", "0987654321");

        NotificationPreference pref = new NotificationPreference(
                NotificationPreference.Frequency.DAILY,
                NotificationPreference.Channel.EMAIL,
                "Website {url} has changed!"
        );

// Nutzer als Observer registrieren
        service.attach(nisa);

        Subscription sub = new Subscription("sub1", "https://example.com", pref);
        service.registerSubscription(nisa, sub);
        service.checkAllSubscriptions(); // Simuliert eine Änderung und Benachrichtigung
    }
}
