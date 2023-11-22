package cz.hesovodoupe.policerp

import cz.hesovodoupe.policeroleplay.prestupek
import org.bukkit.plugin.java.JavaPlugin

public val databaze = mutableMapOf<String, Int>()


class PoliceRP : JavaPlugin() {
    override fun onEnable() {
        getLogger().info("Testovací zpráva! ")
        println("Děkujeme, že využíváte náš jednoduchý trestací systém pro PoliceRP")
        println("Upozorňujeme, že policisté musí mít právo na PoliceRP.punish")

        registerCommands()

    }

    override fun onDisable() {
        getLogger().info("Plugin se vypíná")

    }

    private fun registerCommands() {
        getCommand("prestupek")?.setExecutor(prestupek)
        getCommand("propustit")?.setExecutor(prestupek)
        getCommand("policienabor")?.setExecutor(prestupek)
        getCommand("policievyhazov")?.setExecutor(prestupek)
        getCommand("hasicinabor")?.setExecutor(prestupek)
        getCommand("hasicivyhazov")?.setExecutor(prestupek)
        getCommand("armynabor")?.setExecutor(prestupek)
        getCommand("armyvyhazov")?.setExecutor(prestupek)
        getCommand("emsnabor")?.setExecutor(prestupek)
        getCommand("emsvyhazov")?.setExecutor(prestupek)

    }


}