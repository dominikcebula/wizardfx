package pl.dominikcebula.tools.wizardfx.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OrderWizardFxExample extends Application
{
    public static void main(String... args)
    {
        Application.launch(OrderWizardFxExample.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("wizardfx-example.fxml"))));

        primaryStage.setHeight(400);
        primaryStage.setWidth(400);
        primaryStage.show();
    }
}
