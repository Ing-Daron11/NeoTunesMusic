package model;

public abstract class UserProductor extends User{

	private String url;

	/**
	 * Comntructor
	 */
	public UserProductor(String nickname, String cc, String url){
		super(nickname, cc);
		this.url = url;
	}

	


}