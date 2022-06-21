package pl.rpow.sales.payment;

public interface PaymentGateway {

    RegisterPaymentResponse handle(RegisterPaymentRequest registerPaymentRequest);
}
