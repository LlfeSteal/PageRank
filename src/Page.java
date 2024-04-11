import java.util.ArrayList;
import java.util.List;

public class Page {
    private String name;
    private List<String> keywords;
    private List<Page> nextPages = new ArrayList<>();

    public Page(String name, List<String> keywords) {
        this.name = name;
        this.keywords = keywords;
    }

    public void addNextPage(Page page) {
        this.nextPages.add(page);
    }

    public String getName() {
        return name;
    }

    public List<String> getKeywords() {
        return keywords;
    }


    public boolean hasNext(Page page) {
        return this.nextPages.contains(page);
    }

}
