package pl.dominikcebula.tools.wizardfx.example.steps;

import pl.dominikcebula.tools.wizardfx.StepController;

@SuppressWarnings("unused")
public class GeneralInfoStepController extends StepController
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
}
