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
				"1. Add artist \n" +
				"2. Add Creator \n" + 
				"3. Add user standar \n" +
				"4. Add user premiun \n" +
				"5. Add a song \n" +
				"6. Add a podcast \n" +
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
				switch(option){
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

					case 3: //Add user standar
						System.out.print("Type the nickname of the user standar: ");
						userNickname = input.next();
						System.out.print("Type the id number of the user standar: ");
						userCc = input.next();
						msj = controller.addUserStandar(userNickname, userCc);
						System.out.println(msj);

						break;

					case 4: //Add user premiun
						System.out.print("Type the nickname of the user premiun: ");
						userNickname = input.next();
						System.out.print("Type the id number of the user premiun: ");
						userCc = input.next();
						msj = controller.addUserPremiun(userNickname, userCc);
						System.out.println(msj);

						break;

					case 5: //Add a song
						System.out.print("Type the id number of the artist: ");
						userCc = input.next();
						if(controller.validateArtistExists(userCc) != -1){
							System.out.print("Type the name of the song: ");
							String songName = input.next();
							System.out.print("Type the url of the song: ");
							String songUrl = input.next();
							System.out.print("Type the duration: ");
							String songDuration = input.next();
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