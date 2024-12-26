package io.NotKeira.Protocols.Listeners;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.NotKeira.Config.Configuration;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command.Choice;

public class OnAutoComplete extends ListenerAdapter {

    private String[] servers = new String[0];

    // Load the servers from the configuration file
    public OnAutoComplete(Configuration config) {
        if (!config.getStringList("pterodactyl.servers").isEmpty()) {
            servers = config.getStringList("pterodactyl.servers").toArray(new String[0]);
        } else {
            // If no servers are found, just ignore
        }
    }

    @Override
    public void onCommandAutoCompleteInteraction(CommandAutoCompleteInteractionEvent event) {
        if (event.getFocusedOption().getName().equals("server")) {
            List<Choice> options = Stream.of(servers).filter(word -> word.startsWith(event.getFocusedOption().getValue())).map(word -> new Choice(word, word)).collect(Collectors.toList());
            event.replyChoices(options).queue();
        }
    }
}
