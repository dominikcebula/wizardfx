package pl.dominikcebula.tools.wizardfx.graph;

import javafx.scene.control.Button;
import pl.dominikcebula.tools.wizardfx.step.*;

public class Node
{
   private final Controller controller;
   private Step step;
   private final Button label;
   private final javafx.scene.Node content;

   public Node(Step step, Controller controller, Button button, javafx.scene.Node content)
   {
      this.step = step;
      this.controller = controller;
      this.label = button;
      this.content = content;
   }

   public Controller getController()
   {
      return controller;
   }

   public Step getStep()
   {
      return step;
   }

   public Button getButton()
   {
      return label;
   }

   public javafx.scene.Node getContent()
   {
      return content;
   }
}
