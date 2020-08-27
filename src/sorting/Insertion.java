package sorting;

import CDArchiveProject.CDRecord;

import java.util.ArrayList;
import java.util.List;

public class Insertion {
    public static void main(String[] args) {
        List<CDRecord> recordList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            int randomBarcode = (int) (Math.random() * 100);
            recordList.add(new CDRecord(randomBarcode));
        }
        System.out.println("Before Start: " + recordList.toString());

        Insertion.sort(recordList);
        System.out.println("After Sort: " + recordList.toString());
    }
    public static void sort(List<CDRecord> records) {

        for (int index = 1; index < records.size(); index++) {

            CDRecord indexRecord = records.get(index);
            int prevIndex = index - 1;
            while (prevIndex >= 0 && records.get(prevIndex).getBarcode() > indexRecord.getBarcode()) {
                CDRecord prevRecord = records.get(prevIndex);
                records.set(prevIndex + 1, prevRecord);
                prevIndex--;
            }
            records.set(prevIndex + 1, indexRecord);
        }
    }
}
