package pl.dominikcebula.tools.wizardfx.graph;

import javafx.scene.control.Label;
import pl.dominikcebula.tools.wizardfx.step.Controller;

public class Node
{
   private final Controller controller;
   private final Label label;
   private final javafx.scene.Node content;

   public Node(Controller controller, Label label, javafx.scene.Node content)
   {
      this.controller = controller;
      this.label = label;
      this.content = content;
   }

   public Controller getController()
   {
      return controller;
   }

   public Label getLabel()
   {
      return label;
   }

   public javafx.scene.Node getContent()
   {
      return content;
   }
}
