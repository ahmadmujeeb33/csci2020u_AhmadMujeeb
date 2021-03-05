package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn sid;
    @FXML
    private TableColumn assignments;
    @FXML
    private TableColumn midterm;
    @FXML
    private TableColumn finalExam;
    @FXML
    private TableColumn FinalMark;
    @FXML
    private TableColumn Lettergrade;

    private TableView<DataSource> people;



    @FXML
    public void initialize() {
        sid.setCellValueFactory(new PropertyValueFactory<>("sid"));
        assignments.setCellValueFactory(new PropertyValueFactory<>("assignments"));
        midterm.setCellValueFactory(new PropertyValueFactory<>("midterm"));
        finalExam.setCellValueFactory(new PropertyValueFactory<>("finalExam"));
        FinalMark.setCellValueFactory(new PropertyValueFactory<>("FinalMark"));
        Lettergrade.setCellValueFactory(new PropertyValueFactory<>("Lettergrade"));
        tableView.setItems(DataSource.getAllMarks());
    }


}