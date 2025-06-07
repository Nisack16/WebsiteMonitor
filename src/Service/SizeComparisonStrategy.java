package Service;

public class SizeComparisonStrategy implements ComparisonStrategy {
    @Override
    public boolean hasChanged(String oldContent, String newContent) {
        return oldContent == null || oldContent.length() != newContent.length();
    }
}
