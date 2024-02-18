package com.eduwise.eduwise.service.paymentService.impl;

import com.eduwise.eduwise.model.paymentModel.reponse.ProviderTwoPaymentResponse;
import com.eduwise.eduwise.model.paymentModel.request.ProviderTwoPaymentRequest;
import com.eduwise.eduwise.service.paymentService.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class ProviderTwoPaymentServiceImpl implements PaymentService<ProviderTwoPaymentRequest, ProviderTwoPaymentResponse> {

    @Override
    public ProviderTwoPaymentResponse pay(ProviderTwoPaymentRequest request) {
        // To do payment logic with provider 2 ...
        return new ProviderTwoPaymentResponse();
    }

}
