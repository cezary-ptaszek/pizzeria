package pl.psi.pizza.menu;

import pl.psi.pizza.model.ItalianPiePizza;

import java.util.ArrayList;
import java.util.List;

public class ItalianPiePizzaMenu {

    public List<ItalianPiePizza> getPizzasList() {
        ArrayList<ItalianPiePizza> pizzas = new ArrayList<>();
        pizzas.add(new ItalianPiePizza("MARGERITTA", "Sos pomidorowy, mozzarella", 13.50));
        pizzas.add(new ItalianPiePizza("MARINARA", "Sos pomidorowy, mozzarella, czosnek", 14.40));
        pizzas.add(new ItalianPiePizza("NAPOLETANA", "Sos pomidorowy, mozzarella, czarne oliwki", 16.50));
        pizzas.add(new ItalianPiePizza("HAWAJSKA", "Sos pomidorowy, mozzarella, ananas", 14.40));
        pizzas.add(new ItalianPiePizza("FUNGHI", "Sos pomidorowy, mozzarella, pieczarki", 14.10));
        pizzas.add(new ItalianPiePizza("QUATRO STAGIONI", "Sos pomidorowy, mozzarella, szynka, karczochy, papryka", 18.20));
        pizzas.add(new ItalianPiePizza("CAPRICCIOSA", "Sos pomidorowy, mozzarella, szynka, pieczarki", 16.80));
        pizzas.add(new ItalianPiePizza("DINAMITE", "Sos pomidorowy, mozzarella, salami pikantne", 15.10));
        return pizzas;
    }
}
