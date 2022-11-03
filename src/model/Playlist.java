package model;

import java.util.ArrayList;
import java.lang.Math;

public class Playlist{

	private ArrayList<Audio> audios;
	private String name;
	private int code;

	public static final int ROWS = 4; 
    public static final int COLUMNS = 4; 

    private int[][] matrix;

    /**
    * Constructor
    */
    public Playlist(String name){
    	this.name = name;
    	audios = new ArrayList<Audio>(10);
    	matrix = new int[ROWS][COLUMNS];

    }

    /**
     * @return: String: msj = It contains all the elements of the matrix
     */
    public String printIntMatrix(){
        String msj = ""; 
        int upperBound = 9;
        int lowerBound = 0;
        int range = (upperBound - lowerBound) + 1;

        for(int i = 0; i < ROWS; i++){
            msj += "\n"; 
            for(int j = 0; j < COLUMNS; j++){
                matrix[i][j] = (int)(Math.random() * range) + lowerBound;
                msj += matrix[i][j] + " ";  
            }
        }
        return msj; 
    }

}