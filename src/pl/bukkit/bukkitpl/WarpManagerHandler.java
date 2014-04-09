package pl.bukkit.bukkitpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.bukkit.Location;

import pl.bukkit.bukkitpl.api.Warp;
import pl.bukkit.bukkitpl.api.WarpManager;

/**
 * Klasa do zarz¹dzania warpami, realizacja {@link WarpManager}
 * 
 * @author BukkitSmerf
 * 
 */
public class WarpManagerHandler implements WarpManager
{
	private final Map<String, Warp> warps = new HashMap<>();

	@Override
	public void addWarp(final Warp warp)
	{
		this.warps.put(warp.getName(), warp);
	}

	@Override
	public Warp createAndAddWarp(final String name, final Location loc)
	{
		return this.createAndAddWarp(name, loc, "BukkitPL.default");
	}

	@Override
	public Warp createAndAddWarp(final String name, final Location loc, final String permission)
	{
		final Warp warp = new WarpHandler(name, loc, permission);
		this.addWarp(warp);
		return warp;
	}

	@Override
	public void removeWarp(final Warp warp)
	{
		this.removeWarp(warp.getName());
	}

	@Override
	public Warp removeWarp(final String name)
	{
		return this.warps.remove(name);
	}

	@Override
	public Warp getWarp(final String name)
	{
		return this.warps.get(name);
	}

	@Override
	public boolean isWarp(final String name)
	{
		return this.warps.containsKey(name);
	}

	@Override
	public Set<String> getWarpNameList()
	{
		return this.warps.keySet();
	}

	@Override
	public Collection<Warp> getWarpList()
	{
		return this.warps.values();
	}

	@Override
	public Set<String> getWarpNameListFor(final User user)
	{
		final Set<String> result = new TreeSet<>();
		for (final Warp w : this.warps.values())
		{
			if (user.hasPermission(w.getPermission()))
			{
				result.add(w.getName());
			}
		}
		return result;
	}

	@Override
	public Collection<Warp> getWarpListFor(final User user)
	{
		final List<Warp> result = new ArrayList<>();
		for (final Warp w : this.warps.values())
		{
			if (user.hasPermission(w.getPermission()))
			{
				result.add(w);
			}
		}
		return result;
	}

	@Override
	public Map<String, Warp> getWarps()
	{
		return this.warps;
	}

	@Override
	public Set<String> getWarpNameListFor(final String permission)
	{
		final Set<String> result = new TreeSet<>();
		for (final Warp w : this.warps.values())
		{
			if (w.getPermission().equalsIgnoreCase(permission))
			{
				result.add(w.getName());
			}
		}
		return result;
	}

	@Override
	public Collection<Warp> getWarpListFor(final String permission)
	{
		final List<Warp> result = new ArrayList<>();
		for (final Warp w : this.warps.values())
		{
			if (w.getPermission().equalsIgnoreCase(permission))
			{
				result.add(w);
			}
		}
		return result;
	}

	@Override
	public Warp createWarp(final String name, final Location loc)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Warp createWarp(final String name, final Location loc, final String permission)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
