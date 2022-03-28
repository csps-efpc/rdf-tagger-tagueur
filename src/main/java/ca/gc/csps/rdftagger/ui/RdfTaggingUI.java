package ca.gc.csps.rdftagger.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author jturner
 */
public class RdfTaggingUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        // Happens before start()
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ResourceBundle rb = ResourceBundle.getBundle("ca.gc.csps.rdftagger.ui.i18n");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ca/gc/csps/rdftagger/ui/RdfTaggingUI.fxml"), rb);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("RDF Tagger");
        primaryStage.getIcons().clear();
        primaryStage.getIcons().add(new Image(getClass().getResource("triple.png").toExternalForm()));
        primaryStage.setScene(scene);
        primaryStage.show();
        RdfTaggingUIController controller = loader.getController();
        Platform.runLater(() -> {

            Parameters cliParms = this.getParameters();
            if (!cliParms.getUnnamed().isEmpty()) {
                controller.loadSubjectsFile(Arrays.asList(new File[]{new File(cliParms.getUnnamed().get(0))}));
                if (cliParms.getUnnamed().size() > 1) {
                    controller.loadPredicatesFile(Arrays.asList(new File[]{new File(cliParms.getUnnamed().get(1))}));
                }
                if (cliParms.getUnnamed().size() > 2) {
                    controller.loadObjectsFile(Arrays.asList(new File[]{new File(cliParms.getUnnamed().get(2))}));
                }
                if (cliParms.getUnnamed().size() > 3) {
                    controller.loadRDFModel(Arrays.asList(new File[]{new File(cliParms.getUnnamed().get(3))}));
                }
            }
        });
    }

    @Override
    public void stop() throws Exception {
    }

}
