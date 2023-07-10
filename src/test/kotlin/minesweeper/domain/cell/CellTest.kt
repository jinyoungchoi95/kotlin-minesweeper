package minesweeper.domain.cell

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import minesweeper.domain.cell.CellType.MINE
import minesweeper.domain.cell.CellType.UNKNOWN

fun Cell(row: Int, column: Int, cellType: CellType, isDisplay: Boolean): Cell =
    Cell(Coordinate(row, column), cellType, isDisplay)

fun Cell(row: Int, column: Int, cellType: CellType): Cell = Cell(Coordinate(row, column), cellType)

fun Cell(row: Int, column: Int, isDisplay: Boolean): Cell = Cell(Coordinate(row, column), isDisplay = isDisplay)

class CellTest : FunSpec({

    context("init") {
        test("초기 isDisplay는 false이다.") {
            val actual = Cell(0, 0).isDisplay

            actual shouldBe false
        }
    }

    context("isMine") {
        forAll(
            row(UNKNOWN, false),
            row(MINE, true),
        ) { input, expected ->
            test("${input}타입인 cell은 mine이 ${expected}이다.") {
                val actual = Cell(0, 0, input, true).isMine()
                actual shouldBe expected
            }
        }
    }

    context("openCellType") {
        forAll(
            row(false, UNKNOWN),
            row(true, MINE),
        ) { input, expected ->
            test("isDisplayable이 ${input}일 때 ${expected}를 반환한다.") {
                val cell = Cell(0, 0, MINE, input)
                val actual = cell.openCellType()

                actual shouldBe expected
            }
        }
    }

    context("changeToMine") {
        test("지뢰로 변경한다.") {
            val cell = Cell(0, 0, UNKNOWN, true)
            cell.changeToMine()
            val actual = cell.openCellType()

            actual shouldBe MINE
        }
    }

    context("changeToDisplay") {
        test("이미 display 상태인데 변경하는 경우 예외가 발생한다.") {
            val cell = Cell(0, 0, MINE, true)
            val exception = shouldThrowExactly<IllegalStateException> { cell.changeToDisplay() }
            exception shouldHaveMessage "이미 Display 상태입니다."
        }

        test("isDisplay를 true로 변경한다.") {
            val cell = Cell(0, 0, MINE, false)
            cell.changeToDisplay()

            cell.isDisplay shouldBe true
        }
    }
})
