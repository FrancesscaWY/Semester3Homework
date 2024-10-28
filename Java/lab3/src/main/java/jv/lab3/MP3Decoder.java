package jv.lab3;

public class MP3Decoder implements Decoder{
    public MP3Decoder(){};
    public boolean canDecode(String path){
        return path.endsWith(".mp3")||path.endsWith(".MP3");
    }
    public String decode(String path){
        return "解码"+path;
    }

}
