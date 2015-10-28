package org.ponaszki;

import java.math.BigDecimal;

public class VatCounter {
	public String VAT_9 = "0.09";
	private BigDecimal kwota;
	private BigDecimal stawkaVat;
	public VatCounter(BigDecimal kwota, BigDecimal stawkaVat) {
		this.kwota = kwota;
		this.stawkaVat = stawkaVat;
	}
	
	public BigDecimal ileWatu(BigDecimal kwotaNetto, BigDecimal stawkaVat){
		BigDecimal vat = kwota.multiply(stawkaVat);
		return vat;
	}
	public BigDecimal ileBrutto(BigDecimal kwotaNetto, BigDecimal stawkaVat){
		BigDecimal brutto = kwotaNetto.multiply(stawkaVat).add(kwotaNetto);
		brutto.setScale(2, BigDecimal.ROUND_HALF_UP);
		return brutto;
	}
}
