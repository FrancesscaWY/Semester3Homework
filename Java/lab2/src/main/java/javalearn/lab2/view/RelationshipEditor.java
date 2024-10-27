package javalearn.lab2.view;

import javalearn.lab2.core.Relationship;

public class RelationshipEditor extends Editor<Relationship>{
    @Override
    public String[] values(){
        Relationship rel = this.getTarget();
        return new String[] {rel.getName(),rel.getAttribute()};
    }
    @Override
    public String[] fieldNames(){
        return new String[] {"名称","属性"};
    }
    @Override
    public void update(String[] values){
        Relationship rel = this.getTarget();
        rel.setName(values[0]);
        rel.setAttribute(values[1]);
    }
}