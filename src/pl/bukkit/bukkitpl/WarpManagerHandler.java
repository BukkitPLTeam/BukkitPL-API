package pl.bukkit.bukkitpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.Validate;

import org.bukkit.Location;

import pl.bukkit.bukkitpl.api.BukkitPLAPI;
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
	public void addWarp(final Warp warp) throws NullPointerException
	{
		Validate.notNull(warp, "Arguments can't be null!");
		this.warps.put(warp.getName(), warp);
	}

	@Override
	public Warp createAndAddWarp(final String name, final Location loc) throws NullPointerException
	{
		return this.createAndAddWarp(name, loc, BukkitPLAPI.PERM_DEFAULT, "");
	}

	@Override
	public Warp createAndAddWarp(final String name, final Location loc, final String permission) throws NullPointerException
	{
		return this.createAndAddWarp(name, loc, permission, "");
	}

	@Override
	public Warp createAndAddWarp(final String name, final Location loc, final String permission, final String desc) throws NullPointerException
	{
		Validate.noNullElements(new Object[] { name, loc, permission, desc }, "Arguments can't be null!");
		final Warp warp = this.createWarp(name, loc, permission, desc);
		this.addWarp(warp);
		return warp;
	}

	@Override
	public void removeWarp(final Warp warp) throws NullPointerException
	{
		this.removeWarp(warp.getName());
	}

	@Override
	public Warp removeWarp(final String name) throws NullPointerException
	{
		Validate.noNullElements(new Object[] { name }, "Arguments can't be null!");
		return this.warps.remove(name);
	}

	@Override
	public Warp getWarp(final String name) throws NullPointerException
	{
		Validate.noNullElements(new Object[] { name }, "Arguments can't be null!");
		return this.warps.get(name);
	}

	@Override
	public boolean isWarp(final String name) throws NullPointerException
	{
		Validate.noNullElements(new Object[] { name }, "Arguments can't be null!");
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
	public Set<String> getWarpNameListFor(final User user) throws NullPointerException
	{
		Validate.noNullElements(new Object[] { user }, "Arguments can't be null!");
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
	public Collection<Warp> getWarpListFor(final User user) throws NullPointerException
	{
		Validate.noNullElements(new Object[] { user }, "Arguments can't be null!");
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
	public Set<String> getWarpNameListFor(final String permission) throws NullPointerException
	{
		Validate.noNullElements(new Object[] { permission }, "Arguments can't be null!");
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
	public Collection<Warp> getWarpListFor(final String permission) throws NullPointerException
	{
		Validate.noNullElements(new Object[] { permission }, "Arguments can't be null!");
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
	public Warp createWarp(final String name, final Location loc) throws NullPointerException
	{
		return this.createWarp(name, loc, BukkitPLAPI.PERM_DEFAULT, "");
	}

	@Override
	public Warp createWarp(final String name, final Location loc, final String permission) throws NullPointerException
	{
		return this.createWarp(name, loc, permission, "");
	}

	@Override
	public Warp createWarp(final String name, final Location loc, final String permission, final String desc) throws NullPointerException
	{
		Validate.noNullElements(new Object[] { name, loc, permission, desc }, "Arguments can't be null!");
		return new WarpHandler(name, loc, permission, desc);
	}

	@Override
	public void renameWarp(final Warp warp, final String newName) throws NullPointerException
	{
		Validate.noNullElements(new Object[] { warp, newName }, "Arguments can't be null!");
		this.warps.remove(warp.getName());
		this.warps.put(newName, this.createWarp(newName, warp.getLocation(), warp.getPermission(), warp.getDesc()));
	}

	@Override
	public void renameWarp(final String warp, final String newName) throws NullPointerException
	{
		Validate.noNullElements(new Object[] { warp, newName }, "Arguments can't be null!");
		this.renameWarp(this.warps.get(newName), newName);
	}
}
