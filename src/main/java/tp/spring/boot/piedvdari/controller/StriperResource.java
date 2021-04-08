package tp.spring.boot.piedvdari.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import tp.spring.boot.piedvdari.PaymentIntentDto;
import tp.spring.boot.piedvdari.service.PaymentService;

@RestController
@RequestMapping("/stripe")
public class StriperResource {
	 @Autowired
	    PaymentService paymentService;
	 
	 @PostMapping("/paymentintent/{int id_furniture}")
	    public ResponseEntity<String> payment(@PathVariable("int id_furniture") int id) throws StripeException {
	        PaymentIntent paymentIntent = paymentService.paymentIntent(id);
	        String paymentStr = paymentIntent.toJson();
	        return new ResponseEntity<String>(paymentStr, HttpStatus.OK);
	    }

	    @PostMapping("/confirm/{id}")
	    public ResponseEntity<String> confirm(@PathVariable("id") String id) throws StripeException {
	        PaymentIntent paymentIntent = paymentService.confirm(id);
	        String paymentStr = paymentIntent.toJson();
	        return new ResponseEntity<String>(paymentStr, HttpStatus.OK);
	    }

	    @PostMapping("/cancel/{id}")
	    public ResponseEntity<String> cancel(@PathVariable("id") String id) throws StripeException {
	        PaymentIntent paymentIntent = paymentService.cancel(id);
	        String paymentStr = paymentIntent.toJson();
	        return new ResponseEntity<String>(paymentStr, HttpStatus.OK);
	    }
	 
}
