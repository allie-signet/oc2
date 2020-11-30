package li.cil.oc2.serialization.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import li.cil.oc2.serialization.NBTToJsonConverter;
import net.minecraft.item.ItemStack;

import java.lang.reflect.Type;

public final class ItemStackJsonSerializer implements JsonSerializer<ItemStack> {
    @Override
    public JsonElement serialize(final ItemStack src, final Type typeOfSrc, final JsonSerializationContext context) {
        if (src == null || src.isEmpty()) {
            return JsonNull.INSTANCE;
        }

        final JsonElement json = NBTToJsonConverter.convert(src.serializeNBT());

        // TODO Postprocessing, filter out tags that should not be visible to the VM.

        return json;
    }
}
