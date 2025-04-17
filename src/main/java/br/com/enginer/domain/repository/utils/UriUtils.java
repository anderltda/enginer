package br.com.enginer.domain.repository.utils;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.web.util.UriBuilder;

/**
 * 
 */
public class UriUtils {

	/**
	 * @param path
	 * @param params
	 * @return
	 */
	public static Function<UriBuilder, URI> buildUriWithQueryParams(String path, Map<String, Object> params) {
		return uriBuilder -> {
			UriBuilder builder = uriBuilder.path(path);

			for (Map.Entry<String, Object> entry : params.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();

				if (value == null)
					continue;

				if (value instanceof List<?> list) {
					for (Object item : list) {
						if (item != null) {
							builder.queryParam(key, item.toString());
						}
					}
				} else if (value.getClass().isArray()) {
					for (Object item : (Object[]) value) {
						if (item != null) {
							builder.queryParam(key, item.toString());
						}
					}
				} else {
					builder.queryParam(key, value.toString());
				}
			}

			return builder.build();
		};
	}

	/**
	 * @param params
	 * @return
	 */
	public static String toQueryString(Map<String, Object> params) {
		StringBuilder query = new StringBuilder();

		for (Map.Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			if (value == null)
				continue;

			if (value instanceof List<?> list) {
				for (Object item : list) {
					if (item != null) {
						query.append(key).append("=").append(item.toString()).append("&");
					}
				}
			} else if (value.getClass().isArray()) {
				for (Object item : (Object[]) value) {
					if (item != null) {
						query.append(key).append("=").append(item.toString()).append("&");
					}
				}
			} else {
				query.append(key).append("=").append(value.toString()).append("&");
			}
		}

		// Remove o último "&" se houver
		if (query.length() > 0) {
			query.setLength(query.length() - 1);
		}

		return query.toString();
	}
}