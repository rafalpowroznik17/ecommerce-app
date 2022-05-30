package pl.rpow.sales;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientData {
    String firstname;
    String lastname;
    String email;
}
