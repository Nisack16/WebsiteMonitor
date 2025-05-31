package model;

public class User implements Observer {
    private String name;
    private int age;
    private String email;
    private String mobileNumber;

    public User(String name, int age, String email, String mobileNumber) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    @Override
    public void update(Notification notification) {
        switch (notification.getChannel()) {
            case EMAIL:
                System.out.println("EMAIL an " + email + ": " + notification.getMessage());
                break;
            case SMS:
                System.out.println("SMS an " + mobileNumber + ": " + notification.getMessage());
                break;
        }
    }
}
