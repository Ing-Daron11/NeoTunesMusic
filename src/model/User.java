package model;
 
import java.util.Date;

public abstract class User{

	private String nickname;
	private String cc;
	private Date vinculationDate;

	/**
	 * Contructor
	 */
	public User(String nickname, String cc){
		this.nickname = nickname;
		this.cc = cc;
		Date newVinculationDate = new Date();
		this.vinculationDate = newVinculationDate;
	}

	



}