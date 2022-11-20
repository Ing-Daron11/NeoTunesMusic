package model;


public abstract class Audio{

	protected String name;
	protected String url;
	protected int duration;
	protected int reproductions;

	public Audio(String name, String url, int duration){
		this.name = name;
		this.url = url;
		this.duration = duration;
		this.reproductions = 0;
	}

//----------------------------------------------- Getters and Setters ------------------------------------


	public String getName(){
		return this.name;
	}

	public String getUrl(){
		return this.url;
	}

	public int getDuration(){
		return this.duration;
	}

	public int getReproductions(){
		return this.reproductions;
	}

	public void setReproductions(int newReproductions){
		this.reproductions = newReproductions;
	}

}