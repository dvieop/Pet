package dvie.pet

import dvie.pet.config.PetConfig
import dvie.pet.config.data.PetsData
import dvie.pet.config.logics.PetsLogic
import dvie.pet.menu.PetMenu
import lombok.Getter
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class Pet : JavaPlugin() {

    companion object {
        @Getter
        lateinit var instance: Pet
        lateinit var petConfig: PetConfig
        lateinit var petData: PetsData
    }

    override fun onEnable() {
        instance = this
        registerConfigLogic()
        reloadConfigs()
        petData = PetsData(File(dataFolder, "pet-data.yml"), this)
        petData.startAutoSave(20 * 60 * 5)
    }

    override fun onDisable() {

    }

    private fun reloadConfigs() {
        petConfig = PetConfig(dataFolder, "pets.yml")
        petConfig.initialize()
        petData.reload()
    }

    private fun registerConfigLogic() {
        PetsLogic().register()
    }
}
