package com.github.dkurata38.open_web_library.web.config;

import com.github.dkurata38.open_web_library.domain.common.Identifier;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.core.mapping.JdbcMappingContext;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.mapping.NamingStrategy;
import org.springframework.data.relational.core.mapping.PersistentPropertyPathExtension;
import org.springframework.data.relational.core.mapping.RelationalPersistentProperty;
import org.springframework.data.util.ParsingUtils;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.Consumer;

import static java.util.stream.Collectors.*;

@Configuration
@EnableJdbcRepositories(basePackages = "*")
public class JdbcConfig extends AbstractJdbcConfiguration {

//	private final JdbcOperations jdbcOperations;

//	@Bean
//	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
//		return new NamedParameterJdbcTemplate(jdbcOperations){
//			@Override
//			protected PreparedStatementCreator getPreparedStatementCreator(final String sql, final SqlParameterSource paramSource, final Consumer<PreparedStatementCreatorFactory> customizer) {
//				MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
//				Arrays.stream(paramSource.getParameterNames())
//						.forEach(name -> {
//							Object paramSourceValue = paramSource.getValue(name);
//							Object value = isIdentifierType(paramSourceValue) ? ((Identifier) paramSourceValue).getValue() : paramSourceValue;
//							if (Objects.isNull(paramSource.getTypeName(name))) {
//								mapSqlParameterSource.addValue(name, value, paramSource.getSqlType(name));
//							} else {
//								mapSqlParameterSource.addValue(name, value, paramSource.getSqlType(name), paramSource.getTypeName(name));
//							}
//						});
//
//				return super.getPreparedStatementCreator(sql, mapSqlParameterSource, customizer);
//			}
//
//			private boolean isIdentifierType(Object value) {
//				return value instanceof Identifier;
//			}
//		};
//	}

//	@Bean
//	@Override
//	public JdbcMappingContext jdbcMappingContext(final Optional<NamingStrategy> namingStrategy, final JdbcCustomConversions customConversions) {
//		return super.jdbcMappingContext(Optional.of(namingStrategy()), customConversions);
//	}

	@Bean
	public NamingStrategy namingStrategy() {
		return new NamingStrategy() {
			@Override
			public String getColumnName(final RelationalPersistentProperty property) {
				if (Identifier.class.isAssignableFrom(property.getOwner().getType())) {
					return ParsingUtils.reconcatenateCamelCase(property.getOwner().getType().getSimpleName(), "_");
				}
				return ParsingUtils.reconcatenateCamelCase(property.getName(), "_");
			}
		};
	}

	@Bean
	@Override
	public JdbcCustomConversions jdbcCustomConversions() {
		return new JdbcCustomConversions(
				List.of(new StringToIdConverterFactory(), new IdToStringConverter())
		);
	}

	@ReadingConverter
	static class StringToIdConverterFactory implements ConverterFactory<String, Identifier> {
		@Override
		public <T extends Identifier> Converter<String, T> getConverter(final Class<T> targetType) {
			return source -> {
				try {
					return targetType.getConstructor(String.class).newInstance(source);
				} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
					throw new IllegalArgumentException(e);
				}
			};
		}
	}

	@WritingConverter
	static class IdToStringConverter implements  Converter<Identifier, String> {
		@Override
		public String convert(final Identifier source) {
			return source.getValue();
		}
	}
}
