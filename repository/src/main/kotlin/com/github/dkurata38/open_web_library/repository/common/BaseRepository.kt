package com.github.dkurata38.open_web_library.repository.common

abstract class BaseRepository<ModelType, TableType> (
		protected val converterToTable: (ModelType) -> TableType,
		protected val converterToModel: (TableType) -> ModelType) {
}
