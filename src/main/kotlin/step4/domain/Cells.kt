package step4.domain

@JvmInline
value class Cells(
    val values: Map<Coordinate, Cell>,
) {
    fun installMine(mineCount: Int) {
        require(mineCount >= MINIMUM_MINE_COUNT) { "지뢰 갯수는 ${MINIMUM_MINE_COUNT}개 이상이어야 합니다." }
        require(mineCount < values.size) { "보유한 cell보다 많은 지뢰를 설치할 수 없습니다." }
    }

    companion object {
        private const val MINIMUM_MINE_COUNT = 1
    }
}
