package com.eduwise.eduwise.service.paymentService.impl;

import com.eduwise.eduwise.model.paymentModel.reponse.ProviderOnePaymentResponse;
import com.eduwise.eduwise.model.paymentModel.request.ProviderOnePaymentRequest;
import com.eduwise.eduwise.service.paymentService.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class ProviderOnePaymentServiceImpl implements PaymentService<ProviderOnePaymentRequest, ProviderOnePaymentResponse> {

    @Override
    public ProviderOnePaymentResponse pay(ProviderOnePaymentRequest request) {
        // To do payment logic with provider 1 ...
        return new ProviderOnePaymentResponse();
    }

}
