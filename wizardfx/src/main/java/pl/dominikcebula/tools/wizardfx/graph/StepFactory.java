package pl.dominikcebula.tools.wizardfx.graph;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import pl.dominikcebula.tools.wizardfx.Controller;
import pl.dominikcebula.tools.wizardfx.StepController;
import pl.dominikcebula.tools.wizardfx.StepControllerFactory;

import java.io.IOException;

public class StepFactory
{
    private StepControllerFactory controllerFactory = new StepControllerFactory();

    public Step createStep(String controllerPackage, Controller controller)
    {
        StepController stepController = controllerFactory.createController(controllerPackage, controller);

        return new Step(
                stepController,
                createLabelForController(stepController),
                createContentForController(stepController)
        );
    }

    private Label createLabelForController(StepController controller)
    {
        return new Label(controller.getStepName());
    }

    private Node createContentForController(StepController controller)
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
}
