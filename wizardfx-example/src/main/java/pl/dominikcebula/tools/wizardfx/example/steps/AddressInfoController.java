package pl.dominikcebula.tools.wizardfx.example.steps;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pl.dominikcebula.tools.wizardfx.example.OrderModel;
import pl.dominikcebula.tools.wizardfx.step.Controller;

public class AddressInfoController extends Controller<OrderModel>
{
   @FXML
   private TextField cityTextField;

   @Override
   public void bind()
   {
      model.cityProperty().bind(cityTextField.textProperty());
   }
}
