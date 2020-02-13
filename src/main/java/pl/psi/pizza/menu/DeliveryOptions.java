package pl.psi.pizza.menu;

import pl.psi.pizza.model.Delivery;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DeliveryOptions {
    public List<Delivery> getDeliveryList() {
        ArrayList<Delivery> delivery = new ArrayList<>();
        delivery.add(new Delivery("Grunwald", new BigDecimal("4.00")));
        delivery.add(new Delivery("Stare miasto", new BigDecimal("5.00")));
        delivery.add(new Delivery("Wilda", new BigDecimal("5.00")));
        delivery.add(new Delivery("Jeżyce", new BigDecimal("5.00")));
        delivery.add(new Delivery("Nowe miasto", new BigDecimal("6.00")));
        return delivery;
    }
}
