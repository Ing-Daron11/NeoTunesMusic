package model;

import java.util.ArrayList;

public class UserCostumerStandar extends UserCostumer{

	public static final int SIZE_OF_PLAYLIST = 20;
	public static final int SIZE_OF_SONGS = 100;

	private ArrayList<Playlist> playlist;
	private int counterOfPlaylist;

	/**
	 * Constructor
	 */
	public UserCostumerStandar(String nickname, String cc){
		super(nickname, cc);
		playlist = new ArrayList<Playlist>();
	}

	/**
	 * Since this clas can only have 20 playlist, this method allows to add only 20 playlists.
	 * @param  objectPlayList It´s the newPlaylist
	 * @return msj            A massage that says if it was added succesfully or not
	 */
	public String addPlaylist(Playlist objectPlayList){
		String msj = "Maximun capacity reached";
		if(getCounterOfPlaylist() < SIZE_OF_PLAYLIST){
			if(playlist.add(objectPlayList)){
				msj = "The playlist was succesfully aded for the standar user";
				int counter = +1;
				setCounterOfPlaylist(counter);
			}else {
				msj = "The playlist wasn't added due to error. Sorry";
			}
		}
		return msj;
	}

    public String getCc(){
      return super.cc;
    }

    public int getCounterOfPlaylist(){
      return this.counterOfPlaylist;
    }

    public void setCounterOfPlaylist(int newCounterOfPlaylist){
    	this.counterOfPlaylist += newCounterOfPlaylist;
    }
  
  


}