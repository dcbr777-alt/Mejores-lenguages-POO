// Tienda.scala
// Tienda con inventario simple en Scala
// Conceptos: trait, clase, extends, val/var

// TRAIT: en Scala es como interface en Java
trait OperacionesProducto {
  def vender(unidades: Int): Boolean
  def agregarStock(unidades: Int): Unit
  def mostrar(): Unit
}

// CLASE que implementa el trait con "extends"
class Producto(val nombre: String, val precio: Double, var cantidad: Int)
    extends OperacionesProducto {

  def vender(unidades: Int): Boolean = {
    if (unidades > cantidad) {
      println(s"Stock insuficiente. Solo hay $cantidad unidades.")
      false
    } else {
      cantidad -= unidades
      println(s"Venta de $unidades x $nombre = $${precio * unidades}")
      true
    }
  }

  def agregarStock(unidades: Int): Unit = {
    cantidad += unidades
    println(s"Stock actualizado: +$unidades $nombre")
  }

  def mostrar(): Unit = {
    println(s"Producto : $nombre")
    println(s"Precio   : $$$precio")
    println(s"Stock    : $cantidad unidades")
    println("--------------------")
  }
}

// OBJECT: punto de entrada en Scala (equivalente al main)
object Tienda extends App {
  val p1 = new Producto("Cuaderno",  3500.0, 10)
  val p2 = new Producto("Lapicero",   800.0, 50)
  val p3 = new Producto("Mochila",  45000.0,  5)

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
// scalac Tienda.scala
// scala Tienda
