package com.eduwise.eduwise.model.paymentModel.request;

import com.eduwise.eduwise.model.paymentModel.constant.PaymentProviderType;

public class ProviderTwoPaymentRequest extends PaymentRequest {

    @Override
    public PaymentProviderType getPaymentProviderType() {
        return PaymentProviderType.PROVIDER_TWO;
    }

}