package step4.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.throwable.shouldHaveMessage

class CellsTest : FunSpec({

    context("installMine") {
        test("입력된 지뢰 갯수가 0개 이하인 경우 예외가 발생한다.") {
            val cells = Cells(mapOf())
            val exception = shouldThrowExactly<IllegalArgumentException> { cells.installMine(0) }
            exception shouldHaveMessage "지뢰 갯수는 1개 이상이어야 합니다."
        }

        test("입력된 지뢰 갯수가 보유한 cell보다 많은 경우 예외가 발생한다.") {
            val cells = Cells(mapOf())
            val exception = shouldThrowExactly<IllegalArgumentException> { cells.installMine(1) }
            exception shouldHaveMessage "보유한 cell보다 많은 지뢰를 설치할 수 없습니다."
        }
    }
})
