package cz.hesovodoupe.policerp.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

object licenseCommandTab: TabCompleter {
    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>?
    ): MutableList<String>? {

        if (args != null) {

            when (args.size) {
                1 -> {
                    var jobList = ArrayList<String>()
                    jobList.add("show")
                    jobList.add("set")

                    return jobList
                }
                2 -> {
                    var playerList = ArrayList<String>()

                    for (p in Bukkit.getServer().onlinePlayers) {
                        playerList.add(p.name)
                    }
                    return playerList
                }
                3 -> {
                    return if(args.contains("set")) {
                        var variants = ArrayList<String>()
                        variants.add("true")
                        variants.add("false")

                        variants

                    } else {
                        null
                    }
                }


            }
        }

        return null

    }
}