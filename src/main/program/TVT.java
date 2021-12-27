package main.program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class TVT {

	public static void main(String[] args) throws FileNotFoundException {

		int a = Math.abs(10 - 20);
		System.out.println(a);
		ArrayList<String> pro = new ArrayList<>();

		String fileLocation = "D:\\campaign_12.0_code\\HCL_Campaign_master\\HCL_Campaign\\AffiniumWebApps\\Campaign\\resourcebundles\\";

		pro.add(fileLocation + "cmpUIMessages");

		// pro.add(fileLocation + "interacterrors");

		// pro.add(fileLocation + "com\\unica\\manager\\notification\\types\\Deliver");

		pro.add(fileLocation + "com\\unica\\manager\\configuration\\Campaign");

		pro.add(fileLocation + "cmpOptUIMessages");

		pro.add(fileLocation + "cmpOptServerMessages");

		pro.add(fileLocation + "cmpOptAdminMessages");

//		pro.add(fileLocation + "cmpInteractUIMessages");

		pro.add(fileLocation + "cmpDataModelMessages");

		pro.add(fileLocation + "cmpDAOXMLIOMessages");

		pro.add(fileLocation + "cmpDAOSQLMapMessages");

		pro.add(fileLocation + "cmpDAOReportnetMessages");

		// pro.add(fileLocation + "acdelivererrors");

		pro.add(fileLocation + "StaticMessages");

		// pro.add(fileLocation + "HelpLinks");

		pro.add(fileLocation + "Flowchart");

		pro.add(fileLocation + "ErrorMessages");

		// pro.add(fileLocation + "APIValidationMessages");

		for (String string : pro) {
			findTVTDiff(string, "ja");
		}

	}

	public static void findTVTDiff(String propertyFile, String coun) throws FileNotFoundException {

		List<String> l = new ArrayList<>();
		Reader s = new FileReader(propertyFile + "_" + coun + ".properties");
		String thisLine = null;

		try {
			// open input stream test.txt for reading purpose.
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(s);

			while ((thisLine = br.readLine()) != null) {
				if (thisLine.contains("="))
					l.add(thisLine.substring(0, thisLine.indexOf("=")).trim());
			}
			// System.out.println(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean diff = false;
		s = new FileReader(propertyFile + ".properties");
		List<String> data = new ArrayList<>();
		try {
			// open input stream test.txt for reading purpose.
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(s);

			while ((thisLine = br.readLine()) != null) {
				if (thisLine.contains("=")) {
					String ss = thisLine.substring(0, thisLine.indexOf("=")).trim();
					if (!l.contains(ss)) {
						diff = true;
						data.add(thisLine);
						// System.out.println(thisLine);
					}
				}
			}
			if (diff) {
				System.out.println("--" + propertyFile + ".properties--");
				System.out.println();
				System.out.println();
				String fileName = propertyFile.substring(propertyFile.lastIndexOf('\\') + 1) + ".properties";
				System.out.println(fileName);
				createFile(fileName, "", data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createFile(String fileName, String filePath, List<String> data) throws IOException {
		filePath = "D:\\TVT\\TVT25SEP20\\" + fileName;
		System.out.println(filePath);
		BufferedWriter output = null;
		try {
			File file = new File(filePath);
			file.getParentFile().mkdir();
			file.createNewFile();
			output = new BufferedWriter(new FileWriter(file));
			for (String line : data) {
				output.write(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				output.close();
			}
		}
	}

}
