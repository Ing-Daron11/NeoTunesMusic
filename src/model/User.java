package model;
 
import java.util.Date;

public abstract class User{

	protected String nickname;
	protected String cc;
	protected Date vinculationDate;

	/**
	 * Contructor
	 */
	public User(String nickname, String cc){
		this.nickname = nickname;
		this.cc = cc;
		Date newVinculationDate = new Date();
		this.vinculationDate = newVinculationDate;
	}

	public String getName(){
		return this.nickname;
	}



}