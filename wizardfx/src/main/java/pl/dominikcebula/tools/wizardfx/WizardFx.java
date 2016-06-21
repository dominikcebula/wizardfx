package pl.dominikcebula.tools.wizardfx;

import javafx.beans.DefaultProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

import static javafx.collections.FXCollections.observableArrayList;

@DefaultProperty("steps")
public class WizardFx extends BorderPane
{
    private final ObservableList<Controller> steps = observableArrayList();
    private WizardFxController controller = new WizardFxController();

    public WizardFx() throws IOException
    {
        getStylesheets().add(getClass().getResource("wizardfx.css").toExternalForm());

        BorderPane innerPane = new BorderPane();
        innerPane.setCenter(load("wizardfx-step-content.fxml", controller));
        innerPane.setBottom(load("wizardfx-step-controls.fxml", controller));

        setLeft(load("wizardfx-step-list.fxml", controller));
        setCenter(innerPane);
        steps.addListener(controller::updateSteps);
    }

    private <T> T load(String fxml, WizardFxController controller) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        loader.setController(controller);
        return loader.load();
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
    public ObservableList<Controller> getSteps()
    {
        return steps;
    }
}
