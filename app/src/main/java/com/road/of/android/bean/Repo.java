package com.road.of.android.bean;

/**
 * Created by 江俊超 on 2019/1/17.
 * Version:1.0
 * Description:
 * ChangeLog:
 */
public class Repo {
    private String id;
    private String name;
    private String stargazers_count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(String stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    @Override
    public String toString() {
        return "Repo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", stargazers_count='" + stargazers_count + '\'' +
                '}';
    }
}
