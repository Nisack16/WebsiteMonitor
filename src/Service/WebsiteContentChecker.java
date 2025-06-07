package Service;

import java.net.URL;
import java.util.Scanner;

public class WebsiteContentChecker {

    public String fetchWebsiteContent(String urlString) {
        StringBuilder content = new StringBuilder();

        try (Scanner scanner = new Scanner(new URL(urlString).openStream())) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Could not fetch content from: " + urlString);
        }

        return content.toString();
    }
}
