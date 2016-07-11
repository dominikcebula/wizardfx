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
      stepListContent.getChildren().add(node.getLabel());

      update();
   }

   public void update()
   {
      updateLabelForStep(nodeGraph.getCurrentStep(), nodeGraph.getLastStep());
      updateContentForStep(nodeGraph.getCurrentStep());
   }

   private void updateContentForStep(Node currentNode)
   {
      stepContent.setCenter(currentNode.getContent());
   }

   private void updateLabelForStep(Node currentNode, Node lastNode)
   {
      lastNode.getLabel().getStyleClass().clear();
      currentNode.getLabel().getStyleClass().add("active");
   }
}
