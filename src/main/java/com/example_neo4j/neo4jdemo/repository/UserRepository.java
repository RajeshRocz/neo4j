package com.example_neo4j.neo4jdemo.repository;

import com.example_neo4j.neo4jdemo.entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
create (Anniyan:Movie{name:'Anniyan',director:'Shankar'})
create (Bagubali:Movie{name:'Bagubali',director:'Rajamouli'})
create (Rajesh:User{name:'Rajesh'})
create (Ramesh:User{name:'Ramesh'})
create (Suresh:User{name:'Suresh'})
create (Anniyan)-[:RATED{rating:9}]->(Rajesh)
create (Bagubali)-[:RATED{rating:10}]->(Rajesh)
create (Anniyan)-[:RATED{rating:8}]->(Ramesh)
create (Bagubali)-[:RATED{rating:9}]->(Ramesh)
create (Anniyan)-[:RATED{rating:9}]->(Suresh)
create (Bagubali)-[:RATED{rating:10}]->(Suresh)
 */

@Repository
public interface UserRepository extends Neo4jRepository<User,Long> {

    @Query("MATCH(u:User)<-[r:RATED]-(m:Movie) RETURN u,r,m")
    public List<User> findAllNodes();

    public Optional<User> findByName(String name);
}
