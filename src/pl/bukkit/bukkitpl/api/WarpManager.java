package pl.bukkit.bukkitpl.api;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.bukkit.Location;

import pl.bukkit.bukkitpl.User;
import pl.bukkit.bukkitpl.WarpManagerHandler;

/**
 * Interface do zarz¹dzania warpami. <br>
 * realizowany przez {@link WarpManagerHandler}
 * 
 * @author BukkitSmerf
 * 
 */
public interface WarpManager
{
	/**
	 * Dodaje nowego warpa.
	 * 
	 * @param warp
	 *            Warp do dodania
	 */
	public void addWarp(final Warp warp);

	/**
	 * Tworzy i dodaje (do listy/managera) nowego warpa, mo¿esz ustawic wymagane
	 * permissions które
	 * zostanie uwzglêdnione podczas uzycia
	 * {@link WarpManager#getWarpListFor(User)} itp.<br>
	 * By dodaæ permissions u¿yj
	 * {@link WarpManager#createAndAddWarp(String, Location, String)}
	 * 
	 * @param name
	 *            nazwa warpa
	 * @param loc
	 *            lokalizacja warpa
	 * @return stworzony warp
	 */
	public Warp createAndAddWarp(final String name, final Location loc);

	/**
	 * Tworzy i dodaje (do listy/managera) nowego warpa, mo¿esz ustawic wymagane
	 * permissions które
	 * zostanie uwzglêdnione podczas uzycia
	 * {@link WarpManager#getWarpListFor(User)} itp.
	 * 
	 * @param name
	 *            nazwa warpa.
	 * @param loc
	 *            lokalizacja warpa.
	 * @param permission
	 *            Uprawnienie warpa.
	 * @return stworzony warp
	 */
	public Warp createAndAddWarp(final String name, final Location loc, final String permission);

	/**
	 * Tworzy nowego warpa, mo¿esz ustawic wymagane permissions. (Nie jest ono w
	 * ¿aden sposób sprawdzane, to tylko dla ciebie)<br>
	 * {@link WarpManager#createWarp(String, Location, String)}
	 * 
	 * @param name
	 *            nazwa warpa
	 * @param loc
	 *            lokalizacja warpa
	 * @return stworzony warp
	 */
	public Warp createWarp(final String name, final Location loc);

	/**
	 * Tworzy nowego warpa, mo¿esz ustawic wymagane permissions. (Nie jest ono w
	 * ¿aden sposób sprawdzane, to tylko dla ciebie)
	 * 
	 * @param name
	 *            nazwa warpa.
	 * @param loc
	 *            lokalizacja warpa.
	 * @param permission
	 *            Uprawnienie warpa.
	 * @return stworzony warp
	 */
	public Warp createWarp(final String name, final Location loc, final String permission);

	/**
	 * Usuwa wybranego warpa.
	 * 
	 * @param warp
	 */
	public void removeWarp(final Warp warp);

	/**
	 * Usuwa warpa o wybranej nazwie.
	 * 
	 * @param name
	 * @return usuniêty warp lub null jeœli nie by³o takiego warpa.
	 */
	public Warp removeWarp(final String name);

	/**
	 * Pobiera warpa z listy, mo¿e zwróciæ null (jeœli nie ma takiego warpa).
	 * 
	 * @param name
	 * @return warp lub null
	 */
	public Warp getWarp(final String name);

	/**
	 * Sprawdza czy warp o podanej nazwie znajduje siê na liœcie.
	 * 
	 * @param name
	 * @return true jeœli siê znajduje.
	 */
	public boolean isWarp(final String name);

	/**
	 * @return Zwraca listê wszystkich nazw warpów.
	 */
	public Set<String> getWarpNameList();

	/**
	 * @return Zwraca listê wszystkich warów
	 */
	public Collection<Warp> getWarpList();

	/**
	 * Zwraca listê wszystkich nazw warpów do których permissions ma wybrany
	 * gracz.
	 * 
	 * @param user
	 *            gracz
	 * @return lista nazw warpów
	 */
	public Set<String> getWarpNameListFor(final User user);

	/**
	 * Zwraca listê wszystkich warpów do których permissions ma wybrany
	 * gracz.
	 * 
	 * @param user
	 *            gracz
	 * @return lista warpów
	 */
	public Collection<Warp> getWarpListFor(final User user);

	/**
	 * @return Zwraca pe³n¹ mapê warpów - zmiany dokonane na tej mapie obejm¹
	 *         te¿ jej orygina³!
	 */
	public Map<String, Warp> getWarps();

	//TODO reszta potem, nie mam czasu :D

	public Set<String> getWarpNameListFor(final String permission);

	public Collection<Warp> getWarpListFor(final String permission);
}
