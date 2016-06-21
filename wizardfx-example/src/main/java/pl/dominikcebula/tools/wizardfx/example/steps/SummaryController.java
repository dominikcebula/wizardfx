package pl.dominikcebula.tools.wizardfx.example.steps;

import pl.dominikcebula.tools.wizardfx.Controller;

@SuppressWarnings("unused")
public class SummaryController extends Controller
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
