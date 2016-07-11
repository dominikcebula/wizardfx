package pl.dominikcebula.tools.wizardfx.graph;

import java.util.List;

public class NodePointer
{
   private final List<Node> nodes;
   private final int currentStepId;
   private final int lastStepId;

   public NodePointer(List<Node> nodes)
   {
      this(nodes, 0, 0);
   }

   public NodePointer(List<Node> nodes, int currentStepId, int lastStepId)
   {
      this.nodes = nodes;
      this.currentStepId = currentStepId;
      this.lastStepId = lastStepId;
   }

   public NodePointer getStep(int stepId)
   {
      return new NodePointer(nodes, stepId, currentStepId);
   }

   public Node getCurrentStep()
   {
      return nodes.get(currentStepId);
   }

   public Node getLastStep()
   {
      return nodes.get(lastStepId);
   }

   public NodePointer getPreviousStep()
   {
      if (currentStepId > 0)
      {
         return new NodePointer(nodes, currentStepId - 1, currentStepId);
      }
      else
      {
         return this;
      }
   }

   public NodePointer getNextStep()
   {
      if (currentStepId < nodes.size() - 1)
      {
         return new NodePointer(nodes, currentStepId + 1, currentStepId);
      }
      else
      {
         return this;
      }
   }

   public NodePointer getFinishStep()
   {
      return new NodePointer(nodes, nodes.size() - 1, currentStepId);
   }
}
