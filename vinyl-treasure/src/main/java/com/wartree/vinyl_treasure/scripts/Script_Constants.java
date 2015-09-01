package com.wartree.vinyl_treasure.scripts;

/**
 * Created by krido02 on 9/1/2015.
 */
public final class Script_Constants {


    public final static String CREATE_DATABASE_VTI = "CREATE DATABASE `v_t_i` /*!40100 DEFAULT CHARACTER SET utf8 */;\n" +

            "CREATE TABLE `v_t_i`.`t_vin-albums` (\n" +
            "  `t-vin-albums_id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `t-vin-albums_name` varchar(45) NOT NULL,\n" +
            "  `t-vin-albums_year` varchar(4) NOT NULL DEFAULT '????',\n" +
            "  `t-vin-albums_num-songs` int(11) NOT NULL,\n" +
            "  `t-vin-albums_songs` varchar(45) DEFAULT NULL COMMENT 'placeholder for song list (table)\\n',\n" +
            "  `t-vin-albums_group` varchar(45) DEFAULT NULL COMMENT 'placeholder for group list (table)',\n" +
            "  PRIMARY KEY (`t-vin-albums_id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n" +

            "CREATE TABLE `v_t_i`.`t_vin-algroup-ref` (\n" +
            "  `t-vin-albgrp-ref_albumid` int(11) NOT NULL,\n" +
            "  `t-vin-albgrp-ref_groupid` int(11) NOT NULL,\n" +
            "  PRIMARY KEY (`t-vin-albgrp-ref_albumid`,`t-vin-albgrp-ref_groupid`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n" +

            "CREATE TABLE `v_t_i`.`t_vin-albsng-ref` (\n" +
            "  `t-vin-albsng-ref_albumid` int(11) NOT NULL,\n" +
            "  `t-vin-albsng-ref_sngid` int(11) NOT NULL,\n" +
            "  `t-vin-albsng-ref_sngnum` int(11) NOT NULL,\n" +
            "  PRIMARY KEY (`t-vin-albsng-ref_albumid`,`t-vin-albsng-ref_sngid`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n" +

            "CREATE TABLE `v_t_i`.`t_vin-comp` (\n" +
            "  `t-vin-comp_id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `t-vin-comp_name (last)` varchar(45) NOT NULL,\n" +
            "  `t-vin-comp_name (first)` varchar(45) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`t-vin-comp_id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n" +

            "CREATE TABLE `v_t_i`.`t_vin-group` (\n" +
            "  `t-vin-group_id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `t-vin-group_name(last)` varchar(100) NOT NULL DEFAULT 'Various',\n" +
            "  `t-vin-group_name(first)` varchar(45) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`t-vin-group_id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n" +

            "CREATE TABLE `v_t_i`.`t_vin-set` (\n" +
            "  `t-vin-set_id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `t-vin-set_name` varchar(45) NOT NULL,\n" +
            "  `t-vin-set_num-albums` int(11) NOT NULL,\n" +
            "  PRIMARY KEY (`t-vin-set_id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n" +

            "CREATE TABLE `v_t_i`.`t_vin-setal-ref` (\n" +
            "  `t-vin-setal-ref_setid` int(11) NOT NULL,\n" +
            "  `t-vin-setal-ref_albumid` int(11) NOT NULL,\n" +
            "  `t-vin-setal-ref_albumnum` int(11) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`t-vin-setal-ref_setid`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n" +

            "CREATE TABLE `v_t_i`.`t_vin-sngcomp-ref` (\n" +
            "  `t-vin-sngcomp-ref_sngid` int(11) NOT NULL,\n" +
            "  `t-vin-sng-comp-ref_compid` int(11) NOT NULL,\n" +
            "  PRIMARY KEY (`t-vin-sngcomp-ref_sngid`,`t-vin-sng-comp-ref_compid`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n" +

            "CREATE TABLE `v_t_i`.`t_vin-song` (\n" +
            "  `t-vin-song_id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `t-vin-song_title` varchar(100) NOT NULL,\n" +
            "  `t-vin-song_duration` varchar(5) DEFAULT '00:00',\n" +
            "  `t-vin-song_genre` varchar(45) NOT NULL DEFAULT 'Misc',\n" +
            "  `t-vin-song_comp` varchar(45) DEFAULT NULL COMMENT 'placehoder for composer list (table)',\n" +
            "  PRIMARY KEY (`t-vin-song_id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;"

            ;



}
