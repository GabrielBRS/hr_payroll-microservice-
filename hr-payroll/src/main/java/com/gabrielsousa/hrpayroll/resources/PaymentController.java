package com.gabrielsousa.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielsousa.hrpayroll.entities.Payment;
import com.gabrielsousa.hrpayroll.services.PaymentService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
//	private final WebClient webClient;
//	private final ReactiveCircuitBreakerFactory reactiveCircuitBreakerFactory;

	@GetMapping("/{id}/days/{days}")
//	@TimeLimiter(name = "paymentController")
	@Retry(name="paymentController", fallbackMethod = "getDefaultPaymentList")
	public ResponseEntity<Payment> getPayment(@PathVariable Long id, @PathVariable Integer days) {
		Payment payment = paymentService.getPayment(id, days);
		return ResponseEntity.ok(payment);
	}

	public ResponseEntity<String> getDefaultPaymentList(Exception ex){
		return new ResponseEntity<String>("Não foi possível fazer a chamada do Pagamento", HttpStatus.OK);
	}
}
