package com.example.combox;

import com.example.combox.utilities.StudentDialog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.Optional;

public class MainController {
    @FXML
    public ComboBox student_combo;
    @FXML
    public Label student_text;
    @FXML
    public ComboBox value_combo;
    @FXML
    public Label value_text;
    @FXML
    ObservableList<Student> students = FXCollections.observableArrayList();

    public void initialize() {

        students.addAll(
                new Student("Jonas", 34),
                new Student("Karolis", 35),
                new Student("Ieva", 18));

        //Add students to combo
        student_combo.setItems(students);

        student_combo.setOnAction(e -> {
            Student selectedStudent = (Student) student_combo.getValue();
            if (selectedStudent != null) {
                student_text.setText("Student: " + selectedStudent);
            }
        });

        value_combo.setItems(FXCollections.observableArrayList("Reiksme 1", "Reiksme 2", "Reiksme 3"));

    }
    @FXML
    private void addStudent(){
        Optional<Student> newStudent = StudentDialog.showAndWait();
        newStudent.ifPresent(student -> {
            students.add(student);
            student_combo.setValue(student);
        });
    }


}
