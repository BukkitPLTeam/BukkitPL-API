package pl.bukkit.bukkitpl.api;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.bukkit.Location;

import pl.bukkit.bukkitpl.User;
import pl.bukkit.bukkitpl.WarpManagerHandler;

/**
 * Interface do zarz�dzania warpami. <br>
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
	 *             Je�li jaki� z argument�w jest null.
	 */
	public void addWarp(final Warp warp) throws NullPointerException;

	/**
	 * Tworzy i dodaje (do listy/managera) nowego warpa, mo�esz ustawic wymagane
	 * uprawnienie kt�re
	 * zostanie uwzgl�dnione podczas uzycia
	 * {@link WarpManager#getWarpListFor(User)} itp.<br>
	 * By doda� permissions u�yj
	 * {@link WarpManager#createAndAddWarp(String, Location, String)}
	 * 
	 * @param name
	 *            nazwa warpa
	 * @param loc
	 *            lokalizacja warpa
	 * @return stworzony warp
	 * @throws NullPointerException
	 *             Je�li jaki� z argument�w jest null.
	 */
	public Warp createAndAddWarp(final String name, final Location loc) throws NullPointerException;

	/**
	 * Tworzy i dodaje (do listy/managera) nowego warpa, mo�esz ustawic wymagane
	 * uprawnienie kt�re
	 * zostanie uwzgl�dnione podczas uzycia
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
	 *             Je�li jaki� z argument�w jest null.
	 */
	public Warp createAndAddWarp(final String name, final Location loc, final String permission) throws NullPointerException;

	/**
	 * Tworzy i dodaje (do listy/managera) nowego warpa, mo�esz ustawic wymagane
	 * uprawnienie kt�re
	 * zostanie uwzgl�dnione podczas uzycia
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
	 *             Je�li jaki� z argument�w jest null.
	 */
	public Warp createAndAddWarp(final String name, final Location loc, final String permission, final String desc) throws NullPointerException;

	/**
	 * Tworzy nowego warpa, mo�esz ustawic wymagane uprawnienie. (Nie jest ono w
	 * �aden spos�b sprawdzane, to tylko dla ciebie)<br>
	 * {@link WarpManager#createWarp(String, Location, String)}
	 * 
	 * @param name
	 *            nazwa warpa
	 * @param loc
	 *            lokalizacja warpa
	 * @return stworzony warp.
	 * @throws NullPointerException
	 *             Je�li jaki� z argument�w jest null.
	 */
	public Warp createWarp(final String name, final Location loc) throws NullPointerException;

	/**
	 * Tworzy nowego warpa, mo�esz ustawic wymagane uprawnienie. (Nie jest ono w
	 * �aden spos�b sprawdzane, to tylko dla ciebie)
	 * 
	 * @param name
	 *            nazwa warpa.
	 * @param loc
	 *            lokalizacja warpa.
	 * @param permission
	 *            Uprawnienie warpa.
	 * @return stworzony warp.
	 * @throws NullPointerException
	 *             Je�li jaki� z argument�w jest null.
	 */
	public Warp createWarp(final String name, final Location loc, final String permission) throws NullPointerException;

	/**
	 * Tworzy nowego warpa, mo�esz ustawic wymagane uprawnienie. (Nie jest ono w
	 * �aden spos�b sprawdzane, to tylko dla ciebie)
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
	 *             Je�li jaki� z argument�w jest null.
	 */
	public Warp createWarp(final String name, final Location loc, final String permission, final String desc) throws NullPointerException;

	/**
	 * Usuwa wybranego warpa.
	 * 
	 * @param warp
	 *            .
	 * @throws NullPointerException
	 *             Je�li jaki� z argument�w jest null.
	 */
	public void removeWarp(final Warp warp) throws NullPointerException;

	/**
	 * Usuwa warpa o wybranej nazwie.
	 * 
	 * @param name
	 * @return usuni�ty warp lub null je�li nie by�o takiego warpa.
	 */
	public Warp removeWarp(final String name) throws NullPointerException;

	/**
	 * Pobiera warpa z listy, mo�e zwr�ci� null (je�li nie ma takiego warpa).
	 * 
	 * @param name
	 * @return warp lub null.
	 * @throws NullPointerException
	 *             Je�li jaki� z argument�w jest null.
	 */
	public Warp getWarp(final String name) throws NullPointerException;

	/**
	 * Sprawdza czy warp o podanej nazwie znajduje si� na li�cie.
	 * 
	 * @param name
	 * @return true je�li si� znajduje.
	 * @throws NullPointerException
	 *             Je�li jaki� z argument�w jest null.
	 */
	public boolean isWarp(final String name) throws NullPointerException;

	/**
	 * @return Zwraca list� wszystkich nazw warp�w.
	 */
	public Set<String> getWarpNameList();

	/**
	 * @return Zwraca list� wszystkich war�w
	 */
	public Collection<Warp> getWarpList();

	/**
	 * Zwraca list� wszystkich nazw warp�w do kt�rych uprawnienie ma wybrany
	 * gracz.
	 * 
	 * @param user
	 *            gracz
	 * @return lista nazw warp�w
	 * @throws NullPointerException
	 *             Je�li jaki� z argument�w jest null.
	 */
	public Set<String> getWarpNameListFor(final User user) throws NullPointerException;

	/**
	 * Zwraca list� wszystkich warp�w do kt�rych uprawnienie ma wybrany
	 * gracz.
	 * 
	 * @param user
	 *            gracz
	 * @return lista warp�w
	 * @throws NullPointerException
	 *             Je�li jaki� z argument�w jest null.
	 */
	public Collection<Warp> getWarpListFor(final User user) throws NullPointerException;

	/**
	 * @return Zwraca pe�n� map� warp�w - zmiany dokonane na tej mapie obejm�
	 *         te� jej orygina�!
	 */
	public Map<String, Warp> getWarps();

	/**
	 * Zwraca list� nazw warp�w z wybranym wymaganym uprawnieniem.
	 * 
	 * @param permission
	 *            wymagane uprawnienie.
	 * @return lista nazw warp�w z tym uprawnieniem.
	 * @throws NullPointerException
	 *             Je�li jaki� z argument�w jest null.
	 */
	public Set<String> getWarpNameListFor(final String permission) throws NullPointerException;

	/**
	 * Zwraca list� warp�w z wybranym wymaganym uprawnieniem.
	 * 
	 * @param permission
	 *            wymagane uprawnienie.
	 * @return lista warp�w z tym uprawnieniem.
	 * @throws NullPointerException
	 *             Je�li jaki� z argument�w jest null.
	 */
	public Collection<Warp> getWarpListFor(final String permission) throws NullPointerException;

	/**
	 * Zmienia nazw� wybranego warpa.
	 * 
	 * @param warp
	 *            warp kt�rego nazw� chcemy zmieni�.
	 * @param newName
	 *            nowa nazwa warpa.
	 * @throws NullPointerException
	 *             Je�li jaki� z argument�w jest null.
	 */
	public void renameWarp(final Warp warp, final String newName) throws NullPointerException;

	/**
	 * Zmienia nazw� wybranego warpa.
	 * 
	 * @param warp
	 *            nazwa warpa kt�rego nazw� chcemy zmieni�.
	 * @param newName
	 *            nowa nazwa warpa.
	 * @throws NullPointerException
	 *             Je�li jaki� z argument�w jest null.
	 */
	public void renameWarp(final String warp, final String newName) throws NullPointerException;
}
