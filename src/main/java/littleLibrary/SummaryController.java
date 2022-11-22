package littleLibrary;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SummaryController {
    @FXML
    Label summaryLabel = new Label();
    Slideshow slideshow = new Slideshow();
    @FXML StackPane slideShowContainer = new StackPane();
    public void initialize () throws SQLException {
        getBookSummary();
        slideshow.showCovers();
    }
    public void getBookSummary() throws SQLException {
        Connection connection = DatabaseTings.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*)FROM Entries");

        int numEntries = 0;
        if (resultSet.next()) {
            numEntries = resultSet.getInt(1);
        }

        summaryLabel.setText("You have read " + numEntries + " books this year");
    }
}
