package edu.sdccd.cisc191.template;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.IntegerStringConverter;

public class GUI extends Application {

    public GUI() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        BorderPane bPane = new BorderPane();
        TableView table = new TableView<Scores>();

        table.setEditable(true);
        //Create columns and set cellvaluefactories
        TableColumn firstNameCol = new TableColumn<Scores, String>("Team 1");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Scores, String>("name"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Scores, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent event) {
                Scores score = (Scores) event.getRowValue();
                score.setName((String) event.getNewValue());

            }
        });

        TableColumn firstTeamScoreCol = new TableColumn("Score");
        firstTeamScoreCol.setCellValueFactory(new PropertyValueFactory<Scores, Integer>("score"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableColumn secondNameCol = new TableColumn("Team 2");
        secondNameCol.setCellValueFactory(new PropertyValueFactory<Scores, String>("name2"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn secondTeamScoreCol = new TableColumn("Score");
        secondTeamScoreCol.setCellValueFactory(new PropertyValueFactory<Scores, Integer>("score2"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableColumn winnerCol = new TableColumn("Winner");
        winnerCol.setCellValueFactory(new PropertyValueFactory<Scores, String>("winner"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        table.getColumns().addAll(firstNameCol, firstTeamScoreCol, secondNameCol, secondTeamScoreCol, winnerCol);
        for (Scores score : Scores.getScoreList()){
            table.getItems().add(score);
        }


        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        bPane.setCenter(table);

        Scene scene = new Scene(bPane, 440, 500);
        stage.setTitle("Score Tracker");
        //stage.setWidth(440);
      //  stage.setHeight(500);

        final Label label = new Label("Score Tracker");
        label.setFont(new Font("Arial", 20));




        stage.setScene(scene);
        stage.show();
    }
}