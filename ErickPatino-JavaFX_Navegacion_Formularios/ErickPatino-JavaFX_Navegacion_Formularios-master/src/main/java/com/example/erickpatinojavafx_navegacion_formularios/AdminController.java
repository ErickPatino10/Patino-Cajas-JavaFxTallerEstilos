package com.example.erickpatinojavafx_navegacion_formularios;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class AdminController {

    @FXML private Button btIrEncuesta;
    @FXML private Button btIrCajero;
    @FXML private Button btSalir;

    private void abrirVentana(String fxmlArchivo, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlArchivo));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            // CARGA DEL CSS (Asegúrate de que 'styles.css' esté en la misma carpeta)
            String css = getClass().getResource("styles.css").toExternalForm();
            scene.getStylesheets().add(css);

            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al cargar: " + fxmlArchivo);
        }
    }

    @FXML
    public void irAEncuesta() {
        abrirVentana("encuesta.fxml", "Módulo de Encuesta");
    }

    @FXML
    public void irACajero() {
        abrirVentana("cajero.fxml", "Módulo de Cajero");
    }

    @FXML
    public void salir() {
        Stage stage = (Stage) btSalir.getScene().getWindow();
        stage.close();
    }
}