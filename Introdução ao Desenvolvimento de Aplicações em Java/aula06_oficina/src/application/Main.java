package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage palco) {
		Map<String, ArrayList> listagemHospedes = new HashMap<String, ArrayList>();
		ArrayList dadosHospede = new ArrayList<>();

		VBox layoutRaiz = new VBox(10);
		layoutRaiz.setPadding(new Insets(10, 30, 10, 10));

		BorderPane layoutNome = new BorderPane();
		Label labelNome = new Label("Nome:");
		TextField textNome = new TextField();

		layoutNome.setLeft(labelNome);
		layoutNome.setBottom(textNome);

		System.out.println(dadosHospede);
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

		final ToggleGroup tgSexo = new ToggleGroup();
		BorderPane layoutSexo = new BorderPane();
		Label labelSexo = new Label("Sexo:");
		HBox radioSexo = new HBox(10);
		RadioButton masculino = new RadioButton("M");
		RadioButton feminino = new RadioButton("F");

		masculino.setSelected(true);
		tgSexo.getToggles().addAll(masculino, feminino);

		masculino.setPrefWidth(10);
		feminino.setPrefWidth(10);
		radioSexo.setAlignment(Pos.TOP_LEFT);
		radioSexo.setPadding(new Insets(10, 0, 0, 0));
		radioSexo.getChildren().addAll(masculino, feminino);
		layoutSexo.setLeft(labelSexo);
		layoutSexo.setBottom(radioSexo);

		BorderPane layoutSelecaoQuartos = new BorderPane();
		Label labelQuartos = new Label("Número do Quarto");

		ObservableList<String> numeroQuarto = FXCollections.observableArrayList("101", "102", "103");
		final ComboBox cbNumeroQuarto = new ComboBox(numeroQuarto);

		layoutSelecaoQuartos.setLeft(labelQuartos);
		layoutSelecaoQuartos.setBottom(cbNumeroQuarto);

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
		Button btnRemover = new Button("Remover");

		btnSalvar.setPrefWidth(100);
		btnBuscar.setPrefWidth(100);
		btnRemover.setPrefWidth(100);

		layoutBotoes.setAlignment(Pos.TOP_LEFT);

		layoutBotoes.setPadding(new Insets(10, 0, 0, 0));

		layoutBotoes.getChildren().addAll(btnSalvar, btnBuscar, btnRemover);

		layoutRaiz.getChildren().addAll(layoutNome, layoutEndereco, layoutCpf, layoutRg, layoutIdade, layoutSexo,
				layoutSelecaoQuartos, layoutEntradaESaida, layoutBotoes);

		btnSalvar.setOnAction(e -> {
			ArrayList dadosSalvos = new ArrayList<>();

			RadioButton rbSexo = (RadioButton) tgSexo.getSelectedToggle();

			String estadoHospede = "";

			if (cbEntrada.isSelected()) {
				estadoHospede = "Check-in";
			} else if (cbSaida.isSelected()) {
				estadoHospede = "Check-out";
			} else {
				estadoHospede = "Não hospedado.";
			}

			dadosSalvos.add(textNome.getText());
			dadosSalvos.add(textEndereco.getText());
			dadosSalvos.add(textCpf.getText());
			dadosSalvos.add(textRg.getText());
			dadosSalvos.add(textIdade.getText());
			dadosSalvos.add(rbSexo.getText());
			dadosSalvos.add(cbNumeroQuarto.getSelectionModel().getSelectedItem());
			dadosSalvos.add(estadoHospede);

			listagemHospedes.put(textCpf.getText(), dadosSalvos);

			Alert mensagemConfirmacao = new Alert(Alert.AlertType.INFORMATION);
			mensagemConfirmacao.setHeaderText("Cadastro de hóspede");
			mensagemConfirmacao.setContentText("Hóspede cadastrado com sucesso!");
			mensagemConfirmacao.showAndWait();

			limparFormulario(textNome, textEndereco, textCpf, textRg, textIdade, masculino, cbEntrada, cbSaida);
		});

		btnBuscar.setOnAction(e -> {
			try {
				buscarHospede(listagemHospedes, textCpf.getText(), textNome, textEndereco, textCpf, textRg, textIdade,
						masculino, feminino, cbNumeroQuarto, cbSaida, cbSaida);
			} catch (Exception eHospedeNaoEncontrado) {
				Alert mensagemErro = new Alert(Alert.AlertType.ERROR);
				mensagemErro.setHeaderText("Hóspede não encontrado.");
				mensagemErro.setContentText("Hóspede não encontrado. Por favor, verifique CPF inserido.");
				mensagemErro.showAndWait();
			}

		});

		btnRemover.setOnAction(e -> {
			try {
				buscarHospede(listagemHospedes, textCpf.getText(), textNome, textEndereco, textCpf, textRg, textIdade,
						masculino, feminino, cbNumeroQuarto, cbSaida, cbSaida);
				Alert mensagemConfirmarRemover = new Alert(Alert.AlertType.CONFIRMATION);
				ButtonType btnSim = new ButtonType("Sim");
				ButtonType btnNao = new ButtonType("Não");

				mensagemConfirmarRemover.setTitle("Confirmação de remoção de cadastro");
				mensagemConfirmarRemover.setHeaderText(
						"Informe se você deseja remover o cadastro de " + textNome.getText().toUpperCase() + ".");
				mensagemConfirmarRemover.setContentText("Deseja remover o cadastro do sistema?");
				mensagemConfirmarRemover.getButtonTypes().setAll(btnSim, btnNao);

				mensagemConfirmarRemover.showAndWait().ifPresent(opcao -> {

					if (opcao == btnSim) {
						listagemHospedes.remove(textCpf.getText());
						limparFormulario(textNome, textEndereco, textCpf, textRg, textIdade, masculino, cbEntrada,
								cbSaida);
					} else {
						mensagemConfirmarRemover.close();
					}
				});
			} catch (Exception erroHospedeNaoEncontrado) {
				Alert mensagemErro = new Alert(Alert.AlertType.ERROR);
				mensagemErro.setHeaderText("Hóspede não encontrado.");
				mensagemErro.setContentText("Hóspede não encontrado. Por favor, verifique o CPF inserido.");
				mensagemErro.showAndWait();
			}

		});

		Scene cena = new Scene(layoutRaiz, 340, 460);
		palco.setScene(cena);
		palco.setTitle("Cadastro para Check-in de Hotel");
		palco.show();

	}

	public static void main(String[] args) {
		launch();
	}

	public static void limparFormulario(TextField textNome, TextField textEndereco, TextField textCpf, TextField textRg,
			TextField textIdade, RadioButton masculino, CheckBox cbEntrada, CheckBox cbSaida) {
		textNome.clear();
		textEndereco.clear();
		textCpf.clear();
		textRg.clear();
		textIdade.clear();
		cbEntrada.setSelected(false);
		cbSaida.setSelected(false);
		masculino.setSelected(true);
	}

	public static void buscarHospede(Map listagemHospedes, String string, TextField textNome, TextField textEndereco,
			TextField textCpf, TextField textRg, TextField textIdade, RadioButton masculino, RadioButton feminino,
			ComboBox cbNumeroQuarto, CheckBox cbEntrada, CheckBox cbSaida) {
		ArrayList dadosHospede = (ArrayList) listagemHospedes.get(string);

		textNome.setText((String) dadosHospede.get(0));
		textEndereco.setText((String) dadosHospede.get(1));
		textRg.setText((String) dadosHospede.get(3));
		textIdade.setText((String) dadosHospede.get(4));

		String sexo = (String) dadosHospede.get(5);

		if (sexo == "M") {
			masculino.setSelected(true);
		} else {
			feminino.setSelected(true);
		}

		cbNumeroQuarto.setValue((String) dadosHospede.get(6));

		String estadoHospede = (String) dadosHospede.get(7);

		if (estadoHospede == "Check-in") {
			cbEntrada.setSelected(true);
			cbSaida.setSelected(false);
		} else if (estadoHospede == "Check-out") {
			cbSaida.setSelected(true);
			cbEntrada.setSelected(false);
		}

	}

}