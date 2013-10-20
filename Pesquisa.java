import javax.swing.JList.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
/**
 *
 * @author moraes
 */
public class Pesquisa extends JFrame{
//2o JMenu: 
//-Seleção dos filmes e locação: 
//RadioButton ou CheckBox para filtra e criar a lista com os filmes. 
//-Botão Alugar 
//-Botão Devolver 
   
   private JButton alugar, devolver,buscar;
   private JPanel p;
   private JCheckBox cbAcao,cbRomance,cbTerror,cbComedia;
   private JList lista;
   private DefaultListModel defaultList;
   private JScrollPane scroll;
   
   private ArrayList <Filmes> listaFilmes = new ArrayList();
   private boolean[] categorias = new boolean[4];
   
    Pesquisa(){
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
        cbComedia   = new JCheckBox("Comédia");

        defaultList	= new DefaultListModel();
        lista		= new JList();
        
        p.setLayout(new GridLayout(4,4));
     
                lista        = new JList();
                lista.setVisible(true);
                lista.setModel(defaultList);
                
        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        //0 = ação, 1 = comédia, 2 = terror, 3 = romance
        Filmes duroDeMatar 	= new Filmes("Duro de Matar 4.0",0);
        Filmes homemDeFerro 	= new Filmes("Homem de Ferro",0);
        Filmes aEraDoGelo 	= new Filmes("A Era do Gelo",1);
        Filmes fear 		= new Filmes("Fear",2);
        Filmes psEuTeAmo 	= new Filmes("PS: Eu te Amo",3);
        
        listaFilmes.add(duroDeMatar);
        listaFilmes.add(homemDeFerro);
        listaFilmes.add(aEraDoGelo);
        listaFilmes.add(fear);
        listaFilmes.add(psEuTeAmo);

        
        p.add(cbAcao); p.add(cbComedia);
        p.add(cbTerror); p.add(cbRomance);
        p.add(lista);
        p.add(buscar); p.add(alugar); p.add(devolver);
        this.add(p);
       
        
        buscar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		defaultList.clear();
                categorias[0] 	= cbAcao.isSelected();
                categorias[1]	= cbComedia.isSelected();
                categorias[2] 	= cbTerror.isSelected();
                categorias[3]	= cbRomance.isSelected();
        		for (int i = 0; i < categorias.length; i++) { //roda as categorias para checar se estao selecionadas

        			if(categorias[i] == true){	//entra se a categoria do I estiver marcada
        				for (int j = 0; j < listaFilmes.size(); j++) {	//vai rodar por cada filme
        					if(listaFilmes.get(j).getCategoria() == i)	//se a categoria do filme for igual ao checkbox marcado
        						defaultList.addElement(listaFilmes.get(j).getNome());			
        					
        				}	//fim for lista filmmes
        			} //fim do if categorias
        		}
        	} //fim action performed        	
        }); //fim action listener
                
    }
    
}
