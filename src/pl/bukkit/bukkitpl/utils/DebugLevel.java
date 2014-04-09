package pl.bukkit.bukkitpl.utils;

/**
 * Enum od poziomów debugu.
 * 
 * @author BukkitSmerf
 * 
 */
public enum DebugLevel
{
	NONE(0), BASIC(1), SMALL(2), MEDIUM(3), HUGE(4), PRO(5);
	private int level;

	DebugLevel(final int level)
	{
		this.level = level;
	}

	/**
	 * Pobiera liczbow¹ wersje poziomu debugu.
	 * 
	 * @return
	 */
	public int getLevel()
	{
		return this.level;
	}

	private static DebugLevel debug = DebugLevel.NONE;

	/**
	 * Ustawia aktualny poziom debugu.
	 * 
	 * @param debug
	 *            nowy poziom.
	 */
	public static void setDebugLevel(final DebugLevel debug)
	{
		DebugLevel.debug = debug;
	}

	/**
	 * Zwraca aktualny poziom debugu.
	 * 
	 * @return aktualny poziom debugu.
	 */
	public static DebugLevel getDebugLevel()
	{
		return DebugLevel.debug;
	}
}