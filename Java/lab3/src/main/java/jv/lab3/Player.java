package jv.lab3;

public class Player{
    private Decoder[] decoders={new MP3Decoder(),new WAVDecoder()};
    public void play(String path){
        for(Decoder d:decoders){
            if(d.canDecode(path)){
                d.decode(path);
            }
        }
    }
}
