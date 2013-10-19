package persistencia.DAO;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import modelo.Filme;
import persistencia.Connector;




/**
 * Classe DAO respons�vel pela persist�ncia do banco de dados da classe filme.
 * */
public class FilmeDAO {

    Connector c = new Connector();
    private static FilmeDAO SINGLETON = null; //Cria  a conex�o como um singleton, ou seja, �o poder� haver duas instancias na memoria

    public static FilmeDAO getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new FilmeDAO();
        }
        return SINGLETON;
    }

    /**
     * Inclui um filme no banco de dados
     * */
    public void incluir(Filme f) { //Inclui no banco de dados
        try {
            PreparedStatement ps = c.getConnection().prepareStatement(
                    "INSERT INTO ROOT.FILME (titulo, genero, sinopse, classificacao, ano, duracao) VALUES (?,?,?,?,?,?)"); //Cria o statemente e passa o sql, cada ? � um paramento
            ps.setString(1, f.getTitulo());
            ps.setString(2, f.getGenero());
            ps.setString(3, f.getSinopse());
            ps.setString(4, String.valueOf(f.getClassificacao()));
            ps.setString(5, String.valueOf(f.getAno()));
            ps.setString(6, String.valueOf(f.getDuracao()));
            ps.execute(); //executa
           // ResultSet rs = ps.executeQuery("select id from filme order by id desc limit 1");
            //	rs.next();
            //	f.setId(rs.getInt("id"));
            ps.close(); //fecha
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir filme"); //emite uma mensagem caso haja erro
        }

    }

    /**
     * Altera as informa��es de um filme no banco de dados
     * */
    public void alterar(Filme f) {
      
        try {
            PreparedStatement ps = c.getConnection().prepareStatement(
                    "UPDATE ROOT.FILME set titulo = ?, genero = ? , sinopse = ?, classificacao = ?, ano = ?, duracao = ? WHERE id = ?");
            ps.setString(1, f.getTitulo());
            ps.setString(2, f.getGenero());
            ps.setString(3, f.getSinopse());
            ps.setString(4, String.valueOf(f.getClassificacao()));
            ps.setString(5, String.valueOf(f.getAno()));
            ps.setString(6, String.valueOf(f.getDuracao()));
            ps.execute();
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar filme" );
        }

    }

    /**
     * Retorna as informa��es de um filme do banco de dados a partir do nome
     * */
    public void pesquisar(Filme f) {

        try {
            PreparedStatement ps = c.getConnection().prepareStatement(
                    "SELECT * FROM ROOT.filme WHERE titulo like ?");
            ps.setString(1, "%" + f.getTitulo() + "%");
            ResultSet rs = ps.executeQuery();
            rs.next();
            fillObj(f, rs);
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "O filme nao foi localizado");
        }

    }
    

    public Vector pesquisarTodos(Filme f) {
        Vector<Filme> vetor = new Vector<Filme>();
        try {
            PreparedStatement ps = c.getConnection().prepareStatement(
                    "SELECT * FROM ROOT.filme order by titulo");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Filme f2 = new Filme();
                fillObj(f2, rs);
                vetor.add(f2);
            }

            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar filmes");
        } finally {
            return vetor;
        }
    }

    

    private void fillObj(Filme f, ResultSet rs) throws SQLException {
        f.setTitulo(rs.getString("titulo"));
        f.setGenero(rs.getString("genero"));
        f.setClassificacao(rs.getInt("classificacao"));
        f.setDuracao(rs.getDouble("duracao"));
        f.setSinopse(rs.getString("sinopse"));
        f.setAno(rs.getInt("ano"));

    }

    /**
     * Exclui um filme no banco de dados
     * */
    public void excluir(Filme f) {

      try{
           PreparedStatement ps = c.getConnection().prepareStatement(
                    "DELETE FROM ROOT.filme WHERE titulo= ?");
            ps.setString(1, f.getTitulo());
            ps.execute();
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir filme");
        }

    }


}
