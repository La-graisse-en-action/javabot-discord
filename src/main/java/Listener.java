import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class Listener implements EventListener {
	public static void main(String[] args) throws LoginException, InterruptedException {
		JDA jda = JDABuilder.createDefault("token").addEventListeners(new Listener()).build();

		jda.awaitReady();
	}

	public void onEvent(GenericEvent event) {
		if (event instanceof ReadyEvent) {
			System.out.println("Api is ready!");
		}
	}
}
