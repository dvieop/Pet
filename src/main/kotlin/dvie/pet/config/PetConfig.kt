package dvie.pet.config

import dev.splityosis.configsystem.configsystem.AnnotatedConfig
import dev.splityosis.configsystem.configsystem.ConfigField
import dvie.pet.Pet
import dvie.pet.objects.PetsMap
import java.io.File

class PetConfig(parentDirectory: File?, name: String?) : AnnotatedConfig(parentDirectory, name) {

    @ConfigField(path = "item.pets")
    @JvmField
    var petsMap: PetsMap? = PetsMap.getDefaultPets()

}