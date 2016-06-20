package pl.dominikcebula.tools.wizardfx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class WizardFxStep
{
    private ObjectProperty<Class<? extends WizardFxStepController>> controller = new SimpleObjectProperty<>();

    public Class<? extends WizardFxStepController> getController()
    {
        return controller.get();
    }

    public ObjectProperty<Class<? extends WizardFxStepController>> controllerProperty()
    {
        return controller;
    }

    public void setController(Class<? extends WizardFxStepController> controller)
    {
        this.controller.set(controller);
    }
}
