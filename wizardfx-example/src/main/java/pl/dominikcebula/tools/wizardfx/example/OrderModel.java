package pl.dominikcebula.tools.wizardfx.example;

import javafx.beans.property.*;
import pl.dominikcebula.tools.wizardfx.step.Model;

public class OrderModel implements Model
{
   private StringProperty orderCode = new SimpleStringProperty();
   private StringProperty firstName = new SimpleStringProperty();
   private StringProperty lastName = new SimpleStringProperty();
   private StringProperty city = new SimpleStringProperty();

   public String getOrderCode()
   {
      return orderCode.get();
   }

   public StringProperty orderCodeProperty()
   {
      return orderCode;
   }

   public void setOrderCode(String orderCode)
   {
      this.orderCode.set(orderCode);
   }

   public String getFirstName()
   {
      return firstName.get();
   }

   public StringProperty firstNameProperty()
   {
      return firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName.set(firstName);
   }

   public String getLastName()
   {
      return lastName.get();
   }

   public StringProperty lastNameProperty()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName.set(lastName);
   }

   public String getCity()
   {
      return city.get();
   }

   public StringProperty cityProperty()
   {
      return city;
   }

   public void setCity(String city)
   {
      this.city.set(city);
   }
}
