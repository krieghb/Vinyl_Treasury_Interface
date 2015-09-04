package com.krieghb.vinyl_treasure.main;

import com.krieghb.vinyl_treasure.database.Database_MySQL;
import com.krieghb.vinyl_treasure.scripts.Script_Constants;

/**
 * Created by krido02 on 8/31/2015.
 *
 *
 *  Main driver for Vinyl Treasury Interface
 */
public class Vinyl_Main {

    public static void main( String[] args ) {

        System.out.println( "Hello World!\n\n" );



        String mainSchema = "v_t_i";
        String mainTable = "v_sng";

        String databaseUrl = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "admin123";
//        String column_list[] = new String[] {"v_sng_c_head", "v_sng_c_dur", "v_sng_c_comp-l", "v_sng_c_comp-f"};
//        String input_list[] = new String[] {"Test Header", "13:26", "Fours", "Hubert"};




        Database_MySQL newConn =  new Database_MySQL();
        newConn.connectToDb(databaseUrl, username, password);

        if (newConn.schemaExists(databaseUrl, mainSchema, username, password)) {
            System.out.println("Yea, the schema '" + mainSchema + "' exists!");
        }
        else {
            System.out.println("Aww, the schema '" + mainSchema + "' does not exist, creating . . .");
            newConn.createDatabase(Script_Constants.CREATE_DATABASE_VTI);

            if (newConn.schemaExists(databaseUrl, mainSchema, username, password)) {
                System.out.println("Yea, the schema '" + mainSchema + "' now exists!");
            }
            else {
                System.out.println("Aww, the schema '" + mainSchema + "' failed to be created.");
            }

        }


        newConn.disconnectFromDb();



        System.out.println("\nGood bye!\n");

    }

}
