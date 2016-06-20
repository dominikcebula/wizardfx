package pl.dominikcebula.tools.wizardfx;

public interface WizardFxStepController
{
    String getStepName();

    String getStepFxml();

    boolean canEnter();

    void onEnter();

    boolean canExit();

    void onExit();
}
