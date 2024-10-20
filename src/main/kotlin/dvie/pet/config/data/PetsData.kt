package dvie.pet.config.data

import org.bukkit.configuration.InvalidConfigurationException
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable
import java.io.File
import java.io.IOException

class PetsData(private val file: File, val plugin: JavaPlugin) {
    var config: FileConfiguration? = null
    private var autoSaveCode = 0.0

    init {
        try {
            if (!file.parentFile.exists()) file.parentFile.mkdirs()
            if (!file.exists()) file.createNewFile()
            config = YamlConfiguration()
            (config as YamlConfiguration).load(file)
        } catch (e: IOException) {
            plugin.logger.severe("Failed to create or load data file: ${e.message}")
            throw RuntimeException(e)
        } catch (e: InvalidConfigurationException) {
            plugin.logger.severe("Failed to load data file configuration: ${e.message}")
            throw RuntimeException(e)
        }
    }

    fun save() {
        try {
            config!!.save(file)
        } catch (e: IOException) {
            plugin.logger.severe("Failed to save data file: ${e.message}")
            throw RuntimeException(e)
        }
    }

    fun startAutoSave(period: Long) {
        if (isAutoSave) return
        autoSaveCode = Math.random()
        object : BukkitRunnable() {
            private val sessionCode = autoSaveCode
            override fun run() {
                if (sessionCode != autoSaveCode) {
                    cancel()
                    return
                }
                save()
            }
        }.runTaskTimerAsynchronously(plugin, period, period)
    }

    fun stopAutoSave() {
        autoSaveCode = 0.0
    }

    val isAutoSave: Boolean
        get() = autoSaveCode != 0.0

    fun reload() {
        try {
            config!!.load(file)
        } catch (e: IOException) {
            plugin.logger.severe("Failed to reload data file: ${e.message}")
            throw RuntimeException(e)
        } catch (e: InvalidConfigurationException) {
            plugin.logger.severe("Invalid configuration in data file: ${e.message}")
            throw RuntimeException(e)
        }
    }
}