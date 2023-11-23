# PoliceRP Plugin

**Overview**

The PoliceRP plugin has been updated to include new functionality. Two essential commands have been added: /nabor for recruiting players into specific roles (EMS, PD, Fire, Army) and /prestupek for managing player offenses.

**/nabor Command**

**Description**
> Recruit a player into a specific role.

**Permissions**
> **policerp.chief**: Allows access to the command.

**Usage**
> /nabor [ems, pd, fire, army] [player]

**Examples**
> /nabor ems MedicApplicant
> /nabor pd PoliceRecruit
> /nabor fire FirefighterCandidate
> /nabor army SoldierEnlistee

**Notes**
> Ensure that the player executing the command has the necessary permissions (policerp.chief) to recruit players into roles
> The command will prompt if any required information is missing.


**/prestupek Command**

**Description**
> Report a player for an offense.

**Permissions**
> **policerp.punish**: Allows access to the command.

**Usage**
> /prestupek [player]

**Examples**
> /prestupek Troublemaker123

**Notes**
> Use this command to report offenses committed by players.
> Ensure that the player executing the command has the necessary permissions (policerp.punish).
> The plugin will track and manage reported offenses, applying appropriate actions as needed.


**Installation**
1. Download the latest release of the PoliceRP plugin.
2. Place the plugin JAR file in the plugins folder of your Bukkit/Spigot server.
3. Start or restart your server.


