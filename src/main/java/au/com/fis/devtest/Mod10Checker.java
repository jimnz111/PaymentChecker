package au.com.fis.devtest;

/**
 * Uses the standard Luhn algorithm to calculate the check
 * digit for card number
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Luhn_algorithm">Wikipedia</a>
 * for more information
 * 
 * @author James Bushell (e1069023)
 *
 */
public class Mod10Checker {

	
	public boolean isMod10(String number) {
		
		if (!isValidNumber(number)) {
			return false;
		}
		
		int digitSum = getModChecksum(number);
		int checkDigit = digitSum % 10;
		return checkDigit == (number.charAt(number.length()-1) - '0');
	}
	
	public int getModChecksum(String number) {
		
		//4988720000004375
		//2121212121212121
        //897852000000835		  
		
		if (!isValidNumber(number)) {
			return -1;
		}
		int digitSum = 0;
		final byte[] numberBytes = number.getBytes();
		for (int a=(numberBytes.length-2), b=0; a > -1; a--, b++) {
			int val = numberBytes[a] - '0';
			if ((b % 2) == 0) {
				digitSum += (val > 4 ? val * 2 - 9 : val * 2); 
			} else {
				digitSum += val;
			}
		}
		return digitSum * 9;
	}
	
	public boolean isValidNumber(String number) {
		if (number  == null || number.length() == 1) {
			return false;
		}

		if (!number.matches("[0-9]+")) {
			return false;
		}
		
		return true;
	}
}
