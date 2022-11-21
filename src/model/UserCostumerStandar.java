package model;

import java.util.ArrayList;

public class UserCostumerStandar extends UserCostumer{

	public static final int SIZE_OF_PLAYLIST = 20;
	public static final int SIZE_OF_SONGS = 100;

	private ArrayList<Playlist> playlist;
	private int counterOfPlaylist;
	private int counterOfSongs;

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
				msj = "The playlist was succesfully aded for the standar user \n" +
					  "code: " + objectPlayList.getCode() + "\n"+
					  "name: " + objectPlayList.getName();
				int counter = +1;
				setCounterOfPlaylist(counter);
			}else {
				msj = "The playlist wasn't added due to error. Sorry";
			}
		} 
		return msj;
	}

	public int searchPlaylistByNameStandar(String playlistName){
		int posPlaylist = -1;
		boolean playlistExist = false;
		for(int i = 0; i < playlist.size() && i < SIZE_OF_PLAYLIST && !playlistExist; i++){
			if(playlist.get(i) !=null){
				if((playlist.get(i)).getName().equalsIgnoreCase(playlistName)){
					posPlaylist = i;
					playlistExist = true;
				}
			}
			
		}
		return posPlaylist;
	}

	public String addAudioToSpecificPlaylist(String playlistName, Audio objectAudio){
		String msj = "";
		int counter = 0;
		int posPlaylist = searchPlaylistByNameStandar(playlistName);
		int typeOfPlaylist = (playlist.get(posPlaylist)).getTypeOption();
		if(typeOfPlaylist == 1){
			msj = "Maximun capacity reached";
			if(getCounterOfSongs() < SIZE_OF_SONGS){
				int posSong = (playlist.get(posPlaylist)).addSongToPlaylist(objectAudio);
				if(posSong != -1){
					counter = 1;
					setCounterOfSongs(counter);
					msj = "The song was succesfully added";
				}else{
					msj = "This playlist is only for songs. Verify if the song exists or select a real song";
				}
			}
			
		}else if(typeOfPlaylist == 2){
			int posPodcast = (playlist.get(posPlaylist)).addPodcastToPlaylist(objectAudio);
			if(posPodcast != -1){
				msj = "The podcast was succesfully added";
			}else{
				msj = "This playlist is only for podcast. Verify if the podcast exists or select a real podcast";
			}

		}else if(typeOfPlaylist == 3){
			int posAny = (playlist.get(posPlaylist)).addPodcastToPlaylist(objectAudio);
			if(posAny != -1){
				msj = "The Podcast was succesfully added";			
			}else{
				msj = "Maximun capacity reached";
				if(getCounterOfSongs()< SIZE_OF_SONGS){
					counter = 1;
					setCounterOfSongs(counter);
					posAny = (playlist.get(posPlaylist)).addSongToPlaylist(objectAudio);
					msj = "The Song was succesfully added";
				}
			}
		}else{
			msj = "The audio doesn't exist.";
		}
		return msj;
	}
	
	public String listAudiosOfASpecificPlaylist(String playlistName){///
		int posPlaylist = searchPlaylistByNameStandar(playlistName);
		String msj = "";
		if(posPlaylist != -1){
			msj = (((Playlist)(playlist.get(posPlaylist))).listAudios());
		}
		return msj;
	}

	public String deleteAudioStandar(String playlistName, String audioName){
		String msj = "";
		int posPlaylist = searchPlaylistByNameStandar(playlistName);
		msj = (playlist.get(posPlaylist)).deleteAudio(audioName);
		return msj;
	}


//----------------------------------------------- Getters and Setters ------------------------------------


    public String getCc(){
      return super.cc;
    }

    public int getCounterOfPlaylist(){
      return this.counterOfPlaylist;
    }

    public void setCounterOfPlaylist(int newCounterOfPlaylist){
    	this.counterOfPlaylist += newCounterOfPlaylist;
    }
  
  	public int getCounterOfSongs(){
      return this.counterOfSongs;
    }

    public void setCounterOfSongs(int newCounterOfSongs){
    	this.counterOfSongs += newCounterOfSongs;
    }


}