package pl.jkanclerz.sales;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RegisterPaymentRequest {
    String reservationId;
    BigDecimal total;
    String firstname;
    String lastname;
    String email;
}
