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
	 */
	public void addWarp(final Warp warp);

	/**
	 * Tworzy i dodaje (do listy/managera) nowego warpa, mo�esz ustawic wymagane
	 * permissions kt�re
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
	 */
	public Warp createAndAddWarp(final String name, final Location loc);

	/**
	 * Tworzy i dodaje (do listy/managera) nowego warpa, mo�esz ustawic wymagane
	 * permissions kt�re
	 * zostanie uwzgl�dnione podczas uzycia
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
	 * Tworzy nowego warpa, mo�esz ustawic wymagane permissions. (Nie jest ono w
	 * �aden spos�b sprawdzane, to tylko dla ciebie)<br>
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
	 * Tworzy nowego warpa, mo�esz ustawic wymagane permissions. (Nie jest ono w
	 * �aden spos�b sprawdzane, to tylko dla ciebie)
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
	 * @return usuni�ty warp lub null je�li nie by�o takiego warpa.
	 */
	public Warp removeWarp(final String name);

	/**
	 * Pobiera warpa z listy, mo�e zwr�ci� null (je�li nie ma takiego warpa).
	 * 
	 * @param name
	 * @return warp lub null
	 */
	public Warp getWarp(final String name);

	/**
	 * Sprawdza czy warp o podanej nazwie znajduje si� na li�cie.
	 * 
	 * @param name
	 * @return true je�li si� znajduje.
	 */
	public boolean isWarp(final String name);

	/**
	 * @return Zwraca list� wszystkich nazw warp�w.
	 */
	public Set<String> getWarpNameList();

	/**
	 * @return Zwraca list� wszystkich war�w
	 */
	public Collection<Warp> getWarpList();

	/**
	 * Zwraca list� wszystkich nazw warp�w do kt�rych permissions ma wybrany
	 * gracz.
	 * 
	 * @param user
	 *            gracz
	 * @return lista nazw warp�w
	 */
	public Set<String> getWarpNameListFor(final User user);

	/**
	 * Zwraca list� wszystkich warp�w do kt�rych permissions ma wybrany
	 * gracz.
	 * 
	 * @param user
	 *            gracz
	 * @return lista warp�w
	 */
	public Collection<Warp> getWarpListFor(final User user);

	/**
	 * @return Zwraca pe�n� map� warp�w - zmiany dokonane na tej mapie obejm�
	 *         te� jej orygina�!
	 */
	public Map<String, Warp> getWarps();

	//TODO reszta potem, nie mam czasu :D

	public Set<String> getWarpNameListFor(final String permission);

	public Collection<Warp> getWarpListFor(final String permission);
}
