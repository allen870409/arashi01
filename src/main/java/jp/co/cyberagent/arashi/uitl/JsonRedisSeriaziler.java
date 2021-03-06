package jp.co.cyberagent.arashi.uitl;

import java.nio.charset.Charset;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Component;

@Component
public class JsonRedisSeriaziler {
	public static final String EMPTY_JSON = "{}";
	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	protected ObjectMapper objectMapper = new ObjectMapper();

	public JsonRedisSeriaziler() {
	}

	/*** java-object as json-string* @param object* @return */
	public String seriazileAsString(Object object) {
		if (object == null) {
			return EMPTY_JSON;
		}
		try {
			return this.objectMapper.writeValueAsString(object);
		} catch (Exception ex) {
			throw new SerializationException("Could not write JSON: "
					+ ex.getMessage(), ex);
		}
	}

	/*** json-string to java-object* @param str* @return */
	public <T> T deserializeAsObject(String str, Class<T> clazz) {
		if (str == null || clazz == null) {
			return null;
		}
		try {
			return this.objectMapper.readValue(str, clazz);
		} catch (Exception ex) {
			throw new SerializationException("Could not write JSON: "
					+ ex.getMessage(), ex);
		}
	}
}