import java.util.*

import java.util.Arrays.fill

class PrimMst {
    companion object {
        const val INF = Integer.MAX_VALUE / 2 // "Бесконечность"
        const val UNKNOWN_VERTEX = -1
    }

    /* Алгоритм Прима за O(V^2) */
    fun mstPrim(graph: List<List<Int>>): Result {
        val verticesNumber = graph.size
        val usedVertices = BooleanArray(verticesNumber) // массив меток
        val distance = IntArray(verticesNumber) // массив расстояния. dist[v] = вес_ребра(MST, v)
        val chosenVertices = mutableMapOf<Int, Pair<Int, Int>>()

        Arrays.fill(distance, INF) // устанаавливаем расстояние до всех вершин INF
        distance[0] = 0 // для начальной вершины положим 0

        fun getUnusedVertex(): Int {
            var v = UNKNOWN_VERTEX
            for (nv in 0 until verticesNumber) {
                // перебираем вершины
                if (!usedVertices[nv] && distance[nv] < INF && (v == UNKNOWN_VERTEX || distance[v] > distance[nv])) {
                    // выбираем самую близкую непомеченную вершину
                    v = nv
                }
            }
            return v
        }

        while (true) {
            val v = getUnusedVertex()
            if (v == UNKNOWN_VERTEX) break // ближайшая вершина не найдена

            usedVertices[v] = true // помечаем ее
            for (nv in 0 until verticesNumber) {
                if (!usedVertices[nv] && graph[v][nv] < INF) {
                    // улучшаем оценку расстояния (релаксация)
                    // либо уже сохраненная дистанция, либо новое значение
                    if (distance[nv] < graph[v][nv]) {
                        distance[nv] = distance[nv]
                        // chosenVertices[v] = nv
                    } else {
                        distance[nv] = graph[v][nv]
                        chosenVertices[nv] = Pair(v,nv)
                    }

                }
            }
        }

        chosenVertices
            .toSortedMap()
            .forEach { print("${it.key}:(${it.value.first.inc()}->${it.value.second.inc()}), ") }
            .also { println() }

        return Result(
            mst = distance.sum(),
            way =  chosenVertices.map { it.value }
        )
    }

    data class Result(
        val mst: Int,
        val way: List<Pair<Int, Int>>
    )
}