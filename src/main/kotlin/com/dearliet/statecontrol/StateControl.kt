package com.dearliet.statecontrol

import org.bukkit.plugin.java.JavaPlugin

/**
 * A singleton object that serves as the central access point to the plugin instance within the StateControl framework.
 * */
object StateControl {

    private lateinit var instance: JavaPlugin

    /**
     * Sets the implementation to be used by the framework.
     * */
    fun setImplementation(plugin: JavaPlugin){
        instance = plugin
    }

    internal fun getInstance() : JavaPlugin {
        if(!this::instance.isInitialized) throw IllegalStateException("No implementation set.")
        return instance
    }
}