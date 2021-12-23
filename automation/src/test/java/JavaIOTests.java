import java.io.*;
import java.util.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import framework.ConfigurationProvider;

public class JavaIOTests {
	@Test
	public void canReadBrowserTypeFromConfigFile() {
		ConfigurationProvider cfgProvider = new ConfigurationProvider();
		String expectedBrowserType = "chrome";
		try {
			HashMap<String, String> configMap =  cfgProvider.getPropertiesFromResourceFile("config.properties");
			Assert.assertEquals(configMap.get("BrowserType"), expectedBrowserType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void canReadCsvIntoHashMap() {
		try {
			CSVReader reader = new CSVReaderBuilder(new FileReader("src/test/resources/basses.csv")).withSkipLines(1).build();
			HashMap<String, String> bassMap = new HashMap<String, String>();
			String expectedBassModel = "BB500";
			
			List<String[]> allRows = null;
			try {
				allRows = reader.readAll();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (CsvException e1) {
				e1.printStackTrace();
			}

			for (String[] row : allRows) {
				bassMap.put(row[0], row[1]);
			}
			
			Assert.assertEquals(bassMap.get("Yamaha"), expectedBassModel);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
	}	
}