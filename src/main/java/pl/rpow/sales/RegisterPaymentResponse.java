package pl.rpow.sales;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterPaymentResponse {
    String id;
    String url;
}
