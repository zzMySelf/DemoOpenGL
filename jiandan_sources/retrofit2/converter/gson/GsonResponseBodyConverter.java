package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    public final TypeAdapter<T> adapter;
    public final Gson gson;

    public GsonResponseBodyConverter(Gson gson2, TypeAdapter<T> typeAdapter) {
        this.gson = gson2;
        this.adapter = typeAdapter;
    }

    public T convert(ResponseBody responseBody) throws IOException {
        JsonReader newJsonReader = this.gson.newJsonReader(responseBody.charStream());
        try {
            T read = this.adapter.read(newJsonReader);
            if (newJsonReader.peek() == JsonToken.END_DOCUMENT) {
                return read;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
