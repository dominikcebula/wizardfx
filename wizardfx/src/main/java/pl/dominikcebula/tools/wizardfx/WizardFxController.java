package pl.dominikcebula.tools.wizardfx;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import pl.dominikcebula.tools.wizardfx.graph.*;
import pl.dominikcebula.tools.wizardfx.step.*;

public class WizardFxController
{
   @FXML
   @SuppressWarnings("unused")
   private BorderPane stepContent;
   @FXML
   @SuppressWarnings("unused")
   private VBox stepListContent;
   private Model model;
   private NodeFactory nodeFactory = new NodeFactory();
   private NodeGraph nodeGraph = new NodeGraph();

   public void addStep(Step step)
   {
      Node node = nodeFactory.createNode(step, nodeGraph, model, this);
      nodeGraph.addStep(node);
      stepListContent.getChildren().add(node.getButton());

      update();
   }

   public Scene getScene()
   {
      return stepContent.getScene();
   }

   public void update()
   {
      updateButtonForStep(nodeGraph.getCurrentStep(), nodeGraph.getLastStep());
      updateContentForStep(nodeGraph.getCurrentStep());
   }

   private void updateButtonForStep(Node currentNode, Node lastNode)
   {
      lastNode.getButton().getStyleClass().clear();
      currentNode.getButton().getStyleClass().add("active");
   }

   private void updateContentForStep(Node currentNode)
   {
      stepContent.setCenter(currentNode.getContent());
   }

   public Model getModel()
   {
      return model;
   }

   public void setModel(String modelClass) throws ClassNotFoundException, IllegalAccessException, InstantiationException
   {
      if (model == null)
      {
         model = (Model) Class.forName(modelClass).newInstance();
      }
      else
      {
         throw new IllegalArgumentException("Model for Wizard can be set only once");
      }
   }
}
