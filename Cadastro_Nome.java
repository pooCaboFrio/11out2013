package javaapplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author aluno
 */
public class Cadastro_Nome extends JFrame {

    JLabel l_nome, l_data, l_prof, l_cpf, l_idade, l_cidade, l_estado, l_dependente;
    JTextField t_nome, t_data, t_prof, t_cpf, t_idade, t_dependente;
    JComboBox c_cidade, c_estado;
    JRadioButton r_dep;
    JPanel p_tela;

    public Cadastro_Nome() {
        iniciarComponentes();
        this.setVisible(true);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
    }

    public void iniciarComponentes() {
        t_nome = new JTextField(30);
        t_data = new JTextField(9);
        t_prof = new JTextField(10);
        t_cpf = new JTextField(13);
        t_idade = new JTextField(2);
        t_dependente = new JTextField(30);

        l_nome = new JLabel("Nome");
        l_data = new JLabel("Data");
        l_prof = new JLabel("Profissão");
        l_cpf = new JLabel("CPF");
        l_idade = new JLabel("Idade");
        l_cidade = new JLabel("Cidade:");
        l_estado = new JLabel("Estado");
        l_dependente = new JLabel("Nome do dependente");

        l_dependente.setVisible(false);

        p_tela = new JPanel();
        p_tela.setLayout(new GridLayout(5, 5));

        p_tela.add(l_nome);

        p_tela.add(l_data);
        p_tela.add(l_prof);
        p_tela.add(l_cpf);
        p_tela.add(l_idade);
        p_tela.add(l_estado);
        p_tela.add(l_cidade);
        p_tela.add(l_dependente);
        
        p_tela.add(t_nome);

        this.add(p_tela);
    }
}
