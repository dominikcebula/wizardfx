package pl.dominikcebula.tools.wizardfx.example.steps;

import pl.dominikcebula.tools.wizardfx.WizardFxStepController;

public class AddressInfoStepController implements WizardFxStepController
{
    @Override
    public String getStepName()
    {
        return "Address";
    }

    public String getStepFxml()
    {
        return "address-info-step.fxml";
    }

    @Override
    public boolean canEnter()
    {
        return true;
    }

    @Override
    public void onEnter()
    {

    }

    @Override
    public boolean canExit()
    {
        return true;
    }

    @Override
    public void onExit()
    {

    }
}
