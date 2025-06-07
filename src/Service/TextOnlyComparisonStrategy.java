package Service;

public class TextOnlyComparisonStrategy implements ComparisonStrategy {
    @Override
    public boolean hasChanged(String oldContent, String newContent) {
        if (oldContent == null) return true;

        String oldText = stripHtmlTags(oldContent);
        String newText = stripHtmlTags(newContent);

        return !oldText.equals(newText);
    }

    private String stripHtmlTags(String html) {
        // Entfernt alles zwischen < > = HTML-Tags
        return html.replaceAll("<.*?>", "").trim();
    }
}
