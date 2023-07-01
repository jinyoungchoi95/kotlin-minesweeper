package minesweeper

@JvmInline
value class Height(
    val value: Int,
) {
    init {
        require(value > 0) { "높이는 0보다 커야 합니다." }
    }
}
