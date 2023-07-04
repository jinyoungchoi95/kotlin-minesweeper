package minesweeper.domain.cell

import minesweeper.domain.cell.CellType.MINE
import minesweeper.domain.cell.CellType.ZERO

class Cell(
    val coordinate: Coordinate,
    cellType: CellType = ZERO,
    private val isDisplay: Boolean = true,
) {
    var cellType: CellType = cellType
        get() = cellType(field)
        private set

    constructor(row: Int, column: Int, cellType: CellType, isDisplay: Boolean) :
        this(Coordinate(row, column), cellType, isDisplay)

    constructor(row: Int, column: Int, cellType: CellType) : this(Coordinate(row, column), cellType)

    constructor(row: Int, column: Int) : this(Coordinate(row, column))

    fun isMine(): Boolean = cellType == MINE

    fun changeToMine() {
        check(cellType != MINE) { "지뢰는 지뢰로 변경할 수 없습니다." }
        cellType = MINE
    }

    fun changeToCellType(cellType: CellType) {
        this.cellType = cellType
    }

    private fun cellType(cellType: CellType): CellType {
        if (isDisplay) {
            return cellType
        }
        return CellType.UNKNOWN
    }
}
