package utils;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BaseCommand extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		mapArgs(args);

		// Isn't necessary import the class, 'cause are in the same directory
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

	@Override
	public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
		if (event.getName().equals("info")) {
			// you need the reply because it is the method that returns the message,
			// although the content in the method will not be displayed
			event.reply("").setEphemeral(false).flatMap(v -> event.getHook().editOriginal("Hiiiiii")).queue();
		}
	}

	/**
	 * <h1>This is just for map every command and show it in the terminal</h1>
	 * 
	 * @param msgRaw
	 */
	private void mapArgs(String[] msgRaw) {
		for (String msg : msgRaw) {
			System.out.print(msg + " ");
		}
	}
}
