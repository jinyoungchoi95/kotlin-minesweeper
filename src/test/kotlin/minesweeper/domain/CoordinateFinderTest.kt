package minesweeper.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import minesweeper.domain.CoordinateFinder.Companion.nearCoordinates
import minesweeper.domain.CoordinateFinder.EAST
import minesweeper.domain.CoordinateFinder.NORTH
import minesweeper.domain.CoordinateFinder.NORTH_SOUTH
import minesweeper.domain.CoordinateFinder.NORTH_WEST
import minesweeper.domain.CoordinateFinder.SOUTH
import minesweeper.domain.CoordinateFinder.SOUTH_EAST
import minesweeper.domain.CoordinateFinder.SOUTH_WEST
import minesweeper.domain.CoordinateFinder.WEST
import minesweeper.domain.cell.Cell
import minesweeper.domain.cell.Coordinate

class CoordinateFinderTest : FunSpec({

    context("find") {
        forAll(
            row(SOUTH, Coordinate(2, 1)),
            row(SOUTH_WEST, Coordinate(2, 0)),
            row(WEST, Coordinate(1, 0)),
            row(NORTH_WEST, Coordinate(0, 0)),
            row(NORTH, Coordinate(0, 1)),
            row(NORTH_SOUTH, Coordinate(0, 2)),
            row(EAST, Coordinate(1, 2)),
            row(SOUTH_EAST, Coordinate(2, 2)),
        ) { input, expected ->
            test("${input}은 find 장소가 ${expected}이다.") {
                val actual = input.find(Coordinate(1, 1))
                actual shouldBe expected
            }
        }
    }

    context("nearCoordinates") {
        test("근처에 있는 모든 좌표를 반환할 수 있다.") {
            val actual = nearCoordinates(Cell(1, 1))

            actual shouldContainAll listOf(
                Coordinate(0, 0),
                Coordinate(0, 1),
                Coordinate(0, 2),
                Coordinate(1, 0),
                Coordinate(1, 2),
                Coordinate(2, 0),
                Coordinate(2, 1),
                Coordinate(2, 2),
            )
        }
    }
})
