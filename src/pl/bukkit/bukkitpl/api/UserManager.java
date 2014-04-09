package pl.bukkit.bukkitpl.api;

import pl.bukkit.bukkitpl.User;
import pl.bukkit.bukkitpl.UserManagerHandler;

/**
 * Interface do zarz�dzania graczami. <br>
 * realizowany przez {@link UserManagerHandler}
 * 
 * @author BukkitSmerf
 * 
 */
public interface UserManager
{
	/**
	 * Pobiera gracza z listy aktualnie dost�pnych (online) graczy.
	 * 
	 * @param nickname
	 *            nick gracza do pobrania.
	 * @return instancje gracza lub null
	 */
	public User getOnlineUser(final String nickname);

	/**
	 * Tworzy nowego gracza i zwraca jego instancje daj�c mo�liwo��
	 * skonfigurowania jego ustawien.<br>
	 * Zmiany nie zostan� automatycznie zapisane, musisz to zrobi� sam.<br>
	 * <br>
	 * Je�li gracz ju� istnieje, rejestracia si� nie powiedzie a metoda zwr�ci
	 * null.
	 * 
	 * @param nickname
	 *            nick gracza do stworzenia.
	 * @return Gracz lub null
	 */
	public User registerUser(final String nickname);

	/**
	 * Usuwa gracza (Z servera, wszystkie jego pliki itp)
	 * 
	 * @param nickname
	 *            nick gracza do skasowania.
	 * @return true je�li taki gracz istnieje i zosta� usuni�ty, false w ka�dym
	 *         innym wypadku.
	 */
	public boolean removeUser(final String nickname);

	/**
	 * Usuwa gracza (Z servera, wszystkie jego pliki itp)
	 * 
	 * @param user
	 *            gracz do skasowania.
	 * @return true je�li taki gracz istnieje i zosta� usuni�ty, false w ka�dym
	 *         innym wypadku.
	 */
	public boolean removeUser(final User user);

	/**
	 * Resetuje konto gracza (usuwa i tworzy na nowo)
	 * 
	 * @param nickname
	 *            nick gracza do zresetowania.
	 * @return true je�li taki gracz istnieje i zosta� zresetowany, false w
	 *         ka�dym
	 *         innym wypadku.
	 */
	public boolean resetUser(final String nickname);

	/**
	 * Resetuje konto gracza (usuwa i tworzy na nowo)
	 * 
	 * @param user
	 *            gracz do zresetowania.
	 * @return true je�li taki gracz istnieje i zosta� zresetowany, false w
	 *         ka�dym
	 *         innym wypadku.
	 */
	public boolean resetUser(final User user);
}
