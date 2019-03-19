package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Game.Displays.MainGame;
import sample.Game.Displays.MultipleGame;
import sample.Game.Displays.RepeatGame;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    public static Stage stage;
    @FXML
    Button out;


    /**
     * Create a new window for the game action
     **/

    public void NewGame(ActionEvent actionEvent) throws Exception {
        Stage stage = new Stage();
        MainGame.getObject(0).start(stage);
    }

    public void Multipleer(ActionEvent actionEvent) throws Exception {
        Stage stage = new Stage();
        MultipleGame.getObject(1).start(stage);
    }

    public void Records(ActionEvent actionEvent) throws Exception {


/**Create a window for the record results**/
        Stage stage = new Stage();
        RepeatGame.getObject(0).start(stage);

    }

    public void setStage(Stage stage) {

        this.stage = stage;
        System.out.println(stage);
    }

    public void Settings(ActionEvent actionEvent) throws IOException {
       /* Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Game/FXML/Settings.fxml"));
        Parent root = (Parent) loader.load();
        Settings_Controller controller = loader.getController();
        Scene scene = new Scene(root,700, 700);
        scene.getStylesheets().add(getClass().getResource("../Menu/Css/Game_Style.css").toExternalForm());

        stage.setTitle("Results");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setHeight(400);
        stage.setWidth(615);


        controller.setStage(stage);
        stage.show();*/

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        out.setOnAction(event -> {
            System.out.println(stage);
            this.stage.close();
        });
    }
}