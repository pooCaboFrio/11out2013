import javax.swing.JList.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainJmenu2 extends JFrame{
//2Âº JMenu: 
//-SeleÃ§Ã£o dos filmes e locaÃ§Ã£o: 
//RadioButton ou CheckBox para filtra e criar a lista com os filmes. 
//-BotÃ£o Alugar 
//-BotÃ£o Devolver 
   
   private JButton alugar, devolver,buscar;
   private JPanel p;
   private JCheckBox cbAcao,cbRomance,cbTerror,cbComedia;
   private JList lista;
   private DefaultListModel defaultList;
   private JScrollPane scroll;
   private ArrayList <Filmes> listaFilmes = new ArrayList();
   
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
        buscar		= new JButton("Buscar");
        
        p           = new JPanel();
        cbAcao      = new JCheckBox("Ação");
        cbRomance   = new JCheckBox("Romance");
        cbTerror    = new JCheckBox("Terror");
        cbComedia   = new JCheckBox("ComÃ©dia");
 
        defaultList	= new DefaultListModel();
        lista		= new JList();
        
        p.setLayout(new GridLayout(4,4));
     
                lista        = new JList();
                lista.setVisible(true);

        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        lista.setModel(defaultList);
        
        defaultList.addElement("Duro de Matar 4.0");

  
        
        p.add(cbAcao); p.add(cbRomance);
        p.add(cbTerror); p.add(cbComedia);
        p.add(lista);
        p.add(buscar); p.add(alugar); p.add(devolver);
        this.add(p);
        
                
    }
    
}
