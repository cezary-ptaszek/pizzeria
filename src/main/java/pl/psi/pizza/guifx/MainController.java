package pl.psi.pizza.guifx;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {

    public static BigDecimal totalSum;
    public static ToggleGroup group;
    public static Boolean isChecked;
    public static String ingredients;
    public static BigDecimal ingredientsSum;
    private Integer num;
    private TextArea textArea;

    @FXML
    private ScrollPane scrollPaneBox;
    @FXML
    private VBox isStudentBox;
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
        num = 1;
        ingredients = "";
        ingredientsSum = new BigDecimal("0.0");
        textArea = new TextArea();
        textArea.setEditable(false);

        addPizzaButton.setText("DODAJ DO\n ZAMÓWIENIA");
        addPizzaButton.textAlignmentProperty().set(TextAlignment.CENTER);

        orderPriceLabel.setText("Witaj, wybierz to na co masz ochote! ");
        orderPriceLabel.setPadding(new Insets(10, 10, 10, 20));
        pieGroup.selectedToggleProperty().addListener( (e) -> refreshPizzaMenu());
        ingredientsMenu();
        refreshPizzaMenu();
    }

    private void refreshPizzaMenu(){
        pizzaBox.getChildren().clear();
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
    }

    private void ingredientsMenu(){
        IngredientsMenu ingredientsMenu = new IngredientsMenu();
        for (Ingredient ingredient : ingredientsMenu.getIngredientsList()) {
            ingredientsBox.getChildren().add(new IngredientsEntry(ingredient.getName(), ingredient.getPrice()));
        }
    }

    @FXML
    private void addPizzaButtonAction(){
        String selectedRadioButton = ((RadioButton) group.getSelectedToggle()).getText();

        Pattern patternPrice = Pattern.compile("\\d\\d\\.\\d\\d");
        Matcher matcherPrice = patternPrice.matcher(selectedRadioButton);
        BigDecimal price = new BigDecimal("0");
        if (matcherPrice.find()) {
            price = new BigDecimal(matcherPrice.group(0));
            totalSum = totalSum.add(price);
        }
        totalSum = totalSum.add(ingredientsSum);

        Pattern patternPizza = Pattern.compile("[A-Z]+\\s?[A-Z]+");
        Matcher matcherPizza = patternPizza.matcher(selectedRadioButton);
        if (matcherPizza.find()){
            addToScrollPaneBox(matcherPizza.group(0), price, ingredients);
        }

        setTotalPrize();
        new MaybeNextPizzaStage();
    }

    @FXML
    private void confirmOrderAction(){
    }

    @FXML
    private void setTotalPrize(){
        totalPrice.setText(totalSum + "zł");
    }

    private void addToScrollPaneBox(String pizza, BigDecimal priceOfPizza, String ingr){
        String string = num.toString();

        if(ingr.equals(""))
            string += (". " + pizza + "\t" + priceOfPizza + "zł\n");
        else
            string += (". " + pizza + "\t" + priceOfPizza + "zł\n\t" + ingr + "\t" + ingredientsSum + "zł\n");

        textArea.appendText(string);
        scrollPaneBox.setContent(textArea);

        num++;
    }
}
