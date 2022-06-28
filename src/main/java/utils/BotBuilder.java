package utils;

import java.util.Collections;

import javax.security.auth.login.LoginException;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;


public class BotBuilder {
	public String prefix = "f-";

	/**
	 * <h2>Create the base configuration of the bot by setting some options and
	 * executing the necessary methods</h2>
	 * 
	 * @param <b>JDABuilder</b> builder
	 * @return <b>JDA</b>
	 * @throws LoginException
	 */
	public static JDA setConfig(JDABuilder builder) throws LoginException {
		builder.setActivity(Activity.watching("Hentai"));
		builder.setStatus(OnlineStatus.ONLINE);
		JDABuilder.createLight(getToken(), Collections.emptyList());

		JDA jda = builder.build();
		createSlashCommands(jda);
		return jda;
	}

	/**
	 * <h2>Returns the Bot Token to use the createDefault method</h2>
	 * 
	 * @return <b>String</b> token
	 */
	public static String getToken() {
		Dotenv dotenv = Dotenv.configure().load();
		String token = dotenv.get("TOKEN");
		return token;
	}

	/**
	 * <h2>Add to the collection all the SlashCommands available</h2>
	 * 
	 * @param <b>JDA</b> jda
	 */
	private static void createSlashCommands(JDA jda) {
		jda.upsertCommand("info", "Show info about the bot").queue();
	}
}
