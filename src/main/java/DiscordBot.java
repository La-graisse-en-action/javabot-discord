import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utils.BotBuilder;
import utils.Commands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class DiscordBot extends ListenerAdapter {
	
	public static void main(String[] args) throws LoginException, InterruptedException {
		JDABuilder botBuilder = JDABuilder.createDefault(BotBuilder.getToken());
		JDA jda = BotBuilder.setConfig(botBuilder);
		
		jda.addEventListener(new Commands());
	}
}
