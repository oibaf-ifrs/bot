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

package edu.ifrs.bot;

import dev.orion.bot.OrionBot;
import dev.orion.bot.commands.CommandNotFound;
import dev.orion.bot.commands.Ping;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * AppIT.
 */
public class AppTest {

    private static OrionBot bot;

    @BeforeAll
    public static void init() {
        bot = Mockito.mock(OrionBot.class);
        when(bot.selectCommand("ping")).thenReturn(new Ping());
        when(bot.selectCommand("xyz")).thenThrow(CommandNotFound.class);
    }

    @Test
    public void selectCommand() {
        assertInstanceOf(Ping.class, bot.selectCommand("ping"));
    }

    @Test
    public void commandNotFound() {
        assertThrows(CommandNotFound.class, () -> bot.selectCommand("xyz"));
    }

}
