package pl.bukkit.bukkitpl.utils;

import java.util.Random;

import org.apache.commons.lang.Validate;

/**
 * Klasa zawieraj¹ca przydatne metody zwi¹zanie z liczeniem czy losowaniem
 * liczb.
 * 
 * @author BukkitSmerf
 * 
 */
public class UMath
{
	private static final Random rand = new Random();

	/**
	 * Zwraca losow¹ liczbê typu int z wybranego przedzia³u. <br>
	 * 
	 * np: <br>
	 * <br>
	 * getRandInt(-2, 3) mo¿e wylosowaæ liczby od -2 do 3 czyli jedn¹ z {-2, -1,
	 * 0, 1, 2, 3} <br>
	 * 
	 * 
	 * @param min
	 *            minimalna liczba (w³¹cznie)
	 * @param max
	 *            maksymalna liczba (w³¹cznie)
	 * @return wynik losowania
	 * @throws IllegalArgumentException
	 *             jeœli liczba minimalna jest wiêksza od maksymalnej.
	 */
	public static int getRandInt(final int min, final int max) throws IllegalArgumentException
	{
		Validate.isTrue(max > min, "Max can't be smaller than min!");
		return UMath.rand.nextInt((max - min) + 1) + min;
	}

	/**
	 * Zwraca losow¹ liczbê typu double (zmiennoprzecinkowa) z wybranego
	 * przedzia³u. <br>
	 * 
	 * np: <br>
	 * <br>
	 * getRandDouble(-0.5, 0.5) mo¿e wylosowaæ liczby od -0.5 do 0.5 np
	 * 0.34366745346764 <br>
	 * 
	 * 
	 * @param min
	 *            minimalna liczba (w³¹cznie)
	 * @param max
	 *            maksymalna liczba (w³¹cznie)
	 * @return wynik losowania
	 * @throws IllegalArgumentException
	 *             jeœli liczba minimalna jest wiêksza od maksymalnej.
	 */
	public static double getRandDouble(final double min, final double max) throws IllegalArgumentException
	{
		Validate.isTrue(max > min, "Max can't be smaller than min!");
		return (UMath.rand.nextDouble() * (max - min)) + min;
	}

	/**
	 * Zwraca losow¹ liczbê typu float (zmiennoprzecinkowa) z wybranego
	 * przedzia³u. <br>
	 * 
	 * np: <br>
	 * <br>
	 * getRandFloat(-0.5, 0.5) mo¿e wylosowaæ liczby od -0.5 do 0.5 np
	 * 0.34366745 <br>
	 * 
	 * 
	 * @param min
	 *            minimalna liczba (w³¹cznie)
	 * @param max
	 *            maksymalna liczba (w³¹cznie)
	 * @return wynik losowania
	 * @throws IllegalArgumentException
	 *             jeœli liczba minimalna jest wiêksza od maksymalnej.
	 */
	public static float getRandFloat(final float min, final float max) throws IllegalArgumentException
	{
		Validate.isTrue(max > min, "Max can't be smaller than min!");
		return (UMath.rand.nextFloat() * (max - min)) + min;
	}

	/**
	 * Umo¿liwia proste wykonanie losowej szansy, wystraczy podaæ szanse na
	 * udane losowanie w %, a metoda zwróci true lub false w zale¿noœci od
	 * wyniku "losowania"<br>
	 * np: <br>
	 * <br>
	 * getChance(12,5d) 12,5% na wylosowanie prawdy, podanie argumentu wiêkszego
	 * od 100 spowoduje natychmiastowe zwrócenie prawdy z pominiêciem losowania.
	 * 
	 * @param chance
	 *            szansa na zwrócenie true w procentach.
	 * @return true lub false w zale¿noœci od wyniku losowania
	 */
	public static boolean getChance(final double chance)
	{
		return (chance >= 100) || (chance >= UMath.getRandDouble(0, 100));
	}
}
