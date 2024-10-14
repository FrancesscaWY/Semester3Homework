package javalearn.lab2.core;

public class Node {
    private int id;
    public Node(int id){setId(id);};
    public Node(){};
    public void setId(int id){this.id=id;}
    public int getId(){return id;}

    @Override
    public boolean equals(Object o){
        if(this == o)return true;
        if(o==null||getClass()!=o.getClass()) return false;
        Node node = (Node) o;
        return this.id == node.id;
    }
    @Override
    public int hashCode(){
        return Integer.hashCode(id);
    }

}
