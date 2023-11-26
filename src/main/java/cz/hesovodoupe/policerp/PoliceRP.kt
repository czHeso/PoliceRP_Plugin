package cz.hesovodoupe.policerp

import cz.hesovodoupe.policerp.commands.nabor
import cz.hesovodoupe.policerp.commands.prestupek
import cz.hesovodoupe.policerp.commands.vyhazov
import org.bukkit.plugin.java.JavaPlugin

public val databaze = mutableMapOf<String, Int>()

object ConfigManager {
    var emsHireValue: String = ""
    var pdHireValue: String = ""
    var fireHireValue: String = ""
    var armyHireValue: String = ""
    var prestupky: String = ""
    var casJail: String = ""
    var jailName: String = ""
}

class PoliceRP : JavaPlugin() {

    override fun onEnable() {
        getLogger().info("Testovací zpráva! ")
        println("Děkujeme, že využíváte náš jednoduchý trestací systém pro PoliceRP")
        println("Upozorňujeme, že policisté musí mít právo na PoliceRP.punish")

        saveDefaultConfig()
        ConfigManager.emsHireValue = config.getString("nabor.ems").toString()
        ConfigManager.pdHireValue = config.getString("nabor.pd").toString()
        ConfigManager.fireHireValue = config.getString("nabor.fire").toString()
        ConfigManager.armyHireValue = config.getString("nabor.army").toString()
        ConfigManager.prestupky = config.getString("prestupky.pocet").toString()
        ConfigManager.casJail = config.getString("prestupky.time").toString()
        ConfigManager.jailName = config.getString("prestupky.jail").toString()



        registerCommands()

        config.getString("ems")

    }

    override fun onDisable() {
        getLogger().info("Plugin se vypíná")

    }

    private fun registerCommands() {
        getCommand("prestupek")?.setExecutor(prestupek)
        getCommand("propustit")?.setExecutor(prestupek)
        getCommand("nabor")?.setExecutor(nabor)
        getCommand("vyhazov")?.setExecutor(vyhazov)


    }



}