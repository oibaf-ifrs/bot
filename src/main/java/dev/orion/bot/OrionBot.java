/**
 * Copyright 2021 Orion Bot @ https://github.com/orion-services/bot
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.orion.bot;

import dev.orion.bot.commands.Command;
import dev.orion.bot.commands.CommandNotFound;
import dev.orion.bot.commands.Ping;
import java.util.HashMap;
import java.util.Map;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

/**
 * OrionBot.
 */
public class OrionBot {

    private Map<String, Command> commands;

    private String token = "discord token";

    /**
     * OrionBot.
     */
    public OrionBot() {
        this.commands = new HashMap<String, Command>();
    }

    /**
     * listen.
     */
    public void listen() {
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage("Pong!");
            }
        });

        // Print the invite url of your bot
        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
    }

    /**
     * selectCommand.
     *
     * @param name
     * @return
     */
    public Command selectCommand(String name) throws CommandNotFound {
        // TODO
        return null;
    }

    /**
     * execCommand.
     *
     * @param command
     */
    public void execCommand(Command command) {
        // TODO
    }

    /**
     * loadCommand.
     */
    private void loadCommands() {
        this.commands.put("ping", new Ping());
    }

}
