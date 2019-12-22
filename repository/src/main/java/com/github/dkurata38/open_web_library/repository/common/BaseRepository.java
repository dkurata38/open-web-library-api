package com.github.dkurata38.open_web_library.repository.common;

import java.util.function.Function;

public abstract class BaseRepository<ModelType, TableType> {
	private final Function<ModelType, TableType> converterToTable;
	private final Function<TableType, ModelType> converterToModel;

	protected BaseRepository(final Function<ModelType, TableType> converterToTable,
							 final Function<TableType, ModelType> converterToModel) {
		this.converterToTable = converterToTable;
		this.converterToModel = converterToModel;
	}

	protected ModelType convertToModel(TableType record) {
		return converterToModel.apply(record);
	}

	protected TableType convertToTable(ModelType instance) {
		return converterToTable.apply(instance);
	}
}
