package pl.dominikcebula.tools.wizardfx.example.steps;

import pl.dominikcebula.tools.wizardfx.StepController;

@SuppressWarnings("unused")
public class AddressInfoStepController extends StepController
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
}
