package model;

import java.util.ArrayList;

public class MusicController{

	private ArrayList<User> users;
    private ArrayList<Audio> totalAudios; //This are all the audios of the System


	public MusicController(){
		users = new ArrayList<User>();
		totalAudios = new ArrayList<Audio>();

	}


//----------------------------------- Requirement 1 -----------------------------------


	/**
	 * This method allows to add a new Artis to the arraylist
	 * @param  nickname [It represents the name or nickname of the artist]	
	 * @param  cc       [It represents the id number of ther artist]
	 * @param  url      [It Contains the image of the artist]
	 * @return msj      [It contains the massage that says if it was added or not]
	 */		
	public String addArtist(String nickname, String cc, String url){
		String msj = "";
		UserProductorArtist newArtist = new UserProductorArtist(nickname, cc, url);
		if(users.add(newArtist)){
			msj = "The Artist was added succesfully";
		}else{
			msj = "The Artist wasn't added due to an error. Sorry";
		}
		return msj;
	}

	/**
	 * This method allows to add a new Creator to the arraylist
	 * @param  nickname [It represents the name or nickname of the creator]	
	 * @param  cc       [It represents the id number of ther creator]
	 * @param  url      [It Contains the image of the creator]
	 * @return msj      [It contains the massage that says if it was added or not]
	 */		
	public String addCreator(String nickname, String cc, String url){
		String msj = "";
		UserProductorCreator newCreator = new UserProductorCreator(nickname, cc, url);
		if(users.add(newCreator)){
			msj = "The creator was added succesfully";
		}else{
			msj = "The creator wasn't added due to an error. Sorry";
		}
		return msj;
	}

//----------------------------------- Requirement 2 ------------------------------------


	/**
	 * This method allows to add a new Standar user to the arraylist
	 * @param  nickname [It represents the name or nickname of the standar user]	
	 * @param  cc       [It represents the id number of ther standar user]
	 * @return msj      [It contains the massage that says if it was added or not]
	 */		
	public String addUserStandar(String nickname, String cc){
		String msj = "";
		UserCostumerStandar newUserStandar = new UserCostumerStandar(nickname, cc);
		if(users.add(newUserStandar)){
			msj = "The standar user was added succesfully";
		}else{
			msj = "The standar user wasn't added due to an error. Sorry";
		}
		return msj;
	}

	/**
	 * This method allows to add a new premiun user to the arraylist
	 * @param  nickname [It represents the name or nickname of the premiun user]	
	 * @param  cc       [It represents the id number of ther premiun user]
	 * @return msj      [It contains the massage that says if it was added or not]
	 */		
	public String addUserPremiun(String nickname, String cc){
		String msj = "";
		UserCostumerPremiun newUserPremiun = new UserCostumerPremiun(nickname, cc);
		if(users.add(newUserPremiun)){
			msj = "The premiun user was added succesfully";
		}else{
			msj = "The premiun user wasn't added due to an error. Sorry";
		}
		return msj;
	}

//----------------------------------- Requirement 3 ------------------------------------

//We have to validate if the artist exists
	/**
	 * This method validates if the artis exists
	 * @param  cc It's the identification of the artist.
	 * @return posArtist It contains the position of the artist in the arraylist or -1 if it doesn't exist.
	 */
	public int validateArtistExists(String cc){
		int posArtist = -1;
		boolean artistExist = false;
		for(int i = 0; i < users.size() && !artistExist; i++){
			if(users.get(i) != null){
				if(users.get(i) instanceof UserProductorArtist){
					if(((UserProductorArtist)(users.get(i))).getCc().equalsIgnoreCase(cc)){
						artistExist = true;
						posArtist = i;
					}
				}
			}
		}
		return posArtist;
	}

	/**
	 * This method add a new song to the arraylist of the Artist
	 * @param  artistCc       It's the id of the artist
	 * @param  name           It's the name of the song
	 * @param  url            It's the url that contains the image of the song
	 * @param  duration       It contains the duration of the song in seconds
	 * @param  album          It's the album's name of the song
	 * @param  cost           The price of the song
	 * @param  optionTypeSong It contains the genre of the song
	 * @return msj            A massage that says if it was added succesfully.
	 */
	public String addSong(String artistCc, String name, String url, int duration, String album, double cost, int optionTypeSong){
		String msj = "";
		int posArtist = validateArtistExists(artistCc);
		if(posArtist != -1){
			Song newSong = new Song(name, url, duration, album, cost, optionTypeSong);
			msj = ((UserProductorArtist)(users.get(posArtist))).addSongToArtist(newSong);
			totalAudios.add(newSong);
		}else{
			msj = "The artis wasn't found";
		}
		return msj;
		
	}

