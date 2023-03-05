package qweruHax.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dict {
    public List<String> keys = new ArrayList<>();
    public List<String> values = new ArrayList<>();

    public Dict(){

    }

    public void map(List<String> aKeys, List<String> aValues){
        if(aKeys.size()!=aValues.size()) return;
        for(int i = 0; i<aKeys.size(); i++){
            this.keys.add(aKeys.get(i));
            this.values.add(aValues.get(i));
        }
    }

    public String get(String key){
        for(int i = 0; i<this.keys.size(); i++){
            if(Objects.equals(keys.get(i), key)) return values.get(i);
        }
        return null;
    }
}
