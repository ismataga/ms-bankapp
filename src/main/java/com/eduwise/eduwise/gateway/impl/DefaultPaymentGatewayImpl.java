package com.eduwise.eduwise.gateway.impl;

import com.eduwise.eduwise.gateway.PaymentGateway;
import com.eduwise.eduwise.model.paymentModel.reponse.PaymentResponse;
import com.eduwise.eduwise.model.paymentModel.request.PaymentRequest;
import com.eduwise.eduwise.provider.PaymentProvider;
import com.eduwise.eduwise.service.paymentService.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultPaymentGatewayImpl implements PaymentGateway<PaymentResponse, PaymentRequest> {
    private final PaymentProvider<PaymentService<PaymentRequest, PaymentResponse>> paymentProvider;

    @Override
    public PaymentResponse makePayment(PaymentRequest paymentRequest) {
        return paymentProvider.getProvider(paymentRequest.getPaymentProviderType()).pay(paymentRequest);
    }

}