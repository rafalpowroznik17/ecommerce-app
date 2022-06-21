package pl.rpow.sales.offer;

import pl.rpow.sales.cart.Cart;
import pl.rpow.sales.cart.CartItem;

import java.math.BigDecimal;

public class OfferMaker {
    public Offer calculateOffer(Cart cart) {
        BigDecimal total = cart
                .getItems()
                .stream()
                .map(this::calculateLineTotal)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

        return Offer.of(total, cart.items.size());
    }

    private BigDecimal calculateLineTotal(CartItem cartItem) {
        return cartItem.getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity()));
    }
}
