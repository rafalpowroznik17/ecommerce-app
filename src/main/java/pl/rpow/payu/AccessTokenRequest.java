package pl.rpow.payu;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccessTokenRequest {
    private final String client_credentials;
    private final String client_id;
    private final String client_secret;
}

