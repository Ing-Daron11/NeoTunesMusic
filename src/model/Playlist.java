package model;

import java.util.ArrayList;
import java.lang.Math;

public class Playlist{

	private ArrayList<Audio> audios;
	private String name;
	private int code;

	public static final int ROWS = 6; 
    public static final int COLUMNS = 6; 

    private int[][] matrix;

    /**
    * Constructor
    */
    public Playlist(String name, int type){
    	this.name = name;
    	this.code = generateCode(type);
    	audios = new ArrayList<Audio>(10);
    	matrix = new int[ROWS][COLUMNS];

    }

    /**
     * This method fill all the matrix
     */
    public void filltMatrix(){
        int upperBound = 9;
        int lowerBound = 0;
        int range = (upperBound - lowerBound) + 1;
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++){
                matrix[i][j] = (int)(Math.random() * range) + lowerBound; 
            }
        }
    }

    /**
     * This method generates the code automatically based on the matrix and the type of playlist
     * @param  type It's the type of playlist selected
     * @return      it's the code already done
     */
    public int generateCode(int type){
    	int code = 0;
    	if(type == 1){
    		//generar código para solo songs
    	}else if(type == 2){
    		//generar código para solo podcasts
    	}else if(type == 3){
    		//generar código para Mix
    	}
    	return code;
    }

    public int getCode(){
        return this.code;
    }

}