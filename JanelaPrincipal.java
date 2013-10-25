package principal;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.*;
import javax.swing.*;


public class JanelaPrincipal extends JFrame{
    JMenuBar mBar; 
    JMenu m1,m2,m3,m31,m32; 
    JMenuItem a11,a12;
    
    Font fonte;
    Color cor;
    
    NewJFrame jfPrincipal;
    
    ButtonGroup gCor,gFonte;
    JRadioButtonMenuItem cVermelho,cAzul,cAmarelo,fVermelho,fAzul,fAmarelo;
    
    
    public void setCor(Color c){
        jfPrincipal.setBackground(c);
        mBar.setBackground(c);
    }
    
    public void setFonte(){
        
    }
    
    
    public JanelaPrincipal(){ 
        iniciarComponentes(); 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        this.setSize(500, 300); 
        this.setVisible(true); 
          
    } 
      
    public void iniciarComponentes(){ 
        fonte       = new Font("Courier",Font.PLAIN,12);
        cor         = new Color(0,0,0);
        
        jfPrincipal = new NewJFrame();
        mBar        = new JMenuBar(); 
        m1          = new JMenu("Cadastro"); 
        m2          = new JMenu("Seleção de Filmes"); 
        m3          = new JMenu("Layout"); 
              
        a11         = new JMenuItem("Cliente"); 
        a12         = new JMenuItem("Filme"); 
        m31         = new JMenu("Cor do Fundo");
        m32         = new JMenu("Cor da Fonte");
        
        gCor        = new ButtonGroup();
        gFonte      = new ButtonGroup();
        
        cVermelho   = new JRadioButtonMenuItem("Vermelho");
        cAzul       = new JRadioButtonMenuItem("Azul");
        cAmarelo    = new JRadioButtonMenuItem("Amarelo");
        fVermelho   = new JRadioButtonMenuItem("Vermelho");
        fAzul       = new JRadioButtonMenuItem("Azul");
        fAmarelo    = new JRadioButtonMenuItem("Amarelo");
        
        
        
        //ADD DO MENU
        mBar.add(m1);
        mBar.add(m2);
        mBar.add(m3);
        
        //ADD ITENS MENU
        m1.add(a11);
        m1.add(a12);
        
        m3.add(m31);
        m3.add(m32);
        
        //ADD SUBITENS O MENU LAYOUT
        
        gCor.add(cVermelho);
        gCor.add(cAzul);
        gCor.add(cAmarelo);
        gFonte.add(fVermelho);
        gFonte.add(fAzul);
        gFonte.add(fAmarelo);
        
        
        m31.add(cVermelho);
        m31.add(cAzul);
        m31.add(cAmarelo);
        m32.add(fVermelho);
        m32.add(fAzul);
        m32.add(fAmarelo);
        
        //ADD MENUBAR
        this.setJMenuBar(mBar);
        
        //ADD JFRAME E SETLAYOUT
        jfPrincipal.setLayout(null);
        jfPrincipal.setVisible(true);
        this.add(jfPrincipal);
      
        //LISTNERS
        
        cVermelho.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setCor(Color.red);
                    }
                }
        );
        cAzul.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setCor(Color.blue);
                    }
                }
        );
        cAmarelo.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setCor(Color.yellow);
                    }
                }
        );
        
        
        
        
        
    } 
          
    
}
