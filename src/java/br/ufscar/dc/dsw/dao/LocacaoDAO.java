package br.ufscar.dc.dsw.dao;
import br.ufscar.dc.dsw.model.Locacao;
import br.ufscar.dc.dsw.model.Locadora;
import br.ufscar.dc.dsw.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LocacaoDAO extends GenericDAO {

    private final static String CRIAR_LOCACAO_SQL = "insert into Locadora" + " (email_locadora, senha_locadora, cnpj_locadora, nome_locadora, cidade_locadora)" + "values(?,?,?,?,?)";
    private final static String LISTAR_LOCACAO_CLIENTE_SQL = "select" + "c.cpf_cliente, l.cpnj_locadora, l.data_dia" + " from Locacao l inner join Cliente c on c.cpf_cliente = l.cpf_cliente" + "where cpf_cliente = ?";
    private final static String LISTAR_LOCACAO_LOCADORA_SQL = "select" + "ld.cnpj_locadora, l.cpf_cliente, l.data_dia" + " from Locacao l inner join Locadora ld on ld.cnpj_cliente = l.cnpj_cliente" + "where cnpj_locadora = ?";
    public Locacao gravarLocacao(Locacao locacao) throws SQLException {
        try (Connection con = this.getConnection()) {
            PreparedStatement ps = con.prepareStatement(CRIAR_LOCACAO_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, locacao.getId_locacao());
            ps.setString(2, locacao.getData_locacao());
            
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            locacao.setId_locacao(rs.getInt(1));
        }
        return locacao;
    }
    
    public List<Locacao> listarTodasLocacoesPorCliente(String cliente_locacao) throws SQLException {
        List<Locacao> ret = new ArrayList<>();
        try (Connection con = this.getConnection()) {
            PreparedStatement ps = con.prepareStatement(LISTAR_LOCACAO_CLIENTE_SQL);
            ps.setString(1, cliente_locacao);
            ps.setString(2, cliente_locacao);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Locacao locacao = new Locacao();
                Locadora locadora = new Locadora();
                Cliente cliente = new Cliente();
                
                locacao.setId_locacao(rs.getInt("id_locacao"));
                locacao.setData_dia(rs.getString("data_dia"));           
                cliente.setCpf_cliente(rs.getString("cpf_cliente"));
                locadora.setCpnj_locadora(rs.getString("cnpj_locadora"));
                ret.add(locacao);
            }
        }
        return ret;
    }
    
        public List<Locacao> listarTodasLocacoesPorLocadora(String locadora_locacao) throws SQLException {
        List<Locacao> ret = new ArrayList<>();
        try (Connection con = this.getConnection()) {
            PreparedStatement ps = con.prepareStatement(LISTAR_LOCACAO_LOCADORA_SQL);
            ps.setString(1, locadora_locacao);
            ps.setString(2, locadora_locacao);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Locacao locacao = new Locacao();
                Locadora locadora = new Locadora();
                Cliente cliente = new Cliente();
                
                locacao.setId_locacao(rs.getInt("id_locacao"));
                locacao.setData_dia(rs.getString("data_dia"));           
                locadora.setCpnj_locadora(rs.getString("cnpj_locadora"));
                cliente.setCpf_cliente(rs.getString("cpf_cliente"));
                ret.add(locacao);
            }
        }
        return ret;
    }

        public List<Locacao> getAll() {
        List<Locacao> listaLocacao = new ArrayList<>();
        String sql = "SELECT * FROM Locacao";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                
                String cpf_cliente = resultSet.getString("cpf_cliente");
                String cnpj_locadora = resultSet.getString("cnpj_locadora");
                String data_dia = resultSet.getString("data_dia");

                Locacao locacao = new Locacao(cpf_cliente, cnpj_locadora, data_dia);
                listaLocacao.add(locacao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacao;
    }
        
    public void insert(Locacao locacao) {
        String sql = "INSERT INTO Locacao(id_locacao, data_dia, cpf_cliente, cnpj_locadora) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, locacao.getId_locacao());
            statement.setString(2, locacao.getData_locacao());
            statement.setString(3, locacao.getCpf_cliente());
            statement.setString(4, locacao.getCnpj_locadora());

            int i = statement.executeUpdate();
            statement.close();
            conn.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Locacao locacao) {
        String sql = "DELETE FROM Locacao WHERE id_locacao = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, locacao.getId_locacao());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Locacao locacao) {
        String sql = "UPDATE Locacao SET data_dia = ?, cpf_cliente = ?, cnpj_locadora = ?";
        sql += " WHERE id_locacao = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, locacao.getData_locacao());
            statement.setString(2, locacao.getCpf_cliente());
            statement.setString(3, locacao.getCnpj_locadora());
            statement.setInt(4, locacao.getId_locacao());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Locacao get(int id_locacao) {
        Locacao locacao = null;
        String sql = "SELECT * FROM Locacao WHERE id_locacao = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, id_locacao);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String data_dia = resultSet.getString("data_dia");
                String cpf_cliente = resultSet.getString("cpf_cliente");
                String cnpj_locadora = resultSet.getString("cnpj_locadora");
                locacao = new Locacao(id_locacao, data_dia, cpf_cliente, cnpj_locadora);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locacao;
    }
}
