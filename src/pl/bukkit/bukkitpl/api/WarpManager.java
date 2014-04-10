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
	 * @throws NullPointerException
	 *             Jeœli jakiœ z argumentów jest null.
	 */
	public void addWarp(final Warp warp) throws NullPointerException;

	/**
	 * Tworzy i dodaje (do listy/managera) nowego warpa, mo¿esz ustawic wymagane
	 * uprawnienie które
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
	 * @throws NullPointerException
	 *             Jeœli jakiœ z argumentów jest null.
	 */
	public Warp createAndAddWarp(final String name, final Location loc) throws NullPointerException;

	/**
	 * Tworzy i dodaje (do listy/managera) nowego warpa, mo¿esz ustawic wymagane
	 * uprawnienie które
	 * zostanie uwzglêdnione podczas uzycia
	 * {@link WarpManager#getWarpListFor(User)} itp.
	 * 
	 * @param name
	 *            nazwa warpa.
	 * @param loc
	 *            lokalizacja warpa.
	 * @param permission
	 *            Uprawnienie warpa.
	 * @return stworzony warp.
	 * @throws NullPointerException
	 *             Jeœli jakiœ z argumentów jest null.
	 */
	public Warp createAndAddWarp(final String name, final Location loc, final String permission) throws NullPointerException;

	/**
	 * Tworzy i dodaje (do listy/managera) nowego warpa, mo¿esz ustawic wymagane
	 * uprawnienie które
	 * zostanie uwzglêdnione podczas uzycia
	 * {@link WarpManager#getWarpListFor(User)} itp.
	 * 
	 * @param name
	 *            nazwa warpa.
	 * @param loc
	 *            lokalizacja warpa.
	 * @param permission
	 *            Uprawnienie warpa.
	 * @param desc
	 *            opis warpa.
	 * @return stworzony warp.
	 * @throws NullPointerException
	 *             Jeœli jakiœ z argumentów jest null.
	 */
	public Warp createAndAddWarp(final String name, final Location loc, final String permission, final String desc) throws NullPointerException;

	/**
	 * Tworzy nowego warpa, mo¿esz ustawic wymagane uprawnienie. (Nie jest ono w
	 * ¿aden sposób sprawdzane, to tylko dla ciebie)<br>
	 * {@link WarpManager#createWarp(String, Location, String)}
	 * 
	 * @param name
	 *            nazwa warpa
	 * @param loc
	 *            lokalizacja warpa
	 * @return stworzony warp.
	 * @throws NullPointerException
	 *             Jeœli jakiœ z argumentów jest null.
	 */
	public Warp createWarp(final String name, final Location loc) throws NullPointerException;

	/**
	 * Tworzy nowego warpa, mo¿esz ustawic wymagane uprawnienie. (Nie jest ono w
	 * ¿aden sposób sprawdzane, to tylko dla ciebie)
	 * 
	 * @param name
	 *            nazwa warpa.
	 * @param loc
	 *            lokalizacja warpa.
	 * @param permission
	 *            Uprawnienie warpa.
	 * @return stworzony warp.
	 * @throws NullPointerException
	 *             Jeœli jakiœ z argumentów jest null.
	 */
	public Warp createWarp(final String name, final Location loc, final String permission) throws NullPointerException;

	/**
	 * Tworzy nowego warpa, mo¿esz ustawic wymagane uprawnienie. (Nie jest ono w
	 * ¿aden sposób sprawdzane, to tylko dla ciebie)
	 * 
	 * @param name
	 *            nazwa warpa.
	 * @param loc
	 *            lokalizacja warpa.
	 * @param permission
	 *            Uprawnienie warpa.
	 * @param desc
	 *            opis warpa.
	 * @return stworzony warp.
	 * @throws NullPointerException
	 *             Jeœli jakiœ z argumentów jest null.
	 */
	public Warp createWarp(final String name, final Location loc, final String permission, final String desc) throws NullPointerException;

	/**
	 * Usuwa wybranego warpa.
	 * 
	 * @param warp
	 *            .
	 * @throws NullPointerException
	 *             Jeœli jakiœ z argumentów jest null.
	 */
	public void removeWarp(final Warp warp) throws NullPointerException;

	/**
	 * Usuwa warpa o wybranej nazwie.
	 * 
	 * @param name
	 * @return usuniêty warp lub null jeœli nie by³o takiego warpa.
	 */
	public Warp removeWarp(final String name) throws NullPointerException;

	/**
	 * Pobiera warpa z listy, mo¿e zwróciæ null (jeœli nie ma takiego warpa).
	 * 
	 * @param name
	 * @return warp lub null.
	 * @throws NullPointerException
	 *             Jeœli jakiœ z argumentów jest null.
	 */
	public Warp getWarp(final String name) throws NullPointerException;

	/**
	 * Sprawdza czy warp o podanej nazwie znajduje siê na liœcie.
	 * 
	 * @param name
	 * @return true jeœli siê znajduje.
	 * @throws NullPointerException
	 *             Jeœli jakiœ z argumentów jest null.
	 */
	public boolean isWarp(final String name) throws NullPointerException;

	/**
	 * @return Zwraca listê wszystkich nazw warpów.
	 */
	public Set<String> getWarpNameList();

	/**
	 * @return Zwraca listê wszystkich warów
	 */
	public Collection<Warp> getWarpList();

	/**
	 * Zwraca listê wszystkich nazw warpów do których uprawnienie ma wybrany
	 * gracz.
	 * 
	 * @param user
	 *            gracz
	 * @return lista nazw warpów
	 * @throws NullPointerException
	 *             Jeœli jakiœ z argumentów jest null.
	 */
	public Set<String> getWarpNameListFor(final User user) throws NullPointerException;

	/**
	 * Zwraca listê wszystkich warpów do których uprawnienie ma wybrany
	 * gracz.
	 * 
	 * @param user
	 *            gracz
	 * @return lista warpów
	 * @throws NullPointerException
	 *             Jeœli jakiœ z argumentów jest null.
	 */
	public Collection<Warp> getWarpListFor(final User user) throws NullPointerException;

	/**
	 * @return Zwraca pe³n¹ mapê warpów - zmiany dokonane na tej mapie obejm¹
	 *         te¿ jej orygina³!
	 */
	public Map<String, Warp> getWarps();

	/**
	 * Zwraca listê nazw warpów z wybranym wymaganym uprawnieniem.
	 * 
	 * @param permission
	 *            wymagane uprawnienie.
	 * @return lista nazw warpów z tym uprawnieniem.
	 * @throws NullPointerException
	 *             Jeœli jakiœ z argumentów jest null.
	 */
	public Set<String> getWarpNameListFor(final String permission) throws NullPointerException;

	/**
	 * Zwraca listê warpów z wybranym wymaganym uprawnieniem.
	 * 
	 * @param permission
	 *            wymagane uprawnienie.
	 * @return lista warpów z tym uprawnieniem.
	 * @throws NullPointerException
	 *             Jeœli jakiœ z argumentów jest null.
	 */
	public Collection<Warp> getWarpListFor(final String permission) throws NullPointerException;

	/**
	 * Zmienia nazwê wybranego warpa.
	 * 
	 * @param warp
	 *            warp którego nazwê chcemy zmieniæ.
	 * @param newName
	 *            nowa nazwa warpa.
	 * @throws NullPointerException
	 *             Jeœli jakiœ z argumentów jest null.
	 */
	public void renameWarp(final Warp warp, final String newName) throws NullPointerException;

	/**
	 * Zmienia nazwê wybranego warpa.
	 * 
	 * @param warp
	 *            nazwa warpa którego nazwê chcemy zmieniæ.
	 * @param newName
	 *            nowa nazwa warpa.
	 * @throws NullPointerException
	 *             Jeœli jakiœ z argumentów jest null.
	 */
	public void renameWarp(final String warp, final String newName) throws NullPointerException;
}
