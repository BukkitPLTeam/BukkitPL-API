package pl.bukkit.bukkitpl.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import pl.bukkit.bukkitpl.BukkitPL;
import pl.bukkit.bukkitpl.utils.DebugLevel;
import pl.bukkit.bukkitpl.utils.UMsg;

/**
 * Klasa do zarz¹dzania baz¹ danych MySQL/SqLite
 * 
 * @author BukkitSmerf
 * 
 */
public class Db
{
	private static Connection con = null;

	/**
	 * Inicjuje po³¹czenie z MySQl lub SQLite w zale¿noœci od ustawieñ.
	 */
	public static void setupDb()
	{
		try
		{
			UMsg.debug("DataBase", "Connecting to database... ", DebugLevel.NONE);
			if (Db.con != null)
			{
				Db.con.close();
			}
			// TODO: ca³y system :<
			Class.forName("org.sqlite.JDBC");
			Db.con = DriverManager.getConnection("jdbc:sqlite:" + new File(BukkitPL.getInstance().getDataFolder() + File.separator + "SQLite.db").getAbsolutePath());
			//			final DbStatement stat = Db.createStatement();
			//			stat.addToStatement("CREATE TABLE IF NOT EXISTS ");
			//			stat.runAndClose();
			UMsg.debug("DataBase", "Connection complete! ", DebugLevel.NONE);
		} catch (ClassNotFoundException | SQLException e)
		{
			UMsg.warn("&cError when connecting to DataBase!&r\n\n" + e.getMessage() + "\n\n&cError when connecting to DataBase!");
		}
	}

	private static DbStatement createStatement() throws SQLException
	{
		return new DbStatement(Db.con.createStatement());
	}

	private static void runStatement(final String... sqls) throws SQLException
	{
		new DbStatement(Db.con.createStatement(), sqls).runAndClose();
	}

	private static DbResult getResult(final String sql) throws SQLException
	{
		return new DbResult(Db.con.createStatement(), sql);
	}
}
