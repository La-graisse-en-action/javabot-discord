import javax.security.auth.login.LoginException;

import events.HelpEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utils.BotBuilder;
import utils.BaseCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class DiscordBot extends ListenerAdapter {
	public static void main(String[] args) throws LoginException, InterruptedException {
		JDABuilder botBuilder = JDABuilder.createDefault(BotBuilder.getToken());
		JDA jda = BotBuilder.setConfig(botBuilder);

		// Listen the events
		jda.addEventListener(new BaseCommand());
        jda.addEventListener(new HelpEvent());
	}
}
