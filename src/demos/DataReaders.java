package demos;

import java.util.List;

public class DataReaders {

	public static void main(String[] args) {
		readXLS();
	}
	
	public static void readCSV() {
		String filename = "C:\\Users\\satya\\Desktop\\Eclipse Workspace\\SeleniumTraining\\UserAccounts.csv";
		List<String[]> records = utilities.CSV.get(filename);
		
		//For printing the data from the .csv file
		for (String[] record : records) {
			for (String field : record) {
				System.out.println(field);
			}
		}
	}
	
	public static void readXLS() {
		String filename = "C:\\Users\\satya\\Desktop\\Eclipse Workspace\\SeleniumTraining\\UserLogin.xls";
		String[][] data = utilities.Excel.get(filename);
		for (String[] record : data) {
			System.out.println("\n NEW RECORD");
			System.out.println(record[0]);
			System.out.println(record[1]);
			System.out.println(record[2]);
		}
	}
}
