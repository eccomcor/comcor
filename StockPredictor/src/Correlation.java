import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Correlation {
	
	private double upUp;
	private double upDown;
	private double upFlat;
	private double downUp;
	private double downDown;
	private double downFlat;
	private double flatUp;
	private double flatDown;
	private double flatFlat;
	private double positiveEffectSize;
	private double negativeEffectSize;
	private double flatEffectSize;
	
	private String leadingStockPath = "errorInConstructorFollowing";
	private String trailingStockPath = "errorInConstructorTrailing";
	
	//the correlation name is formatted like "FollowStockTicker_LeadStockTicker"
	private String correlationName = "errorInNamingLeadFollowTickers";
	
	public Correlation(String leadingStockTicker, String trailingStockTicker){
		
		this.correlationName = trailingStockTicker + "_" + leadingStockTicker;
		
		this.leadingStockPath = "src\\" + leadingStockTicker + ".csv";
		this.trailingStockPath = "src\\" + trailingStockTicker + ".csv";
	}

	@SuppressWarnings("resource")
	
	public ArrayList<Stock> initStockArray(String stockDataPath){
		
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		
		BufferedReader stream = null;
		try {
			stream = new BufferedReader(
			        new InputStreamReader(
			        new FileInputStream(stockDataPath)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		try {
			while ((line = stream.readLine()) != null){
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] values = line.split(",");
		if(!values[0].equals("Date")){
		
			Stock stock = new Stock(values[0], Double.parseDouble(values[1]), Double.parseDouble(values[4]));
			stocks.add(stock);
		
		}
		return stocks;
		
	}
	
	public void determineCorrelation(){
		
		ArrayList<Stock> leadingStocks = initStockArray(leadingStockPath);
		ArrayList<Stock> trailingStocks = initStockArray(trailingStockPath);
		
		//t And l hold the day to day changes being compared
		//further variables might hold arrays of varying size and/or complexity
		//economic factors like mortgage rate changes, Fed action, and the CPI might be of interest as well 
		
		double t, l = 0.0;
		
		int limit = trailingStocks.size();
		
		//tally keepers for maintaining averages of correlation data
		double upUpFrequency = 0;
		double upDownFrequency = 0;
		double downUpFrequency = 0;
		double downDownFrequency = 0;
		double upFlatFrequency = 0;
		double downFlatFrequency = 0;
		double flatUpFrequency = 0;
		double flatDownFrequency = 0;
		double flatFlatFrequency = 0;
		
		//for effect size calculations
		double positiveEffectFrequency = 0;
		double negativeEffectFrequency = 0;
		double flatEffectFrequency = 0;
		
		for(int i = 1; i < limit; i++){	
			
			Stock trailingStock = trailingStocks.get(i-1);
			Stock leadingStock = leadingStocks.get(i);
			t = trailingStock.getChange();
			l = leadingStock.getChange();
			
			//correlation coefficient is being calculated given some relationship between leading and trailing
			if((l > 0) && (t > 0)){
				
				upUpFrequency++;
				positiveEffectFrequency++;
				
				//correlation is done by trailing change divided by leading change
			
				double temp = Math.abs(t / l);
				
				upUp = upUp*upUpFrequency-1;
				//add the new one into the sum total
				upUp += temp;
				//now average by dividing by the new frequency
				upUp /= upUpFrequency;
				}
			else if((l > 0) && (t < 0)){
				//basically the same process with different inputs 
				upDownFrequency++;
				negativeEffectFrequency++;
				
				double temp = Math.abs(t/l);
				
				upDown = upDown*upDownFrequency - 1;
				upDown += temp;
				upDown /= upDownFrequency;
			}
			else if((l < 0) && (t < 0)){
					//basically the same process with different inputs 
					downDownFrequency++;
					negativeEffectFrequency++;
					
					double temp = Math.abs(t/l);
					
					downDown = downDown*downDownFrequency - 1;
					downDown += temp;
					downDown /= downDownFrequency;
			}
			else if((l < 0) && (t > 0)){
				//basically the same process with different inputs 
				downUpFrequency++;
				positiveEffectFrequency++;
				
				double temp = Math.abs(t/l);
				
				downUp = downUp*downUpFrequency - 1;
				downUp += temp;
				downUp /= downUpFrequency;
		}	
			else if((l > 0) && (t == 0)){
				//basically the same process with different inputs 
				upFlatFrequency++;
				flatEffectFrequency++;
				
				
				upFlat = upFlat*upFlatFrequency - 1;
				upFlat += l;
				upFlat /= upFlatFrequency;
		}
			else if((l < 0) && (t == 0)){
				//basically the same process with different inputs 
				downFlatFrequency++;
				flatEffectFrequency++;
				
				double temp = Math.abs(l);
				
				downFlat = downFlat*downFlatFrequency - 1;
				downFlat += temp;
				downFlat /= downFlatFrequency;
		}
			else if((l == 0) && (t > 0)){
				//basically the same process with different inputs 
				flatUpFrequency++;
				positiveEffectFrequency++;
				
		
				
				flatUp = flatUp*flatUpFrequency - 1;
				flatUp += t;
				flatUp /= flatUpFrequency;
		}
			else if((l == 0) && (t < 0)){
				//basically the same process with different inputs 
				flatDownFrequency++;
				negativeEffectFrequency++;
				
				double temp = Math.abs(t);
				
				flatDown = flatDown*flatDownFrequency - 1;
				flatDown += temp;
				flatDown /= flatDownFrequency;
		}
			else if((l == 0) && (t == 0)){
				//basically the same process with different inputs 
				flatFlatFrequency++;
				flatEffectFrequency++;
				
				double temp = Math.abs(t/l);
				
				flatFlat = flatFlat*flatFlatFrequency - 1;
				flatFlat += temp;
				flatFlat /= flatFlatFrequency;
		}
			else
				{
				System.out.println("Error calculating correlations");
				}
			
			}
		//after all the effects have been summed, the effect size ratio is found
		
		this.positiveEffectSize = positiveEffectFrequency/limit;
		this.negativeEffectSize = negativeEffectFrequency/limit;
		this.flatEffectSize = flatEffectFrequency/limit;
			
		}
	}

