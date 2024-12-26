package io.NotKeira;

import io.NotKeira.Config.Configuration;
import io.NotKeira.Protocols.Listeners.OnSlash;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class App {

    public static void main(String[] arguments) throws Exception {
        Configuration config = new Configuration();
        config.loadConfig();
        JDABuilder api = JDABuilder.createDefault(config.getString("discord.token"));
        api.enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS);
        api.addEventListeners(new OnSlash());
        JDA bot = api.build();
        bot.setAutoReconnect(true);
        if (config.getBoolean("pterodactyl.multi-server")) {
            bot.updateCommands().addCommands(Commands.slash("start", "Start up the Minecraft Server").addOption(OptionType.STRING, "server", "The command to execute on the server", true, true), Commands.slash("stop", "Stop the Minecraft Server").addOption(OptionType.STRING, "server", "The command to execute on the server", true, true), Commands.slash("restart", "Restart the Minecraft Server").addOption(OptionType.STRING, "server", "The command to execute on the server", true, true), Commands.slash("execute", "Execute a command on the Minecraft Server").addOption(OptionType.STRING, "server", "The command to execute on the server", true, true).addOption(OptionType.STRING, "command", "The command to execute on the server", true)).queue();
        } else {
            bot.updateCommands().addCommands(Commands.slash("start", "Start up the Minecraft Server"), Commands.slash("stop", "Stop the Minecraft Server"), Commands.slash("restart", "Restart the Minecraft Server"), Commands.slash("execute", "Execute a command on the Minecraft Server").addOption(OptionType.STRING, "command", "The command to execute on the server", true)).queue();
        }

    }
}
