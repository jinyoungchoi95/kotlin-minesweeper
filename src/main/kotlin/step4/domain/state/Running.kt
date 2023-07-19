package step4.domain.state

import step4.domain.Cells
import step4.domain.strategy.CoordinateSelectStrategy

class Running(
    var toFindCellCount: Int,
    val cells: Cells,
) : MinesweeperState {
    override fun installMine(mineCount: Int, coordinateSelectStrategy: CoordinateSelectStrategy): MinesweeperState =
        throw IllegalStateException("지뢰를 설치할 수 있는 상태가 아닙니다.")
}
