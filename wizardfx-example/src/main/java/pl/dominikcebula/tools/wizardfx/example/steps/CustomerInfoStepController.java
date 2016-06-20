package pl.dominikcebula.tools.wizardfx.example.steps;

import pl.dominikcebula.tools.wizardfx.WizardFxStepController;

public class CustomerInfoStepController implements WizardFxStepController
{
    @Override
    public String getStepName()
    {
        return "Customer Info";
    }

    @Override
    public String getStepFxml()
    {
        return "customer-info-step.fxml";
    }

    @Override
    public boolean canEnter()
    {
        return false;
    }

    @Override
    public void onEnter()
    {

    }

    @Override
    public boolean canExit()
    {
        return false;
    }

    @Override
    public void onExit()
    {

    }
}
