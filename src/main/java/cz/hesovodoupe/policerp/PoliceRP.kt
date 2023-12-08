package cz.hesovodoupe.policerp

import cz.hesovodoupe.policerp.Metrics.SimplePie
import cz.hesovodoupe.policerp.commands.jobs.fireCommand
import cz.hesovodoupe.policerp.commands.jobs.hireCommand
import cz.hesovodoupe.policerp.commands.jobs.hireCommandTab
import cz.hesovodoupe.policerp.commands.jobs.licenseCommand
import cz.hesovodoupe.policerp.commands.licenseCommandTab
import cz.hesovodoupe.policerp.commands.prestupek
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

public val databaze = mutableMapOf<String, Int>()
public val databazeGuns = mutableMapOf<String, Boolean>()

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
    public val felony_db: File = File(dataFolder, "felony_db.yml")
    public val gun_licenses_db: File = File(dataFolder, "gun_licenses_db.yml")

    public val cfgFelony = YamlConfiguration.loadConfiguration(felony_db)
    val cfgGun = YamlConfiguration.loadConfiguration(gun_licenses_db)
    override fun onEnable() {
        println("Thank you for using our simple punishment system for PoliceRP")
        println("Note that police officers must have the right to PoliceRP.punish")

        saveDefaultConfig()
        registerCommands()
        loadDbprestupky()
        loadDbGuns()

        val pluginId = 113732
        val metrics = Metrics(this, pluginId)
        metrics.addCustomChart(SimplePie("chart_id") { "My value" })



        ConfigManager.emsHireValue = config.getString("nabor.ems").toString()
        ConfigManager.pdHireValue = config.getString("nabor.pd").toString()
        ConfigManager.fireHireValue = config.getString("nabor.fire").toString()
        ConfigManager.armyHireValue = config.getString("nabor.army").toString()
        ConfigManager.prestupky = config.getString("prestupky.pocet").toString()
        ConfigManager.casJail = config.getString("prestupky.time").toString()
        ConfigManager.jailName = config.getString("prestupky.jail").toString()



    }

    override fun onDisable() {
        getLogger().info("Plugin is shutting down")
        saveDbprestupky()
        saveDbGun()
    }

    private fun registerCommands() {
        getCommand("felony")?.setExecutor(prestupek)
        getCommand("release")?.setExecutor(prestupek)

        getCommand("hire")?.setExecutor(hireCommand)
        getCommand("hire")?.setTabCompleter(hireCommandTab)

        getCommand("fire")?.setExecutor(fireCommand)
        getCommand("fire")?.setTabCompleter(hireCommandTab)

        getCommand("license")?.setExecutor(licenseCommand)
        getCommand("license")?.setTabCompleter(licenseCommandTab)
    }

    fun saveDbprestupky(){
        for ((key, value) in databaze) {
            // Zde můžete provádět operace pro každou položku
            cfgFelony.set(key, value)
        }
        cfgFelony.save(felony_db)
        getLogger().info("felony_db Saved")
    }

    fun saveDbGun(){
        for ((key, value) in databazeGuns) {
            // Zde můžete provádět operace pro každou položku
            cfgGun.set(key, value)
        }
        cfgGun.save(gun_licenses_db)
        getLogger().info("gun_licenses_db Saved")
    }

    fun loadDbprestupky() {
        // Načtení konfiguračního souboru

        if(felony_db.exists()){
            cfgFelony.load(felony_db)

            // Vyčištění stávající databáze
            databaze.clear()

            // Iterace přes všechny klíče v konfiguraci
            for (key in cfgFelony.getKeys(false)) {
                // Získání hodnoty pro daný klíč
                val value = cfgFelony.getInt(key)

                // Aktualizace databáze
                databaze[key] = value
            }

            getLogger().info("Felony_DB Loaded")
        }
        return;
    }


    fun loadDbGuns() {
        // Načtení konfiguračního souboru

        if(gun_licenses_db.exists()){
            cfgGun.load(gun_licenses_db)

            // Vyčištění stávající databáze
            databazeGuns.clear()

            // Iterace přes všechny klíče v konfiguraci
            for (key in cfgGun.getKeys(false)) {
                // Získání hodnoty pro daný klíč
                val value = cfgGun.getBoolean(key)

                // Aktualizace databáze
                databazeGuns[key] = value
            }

            getLogger().info("Guns_DB Loaded")
        }
        return;
    }
}