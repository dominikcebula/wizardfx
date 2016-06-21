package pl.dominikcebula.tools.wizardfx.example.steps;

import pl.dominikcebula.tools.wizardfx.StepController;

@SuppressWarnings("unused")
public class CustomerInfoStepController extends StepController
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
