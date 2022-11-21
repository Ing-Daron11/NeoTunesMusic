package ui;

import java.util.Scanner;

import model.MusicController;

public class Main {


	private Scanner input;
	private MusicController controller;

	public Main() {
		input = new Scanner(System.in); 
		controller = new MusicController();

	}

	public static void main(String[] args) {
			Main main = new Main(); 

			int option = -1; 
			do{
				System.out.println(main.printMenu());
				option = main.getOptionShowMenu(); 
				main.executeOption(option);

			}while(option != 0);

		}

	public Scanner getInput() {
		return this.input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}

	public int getOptionShowMenu(){
			int option = 0;
			option = validateIntegerOption(); 
			return option; 
		}

		public String printMenu(){
			return 
				"\n" +
				"<< --------------------------------------------------------------------- >>\n" +
				"<< -                                Welcome                            - >>\n" +
				"<< --------------------------------------------------------------------- >>\n" +
				"1. Add artist/Creator \n" +
				"2. Add standar/premiun \n" + 
				"3. Add a song/podcast\n" +
				"4. Create a playlist\n" +
				"5. Edit playlist\n" +
				"6. Share a playlist\n" +
				"7. Play a song/podcast\n" +
				"8. Buy a song\n" +
				"9. \n" +
				"0. Exit.\n"; 
		}

