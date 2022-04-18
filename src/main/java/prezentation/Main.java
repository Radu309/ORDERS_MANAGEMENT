package prezentation;

import connection.MySql;
import dataAccess.DataAccess;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage1) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("VirtualShopDesign.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 450);
        stage1.setTitle("Hello!");
        stage1.setScene(scene);
        stage1.show();
    }

    public static void main(String[] args) {
        DataAccess dataAccess = new DataAccess();
        launch();
    }
}