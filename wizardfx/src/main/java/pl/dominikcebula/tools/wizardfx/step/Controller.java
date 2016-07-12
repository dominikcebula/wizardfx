package pl.dominikcebula.tools.wizardfx.step;

import javafx.scene.Scene;
import pl.dominikcebula.tools.wizardfx.WizardFxController;
import pl.dominikcebula.tools.wizardfx.graph.NodeGraph;

public abstract class Controller<M extends Model>
{
   protected NodeGraph nodeGraph;
   protected WizardFxController wizardController;
   protected M model;

   public void setNodeGraph(NodeGraph nodeGraph)
   {
      this.nodeGraph = nodeGraph;
   }

   public void setWizardController(WizardFxController wizardController)
   {
      this.wizardController = wizardController;
   }

   public void setModel(M model)
   {
      this.model = model;
   }

   public Scene getScene()
   {
      return wizardController.getScene();
   }

   public void closeWizard()
   {
      getScene().getWindow().hide();
   }

   public abstract void bind();

   @SuppressWarnings("unused")
   public void onMoveTo(Step step)
   {
      nodeGraph.moveToStep(step);
      wizardController.update();
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

   public boolean canEnter(Step previousStep)
   {
      return true;
   }

   public void onEnter()
   {
   }

   public boolean canExit(Step nextStep)
   {
      return true;
   }

   public void onExit()
   {
   }
}
