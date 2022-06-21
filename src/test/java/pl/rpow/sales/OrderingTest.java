package pl.rpow.sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.rpow.sales.cart.CartStorage;
import pl.rpow.sales.offer.Offer;
import pl.rpow.sales.offer.OfferNotMatchedException;
import pl.rpow.sales.payment.DummyPaymentGateway;
import pl.rpow.sales.payment.PaymentData;
import pl.rpow.sales.products.ListProductDetailsProvider;
import pl.rpow.sales.products.ProductDetails;
import pl.rpow.sales.reservation.Reservation;
import pl.rpow.sales.reservation.ReservationStorage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OrderingTest {

    private List<ProductDetails> products;
    private ReservationStorage reservationStorage;

    @BeforeEach
    void setUp() {
        products = new ArrayList<>();
        reservationStorage = new ReservationStorage();
    }

    @Test
    void itAllowsToOrderCollectedProducts() {
        //Given // Arrange
        String productId = thereIsExampleProduct();
        Sales sales = thereIsSalesModule();
        String customerId = thereIsCustomer();
        sales.addToCart(customerId, productId);
        Offer seenOffer = sales.getCurrentOffer(customerId);

        //when //act
        PaymentData payment = sales.acceptOffer(customerId, exampleCustomerData());

        //then // assert
        String reservationId = payment.getReservationId();
        assertNotNull(payment.getUrl());
        assertNotNull(reservationId);
        thereIsPendingReservationWithId(reservationId);
    }

    private void thereIsPendingReservationWithId(String reservationId) {
        Optional<Reservation> optionalReservation = reservationStorage.find(reservationId);

        assertTrue(optionalReservation.isPresent());
    }

    void dennayPurchaseWhenOfferDifferentThenSeenOffer() {
        String productId = thereIsExampleProduct();
        Sales sales = thereIsSalesModule();
        String customerId = thereIsCustomer();
        sales.addToCart(customerId, productId);
        Offer seenOffer = sales.getCurrentOffer(customerId);
        Offer newOffer = Offer.of(BigDecimal.valueOf(1000), 1);
        //when

        assertThrows(OfferNotMatchedException.class, () -> {
            sales.acceptOffer(
                    customerId,
                    exampleCustomerData());
        });
    }

    private String thereIsExampleProduct() {
        String productId = "123";
        products.add(new ProductDetails(
                productId,
                "Lego",
                BigDecimal.valueOf(10.10)));
        return productId;
    }

    private Sales thereIsSalesModule() {
        return new Sales(
                new CartStorage(),
                new ListProductDetailsProvider(products),
                new DummyPaymentGateway(),
                reservationStorage
        );
    }

    private String thereIsCustomer() {
        return "Kuba";
    }

    private ClientData exampleCustomerData() {
        return ClientData.builder()
                .firstname("John")
                .lastname("Doe")
                .email("john@doe.pl")
                .build();
    }
}
