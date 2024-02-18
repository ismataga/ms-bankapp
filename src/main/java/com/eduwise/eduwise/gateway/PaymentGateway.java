package com.eduwise.eduwise.gateway;

import com.eduwise.eduwise.model.paymentModel.reponse.PaymentResponse;
import com.eduwise.eduwise.model.paymentModel.request.PaymentRequest;

public interface PaymentGateway<T extends PaymentResponse, K extends PaymentRequest> {
    T makePayment(K paymentRequest);
}
