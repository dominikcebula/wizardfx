package pl.dominikcebula.tools.wizardfx.graph;

import java.util.*;

import pl.dominikcebula.tools.wizardfx.step.Controller;

public class NodeGraph
{
   private List<Node> nodes = new LinkedList<>();
   private NodePointer nodePointer = new NodePointer(nodes);

   public void addStep(Node node)
   {
      nodes.add(node);
   }

   public Node getCurrentStep()
   {
      return nodePointer.getCurrentStep();
   }

   public Node getLastStep()
   {
      return nodePointer.getLastStep();
   }

   public void moveToPrevious()
   {
      moveTo(nodePointer.getPreviousStep());
   }

   public void moveToNext()
   {
      moveTo(nodePointer.getNextStep());
   }

   public void moveToLast()
   {
      moveTo(nodePointer.getFinishStep());
   }

   private void moveTo(NodePointer target)
   {
      if (canMoveToStep(nodePointer.getCurrentStep(), target.getCurrentStep()))
      {
         nodePointer.getCurrentStep().getController().onExit();
         nodePointer = target;
         nodePointer.getCurrentStep().getController().onEnter();
      }
   }

   private boolean canMoveToStep(Node from, Node to)
   {
      Controller controllerFrom = from.getController();
      Controller controllerTo = to.getController();

      return from != to && controllerFrom.canExit() && controllerTo.canEnter();
   }
}
