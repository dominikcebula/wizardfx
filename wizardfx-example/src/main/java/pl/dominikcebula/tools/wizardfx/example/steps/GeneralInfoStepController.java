package pl.dominikcebula.tools.wizardfx.example.steps;

import pl.dominikcebula.tools.wizardfx.WizardFxStepController;

@SuppressWarnings("unused")
public class GeneralInfoStepController implements WizardFxStepController
{
    @Override
    public String getStepName()
    {
        return "General Info";
    }

    @Override
    public String getStepFxml()
    {
        return "general-info-step.fxml";
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
