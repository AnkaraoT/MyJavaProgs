import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVFileReader {

	static int count = 0;
	
    public static void main(String[] args) {

        String csvFile = "C:\\Users\\anta0517\\Personal\\GContacts.csv";
        String line = "";
        String cvsSplitBy = ",";
    
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                if(country[1].matches(".*\\w.*"))
                System.out.println(country[0].trim() + " ," + country[1].trim() );

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}