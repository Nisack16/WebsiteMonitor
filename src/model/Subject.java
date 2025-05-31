package model;

import model.Observer;
import model.Notification;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(Notification notification);
}
