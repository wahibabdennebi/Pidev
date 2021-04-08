package tp.spring.boot.piedvdari;

public class PaymentIntentDto {
	public enum Currency{
        usd, eur;
    }

    private String description;
    private Long amount;
    private Currency currency;
	public String getDescription() {
		return description;
	}
	public Long getAmount() {
		return amount;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
