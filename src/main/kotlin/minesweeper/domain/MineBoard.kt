package minesweeper.domain

import minesweeper.domain.cell.Cell
import minesweeper.domain.cell.Cells
import minesweeper.domain.cell.Coordinate
import minesweeper.domain.strategy.MinePlacementStrategy
import minesweeper.domain.strategy.RandomMinePlacementStrategy

class MineBoard(
    val mineBoardInfo: MineBoardInfo,
    val cells: Cells,
    private val minePlacementStrategy: MinePlacementStrategy = RandomMinePlacementStrategy(),
) {
    constructor(height: Int, width: Int, cells: Cells) : this(MineBoardInfo(height, width), cells)

    fun placeMine(mineCount: Int) {
        cells.placeMine(mineCount, minePlacementStrategy)
        mineBoardInfo.removeCellCount(mineCount)
    }

    fun open(coordinate: Coordinate) {
        check(mineBoardInfo.isEnd().not()) { "이미 종료된 게임은 진행이 불가능합니다." }
        val cellOpenResult = cells.open(coordinate)
        mineBoardInfo.removeCellCount(cellOpenResult)
        checkBoardStatus(cellOpenResult)
    }

    fun currentBoard(): CellInfos = CellInfos(height = mineBoardInfo.height, values = cells.cellInfos())

    fun isEndGame(): Boolean = mineBoardInfo.isEnd()

    fun gameResult(): MineBoardStatus {
        check(mineBoardInfo.isEnd()) { "아직 진행중인 게임은 결과를 확인할 수 없습니다." }
        return mineBoardInfo.mineBoardStatus
    }

    private fun checkBoardStatus(cellOpenResult: Int) {
        if (cellOpenResult == 0) {
            mineBoardInfo.toLose()
        }
        if (mineBoardInfo.toFindCellCount == 0) {
            mineBoardInfo.toWin()
        }
    }

    companion object {
        fun generateNewMineBoard(height: Int, width: Int): MineBoard {
            return MineBoard(height, width, Cells(List(height * width) { index -> parseToCell(index, width) }))
        }

        private fun parseToCell(index: Int, width: Int): Cell {
            val row = index / width
            val column = index % width
            return Cell(row, column)
        }
    }
}