	/**
	 * This method validates if the creator exists
	 * @param  cc It's the identification of the creator.
	 * @return posCreator It contains the position of the creator in the arraylist or -1 if it doesn't exist.
	 */
	public int validateCreatorExists(String cc){
		int posCreator = -1;
		boolean creatorExist = false;
		for(int i = 0; i < users.size() && !creatorExist; i++){
			if(users.get(i) != null){
				if(users.get(i) instanceof UserProductorCreator){
					if(((UserProductorCreator)(users.get(i))).getCc().equalsIgnoreCase(cc)){
						creatorExist = true;
						posCreator = i;
					}
				}
			}
		}
		return posCreator;
	}

	/**
	 * This method add a new podcast to the arraylist of the creator
	 * @param  creatorCc      It's the id of the artist
	 * @param  name           It's the name of the song
	 * @param  url            It's the url that contains the image of the song
	 * @param  duration       It contains the duration of the song in seconds
	 * @param  description	  It contains the description of the podcast
	 * @param  optionTypePodcast It contains the genre of the podcast
	 * @return msj            A massage that says if it was added succesfully.
	 */
	public String addPodcast(String creatorCc, String name, String url, int duration,String description, int optionTypePodcast){
		String msj = "";
		int posCreator = validateCreatorExists(creatorCc);
		if(posCreator != -1){
			Podcast newPodcast = new Podcast(name, url, duration, description, optionTypePodcast);
			msj = ((UserProductorCreator)(users.get(posCreator))).addPodcastToCreator(newPodcast);
			totalAudios.add(newPodcast);
		}else{
			msj = "The Creator wasn't found";
		}
		return msj;
	}

	/**
	 * This method validates if the answer is between 0 and 3
	 * @param  numprueba it's the user's answer
	 * @return isCorrect It's a boolean; true if the answer is between 0 and 3 or False if not.
	 */
	public boolean validateCorrectOption(int numprueba){
		boolean isCorrect = false;
		if(numprueba >= 0 && numprueba <= 3){
			isCorrect = true;
		}
		return isCorrect;
	}

	/**
	 * This method does the same than the previous one, exept because it validates if the number is between 1 and 3.
	 * @param  numprueba It's the user's answer.
	 * @return isCorrect It's a boolean; true if the answer is between 1 and 3. False if not.
	 */
	public boolean validateCorrectOption2(int numprueba){
		boolean isCorrect = false;
		if(numprueba >= 1 && numprueba <=3){
			isCorrect = true;
		}
		return isCorrect;
	}

//------------------------------- Requeriment 4 -----------------------------------------

	/**
	 * This method validates if the Standar exists
	 * @param  cc It's the identification of the Standar.
	 * @return posStandar It contains the position of the Standar in the arraylist or -1 if it doesn't exist.
	 */
	public int validateStandarExists(String cc){
		int posStandar = -1;
		boolean standarExist = false;
		for(int i = 0; i < users.size() && !standarExist; i++){
			if(users.get(i) != null){
				if(users.get(i) instanceof UserCostumerStandar){
					if(((UserCostumerStandar)(users.get(i))).getCc().equalsIgnoreCase(cc)){
						standarExist = true;
						posStandar = i;
					}
				}
			}
		}
		return posStandar;
	}

	/**
	 * This method allows to add a playlist to the standar user
	 * @param  standarCc it's the identification of the standar user
	 * @param  name      It's the name of playlist
	 * @param  type      it´s the type of the playlist
	 * @return msj		 It contains the massage that says if it was added or not
	 */
	public String addPlaylistToStandar(String standarCc, String name, int type){
		String msj = "";
		int posStandar = validateStandarExists(standarCc);
		if(posStandar != -1){
			Playlist newPlalist = new Playlist(name, type);
			msj = ((UserCostumerStandar)(users.get(posStandar))).addPlaylist(newPlalist);
		}else{
			msj = "The standar user wasn't found";
		}
		return msj;
	}

	/**
	 * This method validates if the premium exists
	 * @param  cc It's the identification of the premium.
	 * @return posPremium It contains the position of the premium in the arraylist or -1 if it doesn't exist.
	 */
	public int validatePremiumExists(String cc){
		int posPremium = -1;
		boolean premiumExist = false;
		for(int i = 0; i < users.size() && !premiumExist; i++){
			if(users.get(i) != null){
				if(users.get(i) instanceof UserCostumerPremiun){
					if(((UserCostumerPremiun)(users.get(i))).getCc().equalsIgnoreCase(cc)){
						premiumExist = true;
						posPremium = i;
					}
				}
			}
		}
		return posPremium;
	}

	/**
	 * This method allows to add a playlist to the premium user
	 * @param  standarCc it's the identification of the premuim user
	 * @param  name      It's the name of playlist
	 * @param  type      it´s the type of the playlist
	 * @return msj		 It contains the massage that says if it was added or not
	 */
	public String addPlaylistToPremium(String premiumCc, String name, int type){
		String msj = "";
		int posPremium = validatePremiumExists(premiumCc);
		if(posPremium != -1){
			Playlist newPlalist = new Playlist(name, type);
			msj = ((UserCostumerPremiun)(users.get(posPremium))).addPlaylist(newPlalist);
		}else{
			msj = "The premium user wasn't found";
		}
		return msj;
	}

//-------------------------------- Requeriment 5------------------------------------------

