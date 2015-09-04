package com.krieghb.vinyl_treasure.scripts;

/**
 * Created by krido02 on 9/1/2015.
 */
public final class Script_Constants {

	
	/**
	 * Constant to hold the entire schema for the vinyl treasury interface.
	 * <p>
	 * Constant to hold the entire schema for the vinyl treasury interface.  This includes
	 * the tables, table names and keys. 
	 */

	//  DB misc
	public final static String DEFAULT_CHAR_SET = "utf8";
	public final static String DEFAULT_CHARSET = "DEFAULT CHARSET=utf8";
	
	//  Schema
	public final static String V_T_I = "v_t_i";
	
	//  Tables for v_t_i schema
	public final static String T_VTI_SET = "t_vti_set";
	public final static String T_VTI_ALBUMS = "t_vti_albums";
	public final static String T_VTI_GROUP = "t_vti_group";
	public final static String T_VTI_SONG = "t_vti_song";
	public final static String T_VTI_COMPOSER = "t_vti_composer";

	public final static String T_VTI_SETALB_REF = "t_vti_setalb_ref";
	public final static String T_VTI_ALBGRP_REF = "t_vti_albgrp_ref";
	public final static String T_VTI_ALBSNG_REF = "t_vti_albsng_ref";
	public final static String T_VTI_SNGCOM_REF = "t_vti_sngcom_ref";
	
	//  Columns for T_VTI_SET
	public final static String SET_ID = "set_id";
	public final static String SET_NAME = "set_name";
	public final static String SET_NUMALBUMS = "set_numalbums";
	
	//  Columns for T_VTI_ALBUMS
	public final static String ALBUM_ID = "album_id";
	public final static String ALBUM_NAME = "album_name";
	public final static String ALBUM_YEAR = "album_year";
	public final static String ALBUM_NUMSONGS = "album_numsongs";
	public final static String ALBUM_SONGS = "album_songs";
	public final static String ALBUM_GROUP = "album_group";
	
	//  Columns for T_VTI_GROUP
	public final static String GROUP_ID = "group_id";
	public final static String GROUP_LNAME = "group_lastname";
	public final static String GROUP_FNAME = "group_firstname";
	
	//  Colums for T_VTI_SONG
	public final static String SONG_ID = "song_id";
	public final static String SONG_TITLE = "song_title";
	public final static String SONG_DURATION = "song_duration";
	public final static String SONG_GENRE = "song_genre";
	public final static String SONG_COMP = "song_comp";
	
	//  Columns for T_VTI_COMPOSER
	public final static String COMPOSER_ID = "composer_id";
	public final static String COMPOSER_LNAME = "composer_lastname";
	public final static String COMPOSER_FNAME = "composer_firstname";
	
	
	//  Columns for T_VTI_SETALB_REF
	public final static String SETALB_SET_ID = "setalb_set_id";
	public final static String SETALB_ALBUM_ID = "setalb_album_id";
	public final static String SETALB_ALBUM_NUM = "setalb_album_num";
	
	//  Columns for T_VTI_SNGCOM_REF
	public final static String SNGCOM_SONG_ID = "sngcom_song_id";
	public final static String SNGCOM_COMPOSER_ID = "sngcom_composer_id";
	
	//  Columns for T_VTI_ALBGRP_REF\
	public final static String ALBGRP_ALBUM_ID = "albgrp_album_id";
	public final static String ALBGRP_GROUP_ID = "albgrp_group_id";
	
	//  Columns for T_VTI_ALBSNG_REF
	public final static String ALBSNG_ALBUM_ID = "albsng_album_id";
	public final static String ALBSNG_SONG_ID = "albsng_song_id";
	public final static String ALBSNG_SONG_NUM = "albsng_song_num";
	
	
	
	// Scripts
	
    public final static String CREATE_DATABASE_VTI = "CREATE DATABASE `" + V_T_I + "` /*!40100 DEFAULT CHARACTER SET utf8 */;\n" +

            "CREATE TABLE `" + V_T_I + "`.`" + T_VTI_SET + "` (\n" +
            "  `" + SET_ID + "` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `" + SET_NAME + "` varchar(45) NOT NULL,\n" +
            "  `" + SET_NUMALBUMS + "` int(11) NOT NULL,\n" +
            "  PRIMARY KEY (`" + SET_ID + "`)\n" +
            ") ENGINE=InnoDB " + DEFAULT_CHARSET + ";\n" +

