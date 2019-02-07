package gg.rsmod.game.model.region.update

import gg.rsmod.game.message.Message
import gg.rsmod.game.message.impl.LocDelMessage
import gg.rsmod.game.model.entity.GameObject

/**
 * @author Tom <rspsmods@gmail.com>
 */
class LocDelUpdate(override val type: EntityUpdateType,
                   override val entity: GameObject) : EntityUpdate<GameObject>(type, entity) {

    override fun toMessage(): Message = LocDelMessage(entity.settings.toInt(), ((entity.tile.x and 0x7) shl 4) or (entity.tile.z and 0x7))
}