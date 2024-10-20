package dvie.pet.menu

import dev.splityosis.menulib.Menu
import org.bukkit.entity.Player

class PetMenu(player: Player) : Menu(27) {

    init {
        setTitle(player.name + "'s Pets")

    }
}
