import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import au.com.fis.devtest.DefaultPaymentEngine;


public class WhenDefaultPaymentEngineChecksCardNumberValid {

	
	private DefaultPaymentEngine dpe;

	@Before
	public void setup() {
		dpe = new DefaultPaymentEngine();
	}
	
	
	@Test
	public void shouldReturnFalseForNullCardNumber() {
		Assert.assertThat(dpe.isCardNumberValid(null), Matchers.is(false));
	}

	@Test
	public void shouldReturnFalseForCardNumberWithNonNumerics() {
		Assert.assertThat(dpe.isCardNumberValid("A"), Matchers.is(false));
	}
	
	@Test
	public void shouldReturnFalseForCardNumberWithLessThan16Digits() {
		Assert.assertThat(dpe.isCardNumberValid("123456789012345"), Matchers.is(false));
	}
	
	@Test
	public void shouldReturnFalseForCardNumberWithMoreThan16Digits() {
		Assert.assertThat(dpe.isCardNumberValid("12345678901234567"), Matchers.is(false));
	}
	
	@Test
	public void shouldReturnTrueForMod10ValidatedCardNumber() {
		Assert.assertThat(dpe.isCardNumberValid("1234560000004373"), Matchers.is(true));
	}
	
	
}