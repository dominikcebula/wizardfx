package pl.dominikcebula.tools.wizardfx.example.steps;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pl.dominikcebula.tools.wizardfx.example.OrderModel;
import pl.dominikcebula.tools.wizardfx.step.Controller;

public class GeneralInfoController extends Controller<OrderModel>
{
   @FXML
   private TextField orderCodeTextField;

   @Override
   public void bind()
   {
      model.orderCodeProperty().bind(orderCodeTextField.textProperty());
   }
}
