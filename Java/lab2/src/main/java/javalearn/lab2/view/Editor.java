package javalearn.lab2.view;

public abstract class Editor<T> {
 private T target;
 public abstract String[] values();
 public abstract String[] fieldNames();
 public abstract void update(String[] values);
 public T getTarget(){
     return target;
 }
 public void setTarget(T target){
     this.target = target;
 }
}
