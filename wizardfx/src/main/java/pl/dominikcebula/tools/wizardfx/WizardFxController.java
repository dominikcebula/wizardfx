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
    private BorderPane stepContent;
    @FXML
    private VBox stepListContent;
    private List<WizardFxController> controllers = new LinkedList<>();
    private List<Label> labels = new LinkedList<>();
    private List<Node> contents = new LinkedList<>();
    private CurrentStep currentStep = new CurrentStep();

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

        Label labelForStep = createLabelForController(controller);
        labels.add(labelForStep);
        stepListContent.getChildren().add(labelForStep);

        contents.add(createContentForController(controller));

        updateStepLabel(currentStep.getCurrentStep(), currentStep.getLastStep());
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

    public void onPrevious()
    {
        currentStep.previousStep();
        updateStepLabel(currentStep.getCurrentStep(), currentStep.getLastStep());
    }

    public void onNext()
    {
        currentStep.nextStep(labels.size() - 1);
        updateStepLabel(currentStep.getCurrentStep(), currentStep.getLastStep());
    }

    public void onFinish()
    {
        currentStep.setStep(labels.size() - 1);
        updateStepLabel(currentStep.getCurrentStep(), currentStep.getLastStep());
    }

    public void updateStepLabel(int currentStep, int lastStep)
    {
        labels.get(lastStep).getStyleClass().clear();
        labels.get(currentStep).getStyleClass().add("active-step");
    }
}
