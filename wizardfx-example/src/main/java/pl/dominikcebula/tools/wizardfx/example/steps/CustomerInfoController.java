package pl.dominikcebula.tools.wizardfx.example.steps;

import pl.dominikcebula.tools.wizardfx.Controller;

@SuppressWarnings("unused")
public class CustomerInfoController extends Controller
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
}
