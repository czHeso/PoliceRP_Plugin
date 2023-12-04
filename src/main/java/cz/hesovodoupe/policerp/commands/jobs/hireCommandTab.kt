package cz.hesovodoupe.policerp.commands.jobs

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter


object hireCommandTab: TabCompleter {
    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>?
    ): MutableList<String>? {

        if (args != null) {
            if(args.size == 1) {
                var jobList = ArrayList<String>()
                jobList.add("Police")
                jobList.add("Ems")
                jobList.add("Fire")
                jobList.add("Army")

                return jobList
            }
            else if(args.size == 2) {
                var playerList = ArrayList<String>()

                for (p in Bukkit.getServer().onlinePlayers) {
                    playerList.add(p.name)

                }

                return playerList
            }
        }

        return null
    }
}