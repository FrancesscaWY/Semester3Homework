package jv.lab3;

public class WAVDecoder implements Decoder{
    public WAVDecoder(){};
    public boolean canDecode(String path){
        return path.endsWith(".wav")||path.endsWith(".WAV");
    }
    public String decode(String path){
        return "解码"+path;
    }
}
