package pl.psi.pizza.guifx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MaybeNextPizzaStage {

    private Button button;

    public MaybeNextPizzaStage(){
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setTitle("Info");
        button = new Button("OK");
        button.setOnAction(arg0 -> dialogStage.close());

        VBox vbox = new VBox(new Text("Może chcesz jeszcze jedną?\n"), button);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(15));

        dialogStage.setScene(new Scene(vbox));
        dialogStage.show();
    }
}
