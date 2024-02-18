package com.eduwise.eduwise.controller.paymentController;

import com.eduwise.eduwise.gateway.PaymentGateway;
import com.eduwise.eduwise.model.paymentModel.reponse.PaymentResponse;
import com.eduwise.eduwise.model.paymentModel.request.PaymentRequest;
import com.eduwise.eduwise.model.paymentModel.request.ProviderOnePaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentGateway<PaymentResponse, PaymentRequest> paymentGateway;

    @PostMapping("/pay")
    public ResponseEntity<PaymentResponse> processPayment(@RequestBody ProviderOnePaymentRequest paymentRequest) {
        return ResponseEntity.ok(paymentGateway.makePayment(paymentRequest));
    }

}
