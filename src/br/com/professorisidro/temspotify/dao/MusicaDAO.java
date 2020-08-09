package br.com.professorisidro.temspotify.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.professorisidro.temspotify.model.Music;

public class MusicaDAO implements GenericDAO{
	private DataSource datasource;
	
	public MusicaDAO( DataSource datasource){
		this.datasource = datasource;
	}
	
	@Override
	public void create(Object o) {
		try {
			if(o instanceof Music) {
				Music musica = ( Music )o;
				String SQL = "INSERT INTO tblMusica VALUES (null, ?, ?, ?, ?, ?)";
				PreparedStatement stm = datasource.getConnection().prepareStatement( SQL );
				stm.setString(1, musica.getTitle());
				stm.setString(2, musica.getArtist());
				stm.setString(3, musica.getAlbum());
				stm.setInt(4, musica.getStyle());
				stm.setString(5, musica.getLinkMP3());
				
				stm.executeUpdate();
				
				stm.close();
				
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Object> read(Object o) {
		try {
			String SQL = "select * from tblMusica order by titulo";
			
			PreparedStatement stm = datasource.getConnection().prepareStatement(SQL);
			
			ResultSet rs = stm.executeQuery();
			
			List<Object> lista = new ArrayList<Object>();
			while( rs.next() ) {
				Music musica = new Music();
				musica.setId( rs.getInt( "idMusica" ) );
				musica.setTitle( rs.getString( "titulo" ) );
				musica.setArtist( rs.getString( "artista" ) );
				musica.setAlbum( rs.getString( "album" ) );
				musica.setStyle( rs.getInt( "estilo" ) );
				musica.setLinkMP3( rs.getString( "linkMP3" ) );
				
				lista.add( musica );
			}
			
			return lista;
 		}catch(SQLException ex) {
			System.out.println("Erro ao recuperar acervo de musicas " + ex.getMessage());
		}
		return null;
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		
	}

}
