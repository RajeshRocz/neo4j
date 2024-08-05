package com.example_neo4j.neo4jdemo.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node(labels = {"User"})
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Property("name") //not needed if name is same in db and entity
    private String name;
    @Relationship(type = "RATED", direction = Relationship.Direction.INCOMING)
    private List<Rated> ratedList;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rated> getRatedList() {
        return ratedList;
    }

    public void setRatedList(List<Rated> ratedList) {
        this.ratedList = ratedList;
    }
}
