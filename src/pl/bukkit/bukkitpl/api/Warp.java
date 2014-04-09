package pl.bukkit.bukkitpl.api;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

import pl.bukkit.bukkitpl.User;

public interface Warp
{
	public Location getLocation();

	public String getPermission();

	public boolean teleport(final User user);

	public boolean teleport(final Entity entity);

	public void setLocation(final Location loc);

	public void setPermission(final String permission);

	public String getName();

	public String getDesc();

	public void setDesc(final String desc);
}
