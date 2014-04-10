package pl.bukkit.bukkitpl.api;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import pl.bukkit.bukkitpl.User;
import pl.bukkit.bukkitpl.WarpHandler;

/**
 * Interface do zarz¹dzania pojedyñczym warpem. <br>
 * realizowany przez {@link WarpHandler}
 * 
 * @author BukkitSmerf
 * 
 */
public interface Warp
{
	/**
	 * @return lokalizacje warpu
	 */
	public Location getLocation();

	/**
	 * @return wymagane uprawnienie.
	 */
	public String getPermission();

	/**
	 * Teleportuje wybranego Usera do lokalizacji tego warpu.
	 * 
	 * @param user
	 *            gracz do przeteleportowania.
	 * @return wynik operacji.
	 */
	public boolean teleport(final User user);

	/**
	 * Teleportuje wybrane {@link Entity} do lokalizacji tego warpu.<br>
	 * ( {@link Player} te¿ jest {@link Entity} )
	 * 
	 * @param entity
	 *            entity do przeteleportowania.
	 * @return wynik operacji.
	 */
	public boolean teleport(final Entity entity);

	/**
	 * Ustawia lokalizacje warpu.
	 * 
	 * @param loc
	 *            nowa lokalizacja.
	 */
	public void setLocation(final Location loc);

	/**
	 * Ustawia nowe wymagane uprawnienie.<br>
	 * Uprawnienie jest u¿ywane tylko podczas pobierania listy warów, musisz sam
	 * sprawdzaæ czy gracz ma uprawnienie w komendzie itp...
	 * 
	 * @param permission
	 *            nowe permissions.
	 */
	public void setPermission(final String permission);

	/**
	 * Sprawdza czy wybrany gracz ma uprawnienie do tego warpa.
	 * 
	 * @param user
	 *            gracz do sprawdzenia.
	 * @return TRUE jeœli ma uprawnienie.
	 */
	public boolean hasPermission(final User user);

	/**
	 * Sprawdza czy wybrany gracz ma uprawnienie do tego warpa.
	 * 
	 * @param user
	 *            gracz do sprawdzenia.
	 * @return TRUE jeœli ma uprawnienie.
	 */
	public boolean hasPermission(final Player player);

	/**
	 * Zwraca nazwê tego warpa.
	 * 
	 * @return nazwa.
	 */
	public String getName();

	/**
	 * Zwraca opis tego warpa.
	 * 
	 * @return opis
	 */
	public String getDesc();

	/**
	 * Ustawia opis tego warpa.
	 * 
	 * @param desc
	 *            nowy opis
	 */
	public void setDesc(final String desc);
}
