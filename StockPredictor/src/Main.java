
public class Main {
	
private String[] largeCap;
private String[] smallCap;

	public static void main(String[] args) {
		// TODO: create correlations for each set of stocks, create effect sizes for each set of stocks
		//use effect size as determinate in fitness function (binary array representation which is then
		//translated to sum of effect sizes for stocks included in the subset. Some parsimony pressure should be added
		//to reduce bloat from fitness function. Correlation coefficient will be used in prediction, once sign has been
		//determined. Solutions must predict sign of daily change correctly to be considered feasible phenotypes. 

	}

	public void initLargeCapRef(){
		largeCap = new String[25];
		
		largeCap[0] = "AAPL";
		largeCap[1] = "AMGN";
		largeCap[2] = "AMZN";
		largeCap[3] = "BBRY";
		largeCap[4] = "CELG";
		largeCap[5] = "CMCSA";
		largeCap[6] = "COST";
		largeCap[7] = "CSCO";
		largeCap[8] = "DELL";
		largeCap[9] = "DTV";
		largeCap[10] = "EBAY";
		largeCap[11] = "ERIC";
		largeCap[12] = "ESRX";
		largeCap[13] = "GILD";
		largeCap[14] = "GOOG";
		largeCap[15] = "INFY";
		largeCap[16] = "INTC";
		largeCap[17] = "LMCA";
		largeCap[18] = "MITSY";
		largeCap[19] = "MSFT";
		largeCap[20] = "NWSA";
		largeCap[21] = "ORCL";
		largeCap[22] = "QCOM";
		largeCap[23] = "TEVA";
		largeCap[24] = "VOD";
		
	}
	
	

public void initSmallCapRef(){
	smallCap = new String[18];
	
	smallCap[0] = "AAON";
	smallCap[1] = "AAVL";
	smallCap[2] = "ABMD";
	smallCap[3] = "ACOR";
	smallCap[4] = "ADTN";
	smallCap[5] = "AINV";
	smallCap[6] = "ALOG";
	smallCap[7] = "AMBA";
	smallCap[8] = "AMBC";
	smallCap[9] = "AMKR";
	smallCap[10] = "ANAC";
	smallCap[11] = "ARCB";
	smallCap[12] = "ARIA";
	smallCap[13] = "ATRO";
	smallCap[14] = "AUXL";
	smallCap[15] = "AVHI";
	smallCap[16] = "SHLM";
	smallCap[17] = "XLRN";
}
	
	
}
