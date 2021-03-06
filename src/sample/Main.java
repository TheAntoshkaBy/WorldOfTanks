package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.Controllers.MenuController;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../sample/FXMLs/mainMenu.fxml"));
        Parent root = (Parent) loader.load();
        MenuController controller = loader.getController();

        Scene scene = new Scene(root, 1024, 600);
        primaryStage.setTitle("WORLD OF TANKS");
        scene.getStylesheets().add(getClass().getResource("../sample/CssFiles/Menu.css").toExternalForm());
        primaryStage.getIcons().addAll(new Image(getClass().getResourceAsStream("Images/WoT.png")));
        primaryStage.setScene(scene);
        MenuController menuController = new MenuController();
        menuController.setStage(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
