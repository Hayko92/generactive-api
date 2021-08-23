package com.example.generactive_api.classes.model;

public class Configuration {
    private  Resolution resolution;

    public Configuration() {
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public Configuration(Resolution resolution) {
        this.resolution = resolution;
    }

}
