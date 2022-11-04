package model;

import java.util.ArrayList;

public class MusicController{

	private ArrayList<User> users;

	public MusicController(){
		users = new ArrayList<User>();
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

	
	public String addSong(String artistCc, String name, String url, String duration, String album, double cost, int optionTypeSong){
		String msj = "";
		int posArtist = validateArtistExists(artistCc);
		if(posArtist != -1){
			Song newSong = new Song(name, url, duration, album, cost, optionTypeSong);
			msj = ((UserProductorArtist)(users.get(posArtist))).addSongToArtist(newSong);
		}else{
			msj = "The artis wasn't found";
		}
		return msj;
		
	}

	public boolean validateCorrectOption(int numprueba){
		boolean isCorrect = false;
		if(numprueba >= 0 && numprueba <= 3){
			isCorrect = true;
		}
		return isCorrect;
	}








}