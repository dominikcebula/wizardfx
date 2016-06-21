package pl.dominikcebula.tools.wizardfx.graph;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import pl.dominikcebula.tools.wizardfx.controller.Controller;
import pl.dominikcebula.tools.wizardfx.controller.ControllerClass;
import pl.dominikcebula.tools.wizardfx.controller.ControllerFactory;

import java.io.IOException;

public class StepFactory
{
    private ControllerFactory controllerFactory = new ControllerFactory();

    public Step createStep(String controllerPackage, ControllerClass controllerClass)
    {
        Controller controller = controllerFactory.createController(controllerPackage, controllerClass);

        return new Step(
                controller,
                createLabelForController(controller),
                createContentForController(controller)
        );
    }

    private Label createLabelForController(Controller controller)
    {
        return new Label(controller.getStepName());
    }

    private Node createContentForController(Controller controller)
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
