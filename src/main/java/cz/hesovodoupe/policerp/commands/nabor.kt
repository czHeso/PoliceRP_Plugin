package cz.hesovodoupe.policerp.commands

import cz.hesovodoupe.policerp.ConfigManager
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.configuration.file.FileConfiguration

object nabor : CommandExecutor {

    override fun onCommand(sender: CommandSender, cmd: Command, p2: String, args: Array<out String>?): Boolean {
        val commandString = cmd.name

        if (commandString == "nabor") {

            if (sender.hasPermission("policerp.chief")) {

                if (args == null || args.size < 2) {
                    sender.sendMessage("V příkazu chybí nějaké důležité informace!")
                    sender.sendMessage("Použití: /nabor [ems,pd,fire,army] [nick]")
                    return false
                }

                val prace = args[0]
                val hrac = args[1]

                if (hrac.isEmpty() || prace.isEmpty()) {
                    sender.sendMessage("V příkazu chybí nějaké důležité informace!")
                    sender.sendMessage("Použití: /nabor [ems,pd,fire,army] [nick]")
                    return false
                }

                when (prace) {
                    "ems" -> {
                        val hireValue = ConfigManager.emsHireValue.toString()
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user $hrac parent add $hireValue")
                        sender.sendMessage("Hráči $hrac byla nahozena role $hireValue")
                        // ADD EMS JOB
                        return true
                    }
                    "pd" -> {
                        val hireValue = ConfigManager.pdHireValue.toString()
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user $hrac parent add $hireValue")
                        sender.sendMessage("Hráči $hrac byla nahozena role $hireValue")
                        // ADD PD JOB
                        return true
                    }
                    "fire" -> {
                        val hireValue = ConfigManager.fireHireValue.toString()
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user $hrac parent add $hireValue")
                        sender.sendMessage("Hráči $hrac byla nahozena role $hireValue")
                        // ADD FIRE JOB
                        return true
                    }
                    "army" -> {
                        val hireValue = ConfigManager.armyHireValue.toString()
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user $hrac parent add $hireValue")
                        sender.sendMessage("Hráči $hrac byla nahozena role $hireValue")
                        // ADD ARMY JOB
                        return true
                    }
                    else -> {
                        sender.sendMessage("Nebyla uvedena správná hodnota.")
                        sender.sendMessage("Použití: /nabor [ems,pd,fire,army] [nick]")
                        return false
                    }
                }

            } else {
                sender.sendMessage("Na tohle nemáš práva!")
                return true
            }

        }

        return false
    }
}
