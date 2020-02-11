package pl.psi.pizza.guifx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import pl.psi.pizza.menu.PizzaPieMenu;
import pl.psi.pizza.model.PizzaPie;

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
            PizzaPieMenu italianMenu = new PizzaPieMenu();
            for (PizzaPie pizza: italianMenu.getItalianPizzasList() ) {
                centerBox.getChildren().add(new PizzaEntry(pizza.getName() + " " + pizza.getPrice()));
            }
        } else if ("Na grubym".equals(selectedRationText)) {
            PizzaPieMenu americanMenu = new PizzaPieMenu();
            for (PizzaPie pizza: americanMenu.getAmericanPizzasList() ) {
                centerBox.getChildren().add(new PizzaEntry(pizza.getName() + " " + pizza.getPrice()));
            }
        }
    }
}
