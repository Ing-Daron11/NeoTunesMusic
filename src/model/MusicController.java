package model;

import java.util.ArrayList;
import java.util.Random;

public class MusicController{

	private ArrayList<User> users;
    private ArrayList<Audio> totalAudios; //This are all the audios of the System


	public MusicController(){
		users = new ArrayList<User>();
		totalAudios = new ArrayList<Audio>();
		initialize();
		
	}

//-----------------------------------Default values----------------------------------
	public void initialize(){
		String msj1 = "";
		String msj2 = "";
		String msj3 = "";
		String msj4 = "";
		String msj5 = "";
		String msj6 = "";
		UserProductorArtist newArtist1 = new UserProductorArtist("Dalmata","123","www.dalmata.com");
		UserProductorArtist newArtist2 = new UserProductorArtist("Daddy_Yanky","456","www.Daddy_Yanky.com");
		UserProductorArtist newArtist3 = new UserProductorArtist("Eddy_Herrera","789","www.Eddy_Herrera.com");
		users.add(newArtist1);
		users.add(newArtist2);
		users.add(newArtist3);
		UserProductorCreator newCreator1 = new UserProductorCreator("Petro","135","www.Petro.com");
		UserProductorCreator newCreator2 = new UserProductorCreator("Jesus","246","www.Jesus.com");
		UserProductorCreator newCreator3 = new UserProductorCreator("El_Chamo","680","www.El_Chamo.com");
		users.add(newCreator1);
		users.add(newCreator2);
		users.add(newCreator3);
		msj1 = addSong("123", "Pasarela", "www.youtube/Pasarela.com", 220, "String album", 3000, 0);
		msj2 = addSong("456", "Bombon", "www.youtube/Bombón.com", 180, "String album", 2000, 1);
		msj3 = addSong("789", "Tu_vicio", "www.youtube/Tu_vicio.com", 120, "String album", 5000, 3);
		msj4 = addPodcast("135", "Una_vida_muchas_vidas", "www.Spotify/Una_vida_muchas_vidas.com", 30000 ,"String description", 0);
		msj5 = addPodcast("246", "Colombia", "www.Spotify/Colombia.com", 30000 ,"String description", 1);
		msj6 = addPodcast("680", "Warzone2", "www.Spotify/warzone2.com", 15000 ,"String description", 2);

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
	/**
	 * This method validates if a playlist belongs to a partiular Standar user.
	 * @param  userCc       It represents the identification of the user
	 * @param  playlistName It contains the name of the playlist that is going to be searched in this user.
	 * @return posPlaylist  It has te position of the playlist if it was found or -1 if it wasn't.
	 */
	public int validateIfPlaylistInStandarExists(String userCc, String playlistName){
		int posPlaylist = -1;
		int posStandar = validateStandarExists(userCc);
		if(posStandar != -1){
			posPlaylist = ( (UserCostumerStandar)(users.get(posStandar))).searchPlaylistByNameStandar(playlistName);
		}
		return posPlaylist;
	}

	/**
	 * This method validates if a playlist belongs to a partiular Premium user.
	 * @param  userCc       It represents the identification of the user
	 * @param  playlistName It contains the name of the playlist that is going to be searched in this user.
	 * @return posPlaylist  It has te position of the playlist if it was found or -1 if it wasn't.
	 */
	public int validateIfPlaylistInPremuimExists(String userCc, String playlistName){
		int posPlaylist = -1;
		int posPremium = validatePremiumExists(userCc);
		if(posPremium != -1){
			posPlaylist = ( (UserCostumerPremiun)(users.get(posPremium))).searchPlaylistByNamePremium(playlistName);
		}
		return posPlaylist;
	}

	/**
	 * This method list all the songs and podcasts that the artists and creators have added
	 * @return msj = It contanis the ordered list
	 */
	public String listOfSongsAndPodcasts(){
		String msj = "";
		String msj1 = "";
		String msj2 = "";
		for(int i = 0; i < totalAudios.size(); i++){
			if(totalAudios.get(i) != null){
				if(totalAudios.get(i) instanceof Song){
					msj1 += ((Song)(totalAudios.get(i))).getName() + "\n";
				}else if(totalAudios.get(i) instanceof Podcast){
					msj2 += ((Podcast)(totalAudios.get(i))).getName() + "\n";
				}
			}
		}
		return msj = "************SONGS:************* \n" +
			   msj1 + "\n" +
			   "************PODCASTS:************* \n" +
			   msj2 + "\n";
	}

	/**
	 * This method allows to add a song or podcast to a playlist's users.
	 * @param  userCc       It represents the identification of the user
	 * @param  playlistName It contains the name of the playlist that is going to be searched in this user.
	 * @param  audioName    It's the name of the audio that is going to be searched and if it exists and the user with it's playlist, then it would be added.
	 * @return msj          It contains the message that says it if was added or not.
	 */
	public String addAudioToSpecificUserStandar(String userCc, String playlistName ,String audioName){
		String msj = "";
		Audio objectAudio = null;
		boolean isFound = false;
		int posStandar = validateStandarExists(userCc); //It´s already validated, I mean, we already know that the user standar does exist.
		//Buscar el audio por el nombre:
		for(int i = 0; i < totalAudios.size() && !isFound; i++){
			if(totalAudios.get(i) != null){
				if(totalAudios.get(i) instanceof Song){
					if((totalAudios.get(i)).getName().equalsIgnoreCase(audioName)){
						isFound = true;
						objectAudio = totalAudios.get(i);
						msj = ((UserCostumerStandar)(users.get(posStandar))).addAudioToSpecificPlaylist(playlistName, objectAudio);
					}else{
						msj = "The audio does not exist";
					}
				}else if(totalAudios.get(i) instanceof Podcast){
					if((totalAudios.get(i)).getName().equalsIgnoreCase(audioName)){
						isFound = true;
						objectAudio = totalAudios.get(i);
						msj = ((UserCostumerStandar)(users.get(posStandar))).addAudioToSpecificPlaylist(playlistName, objectAudio);
					}else{
						msj = "The audio does not exist";
					}
				}
			}
		}
		
		return msj;
	}

	/**
	 * This method allows to add a song or podcast to a playlist's users.
	 * @param  userCc       It represents the identification of the user
	 * @param  playlistName It contains the name of the playlist that is going to be searched in this user.
	 * @param  audioName    It's the name of the audio that is going to be searched and if it exists and the user with it's playlist, then it would be added.
	 * @return msj          It contains the message that says it if was added or not.
	 */
	public String addAudioToSpecificUserPremium(String userCc, String playlistName ,String audioName){
		String msj = "";
		Audio objectAudio = null;
		boolean isFound = false;
		int posPremium = validatePremiumExists(userCc); //It´s already validated, I mean, we already know that the user Premium does exist.
		//Buscar el audio por el nombre:
		for(int i = 0; i < totalAudios.size() && !isFound; i++){
			if(totalAudios.get(i) != null){
				if(totalAudios.get(i) instanceof Song){
					if((((Song)(totalAudios.get(i))).getName()).equalsIgnoreCase(audioName)){
						isFound = true;
						objectAudio = totalAudios.get(i);
						msj = ((UserCostumerPremiun)(users.get(posPremium))).addAudioToSpecificPlaylist(playlistName, objectAudio);

					}else{
						msj = "The audio does not exist";
					}
				}else if(totalAudios.get(i) instanceof Podcast){
					if((((Podcast)(totalAudios.get(i))).getName()).equalsIgnoreCase(audioName)){
						isFound = true;
						objectAudio = totalAudios.get(i);
						msj = ((UserCostumerPremiun)(users.get(posPremium))).addAudioToSpecificPlaylist(playlistName, objectAudio);
					}else{
						msj = "The audio does not exist";
					}
				}
			}
		}
		return msj;
	}

	/**
	 * This method allows to list the content of a specific playlis of a user.
	 * @param  userCc       It represents the id of the user.
	 * @param  playlistName It contains the name of the playlist that is going to searched.
	 * @return msj 			It contains the list of the audios of the playlist of that user.            
	 */
	public String listAudiosOfASpecificPlaylistStandar(String userCc, String playlistName){
		String msj = "";
		int posStandar = validateStandarExists(userCc);
		if(posStandar != -1){
			msj = (((UserCostumerStandar)(users.get(posStandar))).listAudiosOfASpecificPlaylist(playlistName));
		}
		return msj;
	}

	/**
	 * This method allows to remove a specific audio from a specific user's playlist.
	 * @param  userCc       It represents the id of the user.
	 * @param  playlistName It contains the name of the playlist that is going to searched.
	 * @param  audioName    It's the name of the audio that is going to be searched and if it exists and the user with it's playlist, then it would be deleted.
	 * @return msj          It contains the massage that says if the audio was deleted succesfully.
	 */
	public String deleteAudioFromSpecificUserStandar(String userCc, String playlistName, String audioName){
		String msj = "";
		int posStandar = validateStandarExists(userCc);
		if(posStandar != -1){
			msj = (((UserCostumerStandar)(users.get(posStandar))).deleteAudioStandar(playlistName, audioName));
		}
		return msj;
	}

	/**
	 * This method allows to list the content of a specific playlis of a user.
	 * @param  userCc       It represents the id pof the user
	 * @param  playlistName It contains the name of the playlist that is going to searched.
	 * @return msj 			It contains the list of the audios of the playlist of that user.            
	 */
	public String listAudiosOfASpecificPlaylistPremium(String userCc, String playlistName){
		String msj = "";
		int posPremium = validatePremiumExists(userCc);
		if(posPremium != -1){
			msj = (((UserCostumerPremiun)(users.get(posPremium))).listAudiosOfASpecificPlaylist(playlistName));
		}
		return msj;
	}

	/**
	 * This method allows to remove a specific audio from a specific user's playlist.
	 * @param  userCc       It represents the id of the user.
	 * @param  playlistName It contains the name of the playlist that is going to searched.
	 * @param  audioName    It's the name of the audio that is going to be searched and if it exists and the user with it's playlist, then it would be deleted.
	 * @return msj          It contains the massage that says if the audio was deleted succesfully.
	 */
	public String deleteAudioFromSpecificUserPremium(String userCc, String playlistName, String audioName){
		String msj = "";
		int posPremium = validatePremiumExists(userCc);
		if(posPremium != -1){
			msj = (((UserCostumerPremiun)(users.get(posPremium))).deleteAudioPremium(playlistName, audioName));
		}
		return msj;
	}

//-------------------------------- Requeriment 6------------------------------------------

	/**
	 * This method allow to print the matrix where the playlist code is formed.
	 * @param  userCc       It's the id of the User
	 * @param  playlistName It's the playlist that's going to be searched.
	 * @return msj 			It contains the marix well organized.
	 */
	public String showMatrizByStandar(String userCc, String playlistName){
		String msj = "";
		int posStandar = validateStandarExists(userCc);
		if(posStandar != -1){
			msj = ((UserCostumerStandar)(users.get(posStandar))).showMatrizStandar(playlistName);
		}
		return msj;
	}

	/**
	 * This method allow to print the matrix where the playlist code is formed.
	 * @param  userCc       It's the id of the User
	 * @param  playlistName It's the playlist that's going to be searched.
	 * @return msj 			It contains the marix well organized.
	 */
	public String showMatrizByPremium(String userCc, String playlistName){
		String msj = "";
		int posPremium = validatePremiumExists(userCc);
		if(posPremium != -1){
			msj = ((UserCostumerPremiun)(users.get(posPremium))).showMatrizPremium(playlistName);
		}
		return msj;
	}

//-------------------------------- Requeriment 7------------------------------------------

	/**
	 * This method allows to List all the audio from the system
	 * @return msj It contains the list well organized.
	 */
	public String listAudiosFromSystem(){
		String msj = "";
		String msj1 = "";
		String msj2 = "";
		for(int i = 0; i < totalAudios.size(); i++){
			if(totalAudios.get(i) != null){
				if(totalAudios.get(i) instanceof Song){
					msj1 += ((Song)(totalAudios.get(i))).getName() + "\n";
				}else if(totalAudios.get(i) instanceof Podcast){
					msj2 += ((Podcast)(totalAudios.get(i))).getName() + "\n";
				}
			}
		}
		return msj = "\n ************SONGS:************* \n" +
			   msj1 + "\n" +
			   "************PODCASTS:************* \n" +
			   msj2 + "\n";
	}

	/**
	 * This method allows to simulate the play of an audio and include adds
	 * @param  audioName It's the audioName that is going to be played
	 * @return msj  	 It contains the adds and the song being played.
	 */	
	public String playAudioForStandar(String audioName){
		String msj = "The audio" + audioName + "wasn't found";
		int counter = 1;
		boolean isFound = false;
		for (int i = 0; i < totalAudios.size() && !isFound; i++){
			if(totalAudios.get(i) != null){
				if(totalAudios.get(i) instanceof Song){
					if((totalAudios.get(i)).getName().equalsIgnoreCase(audioName)){
						isFound = true;
						msj = "Playing '" + audioName + "'...";
						((Song)(totalAudios.get(i))).setReproductions(counter);
						
						if(((((Song)(totalAudios.get(i))).getReproductions())%2)==0){
							msj += "\n" + playAdd();
						}
					}
				}else if(totalAudios.get(i) instanceof Podcast){
					if((totalAudios.get(i)).getName().equalsIgnoreCase(audioName)){
						isFound = true;
						msj = playAdd() + "\n" +
						"Playing '" + audioName + "'...";
						((Podcast)(totalAudios.get(i))).setReproductions(counter);

					}
				}
			}
		}
		return msj;
	}

	/**
	 * This method allows to simulate the play of an audio
	 * @param  audioName It's the audioName that is going to be played
	 * @return msj  	 It contains the song being played.
	 */	
	public String playAudioForPremium(String audioName){
		String msj = "The audio" + audioName + "wasn't found";
		int counter = 1;
		boolean isFound = false;
		for (int i = 0; i < totalAudios.size() && !isFound; i++){
			if(totalAudios.get(i) != null){
				if(totalAudios.get(i) instanceof Song){
					if((totalAudios.get(i)).getName().equalsIgnoreCase(audioName)){
						isFound = true;
						msj = "Playing '" + audioName + "'...";
						((Song)(totalAudios.get(i))).setReproductions(counter);
					}
				}else if(totalAudios.get(i) instanceof Podcast){
					if((totalAudios.get(i)).getName().equalsIgnoreCase(audioName)){
						isFound = true;
						msj = "Playing '" + audioName + "'...";
						((Podcast)(totalAudios.get(i))).setReproductions(counter);

					}
				}	
			}
		}
		return msj;
	}

	/**
	 * This method allows to play ramdomly an add.
	 * @return msj = It contains the adds. 
	 */
	public String playAdd(){
		Random aleatorio = new Random();
		String msj = "";
		int numRamdom = (aleatorio.nextInt(3-1)+1);
		if(numRamdom == 1){
			msj = "Nike - Just Do It.";
		}else if(numRamdom == 2){
			msj = "Coca-Cola - Open Happiness.";
		}else{
			msj = "M&Ms - Melts in Your Mouth, Not in Your Hands";
		}
		return msj;
	}

//-------------------------------- Requeriment 8------------------------------------------

	/**
	 * This method allows to list only the song in all the system.
	 * @return msj = It contains the list of the songs from the system
	 */
	public String listSongsFromSystem(){
		String msj = "";
		String msj1 = "";
		for(int i = 0; i < totalAudios.size(); i++){
			if(totalAudios.get(i) != null){
				if(totalAudios.get(i) instanceof Song){
					msj1 += ((Song)(totalAudios.get(i))).getName() + " Price: $" + ((Song)(totalAudios.get(i))).getCost() + "\n";
				}
			}
		}
		return msj = "\n ************SONGS:************* \n" +
			   msj1 + "\n";
	}

	/**
	 * This method allows to buy a song from the system
	 * @param  songName It´s the song that is going to bought.
	 * @return msj = It contais the information of the purchase.
	 */
	public String buySong(String songName){
		String msj = "The song '" + songName + "' wasn't found";
		int counter = 1;
		boolean isFound = false;
		for(int i = 0; i < totalAudios.size() && !isFound; i++){
			if(totalAudios.get(i) != null){
				if(totalAudios.get(i) instanceof Song){
					if((totalAudios.get(i)).getName().equalsIgnoreCase(songName)){
						isFound = true;
						msj = "Song bought: " + ((Song)(totalAudios.get(i))).getName() + " Price $" + ((Song)(totalAudios.get(i))).getCost() + "\n" + 
							  "Thanks for your purchase";
						((Song)(totalAudios.get(i))).setSells(counter);
					}
				}
			}
		}
		return msj;
	}

//-------------------------------- Requeriment 9------------------------------------------

	/**
	 * This method allows to count how many times all songa have been played
	 * @return msj: it contains the massage
	 */
	public String countPlaytimes(){
		String msj = "";
		int counterPlayTimes = 0;
		for(int i = 0; i < totalAudios.size(); i++){
			if(totalAudios.get(i) != null){
				if(totalAudios.get(i) instanceof Song){
					counterPlayTimes +=((Song)(totalAudios.get(i))).getReproductions();
				}
			}
		}
		msj = "The total reproductions are: " + counterPlayTimes;
		return msj;
	}

	/**
	 * This methos allows to get the reproductions of the genre most listened
	 * @return msj = It contains the massage
	 */
	public String genreMostPlayed(){
		String msj = "";
		String genreName = "";
		int maxCounter = 0;
		int type = -1;
		int pos = -1;

		for(int i = 0; i < totalAudios.size(); i++){
			if(totalAudios.get(i) != null){
				if(totalAudios.get(i) instanceof Song){
					if(((Song)(totalAudios.get(i))).getReproductions() > maxCounter){
						maxCounter = ((Song)(totalAudios.get(i))).getReproductions();
						pos = i;
					}
				}
			}
		}

		if(pos != -1){
			type = ((Song)(totalAudios.get(pos))).getOptionTypeSong();
				if(type ==0){
					genreName = "Rock";
				}else if(type == 1){
					genreName = "Pop";
				}else if(type == 2){
					genreName = "Trap";
				}else{
					genreName = "House";
				}
				msj = "The genre more listened is: " + genreName + " Reproductions: " + maxCounter;
		}else{
			msj = "There are no Songs played yet"; 
		}
		
		return msj;	
	}

	/**
	 * This methos allows to get the reproductions of the Category most listened
	 * @return msj = It contains the massage
	 */
	public String categoryMostPlayed(){
		String msj = "";
		String categoryName = "";
		int maxCounter = 0;
		int type = -1;
		int pos = -1;

		for(int i = 0; i < totalAudios.size(); i++){
			if(totalAudios.get(i) != null){
				if(totalAudios.get(i) instanceof Podcast){
					if(((Podcast)(totalAudios.get(i))).getReproductions() > maxCounter){
						maxCounter = ((Podcast)(totalAudios.get(i))).getReproductions();
						pos = i;
					}
				}
			}
		}

		if(pos != -1){
			type = ((Podcast)(totalAudios.get(pos))).getOptionTypePodcast();
				if(type ==0){
					categoryName = "POLITICS";
				}else if(type == 1){
					categoryName = "ENTERTAINMENT";
				}else if(type == 2){
					categoryName = "VIDEOGAMES";
				}else{
					categoryName = "FASHION";
				}
				msj = "The genre more listened is: " + categoryName + " Reproductions: " + maxCounter;
		}else{
			msj = "There are no Podcast played yet"; 
		}
		
		return msj;	
	}


	/**
	 * This method allows to list the  top 5 artists and top 5 creators 
	 * based on the amount of reproductions of their audios and show their info.
	 * @return msj = It contains the massage
	 */
	public String showTop5ArtistAndCreator(){
		String msj1 = "";
		String msj2 = "";
		//reproductions
		int varAxuliar1 = 0;
		int varAxuliar2 = 0;
		int varAxuliar3 = 0;
		int varAxuliar4 = 0;
		int varAxuliar5 = 0;
		//names
		String top1 = "";
		String top2 = "";
		String top3 = "";
		String top4 = "";
		String top5 = "";

		//Artists
		for(int i = 0; i < users.size(); i++){
			if(users.get(i) != null){
				if(users.get(i) instanceof UserProductorArtist){
					if(((UserProductorArtist)(users.get(i))).countReproductions() > varAxuliar1){
						varAxuliar1 = ((UserProductorArtist)(users.get(i))).countReproductions();
						top5 = top4;
						top4 = top3;
						top3 = top2;
						top2 = top1;
						top1 = ((UserProductorArtist)(users.get(i))).getName() + " Reproductions: " + varAxuliar1;

					}else if(((UserProductorArtist)(users.get(i))).countReproductions() > varAxuliar2){
						varAxuliar2 = ((UserProductorArtist)(users.get(i))).countReproductions();
						top5 = top4;
						top4 = top3;
						top3 = top2;
						top2 = ((UserProductorArtist)(users.get(i))).getName() + " Reproductions: " + varAxuliar2;

					}else if(((UserProductorArtist)(users.get(i))).countReproductions() > varAxuliar3){
						varAxuliar3 = ((UserProductorArtist)(users.get(i))).countReproductions();
						top5 = top4;
						top4 = top3;
						top3 = ((UserProductorArtist)(users.get(i))).getName() + " Reproductions: " + varAxuliar3;

					}else if(((UserProductorArtist)(users.get(i))).countReproductions() > varAxuliar4){
						varAxuliar4 = ((UserProductorArtist)(users.get(i))).countReproductions();
						top5 = top4;
						top4 = ((UserProductorArtist)(users.get(i))).getName() + " Reproductions: " + varAxuliar4;

					}else if(((UserProductorArtist)(users.get(i))).countReproductions() > varAxuliar5){
						varAxuliar5 = ((UserProductorArtist)(users.get(i))).countReproductions();
						top5 = ((UserProductorArtist)(users.get(i))).getName() + " Reproductions: " + varAxuliar5;
					}
				}
			}
		}
		msj1 = top1 + "\n"+
			  top2 + "\n"+
			  top3 + "\n"+
			  top4 + "\n"+
			  top5 + "\n";

		top1 = "";
		top2 = "";
		top3 = "";
		top4 = "";
		top5 = "";
		//Creators
		for(int i = 0; i < users.size(); i++){
			if(users.get(i) != null){
				if(users.get(i) instanceof UserProductorCreator){
					if(((UserProductorCreator)(users.get(i))).countReproductions() > varAxuliar1){
						varAxuliar1 = ((UserProductorCreator)(users.get(i))).countReproductions();
						top5 = top4;
						top4 = top3;
						top3 = top2;
						top2 = top1;
						top1 = ((UserProductorCreator)(users.get(i))).getName() + " Reproductions: " + varAxuliar1;

					}else if(((UserProductorCreator)(users.get(i))).countReproductions() > varAxuliar2){
						varAxuliar2 = ((UserProductorCreator)(users.get(i))).countReproductions();
						top5 = top4;
						top4 = top3;
						top3 = top2;
						top2 = ((UserProductorCreator)(users.get(i))).getName() + " Reproductions: " + varAxuliar2;

					}else if(((UserProductorCreator)(users.get(i))).countReproductions() > varAxuliar3){
						varAxuliar3 = ((UserProductorCreator)(users.get(i))).countReproductions();
						top5 = top4;
						top4 = top3;
						top3 = ((UserProductorCreator)(users.get(i))).getName() + " Reproductions: " + varAxuliar3;

					}else if(((UserProductorCreator)(users.get(i))).countReproductions() > varAxuliar4){
						varAxuliar4 = ((UserProductorCreator)(users.get(i))).countReproductions();
						top5 = top4;
						top4 = ((UserProductorCreator)(users.get(i))).getName() + " Reproductions: " + varAxuliar4;

					}else if(((UserProductorCreator)(users.get(i))).countReproductions() > varAxuliar5){
						varAxuliar5 = ((UserProductorCreator)(users.get(i))).countReproductions();
						top5 = ((UserProductorCreator)(users.get(i))).getName() + " Reproductions: " + varAxuliar5;
					}
				}
			}
		}
		msj2 = top1 + "\n"+
			   top2 + "\n"+
			   top3 + "\n"+
			   top4 + "\n"+
			   top5 + "\n";

		return "----Top 5 Artists----\n" +
			   msj1 + "\n"+
			   "----Top 5 Creators----\n" +
			   msj2 + "\n";
	}

	/**
	 * This method allows to list the  top 10 Songs and top 10 Podcasts 
	 * based on the amount of reproductions and show their info.
	 * @return msj = It contains the massage
	 */
	public String showTop10SongsAndPodcasts(){
		String msj1 = "";
		String msj2 = "";
		//Reproductions
		int varAxuliar1 = 0;
		int varAxuliar2 = 0;
		int varAxuliar3 = 0;
		int varAxuliar4 = 0;
		int varAxuliar5 = 0;
		int varAxuliar6 = 0;
		int varAxuliar7 = 0;
		int varAxuliar8 = 0;
		int varAxuliar9 = 0;
		int varAxuliar10 = 0;

		//names
		String top1 = "";
		String top2 = "";
		String top3 = "";
		String top4 = "";
		String top5 = "";
		String top6 = "";
		String top7 = "";
		String top8 = "";
		String top9 = "";
		String top10 = "";


		//Songs
		for(int i = 0; i < totalAudios.size(); i++){
			if(totalAudios.get(i) != null){
				if(totalAudios.get(i) instanceof Song){
					if(((Song)(totalAudios.get(i))).getReproductions() > varAxuliar1){
						varAxuliar1 = ((Song)(totalAudios.get(i))).getReproductions();
						top10 = top9;
						top9 = top8;
						top8 = top7;
						top7 = top6;
						top6 = top5;
						top5 = top4;
						top4 = top3;
						top3 = top2;
						top2 = top1;
						top1 = ((Song)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar1;

					}else if(((Song)(totalAudios.get(i))).getReproductions() > varAxuliar2){
						varAxuliar2 = ((Song)(totalAudios.get(i))).getReproductions();
						top10 = top9;
						top9 = top8;
						top8 = top7;
						top7 = top6;
						top6 = top5;
						top5 = top4;
						top4 = top3;
						top3 = top2;
						top2 = ((Song)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar2;

					}else if(((Song)(totalAudios.get(i))).getReproductions() > varAxuliar3){
						varAxuliar3 = ((Song)(totalAudios.get(i))).getReproductions();
						top10 = top9;
						top9 = top8;
						top8 = top7;
						top7 = top6;
						top6 = top5;
						top5 = top4;
						top4 = top3;
						top3 = ((Song)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar3;

					}else if(((Song)(totalAudios.get(i))).getReproductions() > varAxuliar4){
						varAxuliar4 = ((Song)(totalAudios.get(i))).getReproductions();
						top10 = top9;
						top9 = top8;
						top8 = top7;
						top7 = top6;
						top6 = top5;
						top5 = top4;
						top4 = ((Song)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar4;

					}else if(((Song)(totalAudios.get(i))).getReproductions() > varAxuliar5){
						varAxuliar5 = ((Song)(totalAudios.get(i))).getReproductions();
						top10 = top9;
						top9 = top8;
						top8 = top7;
						top7 = top6;
						top6 = top5;
						top5 = ((Song)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar5;

					}else if(((Song)(totalAudios.get(i))).getReproductions() > varAxuliar6){
						varAxuliar6 = ((Song)(totalAudios.get(i))).getReproductions();
						top10 = top9;
						top9 = top8;
						top8 = top7;
						top7 = top6;
						top6 = ((Song)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar6;

					}else if(((Song)(totalAudios.get(i))).getReproductions() > varAxuliar7){
						varAxuliar7 = ((Song)(totalAudios.get(i))).getReproductions();
						top10 = top9;
						top9 = top8;
						top8 = top7;
						top7 = ((Song)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar7;

					}else if(((Song)(totalAudios.get(i))).getReproductions() > varAxuliar8){
						varAxuliar8 = ((Song)(totalAudios.get(i))).getReproductions();
						top10 = top9;
						top9 = top8;
						top8 = ((Song)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar8;
						
					}else if(((Song)(totalAudios.get(i))).getReproductions() > varAxuliar9){
						varAxuliar9 = ((Song)(totalAudios.get(i))).getReproductions();
						top10 = top9;
						top9 = ((Song)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar9;
						
					}else if(((Song)(totalAudios.get(i))).getReproductions() > varAxuliar10){
						varAxuliar10 = ((Song)(totalAudios.get(i))).getReproductions();
						top10 = ((Song)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar10;
						
					}
				}
			}
		}
		msj1 = top1 + "\n"+
			  top2 + "\n"+
			  top3 + "\n"+
			  top4 + "\n"+
			  top5 + "\n"+
			  top6 + "\n"+
			  top7 + "\n"+
			  top8 + "\n"+
			  top9 + "\n"+
			  top10 + "\n";

		top1 = "";
		top2 = "";
		top3 = "";
		top4 = "";
		top5 = "";
		top6 = "";
		top7 = "";
		top8 = "";
		top9 = "";
		top10 = "";

		//Podcast
		for(int i = 0; i < totalAudios.size(); i++){
			if(totalAudios.get(i) != null){
				if(totalAudios.get(i) instanceof Podcast){
					if(((Podcast)(totalAudios.get(i))).getReproductions() > varAxuliar1){
						varAxuliar1 = ((Podcast)(totalAudios.get(i))).getReproductions();
						top10 = top9;
						top9 = top8;
						top8 = top7;
						top7 = top6;
						top6 = top5;
						top5 = top4;
						top4 = top3;
						top3 = top2;
						top2 = top1;
						top1 = ((Podcast)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar1;

					}else if(((Podcast)(totalAudios.get(i))).getReproductions() > varAxuliar2){
						varAxuliar2 = ((Podcast)(totalAudios.get(i))).getReproductions();
						top10 = top9;
						top9 = top8;
						top8 = top7;
						top7 = top6;
						top6 = top5;
						top5 = top4;
						top4 = top3;
						top3 = top2;
						top2 = ((Podcast)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar2;

					}else if(((Podcast)(totalAudios.get(i))).getReproductions() > varAxuliar3){
						varAxuliar3 = ((Podcast)(totalAudios.get(i))).getReproductions();
						top10 = top9;
						top9 = top8;
						top8 = top7;
						top7 = top6;
						top6 = top5;
						top5 = top4;
						top4 = top3;
						top3 = ((Podcast)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar3;

					}else if(((Podcast)(totalAudios.get(i))).getReproductions() > varAxuliar4){
						varAxuliar4 = ((Podcast)(totalAudios.get(i))).getReproductions();
						top10 = top9;
						top9 = top8;
						top8 = top7;
						top7 = top6;
						top6 = top5;
						top5 = top4;
						top4 = ((Podcast)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar4;

					}else if(((Podcast)(totalAudios.get(i))).getReproductions() > varAxuliar5){
						varAxuliar5 = ((Podcast)(totalAudios.get(i))).getReproductions();
						top10 = top9;
						top9 = top8;
						top8 = top7;
						top7 = top6;
						top6 = top5;
						top5 = ((Podcast)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar5;

					}else if(((Podcast)(totalAudios.get(i))).getReproductions() > varAxuliar6){
						varAxuliar6 = ((Podcast)(totalAudios.get(i))).getReproductions();
						top10 = top9;
						top9 = top8;
						top8 = top7;
						top7 = top6;
						top6 = ((Podcast)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar6;

					}else if(((Podcast)(totalAudios.get(i))).getReproductions() > varAxuliar7){
						varAxuliar7 = ((Podcast)(totalAudios.get(i))).getReproductions();
						top10 = top9;
						top9 = top8;
						top8 = top7;
						top7 = ((Podcast)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar7;

					}else if(((Podcast)(totalAudios.get(i))).getReproductions() > varAxuliar8){
						varAxuliar8 = ((Podcast)(totalAudios.get(i))).getReproductions();
						top10 = top9;
						top9 = top8;
						top8 = ((Podcast)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar8;
						
					}else if(((Podcast)(totalAudios.get(i))).getReproductions() > varAxuliar9){
						varAxuliar9 = ((Podcast)(totalAudios.get(i))).getReproductions();
						top10 = top9;
						top9 = ((Podcast)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar9;
						
					}else if(((Podcast)(totalAudios.get(i))).getReproductions() > varAxuliar10){
						varAxuliar10 = ((Podcast)(totalAudios.get(i))).getReproductions();
						top10 = ((Podcast)(totalAudios.get(i))).getName() + " Reproductions: " + varAxuliar10;
						
					}
				}
			}
		}
		msj2 = top1 + "\n"+
			  top2 + "\n"+
			  top3 + "\n"+
			  top4 + "\n"+
			  top5 + "\n"+
			  top6 + "\n"+
			  top7 + "\n"+
			  top8 + "\n"+
			  top9 + "\n"+
			  top10 + "\n";

		return "----Top 10 Songs----\n" +
			   msj1 + "\n"+
			   "----Top 10 Podcasts----\n" +
			   msj2 + "\n";
	}

	/**
	 * This method allows to count the amount of copies per genre and the total price collected
	 * @return msj = it contains all the information
	 */
	public String showTotalSoldSong(){
		String msj = "";
		int copiessoldRock = 0;
		int copiessoldPop = 0;
		int copiessoldTrap = 0;
		int copiessoldHouse = 0;
		int moneyCollectedRock = 0;
		int moneyCollectedPop = 0;
		int moneyCollectedTrap = 0;
		int moneyCollectedHouse = 0;

		int type = -1;
		for (int i = 0; i < totalAudios.size();i++){
			if(totalAudios.get(i) instanceof Song){
				type = ((Song)(totalAudios.get(i))).getOptionTypeSong();
				if(type == 0){
					copiessoldRock += ((Song)(totalAudios.get(i))).getSells();
					moneyCollectedRock += copiessoldRock * ((Song)(totalAudios.get(i))).getCost();
				}else if( type == 1){
					copiessoldPop += ((Song)(totalAudios.get(i))).getSells();
					moneyCollectedPop += copiessoldPop * ((Song)(totalAudios.get(i))).getCost();
				}else if(type == 2){
					copiessoldTrap += ((Song)(totalAudios.get(i))).getSells();
					moneyCollectedTrap += copiessoldTrap * ((Song)(totalAudios.get(i))).getCost();
				}else if(type == 3){
					copiessoldHouse += ((Song)(totalAudios.get(i))).getSells();
					moneyCollectedHouse += copiessoldHouse * ((Song)(totalAudios.get(i))).getCost();
				}
			}
		}
		msj = "****SONGS SOLDS:****\n" +
			  "Rock: " + copiessoldRock + "\n"+
			  "Pop: " + copiessoldPop + "\n"+
			  "Trap: " + copiessoldTrap + "\n"+
			  "House: " + copiessoldHouse + "\n"+
			  "TOTAL: " + (copiessoldRock + copiessoldPop + copiessoldTrap + copiessoldHouse) + "\n"+
			  "****MONEY COLLECTED:****\n"+
			  "Rock: " + moneyCollectedRock + "\n"+
			  "Pop: " + moneyCollectedPop + "\n"+
			  "Trap: " + moneyCollectedTrap + "\n"+
			  "House: " + moneyCollectedHouse + "\n"+
			  "TOTAL: " + (moneyCollectedRock + moneyCollectedPop + moneyCollectedTrap + moneyCollectedHouse) + "\n";
		return msj;
	}

	public String showCopiesAndMoneyCollectedFromMostSoldSong(){
		String msj = "";
		String songName = "";
		int pos = -1;
		double maxCounter = 0;
		double moneycollected = 0;
		for(int i = 0; i < totalAudios.size(); i++){
			if(totalAudios.get(i) != null){
				if(totalAudios.get(i) instanceof Song){
					if(((Song)(totalAudios.get(i))).getSells() > maxCounter){
						maxCounter = ((Song)(totalAudios.get(i))).getSells();
						pos = i;
					}
				}
			}
		}

		songName = ((Song)(totalAudios.get(pos))).getName();
		moneycollected = (maxCounter * ((Song)(totalAudios.get(pos))).getCost());
		msj = "The song most sold is: " + songName + "\n"+
			  "Copies sold: "+ maxCounter + "\n"+
			  "Money collected: " + moneycollected + "\n";
		return msj;
	}


}