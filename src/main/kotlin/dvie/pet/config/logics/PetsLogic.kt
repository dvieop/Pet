package dvie.pet.config.logics

import dev.splityosis.configsystem.configsystem.ConfigTypeLogic
import dev.splityosis.configsystem.configsystem.logics.ItemStackConfigLogic
import dvie.pet.objects.Pets
import dvie.pet.objects.PetsMap
import org.bukkit.configuration.ConfigurationSection

class PetsLogic : ConfigTypeLogic<PetsMap>() {

    override fun getFromConfig(configurationSection: ConfigurationSection, s: String): PetsMap {
        val itemStackConfigLogic = ItemStackConfigLogic()
        val petsMap = PetsMap()

        for (key in configurationSection.getConfigurationSection(s)?.getKeys(false) ?: emptySet()) {
            val isEnabled = configurationSection.getBoolean("$s.$key.enabled")
            val name = configurationSection.getString("$s.$key.name")
            val item = itemStackConfigLogic.getFromConfig(configurationSection, "$s.$key.item")
            val textureUrl = configurationSection.getString("$s.$key.textureUrl")
            val rarity = configurationSection.getString("$s.$key.rarity")
            val disabledWorlds = configurationSection.getStringList("$s.$key.disabledWorlds")
            val cooldown = configurationSection.getLong("$s.$key.cooldown")
            petsMap[key] = Pets(
                isEnabled,
                name.toString(),
                item,
                textureUrl.toString(),
                rarity,
                disabledWorlds,
                cooldown
            )
        }

        return petsMap

    }

    override fun setInConfig(petsMap: PetsMap, configurationSection: ConfigurationSection, s: String) {
        val itemStackConfigLogic = ItemStackConfigLogic()

        for ((key, pet) in petsMap) {
            configurationSection.set("$s.$key.enabled", pet.isEnabled)
            configurationSection.set("$s.$key.name", pet.name)
            itemStackConfigLogic.setInConfig(pet.item, configurationSection, "$s.$key.item")
            configurationSection.set("$s.$key.textureUrl", pet.textureUrl)
            configurationSection.set("$s.$key.rarity", pet.rarity)
            configurationSection.set("$s.$key.disabledWorlds", pet.disabledWorlds)
            configurationSection.set("$s.$key.cooldown", pet.cooldown)
        }
    }
}