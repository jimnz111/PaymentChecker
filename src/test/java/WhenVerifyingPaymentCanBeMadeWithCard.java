import java.time.YearMonth;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import au.com.fis.devtest.DefaultPaymentEngine;


public class WhenVerifyingPaymentCanBeMadeWithCard {

	private DefaultPaymentEngine dpe;
	
	private static final String VALID_CARD_PAN="1234560000004373";
	private YearMonth now;

	@Before
	public void setup() {
		dpe = new DefaultPaymentEngine();
		
		now = YearMonth.now();
	}
	
	
	@Test
	public void shouldReturnTrueForValidCardWithExpiryThisMonth() {
		Assert.assertThat(dpe.canMakePaymentWithCard(VALID_CARD_PAN, now.getMonthValue(), now.getYear()), Matchers.is(true));
	}

	@Test
	public void shouldReturnTrueForValidCardWithExpiryNextMonth() {
		Assert.assertThat(dpe.canMakePaymentWithCard(VALID_CARD_PAN, now.getMonthValue() + 1, now.getYear()), Matchers.is(true));
	}
	
	@Test
	public void shouldReturnFalseForValidCardWithExpiryLastMonth() {
		Assert.assertThat(dpe.canMakePaymentWithCard(VALID_CARD_PAN, now.getMonthValue()-1, now.getYear()), Matchers.is(false));
	}

	@Test
	public void shouldReturnFalseForNullCardNumber() {
		Assert.assertThat(dpe.canMakePaymentWithCard(null,  0,  0), Matchers.is(false));
	}

	@Test
	public void shouldReturnFalseForInvalidCardNumber() {
		Assert.assertThat(dpe.canMakePaymentWithCard("1231",  0,  0), Matchers.is(false));
	}
	
	@Test
	public void shouldReturnFalseForCardNumberTooShort() {
		Assert.assertThat(dpe.canMakePaymentWithCard("1",  0,  0), Matchers.is(false));
	}
	
	
}
