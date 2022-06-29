package dto

import domain.CoordinatePoint
import util.ConvertType

class LandMineMapRequest(val width: List<CoordinatePoint>, val height: List<CoordinatePoint>) {

    companion object {
        fun of(height: String, width: String): LandMineMapRequest {
            val xCoordinatePoints: List<CoordinatePoint> = List(ConvertType.int(width)) { CoordinatePoint(it + 1) }
            val yCoordinatePoints: List<CoordinatePoint> = List(ConvertType.int(height)) { CoordinatePoint(it + 1) }
            return LandMineMapRequest(xCoordinatePoints, yCoordinatePoints)
        }
    }
}