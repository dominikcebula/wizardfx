package pl.dominikcebula.tools.wizardfx;

import javafx.beans.DefaultProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import pl.dominikcebula.tools.wizardfx.controller.ControllerClass;

import java.io.IOException;

import static javafx.collections.FXCollections.observableArrayList;

@DefaultProperty("controllerClasses")
public class WizardFx extends BorderPane
{
    private final ObservableList<ControllerClass> controllerClasses = observableArrayList();
    private WizardFxController controller = new WizardFxController();

    public WizardFx() throws IOException
    {
        getStylesheets().add(getClass().getResource("wizardfx.css").toExternalForm());

        BorderPane innerPane = new BorderPane();
        innerPane.setCenter(load("wizardfx-step-content.fxml", controller));
        innerPane.setBottom(load("wizardfx-step-controls.fxml", controller));

        setLeft(load("wizardfx-step-list.fxml", controller));
        setCenter(innerPane);
        controllerClasses.addListener(this::controllerClassesChanged);
    }

    private <T> T load(String fxml, WizardFxController controller) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        loader.setController(controller);
        return loader.load();
    }

    private void controllerClassesChanged(ListChangeListener.Change<? extends ControllerClass> event)
    {
        while (event.next())
        {
            event.getAddedSubList().forEach(controller::addController);
        }
    }

    public String getControllerPackage()
    {
        return controller.getControllerPackage();
    }

    public void setControllerPackage(String controllerPackage)
    {
        controller.setControllerPackage(controllerPackage);
    }

    @SuppressWarnings("unused")
    public ObservableList<ControllerClass> getControllerClasses()
    {
        return controllerClasses;
    }
}
