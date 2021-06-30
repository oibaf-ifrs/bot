package edu.ifrs.bot;

import java.util.HashMap;
import java.util.Map;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import edu.ifrs.bot.commands.Command;

public class OrionBot {

    private Map<String, Command> commands;

    String token = "your token";

    public OrionBot() {
        this.commands = new HashMap<String, Command>();
    }

    public void start() {
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage("Pong!");
            }
        });

        // Print the invite url of your bot
        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());

    }

    private void loadCommands() {
    }

}
