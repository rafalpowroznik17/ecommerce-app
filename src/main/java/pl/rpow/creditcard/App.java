package pl.rpow.creditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    NamesProvider create(NamesTransformer namesTransformer) {
        return new NamesProvider(namesTransformer);
    }

    @Bean
    NamesTransformer createNT(){
        return new NamesTransformer();
    }
}
