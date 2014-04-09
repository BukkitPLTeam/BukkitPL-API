package pl.bukkit.bukkitpl.api;

import pl.bukkit.bukkitpl.User;
import pl.bukkit.bukkitpl.UserManagerHandler;

/**
 * Interface do zarz¹dzania graczami. <br>
 * realizowany przez {@link UserManagerHandler}
 * 
 * @author BukkitSmerf
 * 
 */
public interface UserManager
{
	/**
	 * Pobiera gracza z listy aktualnie dostêpnych (online) graczy.
	 * 
	 * @param nickname
	 *            nick gracza do pobrania.
	 * @return instancje gracza lub null
	 */
	public User getOnlineUser(final String nickname);

	/**
	 * Tworzy nowego gracza i zwraca jego instancje daj¹c mo¿liwoœæ
	 * skonfigurowania jego ustawien.<br>
	 * Zmiany nie zostan¹ automatycznie zapisane, musisz to zrobiæ sam.<br>
	 * <br>
	 * Jeœli gracz ju¿ istnieje, rejestracia siê nie powiedzie a metoda zwróci
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
	 * @return true jeœli taki gracz istnieje i zosta³ usuniêty, false w ka¿dym
	 *         innym wypadku.
	 */
	public boolean removeUser(final String nickname);

	/**
	 * Usuwa gracza (Z servera, wszystkie jego pliki itp)
	 * 
	 * @param user
	 *            gracz do skasowania.
	 * @return true jeœli taki gracz istnieje i zosta³ usuniêty, false w ka¿dym
	 *         innym wypadku.
	 */
	public boolean removeUser(final User user);

	/**
	 * Resetuje konto gracza (usuwa i tworzy na nowo)
	 * 
	 * @param nickname
	 *            nick gracza do zresetowania.
	 * @return true jeœli taki gracz istnieje i zosta³ zresetowany, false w
	 *         ka¿dym
	 *         innym wypadku.
	 */
	public boolean resetUser(final String nickname);

	/**
	 * Resetuje konto gracza (usuwa i tworzy na nowo)
	 * 
	 * @param user
	 *            gracz do zresetowania.
	 * @return true jeœli taki gracz istnieje i zosta³ zresetowany, false w
	 *         ka¿dym
	 *         innym wypadku.
	 */
	public boolean resetUser(final User user);
}
