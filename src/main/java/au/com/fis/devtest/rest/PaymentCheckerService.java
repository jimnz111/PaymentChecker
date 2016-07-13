package au.com.fis.devtest.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import au.com.fis.devtest.DefaultPaymentEngine;
import au.com.fis.devtest.Mod10Checker;
import au.com.fis.devtest.Payment;

@Path("/payment")
public class PaymentCheckerService {

	private final Payment paymentEngine; 
	
	
	public PaymentCheckerService() {
		paymentEngine = new DefaultPaymentEngine();
	}
	
	public PaymentCheckerService(Payment paymentEngine) {
		this.paymentEngine = paymentEngine;
	}
	
	
	@GET
	@Path("/checkNumber")
	public String checkAccountNumber(
		@QueryParam("cardNumber") String cardNumber) {
		return paymentEngine.isCardNumberValid(cardNumber) ? "OK" : "BAD";
	}

	@GET
	@Path("/checkExpiry")
	public String checkAccountNumber(
		@QueryParam("cardNumber") String cardNumber,
		@QueryParam("expiryMonth") String month,
		@QueryParam("expiryYear") String year) {
		
		Mod10Checker checker = new Mod10Checker();
		if (!checker.isMod10(cardNumber)) {
			return "BAD";
		}
		if (month == null || !month.matches("[0-9]+")) {
			return "BAD";
		}
		if (year == null || !year.matches("[0-9]+")) {
			return "BAD";
		}
		
		final boolean canMakePayment = paymentEngine.canMakePaymentWithCard(cardNumber, Integer.parseInt(month), Integer.parseInt(year));
		return canMakePayment ? "OK" : "BAD";
	}

	@GET
	@Path("checkAmount")
	public String amountAcceptable(
		@QueryParam("amount") String amount) {

		if (amount == null || !amount.matches("[0-9]+")) {
			return "BAD";
		}
		
		try {
			Long.parseLong(amount);
		} catch (NumberFormatException e) {
			return "BAD";
		}
		
		final boolean amountAcceptable = paymentEngine.isValidPaymentAmount(Long.parseLong(amount));
		
		return amountAcceptable ? "OK" : "BAD";
	}
	
}
