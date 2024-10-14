package javalearn.lab2.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class KnowledgeGraph{
    private Set<Entity> entities;
    private Set<Relationship> relations;
    private Map<Entity,Set<Relationship>> outMap;
    private Map<Entity,Set<Relationship>> inMap;
    private int seqNumber;

    public KnowledgeGraph(){
        seqNumber = 1;
        entities = new HashSet<Entity>();
        relations = new HashSet<Relationship>();
        outMap = new HashMap<>();
        inMap = new HashMap<>();
    }

//    What's the Optional class in java ?
    public Optional<Entity> addEntity(String type,String name,String attribute){
        Entity e = new Entity(seqNumber++,type,name,attribute);
        if(addEntity(e)){
            return Optional.ofNullable(e);
        }else{
            return Optional.empty();
        }
    }
    public boolean addEntity(Entity e){
        return this.entities.add(e);
    }

    public Optional<Relationship> addRelation(Entity from,Entity to){
        Optional<Relationship> r = Optional.empty();
        if(entities.contains(from)&&entities.contains(to)){
            Relationship rel = new Relationship(from,to);
            if(relations.add(rel)){
                outMap.computeIfAbsent(from,f -> new HashSet<>()).add(rel); // add the outMap index
                inMap.computeIfAbsent(to,f->new HashSet<>()).add(rel);
            }
        }
        return r;
    }

    public void removeEntity(Entity e){
        this.entities.remove(e);
        removeAllRelsFrom(e);
        removeAllRelsTo(e);
    }

    public void removeAllRelsFrom(Entity from){
        if(outMap.containsKey(from)){
            Set<Relationship> rels = outMap.get(from);
            relations.removeAll(rels);
            outMap.remove(from);
        }
    }

    public void removeAllRelsTo(Entity to) {
        if(inMap.containsKey(to)){
            Set<Relationship> rels= inMap.get(to);
            relations.removeAll(rels);
            inMap.remove(to);
        }
    }

    public Set<Entity> getEntities(){
        return entities;
    }

    public Set<Relationship> getRelations(){
        return relations;
    }


}
