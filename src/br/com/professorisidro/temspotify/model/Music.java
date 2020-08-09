package br.com.professorisidro.temspotify.model;

public class Music implements java.io.Serializable{
	private int    id;
	private String title;
	private String artist;
	private String album;
	private int    style;
	private String linkMP3;
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public int getStyle() {
		return style;
	}
	public void setStyle(int style) {
		this.style = style;
	}
	public String getLinkMP3() {
		return linkMP3;
	}
	public void setLinkMP3(String linkMP3) {
		this.linkMP3 = linkMP3;
	}
	
	
	
}
