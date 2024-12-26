package io.NotKeira.Config;

import java.util.Collection;

import org.simpleyaml.configuration.file.YamlFile;

public class Configuration {

    YamlFile config = new YamlFile("config.yaml");

    public void loadConfig() {
        try {
            config.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getString(String path) {
        return config.getString(path);
    }

    public int getInt(String path) {
        return config.getInt(path);
    }

    public boolean getBoolean(String path) {
        return config.getBoolean(path);
    }

    public Collection<String> getStringList(String path) {
        return config.getStringList(path);
    }

}
