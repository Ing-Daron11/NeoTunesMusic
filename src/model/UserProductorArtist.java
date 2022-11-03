package model;

import java.util.ArrayList;

public class UserProductorArtist extends UserProductor{

	private ArrayList<Song> song;

	/**
	 * Constructor
	 */

	public UserProductorArtist(String nickname, String cc, String url){
		super(nickname, cc, url);
	}

	
}
