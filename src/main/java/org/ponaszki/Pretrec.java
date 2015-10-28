package org.ponaszki;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.ponaszki.VatCounter;
/**
 * Hello world!
 *
 */
public class Pretrec 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println( "OEO!!"+ "Chujjjjjj" );
        BigDecimal kwota = new BigDecimal(Integer.toString(1000));
//        BigDecimal stawkaVat = new BigDecimal();
        VatCounter vc = new VatCounter(kwota, kwota);
        BigDecimal netto = vc.ileWatu(kwota, kwota);
        
        System.out.println("Kwota netto: " + netto);
    }
}
