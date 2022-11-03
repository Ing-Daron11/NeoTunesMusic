package model;

import java.util.Arraylist;

public class UserCostumerStandar extends UserCostumer{

	public static final int SIZE_OF_PLAYLIST = 20;
	public static final int SIZE_OF_SONGS = 100;

	private Arraylist<Playlist> playlist;

	/**
	 * Constructor
	 */
	public UserCostumerStandar(String nickname, String cc){
		super(nickname, cc);
	}

	


}