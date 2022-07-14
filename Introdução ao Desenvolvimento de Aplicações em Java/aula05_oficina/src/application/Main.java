package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage palco) {
		VBox layoutRaiz = new VBox(10);
		layoutRaiz.setPadding(new Insets(10, 30, 10, 10));

		BorderPane layoutNome = new BorderPane();
		Label labelNome = new Label("Nome:");
		TextField textNome = new TextField();

		layoutNome.setLeft(labelNome);
		layoutNome.setBottom(textNome);

		BorderPane layoutEndereco = new BorderPane();
		Label labelEndereco = new Label("Endereço:");
		TextField textEndereco = new TextField();

		layoutEndereco.setLeft(labelEndereco);
		layoutEndereco.setBottom(textEndereco);

		BorderPane layoutCpf = new BorderPane();
		Label labelCpf = new Label("CPF: ");
		TextField textCpf = new TextField();

		layoutCpf.setLeft(labelCpf);
		layoutCpf.setBottom(textCpf);

		BorderPane layoutRg = new BorderPane();
		Label labelRg = new Label("RG:");
		TextField textRg = new TextField();

		layoutRg.setLeft(labelRg);
		layoutRg.setBottom(textRg);

		BorderPane layoutIdade = new BorderPane();
		Label labelIdade = new Label("Idade:");
		TextField textIdade = new TextField();
		layoutIdade.setLeft(labelIdade);
		layoutIdade.setBottom(textIdade);

		BorderPane layoutSexo = new BorderPane();
		Label labelSexo = new Label("Sexo:");
		HBox radioSexo = new HBox(10);
		RadioButton masculino = new RadioButton("M");
		RadioButton feminino = new RadioButton("F");

		masculino.setPrefWidth(10);
		feminino.setPrefWidth(10);
		radioSexo.setAlignment(Pos.TOP_LEFT);
		radioSexo.setPadding(new Insets(10, 0, 0, 0));
		radioSexo.getChildren().addAll(masculino, feminino);
		layoutSexo.setLeft(labelSexo);
		layoutSexo.setBottom(radioSexo);

		BorderPane layoutSelecaoQuartos = new BorderPane();
		Label labelQuartos = new Label("Quartos:");

		ObservableList<String> quantidadeQuartos = FXCollections.observableArrayList("1", "2", "3");
		final ComboBox cbQuantidadeQuartos = new ComboBox(quantidadeQuartos);

		layoutSelecaoQuartos.setLeft(labelQuartos);
		layoutSelecaoQuartos.setBottom(cbQuantidadeQuartos);

		BorderPane layoutEntradaESaida = new BorderPane();
		CheckBox cbEntrada = new CheckBox("Check-In");
		CheckBox cbSaida = new CheckBox("Check-Out");

		cbEntrada.setPrefWidth(90);
		cbSaida.setPrefWidth(90);

		HBox caixaOpcoesEntradaESaida = new HBox(cbEntrada, cbSaida);
		caixaOpcoesEntradaESaida.setPadding(new Insets(0, 10, 10, 0));

		layoutEntradaESaida.setLeft(caixaOpcoesEntradaESaida);

		HBox layoutBotoes = new HBox(20);

		Button btnSalvar = new Button("Salvar");
		Button btnBuscar = new Button("Buscar");
		Button btnCancelar = new Button("Cancelar");

		btnSalvar.setPrefWidth(100);
		btnBuscar.setPrefWidth(100);
		btnCancelar.setPrefWidth(100);

		layoutBotoes.setAlignment(Pos.TOP_LEFT);

		layoutBotoes.setPadding(new Insets(10, 0, 0, 0));

		layoutBotoes.getChildren().addAll(btnSalvar, btnBuscar, btnCancelar);

		layoutRaiz.getChildren().addAll(layoutNome, layoutEndereco, layoutCpf, layoutRg, layoutIdade, layoutSexo,
				layoutSelecaoQuartos, layoutEntradaESaida, layoutBotoes);

		Scene cena = new Scene(layoutRaiz, 340, 460);
		palco.setScene(cena);
		palco.setTitle("Cadastro para Check-in de Hotel");
		palco.show();

	}

	public static void main(String[] args) {
		launch();
	}
}
