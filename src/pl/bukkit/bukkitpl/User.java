package pl.bukkit.bukkitpl;

import java.util.HashMap;
import java.util.Map;

import lombok.Delegate;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.ServerOperator;

import pl.bukkit.bukkitpl.api.HomeManager;

/**
 * Klasa przechowuj�ce wszystkie dane o wybranym graczu, wszystkie pluginy
 * podczepione pod API wsp�dziel� graczy by unikn�c sprzeczno�ci.
 * 
 * @author BukkitSmerf
 * 
 */
public class User
{
	@Delegate(types = { Player.class, Entity.class, CommandSender.class, ServerOperator.class, HumanEntity.class, ConfigurationSerializable.class, LivingEntity.class, Permissible.class })
	private Player player;
	private final Map<String, HomeManager> homes = new HashMap<>();

	public void save()
	{
		//TODO
	}

	public void load()
	{
		//TODO
	}

	public HomeManager getHomeManager(final String name)
	{
		return this.homes.get(this.homes);
	}

	//TODO reszta oopcji zwi�zanych z /home
	//jak ElDzi napisze
}
