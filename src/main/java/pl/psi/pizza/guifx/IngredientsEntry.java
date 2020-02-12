package pl.psi.pizza.guifx;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

import java.math.BigDecimal;

public class IngredientsEntry extends VBox{

    BigDecimal prize;

    public IngredientsEntry(String Text, BigDecimal prize) {
        this.prize = prize;
        getChildren().add(new CheckBox(Text + " " + prize));
    }
}
