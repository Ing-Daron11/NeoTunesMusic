package model;

public class Podcast extends Audio{

	private String description;
	private TypePodcast typePodcast;
	private int optionTypePodcast;

	/**
	 * Contructor
	 */
	public Podcast(String name, String url, int duration,String description,int optionTypePodcast){
		super(name, url, duration);
		this.description = description;
		this.optionTypePodcast = optionTypePodcast;
		this.typePodcast = TypePodcast.values()[optionTypePodcast];
	}

//----------------------------------------------- Getters and Setters ------------------------------------

	public String getName(){
		return super.name;
	}
	
	public String getDescription(){
		return this.description;
	}

	public TypePodcast getTypePodcast(){
		return this.typePodcast;
	}

	public int getOptionTypePodcast(){
		return this.optionTypePodcast;
	}
}