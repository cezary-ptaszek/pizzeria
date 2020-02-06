package pl.psi.pizza.guifx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import pl.psi.pizza.menu.ItalianPiePizzaMenu;
import pl.psi.pizza.model.AmericanPiePizza;
import pl.psi.pizza.model.ItalianPiePizza;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private VBox centerBox;
    @FXML
    private Button confirmOrderButton;
    @FXML
    private Label orderPriceLabel;
    @FXML
    private ToggleGroup pieGroup;

    @FXML
    private void initialize() {
        orderPriceLabel.setText(" Tutaj powinny pojawić się zamówione pizze + cena ");
        pieGroup.selectedToggleProperty().addListener( (e) -> refreshMenu());
        refreshMenu();
    }

    private void refreshMenu(){
        centerBox.getChildren().clear();
        String selectedRationText = ((RadioButton) pieGroup.getSelectedToggle()).getText();
        if ("Na cienkim".equals(selectedRationText)) {
            ItalianPiePizzaMenu italianMenu = new ItalianPiePizzaMenu();
            for (ItalianPiePizza pizza: italianMenu.getPizzasList() ) {
                centerBox.getChildren().add(new PizzaEntry(pizza.getName()));
            }
        } else if ("Na grubym".equals(selectedRationText)) {
            AmericanPiePizza americanMenu = new AmericanPiePizza();
            for (String pizza: americanMenu.getPizzasList() ) {
                centerBox.getChildren().add(new PizzaEntry(pizza));
            }
        }
    }
}
