package pl.bukkit.bukkitpl.api;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.plugin.Plugin;

import pl.bukkit.bukkitpl.BukkitPL;
import pl.bukkit.bukkitpl.HomeManagerHandler;
import pl.bukkit.bukkitpl.PluginManagerHandler;
import pl.bukkit.bukkitpl.WarpManagerHandler;

public class BukkitPLAPI
{
	public static final String PERM_DEFAULT = "BukkitPL.default";
	private static boolean init = false;
	private static UserManager user;
	private static Map<String, PluginManager> plugins = new HashMap<>();

	public static void init()
	{
		if (BukkitPLAPI.init)
		{
			throw new UnsupportedOperationException("API already initialized!");
		}
		BukkitPLAPI.user = BukkitPL.getInstance().getUsersManager();
	}

	/**
	 * Zwraca interface do zarz¹dzania graczami.
	 * 
	 * @return
	 */
	public static UserManager getUserManager()
	{
		return BukkitPLAPI.user;
	}

	/**
	 * Tworzy nowy "HomeManager" niezale¿ny od API (nie jest zapisany w pamiêci
	 * API, ani ¿adne dane nie s¹ zapisywane do configów/baz)
	 * 
	 * @return nowy "HomeManager"
	 */
	public static HomeManager createHomeManager()
	{
		return new HomeManagerHandler();
	}

	/**
	 * Tworzy nowy "WarpManager" niezale¿ny od API (nie jest zapisany w pamiêci
	 * API, ani ¿adne dane nie s¹ zapisywane do configów/baz)
	 * 
	 * @return nowy "WarpManager"
	 */
	public static WarpManager createWarpManager()
	{
		return new WarpManagerHandler();
	}

	/**
	 * Tworzy i zapisuje nowy manager pluginu, za jego pomoc¹ mo¿esz tworzyæ
	 * wszelkie warpy, spawny i u¿ywaæ wszystkich opcji. <br>
	 * Wszystkie dane s¹ automatycznie ³adowane i zapisywane.<br>
	 * <br>
	 * Po stworzeniu mo¿esz zawsze pobraæ manager u¿ywaj¹c: <br>
	 * {@link BukkitPLAPI#getManager(Plugin)} <br>
	 * {@link BukkitPLAPI#getManager(String)} <br>
	 * 
	 * @param plugin
	 *            Instancja twojego pluginu.
	 * @return twój manager.
	 */
	public static PluginManager connectToAPI(final Plugin plugin)
	{
		final String name = plugin.getName();
		if (BukkitPLAPI.plugins.containsKey(name))
		{
			throw new UnsupportedOperationException("Plugin already initialized!");
		}
		final PluginManagerHandler pl = new PluginManagerHandler(plugin);
		BukkitPLAPI.plugins.put(name, pl);
		return pl;
	}

	/**
	 * Pobiera jeden z instniej¹cych managerów.
	 * 
	 * @param plugin
	 *            Instancja pluginu dla którego chcesz pobraæ manager.
	 * @return manager
	 */
	public static PluginManager getManager(final Plugin plugin)
	{
		final String name = plugin.getName();
		if (!BukkitPLAPI.plugins.containsKey(name))
		{
			throw new UnsupportedOperationException("Plugin not initialized!");
		}
		return BukkitPLAPI.plugins.get(name);
	}

	/**
	 * Pobiera jeden z instniej¹cych managerów.
	 * 
	 * @param name
	 *            Nazwa pluginu dla którego chcesz pobraæ manager.
	 * @return manager
	 */
	public static PluginManager getManager(final String name)
	{
		if (!BukkitPLAPI.plugins.containsKey(name))
		{
			throw new UnsupportedOperationException("Plugin not initialized!");
		}
		return BukkitPLAPI.plugins.get(name);
	}
}
