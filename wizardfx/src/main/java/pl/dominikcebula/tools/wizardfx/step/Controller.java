package pl.dominikcebula.tools.wizardfx.step;

import pl.dominikcebula.tools.wizardfx.WizardFxController;
import pl.dominikcebula.tools.wizardfx.graph.NodeGraph;

public abstract class Controller
{
   protected NodeGraph nodeGraph;
   protected WizardFxController wizardController;

   public void setNodeGraph(NodeGraph nodeGraph)
   {
      this.nodeGraph = nodeGraph;
   }

   public void setWizardController(WizardFxController wizardController)
   {
      this.wizardController = wizardController;
   }

   @SuppressWarnings("unused")
   public void onBack()
   {
      nodeGraph.moveToPrevious();
      wizardController.update();
   }

   @SuppressWarnings("unused")
   public void onNext()
   {
      nodeGraph.moveToNext();
      wizardController.update();
   }

   @SuppressWarnings("unused")
   public void onFinish()
   {
      nodeGraph.moveToLast();
      wizardController.update();
   }

   public void initialize()
   {
   }

   public boolean canEnter()
   {
      return true;
   }

   public void onEnter()
   {
   }

   public boolean canExit()
   {
      return true;
   }

   public void onExit()
   {
   }
}
