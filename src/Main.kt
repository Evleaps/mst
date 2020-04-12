fun main() {

    val inf = Integer.MAX_VALUE

    val graph5 = listOf(
        //     1,  2,  3,  4,  5
        listOf(inf,1,  inf,5,  7  ), // 1
        listOf(1,  inf,1,  inf,inf), // 2
        listOf(inf,1,  inf,3,  1  ), // 3
        listOf(5,  inf,3,  inf,1  ), // 4
        listOf(7,  inf,1,  1,  inf)  // 5
    )

    val graph10_1 = listOf(
        //     1,2,3,4,5,6,7,8,9,10
        listOf(0,0,9,9,2,8,0,0,0,7), // 1
        listOf(0,0,0,0,0,0,0,0,4,5), // 2
        listOf(9,0,0,0,5,0,4,0,3,3), // 3
        listOf(9,0,0,0,2,3,5,4,0,3), // 4
        listOf(2,0,5,2,0,0,4,0,0,1), // 5
        listOf(8,0,0,3,0,0,2,4,0,1), // 6
        listOf(0,0,4,5,4,2,0,0,2,0), // 7
        listOf(0,0,0,4,0,4,0,0,5,0), // 8
        listOf(0,4,3,0,0,0,2,5,0,0), // 9
        listOf(7,5,3,3,1,1,0,0,0,0) // 10
    )

    val graph10_2 = listOf(
        //     1,  2,  3,  4,  5,  6,  7,  8,  9,   10
        listOf(inf,inf,9,  9,  2,  8,  inf,inf,inf,  7),  // 1
        listOf(inf,inf,inf,inf,inf,inf,inf,inf,4,    5),  // 2
        listOf(9  ,inf,inf,inf,5,  inf,4,  inf,3,    3),  // 3
        listOf(9  ,inf,inf,inf,2,  3,  5,  4,  inf,  3),  // 4
        listOf(2  ,inf,5,  2,  inf,inf,4,  inf,inf,  1),  // 5
        listOf(8  ,inf,inf,3,  inf,inf,2,  4,  inf,  1),  // 6
        listOf(inf,inf,4,  5,  4,  2,  inf,inf,  2,inf),  // 7
        listOf(inf,inf,inf,4,  inf,4,  inf,inf,5,  inf),  // 8
        listOf(inf,4,  3,  inf,inf,inf,  2,  5,inf,inf),  // 9
        listOf(7  ,5,  3,  3,  1,  1,  inf,inf,inf,inf)   // 10
    )

    val prim = PrimMst()

    val test1 = prim.mstPrim(graph5)
    println("grapg_5 | mst: ${test1.mst}, way: ${test1.way}")
    println()

    val test2 = prim.mstPrim(graph10_1)
    println("grapg_5 | mst: ${test2.mst}, way: ${test2.way}")
    println()

    val test3 = prim.mstPrim(graph10_2)
    println("grapg_5 | mst: ${test2.mst}, way: ${test2.way}")

}