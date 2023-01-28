package qweruHax.module;

import qweruHax.module.velocitymodules.*;

import java.util.ArrayList;
import java.util.List;

public class VelocityModuleManager {

    public VelocityModuleManager(){
        addModules();
    }
    public static List<VelocityModuleBase> moduleList = new ArrayList<>();

    public static List<VelocityModuleBase> getModules(){
        return moduleList;
    }

    public void addModules(){
        VelocityModuleBase PositiveX = new PositiveX();
        VelocityModuleBase PositiveY = new PositiveY();
        VelocityModuleBase PositiveZ = new PositiveZ();
        VelocityModuleBase NegativeX = new NegativeX();
        VelocityModuleBase NegativeY = new NegativeY();
        VelocityModuleBase NegativeZ = new NegativeZ();
        VelocityModuleBase PlayerEntityVelocityMultiplier = new PlayerEntityVelocityMultiplier();

        moduleList.add(PositiveX);
        moduleList.add(PositiveY);
        moduleList.add(PositiveZ);
        moduleList.add(NegativeX);
        moduleList.add(NegativeY);
        moduleList.add(NegativeZ);
        moduleList.add(PlayerEntityVelocityMultiplier);
    }
}
