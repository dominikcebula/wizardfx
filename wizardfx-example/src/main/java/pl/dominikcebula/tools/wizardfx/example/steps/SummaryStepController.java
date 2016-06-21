package pl.dominikcebula.tools.wizardfx.example.steps;

import pl.dominikcebula.tools.wizardfx.StepController;

@SuppressWarnings("unused")
public class SummaryStepController extends StepController
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
}
