package br.edu.ifsp.spo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ContatoDao {
	
	private ConnectionFactory connection;
	private Connection conn;
	
	public ContatoDao(){
		this.connection = new ConnectionFactory();
	}

//	private	static Map<Integer, Contato> contatos = new HashMap<Integer, Contato>();
//	private static AtomicInteger id = new AtomicInteger();

	public void add(Contato contato) {
		
		//Usando o DAO
		
//		int key = id.addAndGet(1);
//		contato.setId(key);
//		contatos.put(key, contato);
		
		//Usando o mySQL
		
		conn = connection.recuperarConexao();
		
		String sql = "INSERT INTO contatos (nome, email, endereco, dataNascimento)"
				+ "VALUES (?, ?, ?, ?)";
		
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getEndereco());
			ps.setDate(4, Date.valueOf(contato.getDataNascimento()));
			
			ps.execute();
			ps.close();
			conn.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		

		
	}
	
	public Contato read(int contatoID) {
		
		//Usando o DAO
	    //return contatos.get(id);
	    
	  //Usando o mySQL
	
	    conn = connection.recuperarConexao();
	    Contato contato = null;
		PreparedStatement ps;
		ResultSet rs;
		
		String sql = "SELECT * FROM contatos WHERE id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, contatoID);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
			Integer id = rs.getInt(1);
			String nome = rs.getString(2);
			String email = rs.getString(3);
			String endereco = rs.getString(4);
			LocalDate dataNascimento = rs.getDate(5).toLocalDate();
			
			contato = new Contato(id, nome, email, endereco, dataNascimento);
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return contato;
	}

	public void altera(Contato contato) {
		
		//Usando o DAO
		//contatos.put(contato.getId(), contato);
		
		//Usando o mySQL
		conn = connection.recuperarConexao();
		PreparedStatement ps;
		String sql = "UPDATE contatos SET nome = ?, email = ?, endereco = ?, dataNascimento = ? WHERE id = ?";
		
		try {
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getEndereco());
			ps.setDate(4, Date.valueOf(contato.getDataNascimento()));
			ps.setInt(5, contato.getId());
			
			ps.execute();
			conn.commit();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
			throw new RuntimeException(e);
		}


	}

	public void delete(int id) {
		
		//Usando o DAO
		//contatos.remove(contato.getId());
		
		//Usando o mySQL
		
		conn = connection.recuperarConexao();
		String sql = "DELETE FROM contatos WHERE id = ?";
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Set<Contato> getContatos() {
		
		//Usando o DAO
		// return contatos.values();
		
		//Usando o mySQL
		
		PreparedStatement ps;
		ResultSet rs;
		
		conn = connection.recuperarConexao();
		Set<Contato> lista = new HashSet<>();
		
		String sql = "SELECT * FROM contatos";
		
		try {

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Integer id = rs.getInt(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String endereco = rs.getString(4);
				LocalDate dataNascimento = rs.getDate(5).toLocalDate();
				
				lista.add(new Contato(id, nome, email, endereco, dataNascimento));
			}
			
			rs.close();
			ps.close();
			conn.close();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}
}
