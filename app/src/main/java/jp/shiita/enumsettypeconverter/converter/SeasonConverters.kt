package jp.shiita.enumsettypeconverter.converter

import jp.shiita.enumsettypeconverter.Season

class SeasonConverters : EnumSetConverters<Season>(Season::class.java) {
    override val Season.storeBit: Int
        get() = when (this) {
            Season.SPRING -> 0
            Season.SUMMER -> 1
            Season.AUTUMN -> 2
            Season.WINTER -> 3
        }
}
