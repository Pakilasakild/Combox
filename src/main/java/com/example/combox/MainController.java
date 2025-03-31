package com.example.combox;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {
    @FXML
    public ComboBox student_combo;
    @FXML
    public Label student_text;
    @FXML
    public ComboBox value_combo;
    @FXML
    public Label value_text;

    public void initialize() {
        List<Student> students = Arrays.asList(
                new Student("Jonas", 34),
                new Student("Karolis", 35),
                new Student("Ieva", 18)
        );


        //Add students to combo
        student_combo.setItems(FXCollections.observableArrayList(students));

        value_combo.setItems(FXCollections.observableArrayList("Reiksme 1", "Reiksme 2", "Reiksme 3"));


    }

}
