import javax.swing.JList.*;
import javax.swing.*;
import java.awt.*;

public class MainJmenu2 extends JFrame{
//2º JMenu: 
//-Seleção dos filmes e locação: 
//RadioButton ou CheckBox para filtra e criar a lista com os filmes. 
//-Botão Alugar 
//-Botão Devolver 
   
   private JButton alugar, devolver;
   private JPanel p;
   private JCheckBox cbAcao,cbRomance,cbTerror,cbComedia;
   private JList lista;
   private DefaultListModel acao,romance,terror,comedia;
   private JScrollPane scroll;
   
    MainJmenu2(){
        this.setVisible(true);
         this.setSize(400,400);
      
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        init();
    }
    
    public void init(){

        alugar      = new JButton("Alugar");
        devolver    = new JButton("Devolver");
        p           = new JPanel();
        cbAcao      = new JCheckBox("Ação");
        cbRomance   = new JCheckBox("Romance");
        cbTerror    = new JCheckBox("Terror");
        cbComedia   = new JCheckBox("Comédia");
 
        p.setLayout(new FlowLayout());
//        acao        = new DefaultListModel();
//        romance     = new DefaultListModel();        
//        terror      = new DefaultListModel();       

                comedia     = new DefaultListModel();
                lista        = new JList();
                lista.setVisible(true);

//        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//        list.setModel(acao);
        
//        acao.addElement("Duro de Matar 4.0");
//        romance.addElement("PS: Eu te amo");
//        terror.addElement("Coraline");
//        comedia.addElement("A era do gelo");

  
        
        p.add(cbAcao); p.add(cbRomance);
        p.add(cbTerror); p.add(cbComedia);
      
        p.add(alugar); p.add(devolver);
        this.add(p);
        
                
    }
    
}
