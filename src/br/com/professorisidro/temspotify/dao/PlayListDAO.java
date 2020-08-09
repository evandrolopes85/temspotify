package br.com.professorisidro.temspotify.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.professorisidro.temspotify.model.Music;
import br.com.professorisidro.temspotify.model.PlayList;

public class PlayListDAO implements GenericDAO{
	private DataSource datasource;
	
	public PlayListDAO( DataSource datasource ) {
		this.datasource = datasource;
	}
	
	@Override
	public void create(Object o) {
		try {
			PlayList pl = PlayList.class.cast(o);
			String SQL = "INSERT INTO tblplaylist VALUES ( null, ?, ? )";
			PreparedStatement stmt = datasource.getConnection().prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
			stmt.setString( 1, pl.getTitle() );
			stmt.setInt( 2, pl.getUser().getId() );
			
			int res = stmt.executeUpdate();
			
			if( res == 0 ) {
				throw new RuntimeException( "Não foi possivel incluir Playlist" );
			}
			
			ResultSet rs = stmt.getGeneratedKeys();
			if( rs.next() ) {
				pl.setId( rs.getInt( 1 ) );
			}
		}
		catch( SQLException ex ) {
			System.out.println( "Erro ao cadastrar playlist: " + ex.getMessage() );
		}
	}

	@Override
	public List<Object> read(Object o) {
		try {
			String SQL = "SELECT * FROM tblPlaylist WHERE idusuario=?";
			Integer idUser = ( Integer )o; 
			PreparedStatement stmt = datasource.getConnection().prepareStatement( SQL );
			stmt.setInt( 1, idUser.intValue() );
			ResultSet rs = stmt.executeQuery();
			ArrayList< Object > list = new ArrayList<>();
			while( rs.next() ) {
				PlayList pl = new PlayList();
				pl.setId( rs.getInt( "idPlaylist" ) );
				pl.setTitle( rs.getString( "titulo" ) );
				list.add( pl );
			}	
			rs.close();
			stmt.close();
			return list;
		}catch( SQLException ex ) {
			System.out.println( "Erro ao recuperar Playlist" + ex.getMessage() );
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
	
	public PlayList readPlayListDetailsById(int id){
		 PlayList playlist = null;
	        try {
	            String SQL = "select tblPlaylist.idPlaylist as idPlaylist, "
	                    + "       tblPlaylist.idUsuario  as idUsuario,  "
	                    + "       tblPlaylist.titulo     as pl_titulo, "
	                    + "	      tblMusica.idMusica     as idMusica, "
	                    + "	      tblMusica.titulo       as mu_titulo, "
	                    + "       tblMusica.artista      as artista, "
	                    + "       tblMusica.album        as album, "
	                    + "       tblMusica.estilo       as estilo, "
	                    + "       tblMusica.linkMP3      as linkMP3 "
	                    + "   from  "
	                    + "     tblPlaylist "
	                    + "     left outer join tblMusicaPlaylist using (idPlaylist) "
	                    + "	 left outer join tblMusica using (idMusica) "
	                    + "     where idPlaylist = ?";
	            PreparedStatement stm = datasource.getConnection().prepareStatement(SQL);
	            stm.setInt(1, id);
	            ResultSet rs = stm.executeQuery();
	            rs.next();
	            do {
	                if (playlist == null) {
	                    playlist = new PlayList();
	                    playlist.setMusics(new ArrayList<Music>());
	                    playlist.setId(rs.getInt("idPlaylist"));
	                    playlist.setTitle(rs.getString("pl_titulo"));
	                }
	                if (rs.getString("mu_titulo") != null) {
	                    Music musica = new Music();
	                    musica.setId(rs.getInt("idMusica"));
	                    musica.setTitle(rs.getString("mu_titulo"));
	                    musica.setArtist(rs.getString("artista"));
	                    musica.setStyle(rs.getInt("estilo"));
	                    musica.setAlbum(rs.getString("album"));
	                    musica.setLinkMP3(rs.getString("linkMP3"));
	                    playlist.getMusics().add(musica);
	                }

	            } while (rs.next());
	            return playlist;

	        } catch (Exception ex) {
	            System.out.println("Erro ao recuperar detalhes da Playlist " + ex.getMessage());
	        }
	        return null;
	}
}
