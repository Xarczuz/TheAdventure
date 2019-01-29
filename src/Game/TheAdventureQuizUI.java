package Game;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class TheAdventureQuizUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws FileNotFoundException, IOException, ParseException {
		primaryStage.setTitle("The Adventure Quiz Game!");

		// Generate Questions
		Quiz_Generator qg1 = new Quiz_Generator();
		Quiz_Data data = new Quiz_Data();

		data.quizBank(qg1);

		// ******************
		Text t = new Text();
		Button btn = new Button();
		qg1.publish_question();
		t.setText(qg1.getActiveQuiz().getQuestion());
		t.setLayoutX(200);
		t.setLayoutY(100);
		btn.setText("New Question.");
		btn.setLayoutX(10);
		btn.setLayoutY(450);

		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				qg1.publish_question();
				t.setText(qg1.getActiveQuiz().getQuestion());

				primaryStage.show();
			}
		});

		Pane root = new Pane();

		root.getChildren().add(btn);
		root.getChildren().add(t);

		primaryStage.setScene(new Scene(root, 1000, 700));
		primaryStage.show();

	}

	public static void name() {

	}

}
