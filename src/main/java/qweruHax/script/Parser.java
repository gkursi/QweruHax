package qweruHax.script;

import qweruHax.util.Dict;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Objects;

public class Parser {
    public String sourceCode;
    public String v;
    public Parser(String sourceCode, String v){
        this.sourceCode = sourceCode;
        this.v = v;
    }

    public Dict readSetup(){
        Dict keymap = new Dict();

        String setupSect = this.sourceCode.split("#setup")[0].split("#/setup")[0];
        String[] lines = setupSect.split(";");
        for (String line : lines) {
            // TODO: FINISH SCRIPT PARSE
            String[] keywords = line.split(" ");
            String definition = keywords[0];
            if(Objects.equals(definition, "data")){
                // VARIABLE
            } else if (Objects.equals(definition, "listener")) {
                // TODO: add events
            }
        }

        return keymap;
    }

}
