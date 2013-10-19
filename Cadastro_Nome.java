/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

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
    JCheckBox ch_dep;
    JPanel p_tela;
    JButton b_enviar, b_cancelar;
    //

    public Cadastro_Nome() {
        iniciarComponentes();
        this.setVisible(true);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
    }
    //Função para iniciar os componentes na Janela

    public void iniciarComponentes() {
        t_nome = new JTextField(30);
        t_data = new JTextField(9);
        t_prof = new JTextField(10);
        t_cpf = new JTextField(13);
        t_idade = new JTextField(2);
        t_dependente = new JTextField(30);


        b_enviar = new JButton("Enviar");
        b_enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        
        b_cancelar = new JButton("Cancelar");
        b_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t_nome.setText("");
                t_data.setText("");
                t_prof.setText("");
                t_cpf.setText("");
                t_idade.setText("");
                t_dependente.setText("");
            }
        });
        
        
        // Função de Declarar estado falta implementar mais alguns estados
        c_estado = new JComboBox();
        c_estado.addItem("RJ");
        c_estado.addItem("SP");
        c_estado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x;
                x = c_estado.getSelectedIndex(); //Guarda na variavel o retorno do Index
                if (x == 0) {

                    c_cidade.setEnabled(true);
                    c_cidade.removeAllItems();
                    c_cidade.addItem("Cabo Frio");
                    c_cidade.addItem("Rio de Janeiro");
                    c_cidade.addItem("São Pedro");

                }
                if (x == 1) {
                    c_cidade.setEnabled(true);
                    c_cidade.removeAllItems();
                    c_cidade.addItem("Santos");
                    c_cidade.addItem("Campinas");
                    c_cidade.addItem("São Paulo");
                }
            }
        });

        c_cidade = new JComboBox();
        c_cidade.setEnabled(false);


        //Instancia o JLabel
        l_nome = new JLabel("Nome");
        l_data = new JLabel("Data");
        l_prof = new JLabel("Profissão");
        l_cpf = new JLabel("CPF");
        l_idade = new JLabel("Idade");

        
        l_cidade = new JLabel("Cidade:");
        l_estado = new JLabel("Estado");
        l_dependente = new JLabel("Nome do dependente");

        
        ch_dep = new JCheckBox();
        ch_dep.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(ch_dep.isSelected());
            }
        });

        
        l_dependente.setVisible(false);

        
        p_tela = new JPanel();
        p_tela.setLayout(new GridLayout(10, 2));

        
        p_tela.add(l_nome);
        p_tela.add(t_nome);
        p_tela.add(l_data);
        p_tela.add(t_data);
        p_tela.add(l_prof);
        p_tela.add(t_prof);
        p_tela.add(l_cpf);
        p_tela.add(t_cpf);
        p_tela.add(l_idade);
        p_tela.add(t_idade);


        p_tela.add(l_estado);
        p_tela.add(c_estado);



        p_tela.add(l_cidade);
        p_tela.add(c_cidade);

        p_tela.add(ch_dep);

        p_tela.add(l_dependente);



        p_tela.add(b_enviar);
        p_tela.add(b_cancelar);
        this.add(p_tela);
    }
}
