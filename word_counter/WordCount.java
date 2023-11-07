package word_counter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
	 public static void main(String[] args) {
	        String inputFile = "input.txt";
	        String outputFile = "output.txt";

	        Map<String, Integer> wordCountMap = new HashMap<>();

	        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                // Convert the word to lowercase to make it case-insensitive
	                String word = line.toLowerCase().trim();
	                // Update the word count in the map
	                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
	            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
	                // Write the word and its count to the output file
	                writer.write(entry.getKey() + " " + entry.getValue());
	                writer.newLine();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Word count results have been written to " + outputFile);
	    }
	}
	

