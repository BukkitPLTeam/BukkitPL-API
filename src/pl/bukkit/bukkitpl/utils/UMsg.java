package pl.bukkit.bukkitpl.utils;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import pl.bukkit.bukkitpl.User;

/**
 * Klasa zaweraj�ca przydatne metody do wysy�ania wiadomo�ci, kolorowania ich
 * oraz zawera metody od log�w BukkitPL
 * 
 * @author BukkitSmerf
 * 
 */
public class UMsg
{
	private static final ConsoleCommandSender console = Bukkit.getConsoleSender();

	public static void log(final String string)
	{
		UMsg.fixAndSend("&4[&bBukkitPL&4][&aINFO&4]&r " + string, UMsg.console);
	}

	public static void warn(final String string)
	{
		UMsg.fixAndSend("&4[&bBukkitPL&4][&cWARNING&4]&r " + string, UMsg.console);
	}

	public static void debug(final String string, final DebugLevel level)
	{
		if (level.getLevel() <= DebugLevel.getDebugLevel().getLevel())
		{
			UMsg.fixAndSend("&4[&bBukkitPL&4][&9DEBUG &c(" + level.getLevel() + ")&4]&r " + string, UMsg.console);
		}
	}

	public static void debug(final String prefix, final String string, final DebugLevel level)
	{
		UMsg.debug("&4[&3" + prefix + "&4]&r " + string, level);
	}

	/**
	 * Zamienia kody kolor�w z & na poprawne, oraz wysy�a wiadomo�� do wybranego
	 * gracza.
	 * 
	 * @param m
	 *            wiadomo�c do wys�ania.
	 * @param s
	 *            cel.
	 * @return czy uda�o sie wys�a�.
	 */
	public static boolean fixAndSend(final String m, final CommandSender s)
	{
		try
		{
			s.sendMessage(UMsg.fixMsg(m));
			return true;
		} catch (final Exception e)
		{
			return false;
		}
	}

	/**
	 * Zamienia kody kolor�w z & na poprawne, oraz wysy�a wiadomo�� do wybranego
	 * gracza.
	 * 
	 * @param m
	 *            wiadomo�c do wys�ania.
	 * @param s
	 *            cel.
	 * @return czy uda�o sie wys�a�.
	 */
	public static boolean fixAndSend(final String m, final User u)
	{
		return UMsg.fixAndSend(m, u.getPlayer());
	}

	/**
	 * Zmienia kodowanie kolor�w z & na poprawne.
	 * 
	 * @param msg
	 *            wiadomo�� do "poprawienia"
	 * @return gotowa wiadomo��.
	 */
	public static String fixColors(final String msg)
	{
		return ChatColor.translateAlternateColorCodes('&', msg);
	}

	/**
	 * Zmienia kodowanie kolor�w z & na poprawne, oraz poprawia znaczniki nowej
	 * lini (\n)
	 * 
	 * @param msg
	 *            wiadomo�� do "poprawienia"
	 * @return gotowa wiadomo��.
	 */
	public static String fixMsg(final String msg)
	{
		return UMsg.fixColors(msg).replace("\\n", "\n");
	}

	/**
	 * Odwrotno�� {@link UMsg#listToMsg(List)} <br>
	 * <br>
	 * Zmienia wielo liniow� wiadomo�� na list�, gdzie ka�dy element to jedna
	 * linijka wiadomo�ci.<br>
	 * (Dzieli wiadomo�� na cze�ci w miejscach wyst�powania '\n' czyli nowej
	 * lini)
	 * 
	 * @param msg
	 *            wiadomo�� do zmienienia.
	 * @return gotowa lista.
	 */
	public static List<String> msgToList(final String msg)
	{
		return Arrays.asList(StringUtils.split("\\n"));
	}

	/**
	 * Odwrotno�� {@link UMsg#msgToList(String)} <br>
	 * <br>
	 * Zmienia list� wiadomo�ci w jedn� wiadomo��, gdzie ka�dy element z listy
	 * jest w nowej lini.<br>
	 * U�ywa {@link StringUtils#join(java.util.Collection, String)}
	 * 
	 * 
	 * @param list
	 *            lista do z��czenia.
	 * @return gotowa wiadomo��.
	 */
	public static String listToMsg(final List<String> list)
	{
		return StringUtils.replace(StringUtils.join(list, "\n"), "\\n", "\n");
	}

}
