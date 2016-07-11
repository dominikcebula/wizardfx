package pl.dominikcebula.tools.wizardfx;

import javafx.fxml.FXML;
import javafx.scene.layout.*;
import pl.dominikcebula.tools.wizardfx.graph.*;
import pl.dominikcebula.tools.wizardfx.step.Step;

public class WizardFxController
{
   @FXML
   @SuppressWarnings("unused")
   private BorderPane stepContent;
   @FXML
   @SuppressWarnings("unused")
   private VBox stepListContent;
   private NodeFactory nodeFactory = new NodeFactory();
   private NodeGraph nodeGraph = new NodeGraph();

   public void addStep(Step step)
   {
      Node node = nodeFactory.createStep(step, nodeGraph, this);
      nodeGraph.addStep(node);
      stepListContent.getChildren().add(node.getButton());

      update();
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
}
