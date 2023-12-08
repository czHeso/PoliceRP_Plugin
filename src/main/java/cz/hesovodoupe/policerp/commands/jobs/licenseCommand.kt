package cz.hesovodoupe.policerp.commands.jobs

import cz.hesovodoupe.policerp.databazeGuns
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object licenseCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>?): Boolean {
        val commandString = cmd.name

        if (commandString == "license") {
            if (!sender.hasPermission("policerp.punish")) {
                sender.sendMessage("You don't have permissions!")
                return false
            }

            if (args == null || args.size < 2) {
                sender.sendMessage("Wrong usage.")
                sender.sendMessage("Usage: /license show [nick].")
                sender.sendMessage("Usage: /license set [nick] [true/false].")
                return false
            }

            val subcommand = args[0]
            val hrac = args[1]

            when (subcommand) {
                "show" -> {
                    if (!databazeGuns.containsKey(hrac)) {
                        sender.sendMessage("Player $hrac does not have a gun license!.")
                    } else {
                        sender.sendMessage("Player $hrac does have a gun license!.")
                    }
                }
                "set" -> {
                    if (args.size < 3) {
                        sender.sendMessage("Wrong usage for set. Usage: /license set [nick] [true/false].")
                        return false
                    }

                    val setDecide = args[2].toBoolean()

                    sender.sendMessage("Player $hrac license was set to $setDecide!.")
                    databazeGuns[hrac] = setDecide
                }
                else -> {
                    sender.sendMessage("Unknown subcommand: $subcommand")
                }
            }
        }
        return true
    }
}
