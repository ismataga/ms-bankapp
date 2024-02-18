package com.eduwise.eduwise.provider;

import com.eduwise.eduwise.model.paymentModel.constant.PaymentProviderType;

public interface PaymentProvider<T> {
    T getProvider(PaymentProviderType type);
}