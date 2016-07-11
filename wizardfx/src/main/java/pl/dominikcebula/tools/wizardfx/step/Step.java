package pl.dominikcebula.tools.wizardfx.step;

public class Step
{
   private String id;
   private String name;
   private Class<? extends Controller> controller;
   private String contentView;
   private String controlsView = "wizardfx-step-controls.fxml";

   @SuppressWarnings("unused")
   public String getId()
   {
      return id;
   }

   @SuppressWarnings("unused")
   public void setId(String id)
   {
      this.id = id;
   }

   @SuppressWarnings("unused")
   public String getName()
   {
      return name;
   }

   @SuppressWarnings("unused")
   public void setName(String name)
   {
      this.name = name;
   }

   @SuppressWarnings("unused")
   public Class<? extends Controller> getController()
   {
      return controller;
   }

   @SuppressWarnings("unused")
   public void setController(Class<? extends Controller> controller)
   {
      this.controller = controller;
   }

   @SuppressWarnings("unused")
   public String getContentView()
   {
      return contentView;
   }

   @SuppressWarnings("unused")
   public void setContentView(String contentView)
   {
      this.contentView = contentView;
   }

   @SuppressWarnings("unused")
   public String getControlsView()
   {
      return controlsView;
   }

   @SuppressWarnings("unused")
   public void setControlsView(String controlsView)
   {
      this.controlsView = controlsView;
   }
}
