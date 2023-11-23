# PoliceRP Plugin

**Version:** ${version}

**Overview**

The PoliceRP plugin is a custom plugin designed for POLICE RP servers. It introduces essential commands for managing player offenses, handling jail releases, recruiting players into specific jobs, and dismissing them from their roles.

****Features****

**Commands**

1. /prestupek
   > Description: Issue a penalty to a player for an offense.
   > Usage: /prestupek [nick]
   > Permission: policerp.punish
2. /propustit
   > Description: Release a player from jail.
   > Usage: /propustit [nick]
   > Permission: policerp.punish
3. /nabor
   > Description: Recruit a player into a job.
   > Usage: /nabor [ems/pd/fire/army] [nick]
   > Permission: policerp.chief
4. /vyhazov
   > Description: Dismiss a player from a job.
   > Usage: /vyhazov [ems/pd/fire/army] [nick]
   > Permission: policerp.chief

**Permissions**
1. policerp.punish:
   > Description: Allows access to police-related commands.
   > Default: false
2. policerp.chief:
   > Description: Allows access to police-related commands.
   > Default: false

**Installation**
1. Download the latest release of the PoliceRP plugin.
2. Place the plugin JAR file in the plugins folder of your Bukkit/Spigot server.
3. Start or restart your server.


