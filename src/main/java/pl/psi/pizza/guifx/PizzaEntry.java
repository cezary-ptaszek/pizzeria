package pl.psi.pizza.guifx;

import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PizzaEntry extends HBox{

    BigDecimal prize;

    public PizzaEntry(String aText, BigDecimal prize) {
        this.prize = prize;

        MainController.lButtons = new ArrayList<>();
        RadioButton button = new RadioButton(aText + " " + prize);
        button.setToggleGroup(MainController.group);
        if(!MainController.isChecked){
            button.setSelected(true);
            MainController.isChecked = true;
        }
        getChildren().add(button);
    }

}
