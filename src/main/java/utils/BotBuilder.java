package utils;

import javax.security.auth.login.LoginException;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class BotBuilder {
	public static void setConfig(JDABuilder builder) throws LoginException {
		builder.setActivity(Activity.watching("Hentai"));
		builder.build();
	}

	public static String getToken() {
		Dotenv dotenv = Dotenv.configure().load();
		String token = dotenv.get("TOKEN");
		return token;
	}
}
