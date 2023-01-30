package qweruHax.module;

import qweruHax.module.modules.*;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public ModuleBase LOBypass = new RoundCoords();
    public ModuleBase Fly = new Fly();
    public ModuleBase SurvivalSpoof = new SurvivalSpoof();
    public ModuleBase NoFall = new NoFall();
    public ModuleBase NoWorldBorder = new NoWorldBorder();
    public ModuleBase VanillaFLy = new VanillaFly();
    public ModuleBase BlockFinder = new BlockFinder();
    public static List<ModuleBase> modules;

    public ModuleManager()  {
        modules = new ArrayList<>();


        modules.add(LOBypass);
        modules.add(Fly);
        modules.add(SurvivalSpoof);
        modules.add(NoFall);
        modules.add(NoWorldBorder);
        modules.add(VanillaFLy);
        modules.add(BlockFinder);
    }

    public static List<ModuleBase> getModules(){
        return modules;
    }


    public static List<ModuleBase> getModulesInCategory(ModuleBase.Category c) {
        List<ModuleBase> modulesInCat = new ArrayList<>();
        for(ModuleBase m :  modules)  {
            if(m.getCategory() == c){
                modulesInCat.add(m);
            }
        }
        return modulesInCat;
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
