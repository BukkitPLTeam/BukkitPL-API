package pl.bukkit.bukkitpl;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.plugin.Plugin;

import pl.bukkit.bukkitpl.api.PluginManager;
import pl.bukkit.bukkitpl.api.WarpManager;

/**
 * Klasa do zarz¹dzania pluginem pod³¹czonym pod API, realizacja
 * {@link PluginManager}
 * 
 * @author BukkitSmerf
 * 
 */
public class PluginManagerHandler implements PluginManager
{
	private final Plugin owner;
	private final Map<String, WarpManager> warps = new HashMap<>();

	public PluginManagerHandler(final Plugin plugin)
	{
		this.owner = plugin;
	}

	public void load()
	{

	}

	@Override
	public void save()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void reload()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public WarpManager createWarpManager(final String name)
	{
		final WarpManager m = new WarpManagerHandler();
		this.warps.put(name, m);
		return m;
	}

	@Override
	public WarpManager getWarpManager(final String name)
	{
		return this.warps.get(name);
	}

	@Override
	public boolean isWarpManager(final String name)
	{
		return this.warps.containsKey(name);
	}

	@Override
	public Plugin getOwner()
	{
		return this.owner;
	}
}
