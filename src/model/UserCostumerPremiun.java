package model;

import java.util.ArrayList; 

public class UserCostumerPremiun extends UserCostumer{

	private ArrayList<Playlist> playlist;

	/**
	 * Constructor
	 */

	public UserCostumerPremiun(String nickname, String cc){
		super(nickname, cc);
		playlist = new ArrayList<Playlist>();
		
	}

	/**
	 * This is method allows to add a playlist to the arraylist
	* @param  ObjectPlayList It´s the newPlaylist
	* @return msj            A massage that says if it was added succesfully or not
	*/
	public String addPlaylist(Playlist objectPlayList){
		String msj = "";
		if(playlist.add(objectPlayList)){
			msj = "The playlist was succesfully aded";
		}else {
			msj = "The playlist wasn't added due to error. Sorry";
		}
		return msj;
	}

	 public String getCc(){
      return super.cc;
    }
}