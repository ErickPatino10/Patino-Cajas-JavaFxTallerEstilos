package com.example.erickpatinojavafx_navegacion_formularios;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class EncuestaController {

    // Pregunta 1
    @FXML
    private RadioButton rbQuito;
    @FXML
    private RadioButton rbGuayaquil;
    @FXML
    private RadioButton rbCuenca;

    // Pregunta 2
    @FXML
    private RadioButton rbPacifico;
    @FXML
    private RadioButton rbAtlantico;
    @FXML
    private RadioButton rbIndico;

    // Pregunta 3
    @FXML
    private RadioButton rbCinco;
    @FXML
    private RadioButton rbSeis;
    @FXML
    private RadioButton rbSiete;

    // Pregunta 4
    @FXML
    private RadioButton rbMarte;
    @FXML
    private RadioButton rbJupiter;
    @FXML
    private RadioButton rbVenus;

    @FXML
    private Label lbResultado;

    @FXML
    private Button btCalificar;

    @FXML
    public void initialize() {

        // Grupo pregunta 1
        ToggleGroup grupo1 = new ToggleGroup();
        rbQuito.setToggleGroup(grupo1);
        rbGuayaquil.setToggleGroup(grupo1);
        rbCuenca.setToggleGroup(grupo1);

        // Grupo pregunta 2
        ToggleGroup grupo2 = new ToggleGroup();
        rbPacifico.setToggleGroup(grupo2);
        rbAtlantico.setToggleGroup(grupo2);
        rbIndico.setToggleGroup(grupo2);

        // Grupo pregunta 3
        ToggleGroup grupo3 = new ToggleGroup();
        rbCinco.setToggleGroup(grupo3);
        rbSeis.setToggleGroup(grupo3);
        rbSiete.setToggleGroup(grupo3);

        // Grupo pregunta 4
        ToggleGroup grupo4 = new ToggleGroup();
        rbMarte.setToggleGroup(grupo4);
        rbJupiter.setToggleGroup(grupo4);
        rbVenus.setToggleGroup(grupo4);
    }

    @FXML
    public void calificar() {

        int correctas = 0;

        if (rbQuito.isSelected()) {
            correctas++;
        }

        if (rbPacifico.isSelected()) {
            correctas++;
        }

        if (rbSiete.isSelected()) {
            correctas++;
        }

        if (rbMarte.isSelected()) {
            correctas++;
        }

        int incorrectas = 4 - correctas;
        int puntaje = correctas * 5;

        lbResultado.setText(
                "Puntaje: " + puntaje +
                        "\nCorrectas: " + correctas +
                        "\nIncorrectas: " + incorrectas
        );

        // Bloquear todas las opciones
        rbQuito.setDisable(true);
        rbGuayaquil.setDisable(true);
        rbCuenca.setDisable(true);

        rbPacifico.setDisable(true);
        rbAtlantico.setDisable(true);
        rbIndico.setDisable(true);

        rbCinco.setDisable(true);
        rbSeis.setDisable(true);
        rbSiete.setDisable(true);

        rbMarte.setDisable(true);
        rbJupiter.setDisable(true);
        rbVenus.setDisable(true);

        // Bloquear botón
        btCalificar.setDisable(true);
    }
}