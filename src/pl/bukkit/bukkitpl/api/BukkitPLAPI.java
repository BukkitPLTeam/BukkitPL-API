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
	 * Zwraca interface do zarz�dzania graczami.
	 * 
	 * @return
	 */
	public static UserManager getUserManager()
	{
		return BukkitPLAPI.user;
	}

	/**
	 * Tworzy nowy "HomeManager" niezale�ny od API (nie jest zapisany w pami�ci
	 * API, ani �adne dane nie s� zapisywane do config�w/baz)
	 * 
	 * @return nowy "HomeManager"
	 */
	public static HomeManager createHomeManager()
	{
		return new HomeManagerHandler();
	}

	/**
	 * Tworzy nowy "WarpManager" niezale�ny od API (nie jest zapisany w pami�ci
	 * API, ani �adne dane nie s� zapisywane do config�w/baz)
	 * 
	 * @return nowy "WarpManager"
	 */
	public static WarpManager createWarpManager()
	{
		return new WarpManagerHandler();
	}

	/**
	 * Tworzy i zapisuje nowy manager pluginu, za jego pomoc� mo�esz tworzy�
	 * wszelkie warpy, spawny i u�ywa� wszystkich opcji. <br>
	 * Wszystkie dane s� automatycznie �adowane i zapisywane.<br>
	 * <br>
	 * Po stworzeniu mo�esz zawsze pobra� manager u�ywaj�c: <br>
	 * {@link BukkitPLAPI#getManager(Plugin)} <br>
	 * {@link BukkitPLAPI#getManager(String)} <br>
	 * 
	 * @param plugin
	 *            Instancja twojego pluginu.
	 * @return tw�j manager.
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
	 * Pobiera jeden z instniej�cych manager�w.
	 * 
	 * @param plugin
	 *            Instancja pluginu dla kt�rego chcesz pobra� manager.
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
	 * Pobiera jeden z instniej�cych manager�w.
	 * 
	 * @param name
	 *            Nazwa pluginu dla kt�rego chcesz pobra� manager.
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
