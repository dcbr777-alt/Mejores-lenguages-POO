// Tienda.kt
// Tienda con inventario simple en Kotlin
// Conceptos: interface, clase, constructor primario, override

// INTERFACE: contrato que todo producto debe cumplir
interface OperacionesProducto {
    fun vender(unidades: Int): Boolean
    fun agregarStock(unidades: Int)
    fun mostrar()
}

// CLASE con constructor primario directo
// var = puede cambiar, val = no puede cambiar
class Producto(
    val nombre: String,
    val precio: Double,
    var cantidad: Int
) : OperacionesProducto {

    override fun vender(unidades: Int): Boolean {
        if (unidades > cantidad) {
            println("Stock insuficiente. Solo hay $cantidad unidades.")
            return false
        }
        cantidad -= unidades
        println("Venta de $unidades x $nombre = $${precio * unidades}")
        return true
    }

    override fun agregarStock(unidades: Int) {
        cantidad += unidades
        println("Stock actualizado: +$unidades $nombre")
    }

    override fun mostrar() {
        println("Producto : $nombre")
        println("Precio   : $$precio")
        println("Stock    : $cantidad unidades")
        println("--------------------")
    }
}

fun main() {
    // En Kotlin no se usa "new"
    val p1 = Producto("Cuaderno",  3500.0, 10)
    val p2 = Producto("Lapicero",   800.0, 50)
    val p3 = Producto("Mochila",  45000.0,  5)

    println("=== INVENTARIO INICIAL ===")
    p1.mostrar(); p2.mostrar(); p3.mostrar()

    println("=== VENTAS ===")
    p1.vender(3)
    p2.vender(10)
    p3.vender(10) // no hay suficiente stock

    println("\n=== INVENTARIO FINAL ===")
    p1.mostrar(); p2.mostrar(); p3.mostrar()
}

// COMPILAR Y EJECUTAR:
// kotlinc Tienda.kt -include-runtime -d tienda.jar
// java -jar tienda.jar
