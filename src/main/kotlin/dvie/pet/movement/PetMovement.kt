package dvie.pet.movement

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

class PetMovement {

    var runnable: BukkitRunnable? = null

    companion object {
        @JvmStatic
        var instance: PetMovement? = null
    }

    init {
        instance = this
    }

    fun start(plugin: JavaPlugin) {
        runnable = object : BukkitRunnable() {
            override fun run() {

            }
        }

        runnable?.runTaskTimer(plugin, 4, 4)

    }
}