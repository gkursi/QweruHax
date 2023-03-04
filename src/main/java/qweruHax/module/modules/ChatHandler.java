package qweruHax.module.modules;

import org.apache.http.util.Args;
import qweruHax.module.ModuleBase;
import qweruHax.util.Defs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatHandler extends ModuleBase {
    public ChatHandler() {
        super("ChatHandler", Defs.NULLKeybind, Category.UTIL);
    }

    private static List<String> parse(String text, String detectCommand){
        List<String> args = new ArrayList<>();
        args = List.of(text.replace(detectCommand, "").split(""));
        return args;
    }

    public static boolean handle(String text){
        if(text.startsWith(".")){
            sendMessage("Command detected!");
            if(text.startsWith(".tp")){
                List<String> args = parse(text, ".tp");
                LargeTP.tp(Integer.parseInt(args.get(0)), Integer.parseInt(args.get(1)), Integer.parseInt(args.get(2)));
                sendMessage("Teleporting...");
            } else if (text.startsWith(".velocity")){
                List<String> args = parse(text, ".velocity");
                sendMessage("Executing velocity command...");
            } else {
                sendMessage("Invalid command! Type .help for help");
            }
            return true;
        }
        return false;
    }
}
