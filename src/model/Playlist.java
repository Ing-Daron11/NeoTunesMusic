package model;

import java.util.ArrayList;
import java.util.Random;

public class Playlist{

	private ArrayList<Audio> audios; //This audios are the ones that a playlist contents
	private String name;
	private String code;
    private int typeOption;

	public static final int ROWS = 6; 
    public static final int COLUMNS = 6; 

    private int[][] matrix;
    private int[][] matrixFilled;

    /**
    * Constructor
    */
    public Playlist(String name, int type){
    	this.name = name;
        matrix = new int[ROWS][COLUMNS];
        filltMatrix();
    	audios = new ArrayList<Audio>(10);
        this.typeOption = type;
        this.code = generateCode();

    }

    /**
     * This method fill all the matrix
     */
    public void filltMatrix(){
        Random aleatorio = new Random();
        for(int i = 0; i <= ROWS-1; i++){
            for(int j = 0; j <= COLUMNS-1; j++){
                this.matrix[i][j] = (aleatorio.nextInt(10-0)+0);
            }
        }
        this.matrixFilled = matrix;
    }

    /**
     * This method generates the code automatically based on the matrix and the type of playlist
     * @param  type It's the type of playlist selected
     * @return      it's the code already done
     */
    public String generateCode(){
        String autoCode = "";
    	if(getTypeOption() == 1){ //N
    		for(int i = ROWS-1; i>= 0; i--){
                autoCode += "" + matrixFilled[i][COLUMNS-6];
            }
            for (int i = 1; i <ROWS; i++){
                for(int j = 1; j <COLUMNS; j++){
                    if(i==j){
                        autoCode += "" + matrixFilled[i][j];
                    }
                }
            }
            for(int i = ROWS-2; i >=0; i--){
                autoCode += "" + matrixFilled[i][COLUMNS-1];
            }

    	}else if(getTypeOption()  == 2){ //T
    		for(int j = 0; j<=2; j++){
                autoCode += "" + matrixFilled[0][j]; 
            }
            for (int i = 1; i < ROWS; i++){
                autoCode += "" + matrixFilled[i][2]; 
            }
            for(int i = ROWS-1; i >=0; i--){
                autoCode += "" + matrixFilled[i][3];
            }
            for(int j = 4; j < COLUMNS; j++){
                autoCode += "" + matrixFilled[0][j];
            }
    	}else if(getTypeOption()  == 3){ //odd
    		for (int i = ROWS-1; i >=0 ; i--){
                for(int j = COLUMNS-1; j >= 0; j--){
                    if( ((i+j)%2)!=0 && ((i+j)>1)){
                        autoCode += "" + matrixFilled[i][j];
                    }
                }
            }
    	}
        return autoCode;
    }

    public int addSongToPlaylist(Audio objectAudio){
        int posSong = -1;
        if(objectAudio instanceof Song){
            audios.add(objectAudio);
            posSong = 1; //It means that it was added
        }
        return posSong;
    }

    public int addPodcastToPlaylist(Audio objectAudio){ 
        int posPodcast = -1;
        if(objectAudio instanceof Podcast){
            audios.add(objectAudio);
            posPodcast = 1; //It means that it was added
        }
        return posPodcast;
    }

    public String listAudios(){
        String msj = "";
        String msj1 = "";
        String msj2 = "";
        for(int i = 0; i < audios.size(); i++){
            if(audios.get(i) instanceof Song){
                msj1 += (((Song)(audios.get(i))).getName()) + " \n";
            }else if( audios.get(i) instanceof Podcast){
                msj2 += (((Podcast)(audios.get(i))).getName()) + " \n";
            }
        }
        return msj = "************SONGS:************* \n" +
               msj1 + "\n" +
               "************PODCASTS:************* \n" +
               msj2 + "\n";
    }

    public String deleteAudio(String audioName){
        String msj = "The audio wasn't found";
        boolean isFound = false;
        for(int i = 0; i < audios.size() && !isFound; i++){
            if(audios.get(i) instanceof Song ){
                if((((Song)(audios.get(i))).getName()).equalsIgnoreCase(audioName)){
                    isFound = true;
                    audios.remove(i);
                    msj = "The Song '" + audioName + "' was succesfully eliminated";
                }
            }else if(audios.get(i) instanceof Podcast){
                if((((Podcast)(audios.get(i))).getName()).equalsIgnoreCase(audioName)){
                    isFound = true;
                    audios.remove(i);
                    msj = "The Podcast '" + audioName + "' was succesfully eliminated";
                }
            }
        }
        return msj;
    }

    public String showMatriz(){
        String msj = "";
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++){
                msj += "|" + this.matrixFilled[i][j];
                if(j==5){ //If it gets to the final column...
                    msj += "|\n";                    
                }
            }
        }
        return msj; 
    }

//------------------------------- Getters and Setters ----------------------

    public String getCode(){
        return this.code;
    }

    public int getTypeOption(){
        return this.typeOption;
    }

    public String getName(){
        return this.name;
    }
}