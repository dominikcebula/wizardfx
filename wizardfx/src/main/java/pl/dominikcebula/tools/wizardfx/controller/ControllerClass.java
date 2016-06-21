package pl.dominikcebula.tools.wizardfx.controller;

import javafx.beans.DefaultProperty;

@DefaultProperty("name")
public class ControllerClass
{
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
