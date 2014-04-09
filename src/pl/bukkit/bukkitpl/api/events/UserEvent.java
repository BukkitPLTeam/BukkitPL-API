package pl.bukkit.bukkitpl.api.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import pl.bukkit.bukkitpl.User;

public abstract class UserEvent extends Event
{

	private static final HandlerList handlers = new HandlerList();
	protected User user;

	@Override
	public HandlerList getHandlers()
	{
		return UserEvent.handlers;
	}

	public static HandlerList getHandlerList()
	{
		return UserEvent.handlers;
	}

	public UserEvent(final User user)
	{
		this.user = user;
	}

	public User getUser()
	{
		return this.user;
	}
}
