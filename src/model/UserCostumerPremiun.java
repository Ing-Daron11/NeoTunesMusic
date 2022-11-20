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

	public int searchPlaylistByNameStandar(String playlistName){ ///////////
		int posPlaylist = -1;
		boolean playlistExist = false;
		for(int i = 0; i < playlist.size() && !playlistExist; i++){
			if(playlist.get(i) !=null){
				if((playlist.get(i)).getName().equalsIgnoreCase(playlistName)){
					posPlaylist = i;
					playlistExist = true;
				}
			}
			
		}
		return posPlaylist;
	}

	/**
	 * This is method allows to add a playlist to the arraylist
	* @param  ObjectPlayList It´s the newPlaylist
	* @return msj            A massage that says if it was added succesfully or not
	*/
	public String addPlaylist(Playlist objectPlayList){
		String msj = "";
		if(playlist.add(objectPlayList)){
			msj = "The playlist was succesfully aded for the standar user \n" +
					  "code: " + objectPlayList.getCode() + "\n"+
					  "name: " + objectPlayList.getName();
		}else {
			msj = "The playlist wasn't added due to error. Sorry";
		}
		return msj;
	}

	 public String getCc(){
      return super.cc;
    }
}