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
        return List.of(text.replace(detectCommand, "").split(" "));
    }

    public static boolean handle(String text){
        if(text.startsWith(".")){
            if(text.startsWith(".tp")){
                List<String> args = parse(text, ".tp");
                sendMessage("Teleporting...");
                sendMessage(args.toString());
                LargeTP.tp(Integer.parseInt(args.get(1)), Integer.parseInt(args.get(2)), Integer.parseInt(args.get(3)));

            } else if (text.startsWith(".velocity")){
                List<String> args = parse(text, ".velocity");
                if(args.get(1) == "x"){
                    mc.player.addVelocity(Integer.parseInt(args.get(2)), 0, 0);
                    sendMessage("Applied x velocity");
                } else if(args.get(1) == "y"){
                    mc.player.addVelocity(0, Integer.parseInt(args.get(2)), 0);
                    sendMessage("Applied y velocity");
                } else if(args.get(1) == "z"){
                    mc.player.addVelocity(0, 0, Integer.parseInt(args.get(2)));
                }
            } else if (text.startsWith(".help")) {
                sendMessage("QweruHax help utility");
                sendMessage(": .help - show this message");
                sendMessage(": .tp <x> <y> <z> - teleport to specific coords");
                sendMessage(": .velocity < x | y | z > <num> - apply specific velocity (client side) ");
                sendMessage(": .packet < log | ?? > - do stuff with packets ");
            } else {
                sendMessage("Invalid command! Type .help for help");
            }
            return true;
        }
        return false;
    }
}
