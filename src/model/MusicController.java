package model;

import java.util.ArrayList;

public class MusicController{

	private ArrayList<UserProductorArtist> artists;
	private ArrayList<UserProductorCreator> creators;
	private ArrayList<UserCostumerStandar> usersStandar;
	private ArrayList<UserCostumerPremiun> usersPremiun;


	public MusicController(){
		artists = new ArrayList<UserProductorArtist>();
		creators = new ArrayList<UserProductorCreator>();
		usersStandar = new ArrayList<UserCostumerStandar>();
		usersPremiun = new ArrayList<UserCostumerPremiun>();

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
		if(artists.add(newArtist)){
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
		if(creators.add(newCreator)){
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
		if(usersStandar.add(newUserStandar)){
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
		if(usersPremiun.add(newUserPremiun)){
			msj = "The premiun user was added succesfully";
		}else{
			msj = "The premiun user wasn't added due to an error. Sorry";
		}
		return msj;
	}

//----------------------------------- Requirement 3 ------------------------------------


	





}