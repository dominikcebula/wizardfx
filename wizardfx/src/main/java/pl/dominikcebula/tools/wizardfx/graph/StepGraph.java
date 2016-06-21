package pl.dominikcebula.tools.wizardfx.graph;

import pl.dominikcebula.tools.wizardfx.controller.Controller;

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
        moveTo(stepPointer.getPreviousStep());
    }

    public void moveToNext()
    {
        moveTo(stepPointer.getNextStep());
    }

    public void moveToLast()
    {
        moveTo(stepPointer.getFinishStep());
    }

    private void moveTo(StepPointer target)
    {
        if (canMoveToStep(stepPointer.getCurrentStep(), target.getCurrentStep()))
        {
            stepPointer.getCurrentStep().getController().onExit();
            stepPointer = target;
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
