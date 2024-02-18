package com.eduwise.eduwise.service.paymentService.impl;

import com.eduwise.eduwise.model.paymentModel.reponse.ProviderThreePaymentResponse;
import com.eduwise.eduwise.model.paymentModel.request.ProviderThreePaymentRequest;
import com.eduwise.eduwise.service.paymentService.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class ProviderThreePaymentServiceImpl implements PaymentService<ProviderThreePaymentRequest, ProviderThreePaymentResponse> {

    @Override
    public ProviderThreePaymentResponse pay(ProviderThreePaymentRequest request) {
        // To do payment logic with provider 3 ...
        return new ProviderThreePaymentResponse();
    }

}
