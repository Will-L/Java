package sorting;

import CDArchiveProject.CDRecord;

import java.util.ArrayList;
import java.util.List;

public class Selection {
    public static void main(String[] args) {
        List<CDRecord> records = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            int randomBarcode = (int) (Math.random() * 100);
            records.add(new CDRecord(randomBarcode));
        }
        System.out.println("Before sort: " + records.toString());

        Selection.sort(records);
        System.out.println("After sort: " + records.toString());
    }

    public static void sort(List<CDRecord> records) {
        for (int index = 0; index < records.size(); index++) {
            int smallestindex = index;
            for (int currentIndex = index+1; currentIndex < records.size(); currentIndex++) {
                if (records.get(currentIndex).getAuthor().hashCode() < records.get(smallestindex).getAuthor().hashCode()) {
                    smallestindex = currentIndex;
                }
            }
            CDRecord smallestRecord = records.get(smallestindex);
            CDRecord indexRecord = records.get(index);
            records.set(index, smallestRecord);
            records.set(smallestindex, indexRecord);
        }
    }
}
