package pl.dominikcebula.tools.wizardfx;

public class ControllerFactory
{
    public Controller createController(String controllerPackage, ControllerClass controllerClass)
    {
        try
        {
            String controllerClassName;
            if (controllerPackage != null)
            {
                controllerClassName = String.format("%s.%s", controllerPackage, controllerClass.getName());
            }
            else
            {
                controllerClassName = controllerClass.getName();
            }
            Controller controller = (Controller) Class.forName(controllerClassName).newInstance();
            controller.initialize();
            return controller;
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e)
        {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
