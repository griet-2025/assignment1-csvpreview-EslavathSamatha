package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        String filePath = "dataset/dataset.csv";
        String delimiter = ",";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Read header line
            String headerLine = br.readLine();
            if (headerLine == null || headerLine.trim().isEmpty()) {
                System.out.println("The CSV file is empty or doesn't have a header.");
                return;
            }

            // Split and print column names
            String[] columns = headerLine.split(delimiter, -1);
            System.out.println("Columns in the file:");
            for (String column : columns) {
                System.out.print(column.trim() + " ");
            }

            System.out.println("\nNumber of columns: " + columns.length);
            System.out.println("\n\n\nShowing first 5 rows:\n");

            // Print first 5 records
            int recordCount = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter, -1);
                for (int i = 0; i < values.length; i++) {
                    values[i] = values[i].trim();
                }

                if (recordCount < 5) {
                    for (String value : values) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
                recordCount++;
            }

            System.out.println("\n\nTotal number of records (excluding header): " + recordCount);

        } catch (IOException e) {
            System.out.println("Could not read the file. Please check the path or file format.");
        }
    }
}