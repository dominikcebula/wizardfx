package pl.dominikcebula.tools.wizardfx.example.steps;

import pl.dominikcebula.tools.wizardfx.controller.Controller;

@SuppressWarnings("unused")
public class AddressInfoController extends Controller
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
