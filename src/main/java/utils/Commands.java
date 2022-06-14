package utils;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		System.out.println(args);
		/*
		 * Isn't necessary import the class, 'cause are in the same directory
		 */
		BotBuilder bot = new BotBuilder();
		if (args[0].equalsIgnoreCase(bot.prefix + "info")) {

			EmbedBuilder embed = new EmbedBuilder();
			embed.setTitle("Embed message").setDescription("Some description").addField("NameField:", "FieldValue", false)
					.setAuthor("Some Author").setColor(0xf45642);

			MessageChannel channel = event.getChannel();
			channel.sendMessageEmbeds(embed.build()).queue();
			// Resets this builder to default state.
			embed.clear();
		}
	}
}
