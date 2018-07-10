/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jonh_
 */
public class Menu_Principal extends Application{
    private static Stage stage;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(getClass().getClassLoader().getResource("View/MenuView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
        setStage(primaryStage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Menu_Principal.stage = stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
