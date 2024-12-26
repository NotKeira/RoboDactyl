package io.NotKeira.Protocols.Listeners;

import java.util.HashMap;
import java.util.Map;

import io.NotKeira.Protocols.Commands.Slash.Command;
import io.NotKeira.Protocols.Commands.Slash.Execute;
import io.NotKeira.Protocols.Commands.Slash.Restart;
import io.NotKeira.Protocols.Commands.Slash.Start;
import io.NotKeira.Protocols.Commands.Slash.Stop;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class OnSlash extends ListenerAdapter {

    private final Map<String, Command> commands = new HashMap<>();

    public OnSlash() {
        commands.put("start", new Start());
        commands.put("restart", new Restart());
        commands.put("stop", new Stop());
        commands.put("execute", new Execute());
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String commandName = event.getName();
        Command command = commands.get(commandName);

        if (command != null) {
            System.out.println("Command: " + commandName);
            command.execute(event);
        } else {
            event.reply("Unknown command").queue();
        }
    }
}
