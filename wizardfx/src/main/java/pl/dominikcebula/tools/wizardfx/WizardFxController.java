package pl.dominikcebula.tools.wizardfx;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import pl.dominikcebula.tools.wizardfx.ds.CurrentStep;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class WizardFxController
{
    @FXML
    @SuppressWarnings("unused")
    private BorderPane stepContent;
    @FXML
    @SuppressWarnings("unused")
    private VBox stepListContent;
    private final List<WizardFxStepController> controllers = new LinkedList<>();
    private final List<Label> labels = new LinkedList<>();
    private final List<Node> contents = new LinkedList<>();
    private CurrentStep currentStep = new CurrentStep(0, 0);

    public void updateSteps(ListChangeListener.Change<? extends WizardFxStep> event)
    {
        while (event.next())
        {
            event.getAddedSubList().forEach(this::addStep);
        }
    }

    private void addStep(WizardFxStep step)
    {
        WizardFxStepController controller = createController(step);
        controllers.add(controller);

        Label labelForStep = createLabelForController(controller);
        labels.add(labelForStep);
        stepListContent.getChildren().add(labelForStep);

        contents.add(createContentForController(controller));

        updateStep(currentStep.getCurrentStepId(), currentStep.getLastStepId());
    }

    private WizardFxStepController createController(WizardFxStep step)
    {
        try
        {
            return step.getController().newInstance();
        }
        catch (InstantiationException | IllegalAccessException e)
        {
            throw new IllegalArgumentException(e);
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
            throw new IllegalArgumentException(e);
        }
    }

    @SuppressWarnings("unused")
    public void onPrevious()
    {
        if (canMove(currentStep, currentStep.previousStep()))
        {
            getController(currentStep).onExit();
            currentStep = currentStep.previousStep();
            getController(currentStep).onEnter();
            updateStep(currentStep.getCurrentStepId(), currentStep.getLastStepId());
        }
    }

    @SuppressWarnings("unused")
    public void onNext()
    {
        if (canMove(currentStep, currentStep.nextStep(labels.size() - 1)))
        {
            getController(currentStep).onExit();
            currentStep = currentStep.nextStep(labels.size() - 1);
            getController(currentStep).onEnter();
            updateStep(currentStep.getCurrentStepId(), currentStep.getLastStepId());
        }
    }

    @SuppressWarnings("unused")
    public void onFinish()
    {
        if (canMove(currentStep, currentStep.getFinishStep(labels.size() - 1)))
        {
            getController(currentStep).onExit();
            currentStep = currentStep.getFinishStep(labels.size() - 1);
            getController(currentStep).onEnter();
            updateStep(currentStep.getCurrentStepId(), currentStep.getLastStepId());
        }
    }

    private void updateStep(int currentStep, int lastStep)
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
        stepContent.setCenter(contents.get(currentStep));
    }

    private boolean canMove(CurrentStep from, CurrentStep to)
    {
        WizardFxStepController controllerFrom = getController(from);
        WizardFxStepController controllerTo = getController(to);

        return controllerFrom.canExit() && controllerTo.canEnter();
    }

    private WizardFxStepController getController(CurrentStep step)
    {
        return controllers.get(step.getCurrentStepId());
    }
}
