package pl.bukkit.bukkitpl.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Klasa od zarz¹dzania {@link ResultSet}
 * 
 * @author BukkitSmerf
 * 
 */
public class DbResult
{
	protected Statement s;
	protected ResultSet result;

	public DbResult(final Statement s, final String sql) throws SQLException
	{
		this.s = s;
		this.result = s.executeQuery(sql);
	}

	public void nextResult(final String sql) throws SQLException
	{
		if (this.result != null)
		{
			this.result.close();
		}
		this.result = this.s.executeQuery(sql);
	}

	public void close() throws SQLException
	{
		this.result.close();
		this.s.close();
	}

	public String getString(final String col) throws SQLException
	{
		return this.result.getString(col);
	}

	public int getInt(final String col) throws SQLException
	{
		return this.result.getInt(col);
	}

	public boolean getBoolean(final String col) throws SQLException
	{
		return this.result.getBoolean(col);
	}

	public long getLong(final String col) throws SQLException
	{
		return this.result.getLong(col);
	}

	public boolean next() throws SQLException
	{
		return this.result.next();
	}

	public void update(final String sql) throws SQLException
	{
		this.s.executeUpdate(sql);
	}

	public void update(final String[] sqls) throws SQLException
	{
		for (final String sql : sqls)
		{
			this.s.addBatch(sql);
		}
		this.s.executeBatch();
	}
}
