package com.eduwise.eduwise.model.paymentModel.reponse;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PaymentResponse {
    @Builder.Default
    private String someText = "someText";
}
