package pl.dominikcebula.tools.wizardfx.graph;

import java.util.List;

public class StepPointer
{
    private final List<Step> steps;
    private final int currentStepId;
    private final int lastStepId;

    public StepPointer(List<Step> steps)
    {
        this(steps, 0, 0);
    }

    public StepPointer(List<Step> steps, int currentStepId, int lastStepId)
    {
        this.steps = steps;
        this.currentStepId = currentStepId;
        this.lastStepId = lastStepId;
    }

    public Step getCurrentStep()
    {
        return steps.get(currentStepId);
    }

    public Step getLastStep()
    {
        return steps.get(lastStepId);
    }

    public StepPointer getPreviousStep()
    {
        if (currentStepId > 0)
        {
            return new StepPointer(steps, currentStepId - 1, currentStepId);
        }
        else
        {
            return this;
        }
    }

    public StepPointer getNextStep()
    {
        if (currentStepId < steps.size() - 1)
        {
            return new StepPointer(steps, currentStepId + 1, currentStepId);
        }
        else
        {
            return this;
        }
    }

    public StepPointer getFinishStep()
    {
        return new StepPointer(steps, steps.size() - 1, currentStepId);
    }
}
