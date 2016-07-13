import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import au.com.fis.devtest.Mod10Checker;




public class WhenCalculatingMod10CheckDigit {

	private Mod10Checker mod10Checker;
	
	@Before
	public void setup() {
		mod10Checker = new Mod10Checker(); 
	}

	@Test
	public void shouldReturnFalseForNullCardNumber() {
		Assert.assertThat(mod10Checker.isMod10(null),  Matchers.is(false));
	}

	@Test
	public void shouldReturnFalseForValueLessThan2Characters() {
		Assert.assertThat(mod10Checker.isMod10("1"),  Matchers.is(false));
	}

	@Test
	public void shouldReturnTrueForValidCardNumber() {
		Assert.assertThat(mod10Checker.isMod10("79927398713"), Matchers.is(true));
		Assert.assertThat(mod10Checker.isMod10("1234560000004373"), Matchers.is(true));
	}
	
}