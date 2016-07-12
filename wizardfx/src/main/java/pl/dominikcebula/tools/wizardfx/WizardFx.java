package pl.dominikcebula.tools.wizardfx;

import java.io.IOException;
import java.net.URL;

import javafx.beans.DefaultProperty;
import javafx.collections.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import pl.dominikcebula.tools.wizardfx.step.*;

import static javafx.collections.FXCollections.observableArrayList;

@DefaultProperty("steps")
public class WizardFx extends BorderPane
{
   private final ObservableList<Step> steps = observableArrayList();
   private WizardFxController wizardController = new WizardFxController();

   public WizardFx() throws IOException
   {
      getStylesheets().add(getClass().getResource("wizardfx.css").toExternalForm());

      setLeft(create("wizardfx-step-list.fxml", wizardController));
      setCenter(create("wizardfx-step-content.fxml", wizardController));
      steps.addListener(this::stepsChanged);
   }

   public static WizardFx create(URL fxml) throws IOException
   {
      return FXMLLoader.load(fxml);
   }

   private <T> T create(String fxml, WizardFxController controller) throws IOException
   {
      FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
      loader.setController(controller);
      return loader.load();
   }

   private void stepsChanged(ListChangeListener.Change<? extends Step> event)
   {
      while (event.next())
      {
         event.getAddedSubList().forEach(wizardController::addStep);
      }
   }

   @SuppressWarnings("unused")
   public ObservableList<Step> getSteps()
   {
      return steps;
   }

   @SuppressWarnings("unused")
   public String getModel()
   {
      return wizardController.getModel().getClass().getName();
   }

   @SuppressWarnings("unused")
   public Model getModelInstance()
   {
      return wizardController.getModel();
   }

   @SuppressWarnings("unused")
   public void setModel(String model) throws ClassNotFoundException, InstantiationException, IllegalAccessException
   {
      wizardController.setModel(model);
   }
}
