package pl.bukkit.bukkitpl.api;

import org.bukkit.plugin.Plugin;

import pl.bukkit.bukkitpl.PluginManagerHandler;

/**
 * Interface do zarz¹dzania pluginem podczepion pod te API. <br>
 * Realizowane przez {@link PluginManagerHandler}
 * 
 * @author BukkitSmerf
 * 
 */
public interface PluginManager
{
	public void save();

	public void reload();

	public WarpManager createWarpManager(final String name);

	public WarpManager getWarpManager(final String name);

	public boolean isWarpManager(final String name);

	public Plugin getOwner();
}
