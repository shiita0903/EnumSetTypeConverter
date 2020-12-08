package jp.shiita.enumsettypeconverter.converter

import androidx.room.TypeConverter

abstract class EnumSetConverters<T : Enum<T>>(private val clazz: Class<T>) {
    protected abstract val T.storeBit: Int

    @TypeConverter
    fun toDbValue(enums: Set<T>?): Int? = enums?.sumBy { 1 shl it.storeBit }

    @TypeConverter
    fun fromDbValue(dbValue: Int?): Set<T>? {
        dbValue ?: return null
        return clazz.enumConstants
            ?.filter { dbValue ushr it.storeBit and 1 == 1 }
            ?.toSet()
    }
}
