package org.ponaszki;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

import org.ponaszki.VatCounter;
/**
 * Hello world!
 *
 */
public class Pretrec 
{
	
	public BigDecimal summarize(ArrayList<HashMap<String, String>> data){
		BigDecimal sum = new BigDecimal("0");
		sum.setScale(2, BigDecimal.ROUND_HALF_UP);
		for (HashMap<String, String> hashMap : data) {
			String val =hashMap.get("amount");
			BigDecimal bd = new BigDecimal( val);
			sum.add(bd);
		}
		return sum;
		
	}
	
    public static void main( String[] args )
    {
    	System.out.println("Sciezka:  " + args[0]);
        if(args.length ==1){

	        FileParser fp = new FileParser();
	        ArrayList<HashMap<String, String>> data =fp.readFile(new String(args[0]));
	        Pretrec pr = new Pretrec();
	        BigDecimal result = pr.summarize(data);

	        System.out.println("Suma " + result);
        }else{
        	System.out.println("musisz podac jeden argument (sciezka do pliku)");
        }
    }
}
