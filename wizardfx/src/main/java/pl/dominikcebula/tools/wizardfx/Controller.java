package pl.dominikcebula.tools.wizardfx;

import javafx.beans.DefaultProperty;

@DefaultProperty("name")
public class Controller
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
