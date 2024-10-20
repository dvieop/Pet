package dvie.pet.objects

import dvie.kfeatures.modules.util.Util
import dvie.pet.enums.Rarity
import org.bukkit.Material
import java.util.Arrays

class PetsMap : HashMap<String, Pets>() {

    companion object {
        fun getDefaultPets(): PetsMap {
            val petsMap = PetsMap()
            petsMap["default"] = Pets(
                true,
                "default",
                item = Util.createItemStack(
                    Material.PLAYER_HEAD,
                    1,
                    "TEST PET",
                    Arrays.asList("a", "", "Rarity : COMMON")
                ),
                "125412375712n4r571rndf71df7qarjn7135715",
                rarity = Rarity.COMMON.toString(),
                Arrays.asList("world"),
                0,
            )
            return petsMap
        }
    }
}