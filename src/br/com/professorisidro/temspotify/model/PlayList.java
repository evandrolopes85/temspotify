package br.com.professorisidro.temspotify.model;

import java.util.List;

public class PlayList implements java.io.Serializable{
	private int         id;
	private String      title;
	private User        user;
	private List<Music> musics;
	
	public List<Music> getMusics() {
		return musics;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setMusics(List<Music> musics) {
		this.musics = musics;
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
	
	
}
