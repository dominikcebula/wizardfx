package pl.dominikcebula.tools.wizardfx.ds;

public class CurrentStep
{
    private final int currentStepId;
    private final int lastStepId;

    public CurrentStep(int currentStepId, int lastStepId)
    {
        this.currentStepId = currentStepId;
        this.lastStepId = lastStepId;
    }

    public int getCurrentStepId()
    {
        return currentStepId;
    }

    public int getLastStepId()
    {
        return lastStepId;
    }

    public CurrentStep previousStep()
    {
        if (currentStepId > 0)
        {
            return new CurrentStep(currentStepId - 1, currentStepId);
        }
        else
        {
            return this;
        }
    }

    public CurrentStep nextStep(int maximumStep)
    {
        if (currentStepId < maximumStep)
        {
            return new CurrentStep(currentStepId + 1, currentStepId);
        }
        else
        {
            return this;
        }
    }

    public CurrentStep getFinishStep(int finishStep)
    {
        return new CurrentStep(finishStep, currentStepId);
    }
}
