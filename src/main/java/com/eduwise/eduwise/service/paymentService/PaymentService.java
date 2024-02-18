package com.eduwise.eduwise.service.paymentService;

import com.eduwise.eduwise.model.paymentModel.reponse.PaymentResponse;
import com.eduwise.eduwise.model.paymentModel.request.PaymentRequest;
import org.springframework.stereotype.Component;

public interface PaymentService<T extends PaymentRequest, R extends PaymentResponse> {
    R pay(T request);
}

