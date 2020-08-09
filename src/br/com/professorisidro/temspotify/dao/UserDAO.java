package br.com.professorisidro.temspotify.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.professorisidro.temspotify.model.User;

public class UserDAO implements GenericDAO{
	private DataSource datasource;
	
	public UserDAO(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public void create( Object o ) {
		try {
			if( o instanceof User ) {
				String sql = "INSERT INTO tblUsuario VALUES(null,?,?,?)";
				User user = User.class.cast(o);
				
				PreparedStatement stmt = datasource.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, user.getUsername());
				stmt.setString(2, user.getEmail());
				stmt.setString(3, user.getEmail());
			
				int res = stmt.executeUpdate();
	
				if( res  != 0 ) {
					ResultSet rs = stmt.getGeneratedKeys();
					if( rs.next() ) {
						user.setId( rs.getInt( 1 ) );
					}
					rs.close();
				}
				stmt.close();
			}else {
				throw new RuntimeException( "Invalid User Model Object" );
			}
		}catch( SQLException ex ) {
			System.out.println( "Erro ao inserir usuario" + ex.getMessage() );
		}
	}
	
	public List<Object> read(Object o) {
		
		try {
			if(o instanceof User) {
				User incompleto = User.class.cast(o);
				
				String SQL = "SELECT * FROM tblUsuario WHERE email=? AND senha=?";
				
				PreparedStatement stmt = datasource.getConnection().prepareStatement(SQL);
				stmt.setString(1, incompleto.getEmail());
				stmt.setString(2, incompleto.getPassword());
				
				ResultSet rs = stmt.executeQuery();
				
				ArrayList<Object> result = new ArrayList<Object>();
				
				while(rs.next()) {
					User user = new User();
					user.setId(rs.getInt("idUsuario"));
					user.setUsername(rs.getString("nome"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("senha"));
					result.add(user);
				}
				
				stmt.close();
				rs.close();
				return result;
			}else {
				throw new RuntimeException("Invalid Object");
			}
		}catch(SQLException ex) {
			System.out.println("ERRO ao recuperar" + ex.getMessage());
		}
		
		
		/*
		// create user
		User user = new User();
		user.setId(1);
		user.setPassword("isidro@professorisidro.com.br");
		user.setUsername("Professor Isidro");
		user.setPassword("1234");
		
		// create a list of the playlist
		ArrayList<PlayList> playlists = new ArrayList<>();
		
		// create a playlist
		PlayList list1 = new PlayList();
		list1.setId(1);
		list1.setTitle("Craaassicos do Roque");
		
		// create ArrayList of the Music
		ArrayList<Music> musicP1 = new ArrayList<Music>();
		
		// create the first music m1
		Music m1 = new Music();
		m1.setId(1);
		m1.setArtist("Iron Maiden");
		m1.setTitle("Wasted Years");
		m1.setStyle(1);
		m1.setAlbum("Somewhere i  Time");
		m1.setLinkMP3("musicas/IroMaiden-WastedYears.mp3");
		
		// create the second music m2
		Music m2 = new Music();
		m2.setId(2);
		m2.setArtist("Scorpions");
		m2.setTitle("Rock You Like a Hurricane");
		m2.setStyle(1);
		m2.setAlbum("Scorpions");
		m2.setLinkMP3("musicas/Scorpions-RYLAH.mp3");
		
		
		musicP1.add(m1); // add m1 to ArrayList musicP1
		musicP1.add(m2); // add m2 to ArrayList musicP1
		list1.setMusics(musicP1); // add ArrayList musicP1 to List list1
		playlists.add(list1);
		user.setPlaylists(playlists);
		
		ArrayList<Object> result = new ArrayList<>();
		result.add(user);
		*/
		return null;
	}
	
	public void update(Object o) {
		
	}
	
	public void delete(Object o) {
		
	}
}
