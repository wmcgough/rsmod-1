package gg.rsmod.game.message.impl

import gg.rsmod.game.message.Message

/**
 * @author Tom <rspsmods@gmail.com>
 */
data class ResumePauseButtonMessage(val parent: Int, val child: Int, val slot: Int) : Message