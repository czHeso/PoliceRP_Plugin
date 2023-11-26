package cz.hesovodoupe.policerp

import cz.hesovodoupe.policerp.commands.nabor
import cz.hesovodoupe.policerp.commands.prestupek
import cz.hesovodoupe.policerp.commands.vyhazov
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

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
    val f: File = File(dataFolder, "prestupky_db.yml")
    val cfg = YamlConfiguration.loadConfiguration(f)
    override fun onEnable() {
        println("Děkujeme, že využíváte náš jednoduchý trestací systém pro PoliceRP")
        println("Upozorňujeme, že policisté musí mít právo na PoliceRP.punish")

        saveDefaultConfig()
        loadDbprestupky()
        ConfigManager.emsHireValue = config.getString("nabor.ems").toString()
        ConfigManager.pdHireValue = config.getString("nabor.pd").toString()
        ConfigManager.fireHireValue = config.getString("nabor.fire").toString()
        ConfigManager.armyHireValue = config.getString("nabor.army").toString()
        ConfigManager.prestupky = config.getString("prestupky.pocet").toString()
        ConfigManager.casJail = config.getString("prestupky.time").toString()
        ConfigManager.jailName = config.getString("prestupky.jail").toString()



        registerCommands()

    }

    override fun onDisable() {
        getLogger().info("Plugin se vypíná")
        saveDbprestupky()
    }

    private fun registerCommands() {
        getCommand("prestupek")?.setExecutor(prestupek)
        getCommand("propustit")?.setExecutor(prestupek)
        getCommand("nabor")?.setExecutor(nabor)
        getCommand("vyhazov")?.setExecutor(vyhazov)


    }

    fun saveDbprestupky(){
        for ((key, value) in databaze) {
            // Zde můžete provádět operace pro každou položku
            cfg.set(key, value)
        }
        cfg.save(f)
        getLogger().info("prestupky_db Saved")
    }

    fun loadDbprestupky() {
        // Načtení konfiguračního souboru

        if(f.exists()){
            cfg.load(f)

            // Vyčištění stávající databáze
            databaze.clear()

            // Iterace přes všechny klíče v konfiguraci
            for (key in cfg.getKeys(false)) {
                // Získání hodnoty pro daný klíč
                val value = cfg.getInt(key)

                // Aktualizace databáze
                databaze[key] = value
            }

            getLogger().info("DB Loaded")
        }
        return;
    }






}