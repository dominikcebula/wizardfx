package pl.dominikcebula.tools.wizardfx.graph;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import pl.dominikcebula.tools.wizardfx.*;
import pl.dominikcebula.tools.wizardfx.step.*;

public class NodeFactory
{
   public Node createStep(Step step, NodeGraph nodeGraph, WizardFxController wizardController)
   {
      Controller controller = createController(step, nodeGraph, wizardController);

      return new Node(
         step,
         controller,
         createButtonForStep(controller, step),
         createContentForStep(controller, step)
      );
   }

   private Controller createController(Step step, NodeGraph nodeGraph, WizardFxController wizardController)
   {
      try
      {
         Controller controller = step.getController().newInstance();
         controller.setNodeGraph(nodeGraph);
         controller.setWizardController(wizardController);
         controller.initialize();
         return controller;
      }
      catch (InstantiationException | IllegalAccessException e)
      {
         throw new IllegalArgumentException(e.getMessage(), e);
      }
   }

   private Button createButtonForStep(Controller controller, Step step)
   {
      Button button = new Button(step.getName());
      button.setOnAction((e) -> controller.onMoveTo(step));
      return button;
   }

   private javafx.scene.Node createContentForStep(Controller controller, Step step)
   {
      try
      {
         BorderPane content = new BorderPane();
         content.setCenter(load(controller, step.getContentView()));
         content.setBottom(load(controller, step.getControlsView()));
         return content;
      }
      catch (IOException e)
      {
         throw new IllegalArgumentException(e.getMessage(), e);
      }
   }

   private javafx.scene.Node load(Controller controller, String fxml) throws IOException
   {
      FXMLLoader loader = new FXMLLoader(getView(controller, fxml));
      loader.setController(controller);
      return loader.load();
   }

   private URL getView(Controller controller, String fxml)
   {
      URL url = controller.getClass().getResource(fxml);
      if (url == null)
      {
         url = WizardFx.class.getResource(fxml);
      }
      if (url == null)
      {
         throw new IllegalArgumentException("Error while loading " + fxml);
      }
      return url;
   }
}