		public void executeOption(int option){
			String msj = "";
			String userNickname = "";
			String userCc = "";
			String userUrl = "";
			boolean sw = true;
			int numPrueba = 0;
			int option2 = 0;
			int playListType = 0;
			int userAnswer = 0;
				switch(option){
					case 1: //Add artist/creator
						System.out.print("selct an option:  \n" +
									 "1. Artist \n" +
									 "2. Creator\n");
						while (!input.hasNextInt()){
							input.next();
							System.out.println("Enter a valid integer number ");
						}
						option2 = input.nextInt();
						switch(option2){
							case 1: //Add artist
								System.out.print("Type the nickname of the artist: ");
								userNickname = input.next();
								System.out.print("Type the id number: ");
								userCc = input.next();
								System.out.print("Copy the url with the image of the artist: ");
								userUrl = input.next();
								msj = controller.addArtist(userNickname, userCc, userUrl);
								System.out.println(msj);
								break;
							case 2: //Add creator
								System.out.print("Type the nickname of the Creator: ");
								userNickname = input.next();
								System.out.print("Type the id number: ");
								userCc = input.next();
								System.out.print("Copy the url with the image of the Creator: ");
								userUrl = input.next();
								msj = controller.addCreator(userNickname, userCc, userUrl);
								System.out.println(msj);
								break;
							default:
								System.out.println("Invalid option");
						}
						break; 

					case 2: //Add standar/premium
						System.out.print("selct an option:  \n" +
									 "1. Standar \n" +
									 "2. premium\n");
						while (!input.hasNextInt()){
							input.next();
							System.out.println("Enter a valid integer number ");
						}
						option2 = input.nextInt();
						switch(option2){
							case 1: //Add standar
								System.out.print("Type the nickname of the user standar: ");
								userNickname = input.next();
								System.out.print("Type the id number of the user standar: ");
								userCc = input.next();
								msj = controller.addUserStandar(userNickname, userCc);
								System.out.println(msj);
								break;
							case 2: //Add premium
								System.out.print("Type the nickname of the user premiun: ");
								userNickname = input.next();
								System.out.print("Type the id number of the user premiun: ");
								userCc = input.next();
								msj = controller.addUserPremiun(userNickname, userCc);
								System.out.println(msj);
								break;
							default:
								System.out.println("Invalid option");
						}
						break;

					case 3: //Add a song/podcast
						System.out.print("selct an option:  \n" +
									 "1. Song \n" +
									 "2. Podcast\n");
						while (!input.hasNextInt()){
							input.next();
							System.out.println("Enter a valid integer number ");
						}
						option2 = input.nextInt();
						switch(option2){
							case 1: //Add song
								System.out.print("Type the id number of the artist: ");
								userCc = input.next();
								if(controller.validateArtistExists(userCc) != -1){
									System.out.print("Type the name of the song: ");
									String songName = input.next();
									System.out.print("Type the url of the song: ");
									String songUrl = input.next();
									System.out.print("Type the duration in seconds: ");
									while (!input.hasNextInt()){
										input.next();
										System.out.println("Enter a valid integer number ");
									}
									int songDuration = input.nextInt();
									System.out.print("Type the name of the album: ");
									String songAlbum = input.next();
									System.out.print("Type the cost of the song: ");
									while (!input.hasNextDouble()){
										input.next();
										System.out.println("Enter a valid double number ");
									}
									double songCost = input.nextDouble();
									while(sw){
										System.out.print("Type the genre of the song: \n"+
														 "0. ROCK \n"+
														 "1. POP \n"+
														 "2. TRAP \n"+
														 "3. HOUSE \n");
										while (!input.hasNextInt()){
											input.next();
											System.out.println("Enter a valid integer number ");
										}
										numPrueba = input.nextInt();
										if(controller.validateCorrectOption(numPrueba)){
											sw = false;
											int optionTypeSong = numPrueba;
											msj = controller.addSong(userCc, songName, songUrl, songDuration, songAlbum, songCost, optionTypeSong);
											System.out.println(msj);
										}else {
											System.out.println("Type a valid number: ");
										}
									}
								}else{
									System.out.println("The artis wasn't found");
								}
								break;
							case 2: //Add podcast
								System.out.print("Type the id number of the creator: ");
								userCc = input.next();
								if(controller.validateCreatorExists(userCc) != -1){
									System.out.print("Type the name of the podcast: ");
									String podcastName = input.next();
									System.out.print("Type the url of the podcast: ");
									String podcastUrl = input.next();
									System.out.print("Type the duration: ");
									while (!input.hasNextInt()){
										input.next();
										System.out.println("Enter a valid integer number ");
									}
									int podcastDuration = input.nextInt();
									System.out.print("Type the description of the Podcast: ");
									String podcastDescription = input.next();
									while(sw){
										System.out.print("Type the genre of the song: \n"+
														 "0. POLITICS \n"+
														 "1. ENTERTAINMENT \n"+
														 "2. VIDEOGAMES \n"+
														 "3. FASHION \n");
										while (!input.hasNextInt()){
											input.next();
											System.out.println("Enter a valid integer number ");
										}
										numPrueba = input.nextInt();
										if(controller.validateCorrectOption(numPrueba)){
											sw = false;
											int optionTypePodcast = numPrueba;
											msj = controller.addPodcast(userCc, podcastName, podcastUrl, podcastDuration, podcastDescription, optionTypePodcast);
											System.out.println(msj);
										}else {
											System.out.println("Type a valid number: ");
										}
									}
								}else{
									System.out.println("The creator wasn't found");
								}
								break;
							default:
								System.out.println("Invalid option");
						}

						break;

					case 4:// Create a playlist
						System.out.print("Type the name of the playlist: ");
						String playListName = input.next();
						while (sw){
							System.out.print("Type the type of the playlist: \n" +
								 			 "1. Solo songs \n"+
								 			 "2. Solo podcasts \n"+
								 			 "3. Mix \n");
							while (!input.hasNextInt()){
								input.next();
								System.out.println("Enter a valid integer number ");
							}
							numPrueba = input.nextInt();
							if(controller.validateCorrectOption2(numPrueba)){
								sw = false;
								playListType = numPrueba;
							}else{
								System.out.print("Type a correct option");
							}
						}
						sw = true;
						while(sw){
							System.out.print("What kind of user is going to have the playlist: \n" +
											 "1. Standar User \n"+
											 "2. Premiun User\n");
							while (!input.hasNextInt()){
								input.next();
								System.out.println("Enter a valid integer number ");
							}
							numPrueba = input.nextInt();
							if(numPrueba == 1){
								sw = false;
								System.out.print("Type the id of the standar user: ");
								userCc = input.next();
								msj = controller.addPlaylistToStandar(userCc, playListName, playListType);
								System.out.println(msj);
							}else if(numPrueba == 2){
								sw = false;
								System.out.print("Type the id of the premium user: ");
								userCc = input.next();
								msj = controller.addPlaylistToPremium(userCc, playListName, playListType);
								System.out.println(msj);
							}else {
								System.out.print("Invalid option ");
							}
						}

						break;

					case 5: //Edit playlist
						System.out.println("Select an option: \n" +
										   "1. add Song/podcast \n" +
										   "2. eliminate song/podcast \n");
						while (!input.hasNextInt()){
							input.next();
							System.out.println("Enter a valid integer number ");
						}
						numPrueba = input.nextInt();
						if(numPrueba == 1){ //add Song/podcast
							while(sw){
								System.out.print("Type the type of user that is going to add a song or a podcast: \n" +
												 "1. Standar \n" +
												 "2. Premium \n");
								while (!input.hasNextInt()){
									input.next();
									System.out.println("Enter a valid integer number ");
								}
								userAnswer = input.nextInt();
								if(userAnswer == 1){ //standar
									sw = false;
									System.out.print("Type the id of the user: ");
									userCc = input.next();
									System.out.print("Type the name of the playlist: ");
									playListName = input.next();
									int playlistExist = controller.validateIfPlaylistInStandarExists(userCc, playListName);
									if (playlistExist != -1){ //It means that the playlist exist.
										System.out.println("Type the name of the podcast or song that you want to add: ");
										msj = controller.listOfSongsAndPodcasts();
										System.out.println(msj);
										String audioName = input.next();
										msj = controller.addAudioToSpecificUserStandar(userCc, playListName, audioName);
										System.out.println(msj);
									}else{
										System.out.println("The satndar user or the playlist in this standar user does not exist.");
									}

								}else if(userAnswer == 2){ //Premium
									sw = false;
									System.out.print("Type the id of the user: ");
									userCc = input.next();
									System.out.print("Type the name of the playlist: ");
									playListName = input.next();
									int playlistExist = controller.validateIfPlaylistInPremuimExists(userCc, playListName);
									if (playlistExist != -1){ //It means that the playlist exist.
										System.out.println("Type the name of the podcast or song that you want to add: ");
										msj = controller.listOfSongsAndPodcasts();
										System.out.println(msj);
										String audioName = input.next();
										msj = controller.addAudioToSpecificUserPremium(userCc, playListName, audioName);
										System.out.println(msj);
									}else{
										System.out.println("The premium user or the playlist in this Premium user does not exist.");
									}

								}else{
									System.out.println("Invalid option");
								}
							}

						}else if(numPrueba == 2){ //Eliminate song/podcast
							while(sw){
								System.out.print("Type the type of user who is going to delete a song or a podcast: \n" +
												 "1. Standar \n" +
												 "2. Premium \n");
								while (!input.hasNextInt()){
									input.next();
									System.out.println("Enter a valid integer number ");
								}
								userAnswer = input.nextInt();
								if(userAnswer == 1){
									sw = false;
									System.out.print("Type the id of the user: ");
									userCc = input.next();
									System.out.print("Type the name of the playlist: ");
									playListName = input.next();
									int playlistExist = controller.validateIfPlaylistInStandarExists(userCc, playListName);
									if(playlistExist != -1){
										msj = controller.listAudiosOfASpecificPlaylistStandar(userCc, playListName);
										System.out.println(msj);
										String audioName = input.next();
										msj = controller.deleteAudioFromSpecificUserStandar(userCc, playListName, audioName);
										System.out.println(msj);
									}else{
										System.out.println("The User or the Playlist wasn't found.");
									}
								}else if (userAnswer == 2){
									sw = false;
									System.out.print("Type the id of the user: ");
									userCc = input.next();
									System.out.print("Type the name of the playlist: ");
									playListName = input.next();
									int playlistExist = controller.validateIfPlaylistInPremuimExists(userCc, playListName);
									if(playlistExist != -1){
										msj = controller.listAudiosOfASpecificPlaylistPremium(userCc, playListName);
										System.out.println(msj);
										String audioName = input.next();
										msj = controller.deleteAudioFromSpecificUserPremium(userCc, playListName, audioName);
										System.out.println(msj);
									}else{
										System.out.println("The User or the Playlist wasn't found.");
									}
								}else{
									System.out.println("Invalid option");
								}
							}

						}else{
							System.out.println("Invalid option");
						}
						break;

					case 6:
						while(sw){
							System.out.print("Type the user who's gonna share the playlist: \n" +
											 "1. Standar \n" +
											 "2. Premium \n");
							while (!input.hasNextInt()){
								input.next();
								System.out.println("Enter a valid integer number ");
							}
							userAnswer = input.nextInt();
							if(userAnswer == 1){
								sw = false;
								System.out.print("Type the id of the user: ");
								userCc = input.next();
								System.out.print("Type the name of the playlist: ");
								playListName = input.next();
								int playlistExist = controller.validateIfPlaylistInStandarExists(userCc, playListName);
								if(playlistExist != -1){
									msj = controller.showMatrizByStandar(userCc,playListName);
									System.out.println(msj);
								}else{
									System.out.print("The User or the Playlist wasn't found");
								}
							}else if(userAnswer == 2){
								sw = false;
								System.out.print("Type the id of the user: ");
								userCc = input.next();
								System.out.print("Type the name of the playlist: ");
								playListName = input.next();
								int playlistExist = controller.validateIfPlaylistInPremuimExists(userCc, playListName);
								if(playlistExist != -1){
									msj = controller.showMatrizByPremium(userCc,playListName);
									System.out.println(msj);
								}else{
									System.out.print("The User or the Playlist wasn't found");
								}
							}else{
								System.out.println("Invalid option");
							}
						}
						break;

					case 7:
						while(sw){
							System.out.print("Type the user who's gonna play the audio: \n" +
											 "1. Standar \n" +
											 "2. Premium \n");
							while (!input.hasNextInt()){
								input.next();
								System.out.println("Enter a valid integer number ");
							}
							userAnswer = input.nextInt();
							if(userAnswer == 1){
								sw = false;
								System.out.print("Type the id of the Standar user: ");
								userCc = input.next();
								int standarExists = controller.validateStandarExists(userCc);
								if(standarExists != -1){
									System.out.print("type the name of the audio you want to play: ");
									msj = controller.listAudiosFromSystem();
									System.out.println(msj);
									String audioName = input.next();
									msj = controller.playAudioForStandar(audioName);
									System.out.println(msj);
								}else{
									System.out.println("The user wasn't found");
								}
								
							}else if(userAnswer == 2){
								sw = false;
								System.out.print("Type the id of the Premium user: ");
								userCc = input.next();
								int premiumExists = controller.validatePremiumExists(userCc);
								if(premiumExists != -1){
									System.out.print("type the name of the audio you want to play: ");
									msj = controller.listAudiosFromSystem();
									System.out.println(msj);
									String audioName = input.next();
									msj = controller.playAudioForPremium(audioName);
									System.out.println(msj);
								}else{
									System.out.println("The User wasn't found");
								}
							}else{
								System.out.println("Invalid option");
							}
						}


						break;

					case 8:
						System.out.println("ATENTION! \n" +
										   "this section is just for supporting an artist. \n" +
										   "However you can listen music and podcasts without buying anything. \n" +
										   "Do you want to continue? \n" +
										   "1. Yes, of course. \n" +
										   "2. No, I'm fine.");
						while (!input.hasNextInt()){
							input.next();
							System.out.println("Enter a valid integer number ");
						}
						userAnswer = input.nextInt();
						if(userAnswer == 1){
							System.out.println("Thank you. Type the name of the song you want to buy:");
							msj = controller.listSongsFromSystem();
							System.out.println(msj);
							String songName = input.next();
							msj = controller.buySong(songName);
							System.out.println(msj);
						}else if(userAnswer == 2){
							System.out.println("Stingy");
							break;

						}else{
							System.out.println("Invalid option");
						}

						break;

					case 9:

						break;

					case 0: 
						System.out.println("Exit program.");
						break; 

					default: 
						System.out.println("Invalid Option");
						break; 
				}
		}

	public int validateIntegerOption(){
		int option = 0; 
		if(input.hasNextInt()){
			option = input.nextInt(); 
		}
		else{
			// clear input. 
			input.nextLine(); 
			option = -1; 
		}
		return option; 
	}

}