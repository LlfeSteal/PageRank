import java.util.ArrayList;
import java.util.List;

public class PageRank {

    private List<Page> pages;
    private List<String> keywords;

    public PageRank(List<Page> pages, List<String> keywords) {
        this.pages = pages;
        this.keywords = keywords;
    }

    private void checkKeywords() {
        System.out.println("---------- Keywords ----------");
        List<Page> copyPageList = new ArrayList<>(pages);
        for (Page page : copyPageList) {
            for (String keyword : this.keywords) {
                if (!page.getKeywords().contains(keyword)) {
                    this.pages.remove(page);
                    System.out.println("La page " + page.getName() + " ne contient pas les mots clefs " + this.keywords.toString());
                }
            }
        }
    }

    public void calculate(int interations, double d) {
        System.out.println("==========Préambule==========");
        checkKeywords();
        double[][] matrix = getMatrix();
        double[] dmatrix = getDMatrix(d, matrix.length);
        System.out.println("=========Calcul==========");
        for (int i = 0; i < interations; ++i) {
            System.out.println("------ Itération " + i + "  ------");
            for (int j = 0; j <  matrix.length; j++) {
                double score = 0;
                for (int k = 0; k < matrix.length; k++) {
                    System.out.println("("+j +","+k+") : " + matrix[j][k]);
                    double value = matrix[j][k];
                    value *= dmatrix[j];
                    score += value;
                }
                dmatrix[j] = score;
                System.out.println("SCORE ligne " + j +" = " +  score);
            }
        }
    }

    private double[][] getMatrix() {
        System.out.println("---------- Matrice ----------");
        double[][] matrix = new double[this.pages.size()][this.pages.size()];
        List<Page> horizontalPages = new ArrayList<>(this.pages);
        List<Page> verticalPages = new ArrayList<>(this.pages);
        for (Page verticalPage : verticalPages) {
            int number = 0;
            for(Page horizontalPage : horizontalPages) {
                int value =  0;
                if (horizontalPage.hasNext(verticalPage)) {
                    value =  1;
                    ++number;
                }
                matrix[horizontalPages.indexOf(horizontalPage)][verticalPages.indexOf(verticalPage)] = value;
                System.out.println("("+horizontalPages.indexOf(horizontalPage) +","+verticalPages.indexOf(verticalPage)+") : " + value);
            }
            for(Page horizontalPage : horizontalPages) {
                double value = matrix[horizontalPages.indexOf(horizontalPage)][verticalPages.indexOf(verticalPage)];
                if (number > 1) {
                    value /= number;
                }
                matrix[horizontalPages.indexOf(horizontalPage)][verticalPages.indexOf(verticalPage)] = value;
            }
        }
        return matrix;
    }

    private double[] getDMatrix(double d, int size) {
        System.out.println("---------- DMatrice ----------");
        double[] dmatrix = new double[size];
        for (int i = 0; i < size; i++) {
            System.out.println("(" + i + ") : " + d);
            dmatrix[i] = d;
        }
        return dmatrix;
    }


}
