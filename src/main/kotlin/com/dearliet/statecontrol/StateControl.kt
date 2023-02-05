package com.dearliet.statecontrol

import org.bukkit.plugin.java.JavaPlugin

/**
 * A singleton object that operates as the primary point of entry for accessing the plugin instance in the StateControl framework.
 * */
object StateControl {

    private lateinit var instance: JavaPlugin

    /**
     * Sets the implementation to be used by the framework.
     *
     * @param plugin The [JavaPlugin] to be used.
     * */
    fun setImplementation(plugin: JavaPlugin){
        instance = plugin
    }

    internal fun getInstance() : JavaPlugin {
        if(!this::instance.isInitialized) throw IllegalStateException("No implementation set.")
        return instance
    }
}