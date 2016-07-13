import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import au.com.fis.devtest.DefaultPaymentEngine;


public class WhenDefaultPaymentEngineChecksAmount {

	private DefaultPaymentEngine dpe;
	
	@Before
	public void setup() {
		dpe = new DefaultPaymentEngine();
	}
	
	@Test
	public void shouldReturnFalseForAmountTooLow() {
		Assert.assertThat(dpe.isValidPaymentAmount(98),  Matchers.is(false));
	}
	
	@Test
	public void shouldReturnFalseForAmountTooHigh() {
		Assert.assertThat(dpe.isValidPaymentAmount(100000000),  Matchers.is(false));
	}
	
	
	
}
