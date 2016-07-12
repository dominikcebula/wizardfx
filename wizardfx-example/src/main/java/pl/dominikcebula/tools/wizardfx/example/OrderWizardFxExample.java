package pl.dominikcebula.tools.wizardfx.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.dominikcebula.tools.wizardfx.WizardFx;

public class OrderWizardFxExample extends Application
{
   public static void main(String... args)
   {
      Application.launch(OrderWizardFxExample.class, args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
      WizardFx wizard = WizardFx.create(getClass().getResource("order-wizard-example.fxml"));

      primaryStage.setScene(new Scene(wizard));
      primaryStage.setWidth(820);
      primaryStage.setHeight(500);
      primaryStage.show();
   }
}
