package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteDAO extends GenericDAO {

    private final static String CRIAR_CLIENTE_SQL = "insert into Cliente"
            + " (email_cliente, senha_cliente, cpf_cliente, nome_cliente, telefone_cliente, sexo_cliente, nascimento_cliente)"
            + " values (?,?,?,?,?,?,?)";

    /*private final static String LISTAR_CLIENTE_LOCACOES_SQL = "select" + " * "  // rever essa query
            + " from Locacao inner join Cliente on Cliente.id_cliente = Locacao.id_locacao";
     */
    /*public Cliente gravarCliente(Cliente cliente) throws IOException, SQLException {
        try (Connection con = this.getConnection()) {
            PreparedStatement ps = con.prepareStatement(CRIAR_CLIENTE_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getEmail_cliente());
            ps.setString(2, cliente.getSenha_cliente());
            ps.setString(3, cliente.getCpf_cliente());
            ps.setString(4, cliente.getNome_cliente());
            ps.setString(5, cliente.getTelefone_cliente());
            ps.setString(6, cliente.getSexo_cliente());
            ps.setString(7, cliente.getNascimento_cliente());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
           // cliente.setId_cliente(rs.getInt(1));
        }
        return cliente;
    }*/
    
    
    public Cliente gravarCliente(Cliente cliente){
        try {
            Connection con = this.getConnection(); 
            PreparedStatement ps = con.prepareStatement(CRIAR_CLIENTE_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getEmail_cliente());
            ps.setString(2, cliente.getSenha_cliente());
            ps.setString(3, cliente.getCpf_cliente());
            ps.setString(4, cliente.getNome_cliente());
            ps.setString(5, cliente.getTelefone_cliente());
            ps.setString(6, cliente.getSexo_cliente());
            ps.setString(7, cliente.getNascimento_cliente());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
           // cliente.setId_cliente(rs.getInt(1));
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }
        

    public List<Cliente> getAll() {
        List<Cliente> listaCliente = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                //int id_cliente = resultSet.getInt("id_cliente");
                String email_cliente = resultSet.getString("email_cliente");
                String senha_cliente = resultSet.getString("senha_cliente");
                String cpf_cliente = resultSet.getString("cpf_cliente");
                String nome_cliente = resultSet.getString("nome_cliente");
                String telefone_cliente = resultSet.getString("telefone_cliente");
                String sexo_cliente = resultSet.getString("sexo_cliente");
                String nascimento_cliente = resultSet.getString("nascimento_cliente");
                 
                Cliente cliente = new Cliente(email_cliente, senha_cliente, cpf_cliente, nome_cliente, telefone_cliente, sexo_cliente, nascimento_cliente);
                listaCliente.add(cliente);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCliente;
    }

        public Cliente get(String cpf_cliente){ 
        //public Cliente get(int id_cliente) {
        Cliente cliente = null;
        //String sql = "SELECT * FROM Cliente WHERE id_cliente = ?";
        String sql = "SELECT * FROM Cliente WHERE cpf_cliente = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            //statement.setInt(1, id_cliente);
            statement.setString(3, cpf_cliente);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email_cliente = resultSet.getString("email_cliente");
                String senha_cliente = resultSet.getString("senha_cliente"); 
                //String cpf_cliente = resultSet.getString("cpf_cliente");
                String nome_cliente = resultSet.getString("nome_cliente");
                String telefone_cliente = resultSet.getString("telefone_cliente");
                String sexo_cliente = resultSet.getString("sexo_cliente");
                String nascimento_cliente = resultSet.getString("nascimento_cliente");
                
                cliente = new Cliente(email_cliente, senha_cliente, nome_cliente, telefone_cliente, sexo_cliente, nascimento_cliente);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }
        public void update(Cliente cliente) {
        String sql = "UPDATE Livro SET email_cliente = ?, senha_cliente = ?, cpf_cliente = ?, nome_cliente = ?, telefone_cliente = ?, sexo_cliente = ?, nascimento_cliente = ?";
        sql += " WHERE cpf_cliente = ?";
        //sql += " WHERE id_cliente = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cliente.getEmail_cliente());
            statement.setString(2, cliente.getSenha_cliente());
            statement.setString(3, cliente.getCpf_cliente());
            statement.setString(4, cliente.getNome_cliente());
            statement.setString(5, cliente.getTelefone_cliente());
            statement.setString(6, cliente.getSexo_cliente());
            statement.setString(7, cliente.getNascimento_cliente());
            //statement.setInt(8, cliente.getId_cliente());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public void delete(Cliente cliente) {
       String sql = "DELETE FROM Cliente where cpf_cliente = ?";
       // String sql = "DELETE FROM Cliente where id_cliente = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            //statement.setInt(1, cliente.getId_cliente());
            statement.setString(3,cliente.getCpf_cliente());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}