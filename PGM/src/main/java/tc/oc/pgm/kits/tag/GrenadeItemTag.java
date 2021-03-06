package tc.oc.pgm.kits.tag;

import net.minecraft.server.NBTTagCompound;
import tc.oc.commons.bukkit.item.BooleanItemTag;
import tc.oc.commons.bukkit.item.FloatItemTag;
import tc.oc.commons.bukkit.item.ItemTag;

public class GrenadeItemTag extends ItemTag<Grenade> {

    protected static final FloatItemTag POWER = new FloatItemTag("power", 1f);
    protected static final BooleanItemTag FIRE = new BooleanItemTag("fire", false);
    protected static final BooleanItemTag DESTROY = new BooleanItemTag("destroy", true);

    public GrenadeItemTag() {
        super("grenade", null);
    }

    @Override
    protected boolean hasPrimitive(NBTTagCompound tag) {
        return tag.hasKeyOfType(name, 10);
    }

    @Override
    protected Grenade getPrimitive(NBTTagCompound tag) {
        NBTTagCompound grenade = tag.getCompound(name);
        return new Grenade(POWER.get(grenade), FIRE.get(grenade), DESTROY.get(grenade));
    }

    @Override
    protected void setPrimitive(NBTTagCompound tag, Grenade value) {
        NBTTagCompound grenade = tag.getCompound(name);
        tag.set(name, grenade);
        POWER.set(grenade, value.power);
        FIRE.set(grenade, value.fire);
        DESTROY.set(grenade, value.destroy);
    }
}
