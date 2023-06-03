import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMCCalculator extends JFrame {
    private JTextField pesoTextField;
    private JTextField alturaTextField;
    private JLabel resultadoLabel;

    public IMCCalculator() {
        // Configurações básicas do JFrame
        setTitle("Calculadora de IMC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        // Criação dos componentes
        JLabel pesoLabel = new JLabel("Peso (Kg):");
        pesoTextField = new JTextField();
        JLabel alturaLabel = new JLabel("Altura (cm):");
        alturaTextField = new JTextField();
        JButton calcularButton = new JButton("Calcular");
        resultadoLabel = new JLabel();

        // Adiciona os componentes ao JFrame
        add(pesoLabel);
        add(pesoTextField);
        add(alturaLabel);
        add(alturaTextField);
        add(calcularButton);
        add(resultadoLabel);

        // Define o ActionListener para o botão "Calcular"
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        // Obtém o peso e a altura inseridos pelo usuário
        double peso = Double.parseDouble(pesoTextField.getText());
        double altura = Double.parseDouble(alturaTextField.getText()) / 100; // Convertendo cm para metros

        // Calcula o IMC
        double imc = peso / (altura * altura);

        // Define a classificação baseada no IMC calculado
        String classificacao;
        if (imc < 18.5) {
            classificacao = "Abaixo do peso";
        } else if (imc < 25) {
            classificacao = "Peso normal";
        } else if (imc < 30) {
            classificacao = "Sobrepeso";
        } else {
            classificacao = "Obesidade";
        }

        // Exibe o resultado na interface gráfica
        resultadoLabel.setText("Seu IMC: " + String.format("%.2f", imc) + " - " + classificacao);
    }

    public static void main(String[] args) {
        // Cria e exibe a janela da calculadora de IMC
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                IMCCalculator calculator = new IMCCalculator();
                calculator.setVisible(true);
            }
        });
    }
}
