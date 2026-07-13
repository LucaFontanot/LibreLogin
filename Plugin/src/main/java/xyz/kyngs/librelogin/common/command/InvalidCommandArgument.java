/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package xyz.kyngs.librelogin.common.command;

import net.kyori.adventure.text.Component;

public class InvalidCommandArgument extends RuntimeException {

    private final Component userFuckUp;

    public InvalidCommandArgument(Component userFuckUp) {
        this.userFuckUp = userFuckUp;
    }

    public Component getUserFuckUp() {
        return userFuckUp;
    }
}
