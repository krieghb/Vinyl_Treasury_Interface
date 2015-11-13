package com.krieghb.vinyl_treasure.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;


/**
 * 
 * @author Krieghb
 *
 */

public class Database_MySQL {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private static String classDriver = "com.mysql.jdbc.Driver";

    private boolean isConnected = false;

    public Database_MySQL() {

        this(classDriver);

    }

    public Database_MySQL(String cDriver) {
        classDriver = cDriver;
        try {
            Class.forName(classDriver);
            System.out.println("Driver loaded!");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Yikes, the driver '" + classDriver + "' does not exist in the classpath.");
        }
    }

    
    /**
     * 
     * @param databaseUrl	URL to the database server
     * @param schemaName	Schema name to check existence of
     * @param username		Username for logging in
     * @param password		Password for longging in
     * @return				Whether the database exists or not
     * 
     */
    public boolean schemaExists(String databaseUrl, String schemaName, String username, String password) {

        boolean schemaExists;

        try {
            //  Attempting to connect to table
            connect = DriverManager.getConnection(databaseUrl + schemaName, username, password);

            schemaExists = true;

            // This is not to open the db, just to check that it exists so closing.
            connect.close();
        }

        catch (SQLException e) {
            schemaExists = false;
        }


        return schemaExists;
    }


    /**
     * 
     * @param url
     * @param username
     * @param password
     * @return
     */
    public boolean connectToDb (String url, String username, String password) {

        System.out.println("Connecting database...");

        try {
            connect = DriverManager.getConnection(url, username, password);

            isConnected = true;
            System.out.println("Database connected!");

        }
        catch (SQLException e) {
            isConnected = false;
            throw new IllegalStateException("Cannot connect the database!", e);
        }


        return isConnected;
    }




    public void readFromDb(String mainSchemaTable) {

        // Statements allow to issue SQL queries to the database
        try {
            statement = connect.createStatement();

            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from " + mainSchemaTable);

            writeResultSet(resultSet);
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    
    public void readFromDb(String mainSchemaTable, String[] columnNames) {
    	//  String to build the execute statement.
    	StringBuilder columnList = new StringBuilder();
    	
    	//  Should be at least one value in list to add to the SELECT statement
    	columnList.append("SELECT ").append(columnNames[0]);
    	
    	//  Going through each column name to add to the select statement.
    	for (int i = 1; i < columnNames.length; i++) {
    		columnList.append(", columnNames[i]");
    		
    	}
    	
    	columnList.append(" FROM ").append(mainSchemaTable);
    	
    	
    	try {
    		statement = connect.createStatement();
    		
    		resultSet = statement.executeQuery(columnList.toString());
    		
    		writeResultSet(resultSet);    		
    		
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    

    /**
     * Method to insert into a database using two lists (column name and data).
     * 
     * @param mainSchemaTable
     * @param columnList
     * @param inputList
     */
    public void insertToDb(String mainSchemaTable, String[] columnList, String[] inputList) {

        int columnSize = columnList.length;
        int counter = 1;
        StringBuilder defaultQs = new StringBuilder("?");

        // PreparedStatements can use variables and are more efficient
        //  This adds the correct number of "?"s for the prepared insert statement
        for (int i = 0; i < columnSize - 1; i++)
        {
            defaultQs.append(", ?");
        }

        System.out.print("");

        try{
            preparedStatement = connect.prepareStatement("insert into " + mainSchemaTable + " values (default, " + defaultQs + ")");

            for (int i = 0; i < columnSize; i++,counter++)
            {
                System.out.println(counter + "  " + columnList[i]);
                preparedStatement.setString(counter, inputList[i]);
            }
            preparedStatement.executeUpdate();

        }
        catch (SQLException e) {
            throw new IllegalStateException("Failed to insert into the database!", e);
        }
    }



    public boolean createDatabase(String databaseScript) {
        boolean didExecute = false;

        if (! isConnected) {
            System.err.println("Cannot create database, not connected to a database server.");

            return didExecute;
        }

        try {

            statement = connect.createStatement();

            didExecute = true;


            //  Since the sql string is a collection of executions (creating database and tables),
            //  Need to execute it as a batch by splitting based on the colon and adding each execution
            //  individually.
            StringTokenizer sqlTokenList = new StringTokenizer(databaseScript, ";");
            String sqlStatement;

            while (sqlTokenList.hasMoreTokens()) {
                sqlStatement = sqlTokenList.nextToken();
                try {
                    statement.addBatch(sqlStatement);
                }
                catch (SQLException e) {
                    System.out.println("Bad batch addition");
                    e.printStackTrace();
                }
            }
            try {
                statement.executeBatch();
            }
            catch (SQLException e) {

                didExecute = false;
                System.out.println ("Bad execution of batch.");
                e.printStackTrace();

            }

        }
        catch (SQLException e) {
            didExecute = false;

            System.out.println("Failed to create connection staetment (createStatment).");
            e.printStackTrace();

        }


        return didExecute;
    }





    /*
     *
     */
    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String head = resultSet.getString("v_sng_c_head");
            String dur = resultSet.getString("v_sng_c_dur");
            String last = resultSet.getString("v_sng_c_comp-l");
            String first = resultSet.getString("v_sng_c_comp-f");



            System.out.printf("%-35s", "Head:  " + head);
            System.out.printf("      %-17s", "Dur:  " + dur);
            System.out.printf("      %-30s", "Last:  " + last);
            System.out.printf("      %-30s\n", "First:  " + first);



        }
    }




    public boolean disconnectFromDb() {

        try{
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }

            System.out.println("Database disconnected!");
            isConnected = true;
        }
        catch (SQLException e) {

            isConnected = false;
            throw new IllegalStateException("Failed to disconnect from the database!", e);

        }


        return isConnected;
    }

}
