package minesweeper.domain.cell

open class Cell(
    val position: Position
) {
    open fun isMine() = false

    override fun equals(other: Any?): Boolean {
        return position == (other as? Cell)?.position
    }

    override fun toString() = "C"

    override fun hashCode(): Int {
        return position.hashCode()
    }
}

fun Position.toCell() = Cell(this)