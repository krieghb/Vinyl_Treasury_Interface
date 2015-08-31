package com.wartree.vinyl_treasure.main;

import com.wartree.vinyl_treasure.database.Database_MySQL;

/**
 * Created by krido02 on 8/31/2015.
 *
 *
 *  Main driver for Vinyl Treasury Interface
 */
public class Vinyl_Main {

    public static void main( String[] args ) {

        System.out.println( "Hello World!\n\n" );



        String mainSchema = "v_t_i1";
        String mainTable = "v_sng";

        String databaseUrl = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "admin123";
        String column_list[] = new String[] {"v_sng_c_head", "v_sng_c_dur", "v_sng_c_comp-l", "v_sng_c_comp-f"};
        String input_list[] = new String[] {"Test Header", "13:26", "Fours", "Hubert"};




        Database_MySQL newConn =  new Database_MySQL();

        if (newConn.schemaExists(databaseUrl, mainSchema, username, password)) {
            System.out.println("Yea, the schema '" + mainSchema + "' exists!");
        }
        else {
            System.out.println("Aww, the schema '" + mainSchema + "' does not exist");
        }

//        newConn.connectToDb(url, username, password);

        newConn.disconnectFromDb();



        System.out.println( "\nGood bye!\n");

    }

}
