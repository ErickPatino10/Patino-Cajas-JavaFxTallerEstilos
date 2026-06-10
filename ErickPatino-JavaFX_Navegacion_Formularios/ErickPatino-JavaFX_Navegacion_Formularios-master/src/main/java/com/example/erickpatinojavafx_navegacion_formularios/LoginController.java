package com.example.erickpatinojavafx_navegacion_formularios;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {

    @FXML private PasswordField txtPassword;
    @FXML private ComboBox<String> cmbRol;
    @FXML private TextField txtNombre;
    @FXML private Label lbInfo;

    @FXML
    public void initialize() {
        cmbRol.getItems().addAll("Administrador", "Cajero");
    }

    // MÉTODO AUXILIAR PARA ABRIR VENTANAS CON CSS
    private void abrirVentana(String fxmlArchivo, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlArchivo));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            // AQUÍ VINCULAMOS EL CSS (Asegúrate de que el nombre sea 'styles.css')
            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(scene);
            stage.show();

            // Cerrar el login
            ((Stage) txtNombre.getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
            lbInfo.setText("Error al abrir: " + fxmlArchivo);
        }
    }

    @FXML
    protected void ingresar() {
        String nombre = txtNombre.getText();
        String password = txtPassword.getText();
        String rol = cmbRol.getValue();

        if (nombre.isEmpty() || password.isEmpty() || rol == null) {
            mostrarAlerta("Campos vacíos", "Debe completar todos los campos.");
            return;
        }

        if (nombre.equals("Admin") && password.equals("123") && rol.equals("Administrador")) {
            abrirVentana("Administrador.fxml", "Panel Administrador");
        } else if (nombre.equals("Cajero") && password.equals("123") && rol.equals("Cajero")) {
            abrirVentana("Cajero.fxml", "Módulo de Cajero");
        } else {
            mostrarAlerta("Error", "Credenciales incorrectas.");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    protected void salir() {
        ((Stage) txtNombre.getScene().getWindow()).close();
    }
}