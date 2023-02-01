package qweruHax.module;

import qweruHax.module.packetmodules.*;

import java.util.ArrayList;
import java.util.List;

public class PacketModuleManager {
    public static List<ModuleBase> modules;

    public PacketModuleManager()  {
        modules = new ArrayList<>();

        // add modules here


    }

    public static List<ModuleBase> getModules(){
        return modules;
    }


    public static List<ModuleBase> getModulesInCategory(ModuleBase.Category c) {
        List<ModuleBase> modulesInCategory = new ArrayList<>();
        for(ModuleBase m :  modules)  {
            if(m.getCategory() == c){
                modulesInCategory.add(m);
            }
        }
        return modulesInCategory;
    }

    public static ModuleBase getModuleByName(String module) {
        for(ModuleBase m : modules) {
            if(m.getName().equalsIgnoreCase(module)){
                return m;
            }
        }
        return null;
    }
}
