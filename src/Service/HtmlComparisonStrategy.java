package Service;

public class HtmlComparisonStrategy implements ComparisonStrategy {
    @Override
    public boolean hasChanged(String oldContent, String newContent) {
        return oldContent == null || !oldContent.equals(newContent);
    }
}
