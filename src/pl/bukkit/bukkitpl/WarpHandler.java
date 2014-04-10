package pl.bukkit.bukkitpl;

import org.apache.commons.lang.Validate;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import pl.bukkit.bukkitpl.api.BukkitPLAPI;
import pl.bukkit.bukkitpl.api.Warp;

/**
 * Klasa do zarz¹dzania pojedynczym warpem, realizacja {@link Warp}
 * 
 * @author BukkitSmerf
 * 
 */
public class WarpHandler implements Warp
{
	private final String name;
	private Location loc;
	private String permission, desc;

	public WarpHandler(final String name, final Location loc, final String permission, final String desc)
	{
		Validate.noNullElements(new Object[] { name, loc, permission, desc }, "Arguments can't be null!");
		this.name = name;
		this.loc = loc;
		this.permission = permission;
		this.desc = desc;
	}

	public WarpHandler(final String name, final Location loc)
	{
		this(name, loc, BukkitPLAPI.PERM_DEFAULT, "");
	}

	@Override
	public Location getLocation()
	{
		return this.loc;
	}

	@Override
	public String getPermission()
	{
		return this.permission;
	}

	@Override
	public boolean teleport(final User user)
	{
		return this.teleport(user.getPlayer());
	}

	@Override
	public boolean teleport(final Entity entity)
	{
		return entity.teleport(this.loc);
	}

	@Override
	public void setLocation(final Location loc)
	{
		this.loc = loc;
	}

	@Override
	public void setPermission(final String permission)
	{
		this.permission = permission;
	}

	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public String getDesc()
	{
		return this.desc;
	}

	@Override
	public void setDesc(final String desc)
	{
		this.desc = desc;
	}

	@Override
	public boolean hasPermission(final User user)
	{
		return user.hasPermission(this.permission);
	}

	@Override
	public boolean hasPermission(final Player player)
	{
		return player.hasPermission(this.permission);
	}
}