            "CREATE TABLE `" + V_T_I + "`.`" + T_VTI_ALBUMS + "` (\n" +
            "  `" + ALBUM_ID + "` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `" + ALBUM_NAME + "` varchar(45) NOT NULL,\n" +
            "  `" + ALBUM_YEAR + "` varchar(4) NOT NULL DEFAULT '????',\n" +
            "  `" + ALBUM_NUMSONGS + "` int(11) NOT NULL,\n" +
            "  `" + ALBUM_SONGS + "` varchar(45) DEFAULT NULL COMMENT 'placeholder for song list (table)\\n',\n" +
            "  `" + ALBUM_GROUP + "` varchar(45) DEFAULT NULL COMMENT 'placeholder for group list (table)',\n" +
            "  PRIMARY KEY (`" + ALBUM_ID + "`)\n" +
            ") ENGINE=InnoDB " + DEFAULT_CHARSET + ";\n" +

            "CREATE TABLE `" + V_T_I + "`.`" + T_VTI_GROUP + "` (\n" +
            "  `" + GROUP_ID + "` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `" + GROUP_LNAME + "` varchar(100) NOT NULL DEFAULT 'Various',\n" +
            "  `" + GROUP_FNAME + "` varchar(45) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`" + GROUP_ID + "`)\n" +
            ") ENGINE=InnoDB " + DEFAULT_CHARSET + ";\n" +

            "CREATE TABLE `" + V_T_I + "`.`" + T_VTI_SONG + "` (\n" +
            "  `" + SONG_ID + "` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `" + SONG_TITLE + "` varchar(100) NOT NULL,\n" +
            "  `" + SONG_DURATION + "` varchar(5) DEFAULT '00:00',\n" +
            "  `" + SONG_GENRE + "` varchar(45) NOT NULL DEFAULT 'Misc',\n" +
            "  `" + SONG_COMP + "` varchar(45) DEFAULT NULL COMMENT 'placehoder for composer list (table)',\n" +
            "  PRIMARY KEY (`" + SONG_ID + "`)\n" +
            ") ENGINE=InnoDB " + DEFAULT_CHARSET + ";\n" +

            "CREATE TABLE `" + V_T_I + "`.`" + T_VTI_COMPOSER + "` (\n" +
            "  `" + COMPOSER_ID + "` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `" + COMPOSER_LNAME + "` varchar(45) NOT NULL,\n" +
            "  `" + COMPOSER_FNAME + "` varchar(45) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`" + COMPOSER_ID + "`)\n" +
            ") ENGINE=InnoDB " + DEFAULT_CHARSET + ";\n" +

            "CREATE TABLE `" + V_T_I + "`.`" + T_VTI_SETALB_REF + "` (\n" +
            "  `" + SETALB_SET_ID + "` int(11) NOT NULL,\n" +
            "  `" + SETALB_ALBUM_ID + "` int(11) NOT NULL,\n" +
            "  `" + SETALB_ALBUM_NUM + "` int(11) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`" + SETALB_SET_ID + "`)\n" +
            ") ENGINE=InnoDB " + DEFAULT_CHARSET + ";\n" +

            "CREATE TABLE `" + V_T_I + "`.`" + T_VTI_SNGCOM_REF + "` (\n" +
            "  `" + SNGCOM_SONG_ID + "` int(11) NOT NULL,\n" +
            "  `" + SNGCOM_COMPOSER_ID + "` int(11) NOT NULL,\n" +
            "  PRIMARY KEY (`" + SNGCOM_SONG_ID + "`,`" + SNGCOM_COMPOSER_ID + "`)\n" +
            ") ENGINE=InnoDB " + DEFAULT_CHARSET + ";\n" +

            "CREATE TABLE `" + V_T_I + "`.`" + T_VTI_ALBGRP_REF + "` (\n" +
            "  `" + ALBGRP_ALBUM_ID + "` int(11) NOT NULL,\n" +
            "  `" + ALBGRP_GROUP_ID + "` int(11) NOT NULL,\n" +
            "  PRIMARY KEY (`" + ALBGRP_ALBUM_ID + "`,`" + ALBGRP_GROUP_ID + "`)\n" +
            ") ENGINE=InnoDB " + DEFAULT_CHARSET + ";\n" +

            "CREATE TABLE `" + V_T_I + "`.`" + T_VTI_ALBSNG_REF + "` (\n" +
            "  `" + ALBSNG_ALBUM_ID + "` int(11) NOT NULL,\n" +
            "  `" + ALBSNG_SONG_ID + "` int(11) NOT NULL,\n" +
            "  `" + ALBSNG_SONG_NUM + "` int(11) NOT NULL,\n" +
            "  PRIMARY KEY (`" + ALBSNG_ALBUM_ID + "`,`" + ALBSNG_SONG_ID + "`)\n" +
            ") ENGINE=InnoDB " + DEFAULT_CHARSET + ";"

            ;



}
