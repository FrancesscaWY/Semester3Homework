package javalearn.lab2.core;

public class Edge {
    private Node from,to;

    public Edge(){};
    public Edge(Node f,Node t){
        setFrom(f);
        setTo(t);
    }

    public void setFrom(Node f){from=f;}
    public void setTo(Node t){to=t;}

    public Node getFrom(){return from;}
    public Node getTo(){return to;}

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null||getClass()!=o.getClass()) return false;
        Edge edge = (Edge) o;
        return edge.getFrom().equals(this.getFrom())&&edge.getTo().equals(this.getTo());
    }

    @Override
    public int hashCode(){
        return Integer.hashCode(Math.addExact(getFrom().getId(),getTo().getId()));
    }
}
