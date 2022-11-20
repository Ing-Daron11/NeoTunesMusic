package model;

import java.util.ArrayList;

public class UserProductorCreator extends UserProductor{

	private ArrayList<Podcast> podcasts;
	/**
	 * Contructor
	 */
	public UserProductorCreator(String nickname, String cc, String url){
		super(nickname, cc, url);
		 podcasts = new ArrayList<Podcast>();
	}

	public String addPodcastToCreator(Podcast newPodcast){
		String msj = "";
		if(podcasts.add(newPodcast)){
			msj = "The Podcast was added succesfully";
		}else{
			msj = "The Podcast wasn't added due to an error. Sorry";
		}
		return msj;
	}

	public String listPodcasts(){
		String msj = "";
		for(int i = 0; i < podcasts.size(); i++){
			if(podcasts.get(i) != null){
				msj += ((Podcast)(podcasts.get(i))).getName() + "\n";
			}
		}
		return msj;
	}

	 public String getCc(){
      return super.cc;
    }
	

}