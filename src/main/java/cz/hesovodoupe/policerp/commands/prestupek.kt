package cz.hesovodoupe.policerp.commands

import cz.hesovodoupe.policerp.ConfigManager
import cz.hesovodoupe.policerp.databaze
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender


object prestupek: CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, p2: String, args: Array<out String>?): Boolean {
        val trestany = args?.get(0).toString()

        val commandString = cmd.name.toString()

        if(commandString == "felony")
        {
            if (!sender.hasPermission("policerp.punish")) {
                sender.sendMessage("You dont have permissions!")
                return false;

            }

            if (args == null)
            {
                sender.sendMessage("You have to type a player nick.")
                return false
            }
            sender.sendMessage(" ")

            val hodnota = 1
            println("$sender issued command to $cmd")
            val pocetPrestupku = ConfigManager.prestupky.toInt()
            val casJailu = ConfigManager.casJail.toInt()
            val jailName = ConfigManager.jailName.toString()

            if(!databaze.containsKey(trestany))
            {

                databaze[trestany] = hodnota
                sender.sendMessage("This is a violation of player $trestany! Thanks for reporting.")
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "msg $trestany Now you have the first reported offense from ${sender.name}")

            }
            else {
                var jizTrestanHodnota: Int = databaze[trestany]!!
                jizTrestanHodnota = jizTrestanHodnota + 1
                sender.sendMessage("This is $jizTrestanHodnota offense value of player $trestany!")
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "msg $trestany You now have $jizTrestanHodnota value of offenses. Last reported by ${sender.name}")

                if(jizTrestanHodnota > pocetPrestupku)
                {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "jail $trestany ${casJailu}m $jailName")
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "msg $trestany You already have $jizTrestanHodnota of offenses. You're going to jail!!")
                    jizTrestanHodnota = 0
                }

                databaze[trestany] = jizTrestanHodnota

            }





            return true




        }

        if(commandString == "release")
        {
            if (!sender.hasPermission("policerp.punish")) {
                sender.sendMessage("You have no rights to this!")
                return false;

            }

            sender.sendMessage("Player $trestany was released")
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "unjail $trestany")
            return true;


        }

        return true
    }


}