package CDArchiveProject;

import java.util.Arrays;
import java.util.List;

public class CDRecord {
    String title;
    String author;
    String section;
    String description;
    int barcode;
    int x, y;
    boolean onLoan;

    public CDRecord(int barcode) {
        this.barcode = barcode;
    }
    public CDRecord(String title, String author, String section, int x, int y, int barcode,
                    String description, boolean onLoan) {
        this.title = title;
        this.author = author;
        this.section = section;
        this.x = x;
        this.y = y;
        this.barcode = barcode;
        this.description = description;
        this.onLoan = onLoan;
    }

    public int getBarcode() {
        return barcode;
    }



    public static List<CDRecord> getTestData() {
        CDRecord[] records = new CDRecord[] {
                new CDRecord("Joe", "Higgins", "Gaming", 5, 2, 523234, "Awesome", true ),
                new CDRecord("Joe4", "Higgins", "Gaming", 1, 2, 523234, "Awesome", true ),
                new CDRecord("Joe6", "Higgins", "Gaming", 4, 2, 523234, "Awesome", true ),
                new CDRecord("Joe8", "Higgins", "Gaming", 9, 2, 523234, "Awesome", true ),
                new CDRecord("Joe9", "Higgins", "Gaming", 7, 2, 523234, "Awesome", true ),
                new CDRecord("Joe02", "Higgins", "Gaming", 8, 2, 523234, "Awesome", true ),
                new CDRecord("Joe21", "Higgins", "Gaming", 2, 2, 523234, "Awesome", true )
        };

        return Arrays.asList(records);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isOnLoan() {
        return onLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    @Override
    public String toString() {
        return "CDRecord{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", section='" + section + '\'' +
                ", description='" + description + '\'' +
                ", barcode=" + barcode +
                ", x=" + x +
                ", y=" + y +
                ", onLoan=" + onLoan +
                '}';
    }
}
