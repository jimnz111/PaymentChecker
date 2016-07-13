package au.com.fis.devtest;

import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

public class DefaultPaymentEngine implements Payment {

	public boolean isCardNumberValid(String cardNumber) {
		
		if (cardNumber == null) { 
			return false;
		}
		
		if (!cardNumber.matches("[0-9]{16}")) {
			return false;
		}
		
		return new Mod10Checker().isMod10(cardNumber);
	}

	
	public boolean isValidPaymentAmount(long amount) {
		return amount > 99 && amount <= 99999999 ;
	}

	public boolean canMakePaymentWithCard(String cardNumber, int expiryMonth, int expiryYear) {
		if (isCardNumberValid(cardNumber)) {
			YearMonth now = YearMonth.now();
			YearMonth expiry = YearMonth.of(expiryYear, expiryMonth);
			return expiry.compareTo(now) >= 0;
		}	
		return false;
	}

}
