package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Locadora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LocadoraDAO extends GenericDAO {

    private final static String CRIAR_LOCADORA_SQL = "insert into Locadora" + " (email_locadora, senha_locadora, cnpj_locadora, nome_locadora, cidade_locadora)" + "values(?,?,?,?,?)";
    private final static String LISTAR_LOCADORA_SQL = "select" + "*" + "from Locadora";
    //private final static String LISTAR_LOCADORA_SQL = "select" + "email_locadora, cnpj_locadora, nome_locadora, cidade_locadora)"+ "from locadora" ;
    private final static String LISTAR_LOCADORA_CIDADE_SQL = "select" + "email_locadora, cnpj_locadora, nome_locadora, cidade_locadora)" + "where cidade_locadora = ?";

    public Locadora gravarLocadora(Locadora locadora) throws SQLException {
        try (Connection con = this.getConnection()) {
            PreparedStatement ps = con.prepareStatement(CRIAR_LOCADORA_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, locadora.getCnpj_locadora());
            ps.setString(2, locadora.getEmail_locadora());
            ps.setString(3, locadora.getSenha_locadora());
            ps.setString(4, locadora.getNome_locadora());
            ps.setString(5, locadora.getCidade_locadora());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
        }
        return locadora;
    }

//Teoricamente, o método a seguir já lista todas as locadoras. Verificar se é melhor deixar ele ou o seguinte, que já tava implementado
    /*public List<Locadora> listarTodasLocadoras()  throws SQLException {
        List<Locadora> listaTodasLocadoras = new ArrayList<>();
            try (Connection con = this.getConnection()) {
                PreparedStatement ps = con.prepareStatement(LISTAR_LOCADORA_SQL);
                ResultSet rset = ps.executeQuery();
                while (rset.next()) {
                    String cnpj_locadora = rset.getString("cnpj_locadora");
                    String email_locadora = rset.getString("email_locadora");
                    String senha_locadora = rset.getString("senha_locadora");
                    String nome_locadora = rset.getString("nome_locadora");
                    String cidade_locadora = rset.getString("cidade_locadora");

                    Locadora locadora = new Locadora(cnpj_locadora, email_locadora, senha_locadora, nome_locadora, cidade_locadora);
                    listaTodasLocadoras.add(locadora);
                }
            
            } 
        return listaTodasLocadoras;
    }*/
    public List<Locadora> listarTodasLocadoras() {
        List<Locadora> listaTodasLocadoras = new ArrayList<>();
        try {
            Connection con = this.getConnection();
            Statement statement = con.createStatement();
            ResultSet rset = statement.executeQuery(LISTAR_LOCADORA_SQL);
            while (rset.next()) {
                String cnpj_locadora = rset.getString("cnpj_locadora");
                String email_locadora = rset.getString("email_locadora");
                String senha_locadora = rset.getString("senha_locadora");
                String nome_locadora = rset.getString("nome_locadora");
                String cidade_locadora = rset.getString("cidade_locadora");

                Locadora locadora = new Locadora(cnpj_locadora, email_locadora, senha_locadora, nome_locadora, cidade_locadora);
                listaTodasLocadoras.add(locadora);
            }
            rset.close();
            statement.close();
            con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return listaTodasLocadoras ;
    }
/*public List<Locadora> getAll() {
        List<Locadora> listaLocadora = new ArrayList<>();
        String sql = "SELECT * FROM Locadora";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String cnpj_locadora = resultSet.getString("cnpj_locadora");
                String email_locadora = resultSet.getString("email_locadora");
                String senha_locadora = resultSet.getString("senha_locadora");
                String nome_locadora = resultSet.getString("nome_locadora");
                String cidade_locadora = resultSet.getString("cidade_locadora");

                Locadora locadora = new Locadora(cnpj_locadora, email_locadora, senha_locadora, nome_locadora, cidade_locadora);
                listaLocadora.add(locadora);
                }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocadora;
    }
 */


    public List<Locadora> listarTodasPorCidade(String cidade) throws SQLException {
            
        List<Locadora> listaLocadorasCidades = new ArrayList<>();
        try (Connection conn = this.getConnection()){            
            PreparedStatement ps = conn.prepareStatement(LISTAR_LOCADORA_CIDADE_SQL);
            ps.setString(1, cidade);
            ResultSet rset = ps.executeQuery();
            while (rset.next()) {
                String cnpj_locadora = rset.getString("cnpj_locadora");
                String email_locadora = rset.getString("email_locadora");
                String senha_locadora = rset.getString("senha_locadora");
                String nome_locadora = rset.getString("nome_locadora");
                String cidade_locadora = rset.getString("cidade_locadora");

                Locadora locadora = new Locadora(cnpj_locadora, email_locadora, senha_locadora, nome_locadora, cidade_locadora);
                listaLocadorasCidades.add(locadora);
            }  
        }
        return listaLocadorasCidades;
    }


    public void insert(Locadora locadora) {
        String sql = "INSERT INTO Locadora(cnpj_locadora, email_locadora, senha_locadora, nome_locadora, cidade_locadora) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, locadora.getCnpj_locadora());
            statement.setString(2, locadora.getEmail_locadora());
            statement.setString(3, locadora.getSenha_locadora());
            statement.setString(4, locadora.getNome_locadora());
            statement.setString(5, locadora.getCidade_locadora());

            int i = statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Locadora locadora) {
        String sql = "DELETE FROM Locadora where cnpj_locadora = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, locadora.getCnpj_locadora());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Locadora locadora) {
        String sql = "UPDATE Locadora SET email_locadora = ?, senha_locadora = ?, nome_locadora = ?, cidade_locadora = ?";
        sql += " WHERE cnpj_locadora = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, locadora.getEmail_locadora());
            statement.setString(2, locadora.getSenha_locadora());
            statement.setString(3, locadora.getNome_locadora());
            statement.setString(4, locadora.getCidade_locadora());
            statement.setString(5, locadora.getCnpj_locadora());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Locadora get(String cnpj_locadora) {
        Locadora locadora = null;
        String sql = "SELECT * FROM Locadora WHERE cnpj_locadora = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, cnpj_locadora);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email_locadora = resultSet.getString("email_locadora");
                String senha_locadora = resultSet.getString("senha_locadora");
                String nome_locadora = resultSet.getString("nome_locadora");
                String cidade_locadora = resultSet.getString("cidade_locadora");
                locadora = new Locadora(cnpj_locadora, email_locadora, senha_locadora, nome_locadora, cidade_locadora);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locadora;
    }
}
