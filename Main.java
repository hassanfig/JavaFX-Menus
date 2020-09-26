package sample;

import com.sun.codemodel.internal.fmt.JTextFile;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.lang.management.GarbageCollectorMXBean;

public class Main extends Application {

    @Override
    public void start(Stage PrimaryStage) throws Exception{


        BorderPane root = new BorderPane();
        MenuBar menubar = new MenuBar();
        root.setTop(menubar);

        //file Menus
        Menu fileMenu = new Menu("File");
        MenuItem item1 = new MenuItem("New Project      Ctrl+Shift+N");
        MenuItem item2 = new MenuItem("Open Project      Ctrl+Shift+o");
        MenuItem item3 = new MenuItem("Exit");
        item3.setOnAction(e -> Platform.exit());
        fileMenu.getItems().addAll(item1,item2,new SeparatorMenuItem(),item3);

        Menu viewMenu = new Menu("View");
        CheckMenuItem check1 = new CheckMenuItem("Editor");
        check1.setSelected(true);

        CheckMenuItem check2 = new CheckMenuItem("Line Number");
        check2.setSelected(true);

        viewMenu.getItems().addAll(check1,check2, new SeparatorMenuItem());


        Menu toolbar = new Menu("Toolbar");
        toolbar.getItems().addAll(
        new CheckMenuItem("File"),
        new CheckMenuItem("Run"),
        new CheckMenuItem("Debug")
        );
        viewMenu.getItems().addAll(toolbar);


        menubar.getMenus().addAll(fileMenu,viewMenu);

        Scene scene = new Scene(root,450,350,Color.WHITE);
        PrimaryStage.setScene(scene);
        PrimaryStage.setResizable(false);
        PrimaryStage.setTitle("Menus");
        PrimaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
