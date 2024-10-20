package dvie.pet.objects

import de.tr7zw.nbtapi.NBTItem
import lombok.Getter
import org.bukkit.inventory.ItemStack

@Getter
data class Pets(
    val isEnabled: Boolean,
    val name: String,
    val item: ItemStack,
    val textureUrl: String,
    val rarity: String?,
    val disabledWorlds: List<String>,
    val cooldown: Long

)

