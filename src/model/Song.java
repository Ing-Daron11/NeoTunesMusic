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
	public Song(String name, String url, String duration, int reproductions, String album, double cost,int sells, int optionTypeSong){
		super(name, url, duration, reproductions);
		this.album = album;
		this.cost = cost;
		this.sells = sells;
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