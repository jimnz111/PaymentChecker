import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import au.com.fis.devtest.Payment;
import au.com.fis.devtest.rest.PaymentCheckerService;


public class WhenCallingPaymentCheckerService {

	
	private PaymentCheckerService pcs;
	
	@Mock private Payment mockPaymentEngine;
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		pcs = new PaymentCheckerService(mockPaymentEngine);
	}
	
	
	@Test
	public void shouldReturnBADForNullCardNumber() {
		Assert.assertThat(pcs.checkAccountNumber(null), Matchers.is("BAD"));
	}
	
}
