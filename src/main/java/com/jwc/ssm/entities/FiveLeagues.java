package com.jwc.ssm.entities;

import org.springframework.stereotype.Repository;

/**
 * Created by cwj on 18-5-17.
 *
 */

@Repository
public class FiveLeagues {
    private int id;
    private int rank;
    private String country;
    private String player_name;
    private String total_manufacturing_goals;
    private float ef1;
    private int total_games;
    private int goals;
    private float ef2;
    private int max_goals;
    private float ef3;
    private int assist;
    private float ef4;
    private int max_assist;
    private float ef5;
    private int max_total_manufacturing_goals;
    private float ef6;
    private float total_assits_goals;
    private String season;
    private String league_name;
    private String continent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getTotal_manufacturing_goals() {
        return total_manufacturing_goals;
    }

    public void setTotal_manufacturing_goals(String total_manufacturing_goals) {
        this.total_manufacturing_goals = total_manufacturing_goals;
    }

    public float getEf1() {
        return ef1;
    }

    public void setEf1(float ef1) {
        this.ef1 = ef1;
    }

    public int getTotal_games() {
        return total_games;
    }

    public void setTotal_games(int total_games) {
        this.total_games = total_games;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public float getEf2() {
        return ef2;
    }

    public void setEf2(float ef2) {
        this.ef2 = ef2;
    }

    public int getMax_goals() {
        return max_goals;
    }

    public void setMax_goals(int max_goals) {
        this.max_goals = max_goals;
    }

    public float getEf3() {
        return ef3;
    }

    public void setEf3(float ef3) {
        this.ef3 = ef3;
    }

    public int getAssist() {
        return assist;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }

    public float getEf4() {
        return ef4;
    }

    public void setEf4(float ef4) {
        this.ef4 = ef4;
    }

    public int getMax_assist() {
        return max_assist;
    }

    public void setMax_assist(int max_assist) {
        this.max_assist = max_assist;
    }

    public float getEf5() {
        return ef5;
    }

    public void setEf5(float ef5) {
        this.ef5 = ef5;
    }

    public int getMax_total_manufacturing_goals() {
        return max_total_manufacturing_goals;
    }

    public void setMax_total_manufacturing_goals(int max_total_manufacturing_goals) {
        this.max_total_manufacturing_goals = max_total_manufacturing_goals;
    }

    public float getEf6() {
        return ef6;
    }

    public void setEf6(float ef6) {
        this.ef6 = ef6;
    }

    public float getTotal_assits_goals() {
        return total_assits_goals;
    }

    public void setTotal_assits_goals(float total_assits_goals) {
        this.total_assits_goals = total_assits_goals;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public FiveLeagues(int rank, String country, String player_name, String total_manufacturing_goals, float ef1, int total_games, int goals, float ef2, int max_goals, float ef3, int assist, float ef4, int max_assist, float ef5, int max_total_manufacturing_goals, float ef6, float total_assits_goals, String season, String league_name, String continent) {
        this.rank = rank;
        this.country = country;
        this.player_name = player_name;
        this.total_manufacturing_goals = total_manufacturing_goals;
        this.ef1 = ef1;
        this.total_games = total_games;
        this.goals = goals;
        this.ef2 = ef2;
        this.max_goals = max_goals;
        this.ef3 = ef3;
        this.assist = assist;
        this.ef4 = ef4;
        this.max_assist = max_assist;
        this.ef5 = ef5;
        this.max_total_manufacturing_goals = max_total_manufacturing_goals;
        this.ef6 = ef6;
        this.total_assits_goals = total_assits_goals;
        this.season = season;
        this.league_name = league_name;
        this.continent = continent;
    }

    public FiveLeagues(){}

    @Override
    public String toString() {
        return "FiveLeagues{" +
                "id=" + id +
                ", rank=" + rank +
                ", country='" + country + '\'' +
                ", player_name='" + player_name + '\'' +
                ", total_manufacturing_goals='" + total_manufacturing_goals + '\'' +
                ", ef1=" + ef1 +
                ", total_games=" + total_games +
                ", goals=" + goals +
                ", ef2=" + ef2 +
                ", max_goals=" + max_goals +
                ", ef3=" + ef3 +
                ", assist=" + assist +
                ", ef4=" + ef4 +
                ", max_assist=" + max_assist +
                ", ef5=" + ef5 +
                ", max_total_manufacturing_goals=" + max_total_manufacturing_goals +
                ", ef6=" + ef6 +
                ", total_assits_goals=" + total_assits_goals +
                ", season='" + season + '\'' +
                ", league_name='" + league_name + '\'' +
                ", continent='" + continent + '\'' +
                '}';
    }
}
