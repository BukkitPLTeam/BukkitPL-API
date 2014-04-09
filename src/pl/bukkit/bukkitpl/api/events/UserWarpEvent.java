package pl.bukkit.bukkitpl.api.events;

import org.bukkit.event.Cancellable;

import pl.bukkit.bukkitpl.User;
import pl.bukkit.bukkitpl.api.Warp;

public class UserWarpEvent extends UserEvent implements Cancellable
{
	protected Warp warp;
	protected boolean cancelled;

	public UserWarpEvent(final User user, final Warp warp)
	{
		super(user);
		this.warp = warp;
	}

	public Warp getWarp()
	{
		return this.warp;
	}

	public void setWarp(final Warp warp)
	{
		this.warp = warp;
	}

	@Override
	public boolean isCancelled()
	{
		return this.cancelled;
	}

	@Override
	public void setCancelled(final boolean cancelled)
	{
		this.cancelled = cancelled;
	}

}
