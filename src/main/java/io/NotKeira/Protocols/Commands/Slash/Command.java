package io.NotKeira.Protocols.Commands.Slash;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public interface Command {

    void execute(SlashCommandInteractionEvent event);
}
