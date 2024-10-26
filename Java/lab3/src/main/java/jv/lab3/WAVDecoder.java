package jv.lab3;

public class WAVDecoder implements Decoder{
    public WAVDecoder(){};
    public boolean canDecode(String path){
        return path.endsWith(".wav");
    }
    public String decode(String path){
        return "WAV";
    }
}
