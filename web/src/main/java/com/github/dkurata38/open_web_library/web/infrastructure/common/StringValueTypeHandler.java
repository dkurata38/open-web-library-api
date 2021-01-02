package com.github.dkurata38.open_web_library.web.infrastructure.common;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public abstract class StringValueTypeHandler<T> extends BaseTypeHandler<T> {
	private final Function<T, String> toString;
	private final Function<String, T> toType;

	public StringValueTypeHandler(Function<T, String> toString, Function<String, T> toType) {
		this.toString = toString;
		this.toType = toType;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, toString.apply(parameter));
	}

	@Override
	public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return toType.apply(rs.getString(columnName));
	}

	@Override
	public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return toType.apply(rs.getString(columnIndex));
	}

	@Override
	public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return toType.apply(cs.getString(columnIndex));
	}
}
