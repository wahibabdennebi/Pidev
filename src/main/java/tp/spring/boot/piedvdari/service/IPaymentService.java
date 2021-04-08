package tp.spring.boot.piedvdari.service;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import tp.spring.boot.piedvdari.PaymentIntentDto;

public interface IPaymentService {
	public PaymentIntent paymentIntent(int id_furniture) throws StripeException;
	public PaymentIntent confirm(String id) throws StripeException;
	 public PaymentIntent cancel(String id) throws StripeException;
	 public void creatCustmer (int id)throws StripeException;
	 public void addCardCustomer () throws StripeException;
	 public void chargeCustomer()throws StripeException;
}
