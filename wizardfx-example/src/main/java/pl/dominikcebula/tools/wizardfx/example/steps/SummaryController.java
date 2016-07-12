package pl.dominikcebula.tools.wizardfx.example.steps;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pl.dominikcebula.tools.wizardfx.example.OrderModel;
import pl.dominikcebula.tools.wizardfx.step.Controller;

public class SummaryController extends Controller<OrderModel>
{
   @FXML
   private Label orderCodeLabel;
   @FXML
   private Label firstNameLabel;
   @FXML
   private Label lastNameLabel;
   @FXML
   private Label cityLabel;

   @Override
   public void bind()
   {
      orderCodeLabel.textProperty().bind(model.orderCodeProperty());
      firstNameLabel.textProperty().bind(model.firstNameProperty());
      lastNameLabel.textProperty().bind(model.lastNameProperty());
      cityLabel.textProperty().bind(model.cityProperty());
   }
}