	public int validateIfPlaylistInStandarExists(String userCc, String playlistName){
		int posPlaylist = -1;
		int posStandar = validateStandarExists(userCc);
		if(posStandar != -1){
			posPlaylist = ( (UserCostumerStandar)(users.get(posStandar))).searchPlaylistByNameStandar(playlistName);
		}
		return posPlaylist;
	}

	public int validateIfPlaylistInPremuimExists(String userCc, String playlistName){
		int posPlaylist = -1;
		int posPremium = validatePremiumExists(userCc);
		if(posPremium != -1){
			posPlaylist = ( (UserCostumerPremiun)(users.get(posPremium))).searchPlaylistByNamePremium(playlistName);
		}
		return posPlaylist;
	}

	public String listOfSongsAndPodcasts(){
		String msj = "";
		String msj1 = "";
		String msj2 = "";
		for(int i = 0; i < users.size(); i++){
			if(users.get(i) != null){
				if(users.get(i) instanceof UserProductorArtist){
					msj1 = ((UserProductorArtist)(users.get(i))).listSongs();
				}else if(users.get(i) instanceof UserProductorCreator){
					msj2 = ( (UserProductorCreator)(users.get(i))).listPodcasts();
				}
			}
		}
		return msj = "************SONGS:************* \n" +
			   msj1 + "\n" +
			   "************PODCASTS:************* \n" +
			   msj2 + "\n";
	}

	public String addAudioToSpecificUserStandar(String userCc, String playlistName ,String audioName){
		String msj = "";
		Audio objectAudio = null;
		int posStandar = validateStandarExists(userCc); //It´s already validated, I mean, we already know that the user standar does exist.
		//Buscar el audio por el nombre:
		for(int i = 0; i < totalAudios.size(); i++){
			if(totalAudios.get(i) != null){
				if(totalAudios.get(i) instanceof Song){
					if((((Song)(totalAudios.get(i))).getName()).equalsIgnoreCase(audioName)){
						objectAudio = totalAudios.get(i);
					}
				}else if(totalAudios.get(i) instanceof Podcast){
					if((((Podcast)(totalAudios.get(i))).getName()).equalsIgnoreCase(audioName)){
						objectAudio = totalAudios.get(i);
					}
				}
			}
		}
		msj = ((UserCostumerStandar)(users.get(posStandar))).addAudioToSpecificPlaylist(playlistName, objectAudio);
		return msj;
	}

	public String addAudioToSpecificUserPremium(String userCc, String playlistName ,String audioName){
		String msj = "";
		Audio objectAudio = null;
		int posPremium = validatePremiumExists(userCc); //It´s already validated, I mean, we already know that the user Premium does exist.
		//Buscar el audio por el nombre:
		for(int i = 0; i < totalAudios.size(); i++){
			if(totalAudios.get(i) != null){
				if(totalAudios.get(i) instanceof Song){
					if((((Song)(totalAudios.get(i))).getName()).equalsIgnoreCase(audioName)){
						objectAudio = totalAudios.get(i);
					}
				}else if(totalAudios.get(i) instanceof Podcast){
					if((((Podcast)(totalAudios.get(i))).getName()).equalsIgnoreCase(audioName)){
						objectAudio = totalAudios.get(i);
					}
				}
			}
		}
		msj = ((UserCostumerPremiun)(users.get(posPremium))).addAudioToSpecificPlaylist(playlistName, objectAudio);
		return msj;
	}

	public String listAudiosOfASpecificPlaylistStandar(String userCc, String playlistName){
		String msj = "";
		int posStandar = validateStandarExists(userCc);
		if(posStandar != -1){
			msj = (((UserCostumerStandar)(users.get(posStandar))).listAudiosOfASpecificPlaylist(playlistName));
		}
		return msj;
	}

	public String deleteAudioFromSpecificUserStandar(String userCc, String playlistName, String audioName){
		String msj = "";
		int posStandar = validateStandarExists(userCc);
		if(posStandar != -1){
			msj = (((UserCostumerStandar)(users.get(posStandar))).deleteAudioStandar(playlistName, audioName));
		}
		return msj;
	}

	public String listAudiosOfASpecificPlaylistPremium(String userCc, String playlistName){
		String msj = "";
		int posPremium = validatePremiumExists(userCc);
		if(posPremium != -1){
			msj = (((UserCostumerPremiun)(users.get(posPremium))).listAudiosOfASpecificPlaylist(playlistName));
		}
		return msj;
	}

	public String deleteAudioFromSpecificUserPremium(String userCc, String playlistName, String audioName){
		String msj = "";
		int posPremium = validatePremiumExists(userCc);
		if(posPremium != -1){
			msj = (((UserCostumerPremiun)(users.get(posPremium))).deleteAudioPremium(playlistName, audioName));
		}
		return msj;
	}

}