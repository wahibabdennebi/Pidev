package tp.spring.boot.piedvdari.service;

import org.springframework.stereotype.Service;


import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.stripe.model.Token;

import tp.spring.boot.piedvdari.PaymentIntentDto;
import tp.spring.boot.piedvdari.PaymentIntentDto.Currency;
import tp.spring.boot.piedvdari.entities.Order;
import tp.spring.boot.piedvdari.repository.IOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PaymentService implements IPaymentService {
	@Value("${stripe.key.secret}")
    String secretKey;
	//paymentIntentDto.getAmount()
	//paymentIntentDto.getCurrency()
	//paymentIntentDto.getDescription()
	@Autowired
	IFornitureService fornitureService;
	 public PaymentIntent paymentIntent(int id_furniture) throws StripeException {
	        Stripe.apiKey = secretKey;
	        Customer a= Customer.retrieve("cus_JGCKifvBdr87iz");
	        
	        List<String> paymentMethodTypes = new ArrayList<String>();
	        paymentMethodTypes.add("card");
	        Map<String, Object> params = new HashMap<>();
	        Order order=fornitureService.addorder( id_furniture);
	    	PaymentIntentDto p= new PaymentIntentDto();
	    	p.setAmount(order.getFurniture().getPrice());
	    	p.setDescription(order.getFurniture().getTitre());
	    	p.setCurrency(Currency.eur);
	    	
	        params.put("amount",p.getAmount());
	        params.put("currency",p.getCurrency());
	        params.put("description",p.getDescription());
	        params.put("payment_method_types", paymentMethodTypes);
	        params.put("customer", a.getId());
	        return PaymentIntent.create(params);
	    }
	 
	 @Override
	 public PaymentIntent confirm(String id) throws StripeException {
	        Stripe.apiKey = secretKey;
	        Customer a= Customer.retrieve("cus_JGCKifvBdr87iz");
	        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
	        Map<String , Object> chargeParm= new HashMap<String , Object>();
			chargeParm.put("amount", paymentIntent.getAmount());
			chargeParm.put("currency", "usd");
			chargeParm.put("customer", a.getId());
			
			Charge.create(chargeParm);
	       // Map<String, Object> params = new HashMap<>();
	       // params.put("payment_method", "pm_card_visa");
	       // params.put("customer",a.getId());
	       // paymentIntent.confirm(params);
	        return paymentIntent;
	    }
	 @Override
	    public PaymentIntent cancel(String id) throws StripeException {
	        Stripe.apiKey = secretKey;
	        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
	        paymentIntent.cancel();
	        return paymentIntent;
	    }
	@Override
	public void creatCustmer(int id) throws StripeException {
		Stripe.apiKey = secretKey;
		Map<String, Object> params = new HashMap<>();
		params.put("email", "w@test1.com");
		Customer customer = Customer.create(params);
		System.out.println(customer.getId());
		
	}
	@Override
	public void addCardCustomer() throws StripeException {
		  Stripe.apiKey = secretKey;
		Customer a= Customer.retrieve("cus_JGCKifvBdr87iz");
		Map<String , Object> cardParam= new HashMap<String , Object>();
		cardParam.put("number", "4242424242424242");
		cardParam.put("exp_month", "11");
		cardParam.put("exp_year", "2022");
		cardParam.put("cvc", 123);
		
		Map<String , Object> tokenParm= new HashMap<String , Object>();
		tokenParm.put("card", cardParam);
		Token token= Token.create(tokenParm);
		Map<String , Object> source= new HashMap<String , Object>();
		source.put("source", token.getId());
		a.getSources().create(source);
	}
	@Override
	public void chargeCustomer() throws StripeException {
		Stripe.apiKey = secretKey;
		Customer a= Customer.retrieve("cus_JGCKifvBdr87iz");
		Map<String , Object> chargeParm= new HashMap<String , Object>();
		chargeParm.put("amount", "500");
		chargeParm.put("currency", "usd");
		chargeParm.put("customer", a.getId());
		
		Charge.create(chargeParm);
		
	}
	
}
