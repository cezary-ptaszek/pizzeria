package pl.psi.pizza.guifx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import pl.psi.pizza.menu.IngredientsMenu;
import pl.psi.pizza.menu.PizzaPieMenu;
import pl.psi.pizza.model.Ingredient;
import pl.psi.pizza.model.PizzaPie;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MainController {

    public static BigDecimal totalSum;
    public static ToggleGroup group;
    public static ArrayList<RadioButton> lButtons;
    public static Boolean isChecked;

    @FXML
    private VBox pizzaBox;
    @FXML
    private VBox ingredientsBox;
    @FXML
    private Label orderPriceLabel;
    @FXML
    private Label totalPrice;
    @FXML
    private ToggleGroup pieGroup;
    @FXML
    private Button addPizzaButton;

    @FXML
    private void initialize() {
        totalSum = new BigDecimal("0");
        group = new ToggleGroup();
        lButtons = new ArrayList<>();

        addPizzaButton.setText("DODAJ DO\n ZAMÓWIENIA");
        addPizzaButton.textAlignmentProperty().set(TextAlignment.CENTER);

        orderPriceLabel.setText("Witaj, wybierz to na co masz ochote! ");
        orderPriceLabel.setPadding(new Insets(10, 10, 10, 20));
        pieGroup.selectedToggleProperty().addListener( (e) -> refreshMenu());
        ingredientsMenu();
        refreshMenu();
    }

    private void refreshMenu(){
        pizzaBox.getChildren().clear();
        lButtons.clear();
        group.selectToggle(null);

        pizzaBox.setPadding(new Insets(10, 10, 10, 10));
        pizzaBox.setSpacing(5);
        isChecked = false;

        String selectedRationText = ((RadioButton) pieGroup.getSelectedToggle()).getText();
        if ("Na cienkim".equals(selectedRationText)) {
            PizzaPieMenu italianMenu = new PizzaPieMenu();
            for (PizzaPie pizza: italianMenu.getItalianPizzasList() ) {
                pizzaBox.getChildren().add(new PizzaEntry(pizza.getName(), pizza.getPrice()));
            }
        } else if ("Na grubym".equals(selectedRationText)) {
            PizzaPieMenu americanMenu = new PizzaPieMenu();
            for (PizzaPie pizza: americanMenu.getAmericanPizzasList() ) {
                pizzaBox.getChildren().add(new PizzaEntry(pizza.getName(), pizza.getPrice()));
            }
        }

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n)
            {
                if (group.getSelectedToggle() != null) {

                }
            }
        });
    }

    private void ingredientsMenu(){
        IngredientsMenu ingredientsMenu = new IngredientsMenu();
        for (Ingredient ingredient : ingredientsMenu.getIngredientsList()) {
            ingredientsBox.getChildren().add(new IngredientsEntry(ingredient.getName(), ingredient.getPrice()));
        }
    }

    @FXML
    private void addPizzaButtonAction(){

    }

    @FXML
    private void confirmOrderAction(){
    }

    @FXML
    public void setTotalPrize(BigDecimal price){
        totalPrice.setText(price + "zł");
    }
}
