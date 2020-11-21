package CDArchiveProject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class RecordStorage {

    // Test only
    public static void main(String[] args) {
        List<CDRecord> records = loadRecordList("records.data");
        System.out.println(records);
    }

    public static List<CDRecord> loadRecordList(String filepath) {

        List<CDRecord> records = new ArrayList<>();

        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] dataColumns = line.split(";");
                CDRecord record = new CDRecord(
                        dataColumns[1], dataColumns[2], dataColumns[3],
                        Integer.parseInt(dataColumns[4]), Integer.parseInt(dataColumns[5]),
                        Integer.parseInt(dataColumns[6]), dataColumns[7], dataColumns[8].equalsIgnoreCase("yes")

                );

                records.add(record);
            }
        }
        catch (Exception e) {
            System.err.println("Failed To Load Records " + e.toString());
        }
        return records;
    }

    public static void saveRecordList(String filepath, List<CDRecord> records) {

        try {
            FileWriter fw = new FileWriter(filepath);
            BufferedWriter bw = new BufferedWriter(fw);

            for (CDRecord record: records) {
                bw.write("0" + ";" + record.getTitle() + ";" + record.getAuthor() + ";" +record.getSection() + ";"
                + record.getX() + ";" + record.getY() + ";" + record.getBarcode() + ";" + record.getDescription() + ";"
                + (record.isOnLoan() ? "Yes" : "No"));

                bw.newLine();
            }
            bw.close();
        }
        catch (Exception e) {
            System.err.println("Failed To Load Records " + e.toString());
        }
    }
}
