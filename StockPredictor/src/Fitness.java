import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class Fitness {
	
	private double fitness = 0.0;
	private File stockIndexReference;
	private String[][] stockIndex = new String[2][25];
	
	
	public Fitness(){
		
	}
	
	
public double getFitness(boolean[] individual, String dependentStockTicker){
	double fitness = 0.0;
	return fitness;
}
	



public String[][] getIndex(){
	
	int index = 0; 
	BufferedReader stream = null;
	try {
		stream = new BufferedReader(
		        new InputStreamReader(
		        new FileInputStream(stockIndexReference)));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String line = null;
	try {
		while ((line = stream.readLine()) != null){
			String[] values = line.split(",");
			stockIndex[0][index] = Integer.toString(index);
			stockIndex[1][index] = values[0];  
			index++;
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return stockIndex;
	}

}
	
	

