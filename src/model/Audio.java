package model;


public abstract class Audio{

	private String name;
	private String url;
	private String duration;
	private int reproductions;

	public Audio(String name, String url, String duration, int reproductions){
		this.name = name;
		this.url = url;
		this.duration = duration;
		this.reproductions = reproductions;
	}


//----------------------------------------------- Getters and Setters ------------------------------------


	public String getName(){
		return this.name;
	}

	public String getUrl(){
		return this.url;
	}

	public String getDuration(){
		return this.duration;
	}

	public int getReproductions(){
		return this.reproductions;
	}

	public void setReproductions(int newReproductions){
		this.reproductions = newReproductions;
	}

}