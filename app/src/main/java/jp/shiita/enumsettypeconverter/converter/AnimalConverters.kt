package jp.shiita.enumsettypeconverter.converter

import jp.shiita.enumsettypeconverter.Animal

class AnimalConverters : EnumSetConverters<Animal>(Animal::class.java) {
    override val Animal.storeBit: Int
        get() = when (this) {
            Animal.DOG -> 0
            Animal.CAT -> 1
            Animal.BIRD -> 2
        }
}
