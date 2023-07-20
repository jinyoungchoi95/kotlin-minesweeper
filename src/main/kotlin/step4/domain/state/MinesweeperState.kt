package step4.domain.state

import step4.domain.CellInfo
import step4.domain.coordinate.Coordinate
import step4.domain.strategy.CoordinateSelectStrategy

interface MinesweeperState {
    fun installMine(mineCount: Int, coordinateSelectStrategy: CoordinateSelectStrategy): MinesweeperState

    fun open(coordinate: Coordinate): MinesweeperState

    fun isFinished(): Boolean

    fun cellInfos(): List<CellInfo>
}
