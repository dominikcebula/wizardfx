package pl.dominikcebula.tools.wizardfx.ds;

public class CurrentStep
{
    private int currentStep = 0;
    private int lastStep = 0;

    public int getCurrentStep()
    {
        return currentStep;
    }

    public int getLastStep()
    {
        return lastStep;
    }

    public void previousStep()
    {
        if (currentStep > 0)
        {
            setStep(currentStep - 1);
        }
    }

    public void nextStep(int maximumStep)
    {
        if (currentStep < maximumStep)
        {
            setStep(currentStep + 1);
        }
    }

    public void setStep(int step)
    {
        lastStep = currentStep;
        currentStep = step;
    }
}
