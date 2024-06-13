module com.hos.gui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.hos.gui to javafx.fxml;
    opens com.hos.gui.controller to javafx.fxml;
    exports com.hos.gui;
}