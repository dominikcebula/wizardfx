package pl.dominikcebula.tools.wizardfx.example.steps;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pl.dominikcebula.tools.wizardfx.example.OrderModel;
import pl.dominikcebula.tools.wizardfx.step.Controller;

public class CustomerInfoController extends Controller<OrderModel>
{
   @FXML
   private TextField firstNameTextField;
   @FXML
   private TextField lastNameTextField;

   @Override
   public void bind()
   {
      model.firstNameProperty().bind(firstNameTextField.textProperty());
      model.lastNameProperty().bind(lastNameTextField.textProperty());
   }
}
