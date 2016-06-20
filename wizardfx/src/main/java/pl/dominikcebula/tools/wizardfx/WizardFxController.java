package pl.dominikcebula.tools.wizardfx;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import pl.dominikcebula.tools.wizardfx.ds.CurrentStep;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class WizardFxController
{
    @FXML
    @SuppressWarnings("unused")
    private Pane stepContent;
    @FXML
    @SuppressWarnings("unused")
    private VBox stepListContent;
    private final List<WizardFxStepController> controllers = new LinkedList<>();
    private final List<Label> labels = new LinkedList<>();
    private final List<Node> contents = new LinkedList<>();
    private CurrentStep currentStep = new CurrentStep(0, 0);
    private String controllerPackage;

    public void updateSteps(ListChangeListener.Change<? extends Controller> event)
    {
        while (event.next())
        {
            event.getAddedSubList().forEach(this::addStep);
        }
    }

    private void addStep(Controller controller)
    {
        WizardFxStepController stepController = createController(controller);
        controllers.add(stepController);

        Label labelForStep = createLabelForController(stepController);
        labels.add(labelForStep);
        stepListContent.getChildren().add(labelForStep);

        contents.add(createContentForController(stepController));

        moveToStep(currentStep.getCurrentStepId(), currentStep.getLastStepId());
    }

    private WizardFxStepController createController(Controller controller)
    {
        try
        {
            String controllerClassName;
            if (controllerPackage != null)
            {
                controllerClassName = String.format("%s.%s", controllerPackage, controller.getName());
            }
            else
            {
                controllerClassName = controller.getName();
            }
            return (WizardFxStepController) Class.forName(controllerClassName).newInstance();
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e)
        {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    private Label createLabelForController(WizardFxStepController controller)
    {
        return new Label(controller.getStepName());
    }

    private Node createContentForController(WizardFxStepController controller)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(controller.getClass().getResource(controller.getStepFxml()));
            loader.setController(controller);
            return loader.load();
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    @SuppressWarnings("unused")
    public void onPrevious()
    {
        if (canMoveToStep(currentStep, currentStep.previousStep()))
        {
            getController(currentStep).onExit();
            currentStep = currentStep.previousStep();
            getController(currentStep).onEnter();
            moveToStep(currentStep.getCurrentStepId(), currentStep.getLastStepId());
        }
    }

    @SuppressWarnings("unused")
    public void onNext()
    {
        if (canMoveToStep(currentStep, currentStep.nextStep(labels.size() - 1)))
        {
            getController(currentStep).onExit();
            currentStep = currentStep.nextStep(labels.size() - 1);
            getController(currentStep).onEnter();
            moveToStep(currentStep.getCurrentStepId(), currentStep.getLastStepId());
        }
    }

    @SuppressWarnings("unused")
    public void onFinish()
    {
        if (canMoveToStep(currentStep, currentStep.getFinishStep(labels.size() - 1)))
        {
            getController(currentStep).onExit();
            currentStep = currentStep.getFinishStep(labels.size() - 1);
            getController(currentStep).onEnter();
            moveToStep(currentStep.getCurrentStepId(), currentStep.getLastStepId());
        }
    }

    private void moveToStep(int currentStep, int lastStep)
    {
        updateLabelForStep(currentStep, lastStep);
        updateContentForStep(currentStep);
    }

    private void updateLabelForStep(int currentStep, int lastStep)
    {
        labels.get(lastStep).getStyleClass().clear();
        labels.get(currentStep).getStyleClass().add("active-step");
    }

    private void updateContentForStep(int currentStep)
    {
        stepContent.getChildren().setAll(contents.get(currentStep));
    }

    private boolean canMoveToStep(CurrentStep from, CurrentStep to)
    {
        WizardFxStepController controllerFrom = getController(from);
        WizardFxStepController controllerTo = getController(to);

        return controllerFrom.canExit() && controllerTo.canEnter();
    }

    private WizardFxStepController getController(CurrentStep step)
    {
        return controllers.get(step.getCurrentStepId());
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
