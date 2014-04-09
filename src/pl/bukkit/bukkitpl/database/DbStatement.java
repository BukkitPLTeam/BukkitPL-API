package pl.bukkit.bukkitpl.database;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Klasa od wywo³ywania poleceñ SQL
 * 
 * @author BukkitSmerf
 * 
 */
public class DbStatement
{
	protected Statement s;

	public DbStatement(final Statement s)
	{
		this.s = s;
	}

	public DbStatement(final Statement s, final String... sqls) throws SQLException
	{
		this.s = s;
		this.addToStatement(sqls);
	}

	public void addToStatement(final String... sqls) throws SQLException
	{
		for (final String sql : sqls)
		{
			this.s.addBatch(sql);
		}
	}

	public void run() throws SQLException
	{
		this.s.executeBatch();
	}

	public void runAndClose() throws SQLException
	{
		this.run();
		this.close();
	}

	public void close() throws SQLException
	{
		this.s.close();
	}
}
