package events;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utils.BotBuilder;

import java.util.Collection;

public class HelpEvent extends ListenerAdapter  {
    public String eventName = "help";
    private void createEmbedMsg(MessageReceivedEvent event) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Help Command").setDescription("Some helpfully description").addField("NameField:", "FieldValue", false)
                .setAuthor("Some Author").setColor(0xf45642);
        MessageChannel channel = event.getChannel();
        channel.sendMessageEmbeds(embed.build()).queue();
        embed.clear();
    }

    private MessageEmbed createEmbedMsgFromSlashEvent(SlashCommandInteractionEvent slashEvent) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Help Command").setDescription("Some helpfully description").addField("NameField:", "FieldValue", false)
                .setAuthor("Some Author").setColor(0xf45642);
        MessageChannel channel = slashEvent.getChannel();
        return embed.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        BotBuilder bot = new BotBuilder();
        if (args[0].equalsIgnoreCase(bot.prefix + eventName)) {
            createEmbedMsg(event);
        }
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals(eventName)) {
            MessageEmbed embed = createEmbedMsgFromSlashEvent(event);
            event.replyEmbeds(embed).queue();
        }
    }
}
