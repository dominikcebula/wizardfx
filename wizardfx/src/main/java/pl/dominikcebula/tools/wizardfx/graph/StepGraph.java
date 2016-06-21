package pl.dominikcebula.tools.wizardfx.graph;

import pl.dominikcebula.tools.wizardfx.Controller;

import java.util.LinkedList;
import java.util.List;

public class StepGraph
{
    private List<Step> steps = new LinkedList<>();
    private StepPointer stepPointer = new StepPointer(steps);

    public void addStep(Step step)
    {
        steps.add(step);
    }

    public Step getCurrentStep()
    {
        return stepPointer.getCurrentStep();
    }

    public Step getLastStep()
    {
        return stepPointer.getLastStep();
    }

    public void moveToPrevious()
    {
        if (canMoveToStep(stepPointer.getCurrentStep(), stepPointer.getPreviousStep().getCurrentStep()))
        {
            stepPointer.getCurrentStep().getController().onExit();
            stepPointer = stepPointer.getPreviousStep();
            stepPointer.getCurrentStep().getController().onEnter();
        }
    }

    public void moveToNext()
    {
        if (canMoveToStep(stepPointer.getCurrentStep(), stepPointer.getNextStep().getCurrentStep()))
        {
            stepPointer.getCurrentStep().getController().onExit();
            stepPointer = stepPointer.getNextStep();
            stepPointer.getCurrentStep().getController().onEnter();
        }
    }

    public void moveToLast()
    {
        if (canMoveToStep(stepPointer.getCurrentStep(), stepPointer.getFinishStep().getCurrentStep()))
        {
            stepPointer.getCurrentStep().getController().onExit();
            stepPointer = stepPointer.getFinishStep();
            stepPointer.getCurrentStep().getController().onEnter();
        }
    }

    private boolean canMoveToStep(Step from, Step to)
    {
        Controller controllerFrom = from.getController();
        Controller controllerTo = to.getController();

        return from != to && controllerFrom.canExit() && controllerTo.canEnter();
    }
}
