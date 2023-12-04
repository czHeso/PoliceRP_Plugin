package cz.hesovodoupe.policerp.commands.jobs

import cz.hesovodoupe.policerp.ConfigManager
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object hireCommand: CommandExecutor  {
    override fun onCommand(sender: CommandSender, cmd: Command, p2: String, args: Array<out String>?): Boolean {
        val commandString = cmd.name

        if (commandString == "hire") {

            if (sender.hasPermission("policerp.chief")) {

                if (args == null || args.size < 2) {
                    sender.sendMessage("The command is missing some important information!")
                    sender.sendMessage("Usage: /hire [Police,Ems,Fire,Army] [nick]")
                    return false
                }

                val prace = args[0]
                val hrac = args[1]

                if (hrac.isEmpty() || prace.isEmpty()) {
                    sender.sendMessage("The command is missing some important information!")
                    sender.sendMessage("Usage: /hire [Police,Ems,Fire,Army] [nick]")
                    return false
                }

                when (prace) {
                    "Ems" -> {
                        val hireValue = ConfigManager.emsHireValue.toString()
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user $hrac parent add $hireValue")
                        sender.sendMessage("Role for $hrac has been set to $hireValue")
                        // ADD EMS JOB
                        return true
                    }
                    "Police" -> {
                        val hireValue = ConfigManager.pdHireValue.toString()
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user $hrac parent add $hireValue")
                        sender.sendMessage("Role for $hrac has been set to $hireValue")
                        // ADD PD JOB
                        return true
                    }
                    "Fire" -> {
                        val hireValue = ConfigManager.fireHireValue.toString()
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user $hrac parent add $hireValue")
                        sender.sendMessage("Role for $hrac has been set to $hireValue")
                        // ADD FIRE JOB
                        return true
                    }
                    "Army" -> {
                        val hireValue = ConfigManager.armyHireValue.toString()
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user $hrac parent add $hireValue")
                        sender.sendMessage("Role for $hrac has been set to $hireValue")
                        // ADD ARMY JOB
                        return true
                    }
                    else -> {
                        sender.sendMessage("A valid value was not provided.")
                        sender.sendMessage("Usage: /hire [Police,Ems,Fire,Army] [nick]")
                        return false
                    }
                }

            } else {
                sender.sendMessage("U dont have permissions!")
                return true
            }

        }

        return false
    }
}