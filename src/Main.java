import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> page0Keywords = new ArrayList<>();
        page0Keywords.add("Anglais");
        page0Keywords.add("Informatique");
        Page page0 = new Page("Page 0", page0Keywords);
        List<String> page1Keywords = new ArrayList<>();
        page1Keywords.add("Anglais");
        page1Keywords.add("Java");
        Page page1 = new Page("Page 1", page1Keywords);
        List<String> page2Keywords = new ArrayList<>();
        page2Keywords.add("Anglais");
        page2Keywords.add("Machine learning");
        Page page2 = new Page("Page 2", page2Keywords);
        List<String> page3Keywords = new ArrayList<>();
        page3Keywords.add("Datamining");
        page3Keywords.add("Big Data");
        Page page3 = new Page("Page 3", page3Keywords);

        page0.addNextPage(page1);
        page1.addNextPage(page2);
        page2.addNextPage(page1);
        page2.addNextPage(page0);

        List<Page> pages = new ArrayList<>();
        pages.add(page0);
        pages.add(page1);
        pages.add(page2);
        pages.add(page3);

        List<String> searchkeywords = new ArrayList<>();
        searchkeywords.add("Anglais");
        PageRank pageRank = new PageRank(pages, searchkeywords);
        pageRank.calculate(1,0.85);
    }
}
