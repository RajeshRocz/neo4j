package com.example_neo4j.neo4jdemo.repository;

import com.example_neo4j.neo4jdemo.entity.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {
}
