package model;

public class NotificationPreference {
    public enum Frequency { DAILY, WEEKLY, HOURLY }
    public  enum Channel { EMAIL, SMS }

    private Frequency frequency;
    private Channel communicationChannel;
    private String messageTemplate;

    public NotificationPreference(Frequency frequency, Channel channel, String template) {
        this.frequency = frequency;
        this.communicationChannel = channel;
        this.messageTemplate = template;
    }

    public Frequency getFrequency() { return frequency; }
    public void setFrequency(Frequency frequency) { this.frequency = frequency; }

    public Channel getCommunicationChannel() { return communicationChannel; }
    public void setCommunicationChannel(Channel channel) { this.communicationChannel = channel; }

    public String getMessageTemplate() { return messageTemplate; }
    public void setMessageTemplate(String template) { this.messageTemplate = template; }
}
