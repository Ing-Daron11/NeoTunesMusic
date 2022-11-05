package model;

public class Song extends Audio{

	private String album;
	private double cost;
	private int sells;
	private TypeSong typeSong;
	private int optionTypeSong;

	/**
	 * Contructor
	 */
	public Song(String name, String url, int duration, String album, double cost, int optionTypeSong){
		super(name, url, duration);
		this.album = album;
		this.cost = cost;
		this.sells = 0;
		this.optionTypeSong = optionTypeSong;
		this.typeSong = TypeSong.values()[optionTypeSong];
	}
	

	//----------------------------------------------- Getters and Setters ------------------------------------

	public String getAlbum(){
		return this.album;
	}

	public double getCost(){
		return this.cost;
	}

	public int getSells(){
		return this.sells;
	}

	public void setSells(int newSells){
		this.sells = newSells;
	}

	public TypeSong getTypeSong(){
		return this.typeSong;
	}
	  

	

}