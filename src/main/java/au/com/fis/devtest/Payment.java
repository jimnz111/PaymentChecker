package au.com.fis.devtest;

public interface Payment {

	/**
	 * Performs a Mod-10/LUHN check on the passed number and returns true if the passed
     * <param name="cardNumber">a valid 16 digit card number
     *
     * @return: true if the card number is valid, otherwise false</returns>
     * 
     * Refer here for MOD10 algorithm: https://en.wikipedia.org/wiki/Luhn_algorithm
     * 
     **/
    public boolean isCardNumberValid(String cardNumber);

    /**
     * Checks if the amount represents a valid payment amount
     * @param amount An amount value in cents (1 Dollar = 100 cents)
     * @return true if the amount is acceptable
     * 
     * Validation:
     * The amount must be between 99 cents and 99999999 cents
     */
    public boolean isValidPaymentAmount(long amount);

    
    /**
     * 
     * Validates the card number, expiry month and year to ensure the details can be used to make a payment
     * 
     * @param cardNumber A 16 digit card number
     * @param expiryMonth Month part of the expiry date
     * @param expiryYear Year part of the expiry date
     * @return true if the details represent a valid card, otherwise false
     * 
     * Validations:
     * cardNumber: Ensure the passed string is 16 in length and passes the MOD10/LUHN check
     * expiryMonth: should represent a month number between 1 and 12
     * expiryYear: Should represent a year value, 4 characters in length and either the current or a future year
     * The expiry month + year should represent a date in the future
     * 
     */
    public boolean canMakePaymentWithCard(String cardNumber, int expiryMonth, int expiryYear);
    
}