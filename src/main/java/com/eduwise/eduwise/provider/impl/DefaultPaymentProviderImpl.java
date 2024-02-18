package com.eduwise.eduwise.provider.impl;

import com.eduwise.eduwise.model.paymentModel.constant.PaymentProviderType;
import com.eduwise.eduwise.model.paymentModel.reponse.PaymentResponse;
import com.eduwise.eduwise.model.paymentModel.request.PaymentRequest;
import com.eduwise.eduwise.provider.PaymentProvider;
import com.eduwise.eduwise.service.paymentService.PaymentService;
import com.eduwise.eduwise.service.paymentService.impl.ProviderOnePaymentServiceImpl;
import com.eduwise.eduwise.service.paymentService.impl.ProviderThreePaymentServiceImpl;
import com.eduwise.eduwise.service.paymentService.impl.ProviderTwoPaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultPaymentProviderImpl implements PaymentProvider<PaymentService<PaymentRequest, PaymentResponse>> {
    private final ApplicationContext applicationContext;

    @Override
    @SuppressWarnings("rawtypes")
    public PaymentService getProvider(PaymentProviderType type) {
        switch (type) {
            case PROVIDER_ONE:
                return applicationContext.getBean(ProviderOnePaymentServiceImpl.class);
            case PROVIDER_TWO:
                return applicationContext.getBean(ProviderTwoPaymentServiceImpl.class);
            case PROVIDER_THREE:
                return applicationContext.getBean(ProviderThreePaymentServiceImpl.class);
            default:
                throw new UnsupportedOperationException("Notification type: " + type + " not supported");
        }
    }

}
