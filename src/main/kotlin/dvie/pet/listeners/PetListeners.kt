package dvie.pet.listeners

import dvie.pet.objects.PetContainer
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap
import org.bukkit.event.Listener
import java.util.*


class PetListeners : Listener {

    var equippedPets: Object2ObjectOpenHashMap<UUID, PetContainer> = Object2ObjectOpenHashMap<UUID, PetContainer>()

}