package cz.hesovodoupe.policerp

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object vyhazov  : CommandExecutor {

    override fun onCommand(sender: CommandSender, cmd: Command, p2: String, args: Array<out String>?): Boolean {
        val commandString = cmd.name

        if (commandString == "vyhazov") {

            if (sender.hasPermission("policerp.chief")) {

                if (args == null || args.size < 2) {
                    sender.sendMessage("V příkazu chybí nějaké důležité informace!")
                    sender.sendMessage("Použití: /vyhazov [ems,pd,fire,army] [nick]")
                    return false
                }

                val prace = args[0]
                val hrac = args[1]

                if (hrac.isEmpty() || prace.isEmpty()) {
                    sender.sendMessage("V příkazu chybí nějaké důležité informace!")
                    sender.sendMessage("Použití: /vyhazov [ems,pd,fire,army] [nick]")
                    return false
                }

                when (prace) {
                    "ems" -> {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user $hrac parent remove emsnew")
                        sender.sendMessage("Hráči $hrac byla sebrána role EMS")
                        // ADD EMS JOB
                        return true
                    }
                    "pd" -> {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user $hrac parent remove policene")
                        sender.sendMessage("Hráči $hrac byla sebrána role EMS")
                        // ADD PD JOB
                        return true
                    }
                    "fire" -> {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user $hrac parent remove hasicinew")
                        sender.sendMessage("Hráči $hrac byla sebrána role EMS")
                        // ADD FIRE JOB
                        return true
                    }
                    "army" -> {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user $hrac parent remove armynew")
                        sender.sendMessage("Hráči $hrac byla sebrána role EMS")
                        // ADD ARMY JOB
                        return true
                    }
                    else -> {
                        sender.sendMessage("Nebyla uvedena správná hodnota.")
                        sender.sendMessage("Použití: /vyhazov [ems,pd,fire,army] [nick]")
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
