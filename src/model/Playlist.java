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

    /**
    * Constructor
    */
    public Playlist(String name, int type){
    	this.name = name;
        matrix = new int[ROWS][COLUMNS];
    	audios = new ArrayList<Audio>(10);
        this.typeOption = type;
        this.code = generateCode();

    }

    /**
     * This method fill all the matrix
     */
    public int[][] filltMatrix(){
        Random aleatorio = new Random();
        for(int i = 0; i <= ROWS-1; i++){
            for(int j = 0; j <= COLUMNS-1; j++){
                this.matrix[i][j] = (aleatorio.nextInt(10-0)+0);
            }
        }
        return matrix;
    }

    /**
     * This method generates the code automatically based on the matrix and the type of playlist
     * @param  type It's the type of playlist selected
     * @return      it's the code already done
     */
    public String generateCode(){ //No genera bien el código
        String autoCode = "";
        int[][] matrixFilled = filltMatrix();
    	if(getTypeOption() == 1){ //N
    		for(int i = ROWS-1; i<= 0; i--){
               autoCode += "" + matrixFilled[i][0];
            }
            for (int i = 0; i <ROWS -1; i++){
                for(int j = 0; j <COLUMNS -1; j++){
                    if(i==j){
                        autoCode += "" + matrixFilled[i][j];
                    }
                }
            }
            for(int i = ROWS-1; i <=0; i--){
                autoCode += "" + matrixFilled[i][5];
            }

    	}else if(getTypeOption()  == 2){ //T
    		for(int j = 0; j<=2; j++){
                autoCode += "" + matrixFilled[0][j]; 
            }
            for (int i = 0; i < ROWS; i++){
                autoCode += "" + matrixFilled[i][2]; 
            }
            for(int i = ROWS-1; i <=0; i--){
                autoCode += "" + matrixFilled[i][3];
            }
            for(int j = 0; j < COLUMNS; j++){
                autoCode += "" + matrixFilled[0][j];
            }
    	}else if(getTypeOption()  == 3){ 
    		for (int i = 0; i <ROWS -1; i--){
                for(int j = 0; j <COLUMNS -1; j--){
                    if( ((i+j)%2)!=0 && ((i+j)>1) ){
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