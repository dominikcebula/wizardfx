package pl.dominikcebula.tools.wizardfx.controller;

public abstract class Controller
{
    public abstract String getStepName();

    public abstract String getStepFxml();

    public void initialize()
    {
    }

    public boolean canEnter()
    {
        return true;
    }

    public void onEnter()
    {
    }

    public boolean canExit()
    {
        return true;
    }

    public void onExit()
    {
    }
}
