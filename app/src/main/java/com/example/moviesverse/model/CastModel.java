package com.example.moviesverse.model;

public class CastModel {

    public String original_name,character,profile_path,known_for_department;

    public CastModel() {
    }

    public CastModel(String original_name, String character, String profile_path, String known_for_department) {
        this.original_name = original_name;
        this.character = character;
        this.profile_path = profile_path;
        this.known_for_department = known_for_department;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public String getKnown_for_department() {
        return known_for_department;
    }

    public void setKnown_for_department(String known_for_department) {
        this.known_for_department = known_for_department;
    }
}
