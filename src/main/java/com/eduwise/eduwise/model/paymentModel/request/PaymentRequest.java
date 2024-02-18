package com.eduwise.eduwise.model.paymentModel.request;

import com.eduwise.eduwise.model.paymentModel.constant.PaymentProviderType;

public abstract class PaymentRequest {
    // any common fields
    public abstract PaymentProviderType getPaymentProviderType();
}
