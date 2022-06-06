package pl.rpow.sales;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentData {
    String paymentId;
    String reservationId;
    String url;
}
