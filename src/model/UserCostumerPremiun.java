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

	public int searchPlaylistByNamePremium(String playlistName){
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
			msj = "The playlist was succesfully aded for the Premium user \n" +
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

    public String addAudioToSpecificPlaylist(String playlistName, Audio objectAudio){
		String msj = "";
		int posPlaylist = searchPlaylistByNamePremium(playlistName);
		int typeOfPlaylist = (playlist.get(posPlaylist)).getTypeOption();
		if(typeOfPlaylist == 1){
			int posSong = (playlist.get(posPlaylist)).addSongToPlaylist(objectAudio);
			if(posSong != -1){
				msj = "The song was succesfully added";
			}else{
				msj = "This playlist is only for songs. Verify is the song exists or select a real song";
			}
		}else if(typeOfPlaylist == 2){
			int posPodcast = (playlist.get(posPlaylist)).addPodcastToPlaylist(objectAudio);
			if(posPodcast != -1){
				msj = "The podcast was succesfully added";
			}else{
				msj = "This playlist is only for podcast. Verify is the podcast exists or select a real podcast";
			}
		}else if(typeOfPlaylist == 3){
			int posAny = (playlist.get(posPlaylist)).addSongToPlaylist(objectAudio);
			if(posAny != -1){
				msj = "The Song was succesfully added";			
			}else{
				posAny = (playlist.get(posPlaylist)).addPodcastToPlaylist(objectAudio);
				msj = "The Podcast was succesfully added";
			}
		}else{
			msj = "The audio doesn't exist.";
		}
		return msj;
	}

	public String listAudiosOfASpecificPlaylist(String playlistName){///
		int posPlaylist = searchPlaylistByNamePremium(playlistName);
		String msj = "";
		if(posPlaylist != -1){
			msj = (((Playlist)(playlist.get(posPlaylist))).listAudios());
		}
		return msj;
	}

	public String deleteAudioPremium(String playlistName, String audioName){
		String msj = "";
		int posPlaylist = searchPlaylistByNamePremium(playlistName);
		msj = (playlist.get(posPlaylist)).deleteAudio(audioName);
		return msj;
	}

	public String showMatrizPremium(String playlistName){///
		int posPlaylist = searchPlaylistByNamePremium(playlistName);
		String msj = "";
		if(posPlaylist != -1){
			if(((Playlist)(playlist.get(posPlaylist))).getName().equalsIgnoreCase(playlistName)){
				msj = ((Playlist)(playlist.get(posPlaylist))).showMatriz() + "\n" +
							"Code: " + ((Playlist)(playlist.get(posPlaylist))).getCode();
			}
		}
		return msj;
	}


}