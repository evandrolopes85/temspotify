package br.com.professorisidro.temspotify.model;

import java.util.List;

public class User implements java.io.Serializable{
	private int            id;
	private String         username;
	private String		   email;
	private String         password;
	private List<PlayList> playlists;
	
	public List<PlayList> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(List<PlayList> playlists) {
		this.playlists = playlists;
	}
	public int getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String name) {
		this.username = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return id + " " + username + " " + email;
	}
}
