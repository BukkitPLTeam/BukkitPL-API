package pl.bukkit.bukkitpl;

import org.bukkit.plugin.java.JavaPlugin;

import pl.bukkit.bukkitpl.utils.UMsg;

/**
 * Main class
 * 
 * @author BukkitSmerf
 * @author ElDzi
 * 
 */
public class BukkitPL extends JavaPlugin
{
	private static BukkitPL instance;
	private UserManagerHandler users;

	public static BukkitPL getInstance()
	{
		return BukkitPL.instance;
	}

	@Override
	public void onEnable()
	{
		this.initManagers();
		UMsg.log("API aktywowane");
	}

	private void initManagers()
	{
		this.users = new UserManagerHandler();
	}

	public UserManagerHandler getUsersManager()
	{
		return this.users;
	}
}
