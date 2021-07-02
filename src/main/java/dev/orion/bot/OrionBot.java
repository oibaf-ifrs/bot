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
import dev.orion.bot.commands.Ping;
import java.util.HashMap;
import java.util.Map;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

/**
 * OrionBot.
 */
public class OrionBot {

    private Map<String, Command> commands;

    private final String token = "your token";

    /**
     * OrionBot.
     */
    public OrionBot() {
        this.commands = new HashMap<String, Command>();
        this.loadCommands();
    }

    /**
     * listen.
     */
    public void listen() {
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
        api.addMessageCreateListener(event -> {
            // according docs/uml/sequence.puml
            String strCommand = this.getCommand(event);
            Command command = this.selectCommand(strCommand);
            command.execute(event);
        });
    }

    /**
     * Returns the name of a command.
     * @param event
     * @return the name of a command
     */
    private String getCommand(MessageCreateEvent event) {
        return event.getMessageContent().toLowerCase().split(" ")[0];
    }

    /**
     * Returns a command.
     * @param name
     * @return a command
     */
    public Command selectCommand(String name) {
        return this.commands.get(name);
    }

    /**
     * Loads the commands in the bot.
     */
    private void loadCommands() {
        this.commands.put("!ping", new Ping());
    }

}
