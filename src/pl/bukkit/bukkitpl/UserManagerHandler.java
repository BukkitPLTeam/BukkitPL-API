package pl.bukkit.bukkitpl;

import java.util.HashMap;

import pl.bukkit.bukkitpl.api.UserManager;

public class UserManagerHandler implements UserManager
{
	UserManagerHandler()
	{}

	private final HashMap<String, User> players = new HashMap<>();

	@Override
	public User getOnlineUser(final String nickname)
	{
		return this.players.get(nickname);
	}

	@Override
	public User registerUser(final String nickname)
	{
		throw new UnsupportedOperationException("Metoda nie gotowa.");
	}

	@Override
	public boolean removeUser(final String nickname)
	{
		throw new UnsupportedOperationException("Metoda nie gotowa.");
	}

	@Override
	public boolean removeUser(final User user)
	{
		throw new UnsupportedOperationException("Metoda nie gotowa.");
	}

	@Override
	public boolean resetUser(final String nickname)
	{
		throw new UnsupportedOperationException("Metoda nie gotowa.");
	}

	@Override
	public boolean resetUser(final User user)
	{
		throw new UnsupportedOperationException("Metoda nie gotowa.");
	}
}
