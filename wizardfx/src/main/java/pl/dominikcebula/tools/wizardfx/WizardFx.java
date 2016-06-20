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
    private final ObservableList<WizardFxStep> steps = observableArrayList();

    public WizardFx() throws IOException
    {
        getStylesheets().add(getClass().getResource("wizardfx.css").toExternalForm());

        WizardFxController controller = new WizardFxController();
        setCenter(load("wizardfx-step-content.fxml", controller));
        setLeft(load("wizardfx-step-list.fxml", controller));
        setBottom(load("wizardfx-step-controls.fxml", controller));
        steps.addListener(controller::updateSteps);
    }

    private <T> T load(String fxml, WizardFxController controller) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        loader.setController(controller);
        return loader.load();
    }

    @SuppressWarnings("unused")
    public ObservableList<WizardFxStep> getSteps()
    {
        return steps;
    }
}
