package jv.lab3;

public class MP3Decoder implements Decoder{
    public MP3Decoder(){};
    public boolean canDecode(String path){
        return path.endsWith(".mp3");
    }
    public String decode(String path){
        return "MP3";
    }

}
