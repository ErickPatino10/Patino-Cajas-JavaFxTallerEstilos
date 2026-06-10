package com.example.erickpatinojavafx_navegacion_formularios;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CajeroController {

    @FXML private TextField txtCliente;
    @FXML private TextField txtCedula;
    @FXML private TextField txtNombre;
    @FXML private Spinner<Integer> fbRetiro; // Cambiado a Integer para montos
    @FXML private Label lbInformacion;

    @FXML
    public void initialize() {
        // Configurar el Spinner para aceptar números entre 0 y 1000
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 0);
        fbRetiro.setValueFactory(valueFactory);
    }

    @FXML
    protected void registrar() {
        String cliente = txtCliente.getText();
        String cedula = txtCedula.getText();

        if (cliente.isEmpty() || cedula.isEmpty()) {
            lbInformacion.setText("Error: Llene los campos obligatorios.");
            lbInformacion.setStyle("-fx-text-fill: #f85149;"); // Rojo si hay error
        } else {
            lbInformacion.setText("Operación exitosa para: " + cliente);
            lbInformacion.setStyle("-fx-text-fill: #58a6ff;"); // Azul si es éxito
        }
    }
}