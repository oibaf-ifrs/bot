/**
 * Orion Discord Bot by Rodrigo Prestes Machado
 *
 * Orion Discord Bot is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 *
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
     * @param name
     */
    public void execCommand(Command name) {
        // TODO
    }

    /**
     * loadCommand.
     */
    private void loadCommands() {
        this.commands.put("ping", new Ping());
    }

}
