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

package dev.orion.bot.commands;

import discord4j.core.object.entity.Message;

/**
 * Creates a activity in Orion Bot.
 */
public class CreateActivity extends Command {

    @Override
    public void execute(Message message) {
        // TODO Auto-generated method stub
    }

    @Override
    public String getHelp() {
        StringBuilder help = new StringBuilder();
        help.append("Create Activity - https://orion-services.github.io/bot/commands/cmdCreateActivity.html");
        return help.toString();
    }
}
