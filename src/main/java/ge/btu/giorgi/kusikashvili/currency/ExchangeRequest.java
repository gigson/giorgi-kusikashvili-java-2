package ge.btu.giorgi.kusikashvili.currency;


public class ExchangeRequest {

	private String currency;

	private double amount;

	public String getCurrency() {
		return currency;
	}

	public double getAmount() {
		return amount;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
