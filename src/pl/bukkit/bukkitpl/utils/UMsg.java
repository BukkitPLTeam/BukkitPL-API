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
 * Klasa zaweraj¹ca przydatne metody do wysy³ania wiadomoœci, kolorowania ich
 * oraz zawera metody od logów BukkitPL
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
	 * Zamienia kody kolorów z & na poprawne, oraz wysy³a wiadomoœæ do wybranego
	 * gracza.
	 * 
	 * @param m
	 *            wiadomoœc do wys³ania.
	 * @param s
	 *            cel.
	 * @return czy uda³o sie wys³aæ.
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
	 * Zamienia kody kolorów z & na poprawne, oraz wysy³a wiadomoœæ do wybranego
	 * gracza.
	 * 
	 * @param m
	 *            wiadomoœc do wys³ania.
	 * @param s
	 *            cel.
	 * @return czy uda³o sie wys³aæ.
	 */
	public static boolean fixAndSend(final String m, final User u)
	{
		return UMsg.fixAndSend(m, u.getPlayer());
	}

	/**
	 * Zmienia kodowanie kolorów z & na poprawne.
	 * 
	 * @param msg
	 *            wiadomoœæ do "poprawienia"
	 * @return gotowa wiadomoœæ.
	 */
	public static String fixColors(final String msg)
	{
		return ChatColor.translateAlternateColorCodes('&', msg);
	}

	/**
	 * Zmienia kodowanie kolorów z & na poprawne, oraz poprawia znaczniki nowej
	 * lini (\n)
	 * 
	 * @param msg
	 *            wiadomoœæ do "poprawienia"
	 * @return gotowa wiadomoœæ.
	 */
	public static String fixMsg(final String msg)
	{
		return UMsg.fixColors(msg).replace("\\n", "\n");
	}

	/**
	 * Odwrotnoœæ {@link UMsg#listToMsg(List)} <br>
	 * <br>
	 * Zmienia wielo liniow¹ wiadomoœæ na listê, gdzie ka¿dy element to jedna
	 * linijka wiadomoœci.<br>
	 * (Dzieli wiadomoœæ na czeœci w miejscach wystêpowania '\n' czyli nowej
	 * lini)
	 * 
	 * @param msg
	 *            wiadomoœæ do zmienienia.
	 * @return gotowa lista.
	 */
	public static List<String> msgToList(final String msg)
	{
		return Arrays.asList(StringUtils.split("\\n"));
	}

	/**
	 * Odwrotnoœæ {@link UMsg#msgToList(String)} <br>
	 * <br>
	 * Zmienia listê wiadomoœci w jedn¹ wiadomoœæ, gdzie ka¿dy element z listy
	 * jest w nowej lini.<br>
	 * U¿ywa {@link StringUtils#join(java.util.Collection, String)}
	 * 
	 * 
	 * @param list
	 *            lista do z³¹czenia.
	 * @return gotowa wiadomoœæ.
	 */
	public static String listToMsg(final List<String> list)
	{
		return StringUtils.replace(StringUtils.join(list, "\n"), "\\n", "\n");
	}

}
