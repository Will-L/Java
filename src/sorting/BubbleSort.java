
package sorting;


import CDArchiveProject.CDRecord;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public static void main(String[] args) {
        List<CDRecord> records = new ArrayList<>();

        for  (int i = 0; i < 100; i++) {
            int randomBarcode = (int)(Math.random() * 100);
            records.add(new CDRecord(randomBarcode));
        }

        System.out.println("Before Sort: " + records.toString());
        BubbleSort.sort(records);
        System.out.println("After Sort: " + records.toString());
    }

    public static void sort (List<CDRecord> records) {

        boolean swapped = true;

        while(swapped) {
            swapped = false;
            for (int i = 1; i < records.size(); i++) {
                CDRecord left = records.get(i-1);
                CDRecord right = records.get(i);
                if (left.getTitle().compareTo(right.getTitle()) < 0) {
                    records.set(i, left);
                    records.set(i-1, right);
                    swapped = true;
                }
            }
        }
    }
}
