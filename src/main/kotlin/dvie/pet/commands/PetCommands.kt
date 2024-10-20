package dvie.pet.commands

import dev.splityosis.commandsystem.SYSCommand
import dev.splityosis.commandsystem.SYSCommandBranch
import dev.splityosis.commandsystem.arguments.PlayerArgument
import dvie.kfeatures.modules.util.Util
import dvie.pet.Pet
import dvie.pet.commands.arguments.PetArgument
import org.bukkit.Bukkit

class PetCommands(vararg names: String?) : SYSCommandBranch("apet", "apets") {

    init {
        setPermission("pets.admin")

        addCommand(SYSCommand("give")
            .setPermission("pets.admin.give")
            .setArguments(PlayerArgument(), PetArgument())
            .setUsage("/pet give <player> <pet>")
            .executes { sender, args ->
                val player = Bukkit.getPlayer(args[0] as String)

            })

        addCommand(SYSCommand("reload")
            .setPermission("pets.admin.reload")
            .setUsage("/pet reload")
            .executes { sender, args ->
                Pet.instance.reloadConfig()
                Util.sendMessage(sender, "&aPet config & data reloaded")
            })
    }
}