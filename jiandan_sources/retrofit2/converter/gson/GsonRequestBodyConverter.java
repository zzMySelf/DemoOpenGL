package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

public final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    public static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public final TypeAdapter<T> adapter;
    public final Gson gson;

    public GsonRequestBodyConverter(Gson gson2, TypeAdapter<T> typeAdapter) {
        this.gson = gson2;
        this.adapter = typeAdapter;
    }

    public RequestBody convert(T t) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter newJsonWriter = this.gson.newJsonWriter(new OutputStreamWriter(buffer.outputStream(), UTF_8));
        this.adapter.write(newJsonWriter, t);
        newJsonWriter.close();
        return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
    }
}
