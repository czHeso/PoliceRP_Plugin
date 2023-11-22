# PoliceRP Plugin

**Overview**

The PoliceRP plugin has undergone recent updates, introducing new commands to enhance server management. This plugin provides a straightforward punishment system for PoliceRP servers in Minecraft, featuring commands for reporting offenses, releasing players from jail, recruiting and removing players from various factions.

**Features**

**Punishment System:** Track and manage player offenses with an easy-to-use system.

**Additional Commands:**

/prestupek [player]: Report a player for an offense.

/propustit [player]: Release a player from jail.

/policienabor [player]: Recruit a player into the police force.

/policievyhazov [player]: Remove a player from the police force.

/hasicinabor [player]: Recruit a player into the firefighters.

/hasicivyhazov [player]: Remove a player from the firefighters.

/armynabor [player]: Recruit a player into the army.

/armyvyhazov [player]: Remove a player from the army.

/emsnabor [player]: Recruit a player into the EMS (Emergency Medical Services).

/emsvyhazov [player]: Remove a player from the EMS.


**Permission System:** Ensure that only authorized personnel have access to the punishment command.


**Installation**

1.Download the latest release of the PoliceRP plugin. 

2.Place the plugin JAR file in the plugins folder of your Bukkit/Spigot server.

3.Start or restart your server.


**Commands**

/prestupek [player]

Description: Report a player for an offense.

Permission: policerp.punish

Usage: /prestupek [player]

Example: /prestupek NotoriousPlayer


/propustit [player]

Description: Release a player from jail.

Permission: policerp.punish

Usage: /propustit [player]

Example: /propustit ReleasedPlayer


/policienabor [player]

Description: Recruit a player into the police force.

Permission: policerp.chief

Usage: /policienabor [player]

Example: /policienabor NewRecruit


/policievyhazov [player]

Description: Remove a player from the police force.

Permission: policerp.chief

Usage: /policievyhazov [player]

Example: /policievyhazov FormerOfficer


/hasicinabor [player]

Description: Recruit a player into the firefighters.

Permission: firerp.chief

Usage: /hasicinabor [player]

Example: /hasicinabor FirefighterRecruit


/hasicivyhazov [player]

Description: Remove a player from the firefighters.

Permission: firerp.chief

Usage: /hasicivyhazov [player]

Example: /hasicivyhazov FormerFirefighter


/armynabor [player]

Description: Recruit a player into the army.

Permission: policerp.chief

Usage: /armynabor [player]

Example: /armynabor NewSoldier


/armyvyhazov [player]

Description: Remove a player from the army.

Permission: policerp.chief

Usage: /armyvyhazov [player]

Example: /armyvyhazov DischargedSoldier


/emsnabor [player]

Description: Recruit a player into the EMS (Emergency Medical Services).

Permission: ems.chief

Usage: /emsnabor [player]

Example: /emsnabor NewMedic


/emsvyhazov [player]

Description: Remove a player from the EMS.

Permission: ems.chief

Usage: /emsvyhazov [player]

Example: /emsvyhazov FormerMedic



**Permissions**


**policerp.punish**: Allows access to the /prestupek, /propustit, and other related commands.

**policerp.chief**: Allows access to the /policienabor and /policievyhazov commands.

**firerp.chief**: Allows access to firefighter-related commands.

**ems.chief**: Allows access to EMS-related commands.


**Usage**


1. In-game, use the /prestupek [player] command to report a player for an offense.
   
2. Ensure that users have the necessary permission (policerp.punish) to use the command.



**Notes**

This plugin is designed for PoliceRP servers and may require additional customization to fit your specific server needs.

Make sure to regularly check for plugin updates to access new features and bug fixes.

- Built for 1.19.3
