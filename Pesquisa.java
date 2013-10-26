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
   
   private JButton alugar, devolver,buscar;
   private JPanel pBoxes,pList,pButtons;
   private JCheckBox cbAcao,cbRomance,cbTerror,cbComedia;
   private JList lista;
   private DefaultListModel defaultList;
   private JScrollPane scroll;
   
   private ArrayList <Filmes> listaFilmes = new ArrayList();
   private boolean[] categorias = new boolean[4]; //numero de checkboxes
   
    Pesquisa(){
    	this.setTitle("Pesquisar Filmes");  	
    	this.setSize(420,250);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1,4));
        init();
    }
    
    public void init(){

        alugar      = new JButton("Alugar");
        devolver    = new JButton("Devolver");
        buscar		= new JButton("Buscar");
        
        pBoxes	    = new JPanel();
        pList		= new JPanel();
        pButtons	= new JPanel();
        
        cbAcao      = new JCheckBox("Ação");
        cbRomance   = new JCheckBox("Romance");
        cbTerror    = new JCheckBox("Terror");
        cbComedia   = new JCheckBox("Comédia");

        pBoxes.setLayout(new FlowLayout(FlowLayout.TRAILING));
        pBoxes.setLayout(new FlowLayout(FlowLayout.CENTER));
        pBoxes.setLayout(new FlowLayout(FlowLayout.LEADING));
        
        defaultList		= new DefaultListModel();
        lista        	= new JList(defaultList);  

        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        //Instancia os Filmes
        //0 = ação, 1 = comédia, 2 = terror, 3 = romance
        Filmes duroDeMatar 	= new Filmes("Duro de Matar 4.0","Ação");
        Filmes homemDeFerro = new Filmes("Homem de Ferro","Ação");
        Filmes aEraDoGelo 	= new Filmes("A Era do Gelo","Comédia,Ação");
        Filmes fear 		= new Filmes("Fear","Ação,Terror");
        Filmes psEuTeAmo 	= new Filmes("PS: Eu te Amo","Romance,Comédia");
        
        //Adiciona os objetos filmes ao Array
        listaFilmes.add(duroDeMatar);
        listaFilmes.add(homemDeFerro);
        listaFilmes.add(aEraDoGelo);
        listaFilmes.add(fear);
        listaFilmes.add(psEuTeAmo);

        //Adiciona componentes aos paineis
        pBoxes.add(cbAcao); pBoxes.add(cbComedia);
        pBoxes.add(cbTerror); pBoxes.add(cbRomance);
        pList.add(lista);
        pBoxes.add(buscar);     
        pButtons.add(alugar); pButtons.add(devolver);
        
        //Adiciona os 3 paineis ao JFrame
        this.add(pBoxes);
        this.add(pList);
        this.add(pButtons);
        
        //TODO objetos em mais de uma categoria aparecem mais de uma vez na lista  
        alugar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		defaultList.clear();
        		
                categorias[0] 	= cbAcao.isSelected();
                categorias[1]	= cbComedia.isSelected();
                categorias[2] 	= cbTerror.isSelected();
                categorias[3]	= cbRomance.isSelected();
                
                /* Somente para checar atraves do for no loop
                 * Apenas inserindo os textos dos checkboxes para um vetor de Strings
                 */
                String[] strs 	= new String[4];	
                strs[0]			= cbAcao.getText();
                strs[1]			= cbComedia.getText();
                strs[2]			= cbTerror.getText();
                strs[3]			= cbRomance.getText();
                
        		for (int i = 0; i < strs.length; i++) { 
        			if(categorias[i] == true){	
        				for (int j = 0; j < listaFilmes.size(); j++) {	
        					if(listaFilmes.get(j).getGenero().contains(strs[i]))
        					defaultList.addElement(listaFilmes.get(j).getNome());			
        				}
        			} 
        		}
        	} 
        }); 
                
        //OK
        buscar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		defaultList.clear();
        		
        		//Se um checkbox estiver marcado, ele verifica todos os filmes e exibe aquele cuja a categoria é igual ao checkbox 
                categorias[0] 	= cbAcao.isSelected();
                categorias[1]	= cbComedia.isSelected();
                categorias[2] 	= cbTerror.isSelected();
                categorias[3]	= cbRomance.isSelected();
        		for (int i = 0; i < categorias.length; i++) { //roda as categorias para checar se estao selecionadas

        			if(categorias[i] == true){	//entra se a categoria do 'i'(checkbox) estiver como true
        				for (int j = 0; j < listaFilmes.size(); j++) {	//vai rodar por cada filme
        					if(listaFilmes.get(j).getCategoria() == i)	//se a categoria do filme for igual ao checkbox marcado
        						defaultList.addElement(listaFilmes.get(j).getNome());	
        						
        					
        				}	//fim for lista filmes
        			} //fim do if categorias
        		}
        	} //fim action performed        	
        }); //fim action listener
                
    }	//fim init   
}	//fim classe
