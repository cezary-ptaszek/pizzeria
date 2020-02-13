package pl.psi.pizza.guifx;

import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;

import java.math.BigDecimal;

import static pl.psi.pizza.guifx.MainController.group;
import static pl.psi.pizza.guifx.MainController.isChecked;

public class PizzaEntry extends HBox{

    BigDecimal prize;

    public PizzaEntry(String aText, BigDecimal prize) {
        this.prize = prize;

        RadioButton button = new RadioButton(aText + " " + prize);
        button.setToggleGroup(group);
        if(!isChecked){
            button.setSelected(true);
            isChecked = true;
        }
        getChildren().add(button);
    }

}
