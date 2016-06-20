package pl.dominikcebula.tools.wizardfx.example.steps;

import pl.dominikcebula.tools.wizardfx.WizardFxStepController;

@SuppressWarnings("unused")
public class SummaryStepController implements WizardFxStepController
{
    @Override
    public String getStepName()
    {
        return "Summary";
    }

    @Override
    public String getStepFxml()
    {
        return "summary-step.fxml";
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
