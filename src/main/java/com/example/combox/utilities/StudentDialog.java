package com.example.combox.utilities;

import com.example.combox.Student;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class StudentDialog {
    public static Optional<Student> showAndWait() {

        //Creating dialog

        Dialog<Student> dialog = new Dialog<>();
        dialog.setTitle("Create new student");
        dialog.setHeaderText("Please enter student data!");

        //Button
        ButtonType createButton = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButton, ButtonType.CANCEL);

        //Inputs for data
        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField ageField = new TextField();
        ageField.setPromptText("Age");

        //Add grid

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(new Label("Name: "), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Age: "), 0, 1);
        grid.add(ageField, 1, 1);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButton) {
                try {
                    String name = nameField.getText().trim();
                    int age = Integer.parseInt(ageField.getText().trim());
                    return new Student(name, age);
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Incorrect age value");
                    alert.showAndWait();
                }
            }
            return null;
        });
        return dialog.showAndWait();
    }
}
