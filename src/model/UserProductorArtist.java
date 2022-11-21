package model;

import java.util.ArrayList;

public class UserProductorArtist extends UserProductor{

	private ArrayList<Song> songs;

	/**
	 * Constructor
	 */
	public UserProductorArtist(String nickname, String cc, String url){
		super(nickname, cc, url);
		songs = new ArrayList<Song>();
	}

	public String addSongToArtist(Song newSong){
		String msj = "";
		if(songs.add(newSong)){
			msj = "The song was added succesfully";
		}else{
			msj = "The Song wasn't added due to an error. Sorry";
		}
		return msj;
	}

	public String listSongs(){
		String msj = "";
		for(int i = 0; i < songs.size(); i++){
			if(songs.get(i) != null){
				msj += ((Song)(songs.get(i))).getName() + "\n";
			}
		}
		return msj;
	}

  public String getCc(){
  	return super.cc;
  }
  

	
}
