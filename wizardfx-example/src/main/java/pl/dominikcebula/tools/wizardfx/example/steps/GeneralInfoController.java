package pl.dominikcebula.tools.wizardfx.example.steps;

import pl.dominikcebula.tools.wizardfx.controller.Controller;

@SuppressWarnings("unused")
public class GeneralInfoController extends Controller
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
