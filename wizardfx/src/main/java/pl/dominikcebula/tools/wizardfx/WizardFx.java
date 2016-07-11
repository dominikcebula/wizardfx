package pl.dominikcebula.tools.wizardfx;

import java.io.IOException;

import javafx.beans.DefaultProperty;
import javafx.collections.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import pl.dominikcebula.tools.wizardfx.step.Step;

import static javafx.collections.FXCollections.observableArrayList;

@DefaultProperty("steps")
public class WizardFx extends BorderPane
{
   private final ObservableList<Step> steps = observableArrayList();
   private WizardFxController controller = new WizardFxController();

   public WizardFx() throws IOException
   {
      getStylesheets().add(getClass().getResource("wizardfx.css").toExternalForm());

      setLeft(load("wizardfx-step-list.fxml", controller));
      setCenter(load("wizardfx-step-content.fxml", controller));
      steps.addListener(this::stepsChanged);
   }

   private <T> T load(String fxml, WizardFxController controller) throws IOException
   {
      FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
      loader.setController(controller);
      return loader.load();
   }

   private void stepsChanged(ListChangeListener.Change<? extends Step> event)
   {
      while (event.next())
      {
         event.getAddedSubList().forEach(controller::addStep);
      }
   }

   @SuppressWarnings("unused")
   public ObservableList<Step> getSteps()
   {
      return steps;
   }
}
