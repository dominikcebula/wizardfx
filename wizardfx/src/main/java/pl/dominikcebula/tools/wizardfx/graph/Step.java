package pl.dominikcebula.tools.wizardfx.graph;

import javafx.scene.Node;
import javafx.scene.control.Label;
import pl.dominikcebula.tools.wizardfx.StepController;

public class Step
{
    private final StepController controller;
    private final Label label;
    private final Node content;

    public Step(StepController controller, Label label, Node content)
    {
        this.controller = controller;
        this.label = label;
        this.content = content;
    }

    public StepController getController()
    {
        return controller;
    }

    public Label getLabel()
    {
        return label;
    }

    public Node getContent()
    {
        return content;
    }
}
