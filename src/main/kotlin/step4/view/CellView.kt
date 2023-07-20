package step4.view

import step4.domain.cell.CellType
import java.lang.IllegalArgumentException

enum class CellView(
    val cellType: CellType,
    val view: String,
) {
    UNKNOWN_CELL(CellType.UNKNOWN, "C"),
    ZERO_CELL(CellType.ZERO, "0"),
    ONE_CELL(CellType.ONE, "1"),
    TWO_CELL(CellType.TWO, "2"),
    THREE_CELL(CellType.THREE, "3"),
    FOUR_CELL(CellType.FOUR, "4"),
    FIVE_CELL(CellType.FIVE, "5"),
    SIX_CELL(CellType.SIX, "6"),
    SEVEN_CELL(CellType.SEVEN, "7"),
    EIGHT_CELL(CellType.EIGHT, "8"),
    MINE_CELL(CellType.MINE, "*"),
    ;

    companion object {
        fun from(cellType: CellType): CellView = values().firstOrNull { it.cellType == cellType }
            ?: throw IllegalArgumentException("지원하지 않는 셀 타입입니다.")
    }
}
