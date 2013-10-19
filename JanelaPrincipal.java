
package principal;
import javax.swing.*;

public class JanelaPrincipal extends JFrame{
    JMenuBar mBar; 
    JMenu m1,m2,m3; 
    JMenuItem a11,a12,a31,a32;
    
    ButtonGroup gCor,gFonte;
    JRadioButtonMenuItem cVermelho,cAzul,cAmarelo,fVermelho,fAzul,fAmarelo;
    
    JFrame p;
    
    public JanelaPrincipal(){ 
        iniciarComponentes(); 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        this.setSize(500, 300); 
        this.setVisible(true); 
          
    } 
      
    public void iniciarComponentes(){ 
        
        p           = new JFrame();
        mBar        = new JMenuBar(); 
        m1          = new JMenu("Cadastro"); 
        m2          = new JMenu("Seleção de Filmes"); 
        m3          = new JMenu("Layout"); 
        
              
        a11         = new JMenuItem("Cliente"); 
        a12         = new JMenuItem("Filme"); 
        a31         = new JMenuItem("Cor do Fundo");
        a32         = new JMenuItem("Cor da Fonte");
              
        
        gCor        = new ButtonGroup();
        gFonte      = new ButtonGroup();
        
        cVermelho   = new JRadioButtonMenuItem("Vermelho");
        cAzul       = new JRadioButtonMenuItem("Azul");
        cAmarelo    = new JRadioButtonMenuItem("Amarelo");
        fVermelho   = new JRadioButtonMenuItem("Vermelho");
        fAzul       = new JRadioButtonMenuItem("Azul");
        fAmarelo    = new JRadioButtonMenuItem("Amarelo");
        
        gCor.add(cVermelho);
        gCor.add(cAzul);
        gCor.add(cAmarelo);
        
        p.setLayout(null);
        
        
        
        //ADD DO MENU
        mBar.add(m1);
        mBar.add(m2);
        mBar.add(m3);
        
        //ADD ITENS MENU
        m1.add(a11);
        m1.add(a12);
        
        m3.add(a31);
        m3.add(a32);
        
        //ADD SUBITENS O MENU LAYOUT
        
        a31.add(cVermelho);
        a31.add(fAzul);
        a31.add(fAmarelo);
        a32.add(fVermelho);
        a32.add(fAzul);
        a32.add(fAmarelo);
        
        //ADD MENUBAR
        this.setJMenuBar(mBar);
      
        
        
        
        
    } 
          
    
}
