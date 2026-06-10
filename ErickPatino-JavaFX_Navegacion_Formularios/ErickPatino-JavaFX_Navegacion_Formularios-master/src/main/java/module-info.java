module com.example.erickpatinojavafx_navegacion_formularios {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.erickpatinojavafx_navegacion_formularios to javafx.fxml;
    exports com.example.erickpatinojavafx_navegacion_formularios;
}