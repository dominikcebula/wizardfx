package pl.dominikcebula.tools.wizardfx;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import pl.dominikcebula.tools.wizardfx.graph.Step;
import pl.dominikcebula.tools.wizardfx.graph.StepFactory;
import pl.dominikcebula.tools.wizardfx.graph.StepGraph;

public class WizardFxController
{
    @FXML
    @SuppressWarnings("unused")
    private Pane stepContent;
    @FXML
    @SuppressWarnings("unused")
    private VBox stepListContent;
    private StepFactory stepFactory = new StepFactory();
    private StepGraph stepGraph = new StepGraph();
    private String controllerPackage;

    public void updateControllers(ListChangeListener.Change<? extends Controller> event)
    {
        while (event.next())
        {
            event.getAddedSubList().forEach(this::addController);
        }
    }

    private void addController(Controller controller)
    {
        Step step = stepFactory.createStep(controllerPackage, controller);
        stepGraph.addStep(step);
        stepListContent.getChildren().add(step.getLabel());

        update(stepGraph.getCurrentStep(), stepGraph.getLastStep());
    }

    @SuppressWarnings("unused")
    public void onBack()
    {
        stepGraph.moveToPrevious();
        update(stepGraph.getCurrentStep(), stepGraph.getLastStep());
    }

    @SuppressWarnings("unused")
    public void onNext()
    {
        stepGraph.moveToNext();
        update(stepGraph.getCurrentStep(), stepGraph.getLastStep());
    }

    @SuppressWarnings("unused")
    public void onFinish()
    {
        stepGraph.moveToLast();
        update(stepGraph.getCurrentStep(), stepGraph.getLastStep());
    }

    private void update(Step currentStep, Step lastStep)
    {
        updateLabelForStep(currentStep, lastStep);
        updateContentForStep(currentStep);
    }

    private void updateLabelForStep(Step currentStep, Step lastStep)
    {
        lastStep.getLabel().getStyleClass().clear();
        currentStep.getLabel().getStyleClass().add("active");
    }

    private void updateContentForStep(Step currentStep)
    {
        stepContent.getChildren().setAll(currentStep.getContent());
    }

    public void setControllerPackage(String controllerPackage)
    {
        this.controllerPackage = controllerPackage;
    }

    public String getControllerPackage()
    {
        return controllerPackage;
    }
}
