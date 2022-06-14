package utils;

import javax.security.auth.login.LoginException;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class BotBuilder {
	public String prefix = "f-";

	public static JDA setConfig(JDABuilder builder) throws LoginException {
		builder.setActivity(Activity.watching("Hentai"));
		builder.setStatus(OnlineStatus.ONLINE);
		JDA jda = builder.build();
		return jda;
	}

	public static String getToken() {
		Dotenv dotenv = Dotenv.configure().load();
		String token = dotenv.get("TOKEN");
		return token;
	}
}
