package pl.bukkit.bukkitpl.utils;

import java.util.Random;

import org.apache.commons.lang.Validate;

/**
 * Klasa zawieraj�ca przydatne metody zwi�zanie z liczeniem czy losowaniem
 * liczb.
 * 
 * @author BukkitSmerf
 * 
 */
public class UMath
{
	private static final Random rand = new Random();

	/**
	 * Zwraca losow� liczb� typu int z wybranego przedzia�u. <br>
	 * 
	 * np: <br>
	 * <br>
	 * getRandInt(-2, 3) mo�e wylosowa� liczby od -2 do 3 czyli jedn� z {-2, -1,
	 * 0, 1, 2, 3} <br>
	 * 
	 * 
	 * @param min
	 *            minimalna liczba (w��cznie)
	 * @param max
	 *            maksymalna liczba (w��cznie)
	 * @return wynik losowania
	 * @throws IllegalArgumentException
	 *             je�li liczba minimalna jest wi�ksza od maksymalnej.
	 */
	public static int getRandInt(final int min, final int max) throws IllegalArgumentException
	{
		Validate.isTrue(max > min, "Max can't be smaller than min!");
		return UMath.rand.nextInt((max - min) + 1) + min;
	}

	/**
	 * Zwraca losow� liczb� typu double (zmiennoprzecinkowa) z wybranego
	 * przedzia�u. <br>
	 * 
	 * np: <br>
	 * <br>
	 * getRandDouble(-0.5, 0.5) mo�e wylosowa� liczby od -0.5 do 0.5 np
	 * 0.34366745346764 <br>
	 * 
	 * 
	 * @param min
	 *            minimalna liczba (w��cznie)
	 * @param max
	 *            maksymalna liczba (w��cznie)
	 * @return wynik losowania
	 * @throws IllegalArgumentException
	 *             je�li liczba minimalna jest wi�ksza od maksymalnej.
	 */
	public static double getRandDouble(final double min, final double max) throws IllegalArgumentException
	{
		Validate.isTrue(max > min, "Max can't be smaller than min!");
		return (UMath.rand.nextDouble() * (max - min)) + min;
	}

	/**
	 * Zwraca losow� liczb� typu float (zmiennoprzecinkowa) z wybranego
	 * przedzia�u. <br>
	 * 
	 * np: <br>
	 * <br>
	 * getRandFloat(-0.5, 0.5) mo�e wylosowa� liczby od -0.5 do 0.5 np
	 * 0.34366745 <br>
	 * 
	 * 
	 * @param min
	 *            minimalna liczba (w��cznie)
	 * @param max
	 *            maksymalna liczba (w��cznie)
	 * @return wynik losowania
	 * @throws IllegalArgumentException
	 *             je�li liczba minimalna jest wi�ksza od maksymalnej.
	 */
	public static float getRandFloat(final float min, final float max) throws IllegalArgumentException
	{
		Validate.isTrue(max > min, "Max can't be smaller than min!");
		return (UMath.rand.nextFloat() * (max - min)) + min;
	}

	/**
	 * Umo�liwia proste wykonanie losowej szansy, wystraczy poda� szanse na
	 * udane losowanie w %, a metoda zwr�ci true lub false w zale�no�ci od
	 * wyniku "losowania"<br>
	 * np: <br>
	 * <br>
	 * getChance(12,5d) 12,5% na wylosowanie prawdy, podanie argumentu wi�kszego
	 * od 100 spowoduje natychmiastowe zwr�cenie prawdy z pomini�ciem losowania.
	 * 
	 * @param chance
	 *            szansa na zwr�cenie true w procentach.
	 * @return true lub false w zale�no�ci od wyniku losowania
	 */
	public static boolean getChance(final double chance)
	{
		return (chance >= 100) || (chance >= UMath.getRandDouble(0, 100));
	}
}
