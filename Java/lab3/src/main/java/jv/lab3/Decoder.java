package jv.lab3;

public interface Decoder {
    boolean canDecode(String path);
    String decode(String path);
}
