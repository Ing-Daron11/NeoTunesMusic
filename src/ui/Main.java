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
				"5. \n" +
				"6. \n" +
				"7. \n" +
				"8. \n" +
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

					case 4:

						break;

					case 5:

						break;

					case 6:

						break;

					case 7:

						break;

					case 8:

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