package pl.dominikcebula.tools.wizardfx;

public class StepControllerFactory
{
    public StepController createController(String controllerPackage, Controller controller)
    {
        try
        {
            String controllerClassName;
            if (controllerPackage != null)
            {
                controllerClassName = String.format("%s.%s", controllerPackage, controller.getName());
            }
            else
            {
                controllerClassName = controller.getName();
            }
            StepController stepController = (StepController) Class.forName(controllerClassName).newInstance();
            stepController.initialize();
            return stepController;
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e)
        {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
