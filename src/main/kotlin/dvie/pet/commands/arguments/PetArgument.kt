package dvie.pet.commands.arguments

import dev.splityosis.commandsystem.SYSArgument
import dev.splityosis.commandsystem.SYSCommand
import dvie.pet.Pet
import org.bukkit.command.CommandSender


class PetArgument : SYSArgument() {


    override fun isValid(s: String?): Boolean {
        val petsMap = Pet.petConfig.petsMap
        return petsMap?.containsKey(s) ?: false
    }

    override fun getInvalidInputMessage(s: String?): MutableList<String> {
        return mutableListOf("Invalid pet: $s")
    }

    override fun tabComplete(sender: CommandSender?, command: SYSCommand?, input: String?): MutableList<String> {
        val pets: MutableList<String> = mutableListOf()
        val petsMap = Pet.petConfig.petsMap

        if (input != null) {
            petsMap?.keys?.forEach { petId ->
                if (petId.lowercase().startsWith(input.lowercase())) {
                    pets.add(petId)
                }
            }
        }
        return pets.toMutableList()
    }
}