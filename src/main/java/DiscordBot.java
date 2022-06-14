import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class DiscordBot extends ListenerAdapter {
	public static void main(String[] args) throws LoginException, InterruptedException {
		JDA botBuilder = JDABuilder.createDefault("token here")
				.setActivity(Activity.watching("Hentai")).build();
		
	}
}
