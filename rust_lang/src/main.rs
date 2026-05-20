// src/main.rs
// Tienda con inventario simple en Rust
// Conceptos: struct, trait, impl

// TRAIT: contrato que todo producto debe cumplir
trait OperacionesProducto {
    fn vender(&mut self, unidades: u32) -> bool;
    fn agregar_stock(&mut self, unidades: u32);
    fn mostrar(&self);
}

// STRUCT: equivalente a una clase
struct Producto {
    nombre:   String,
    precio:   f64,
    cantidad: u32,
}

// IMPL: métodos propios del struct
impl Producto {
    fn new(nombre: &str, precio: f64, cantidad: u32) -> Producto {
        Producto {
            nombre:   nombre.to_string(),
            precio,
            cantidad,
        }
    }
}

// Implementamos el TRAIT para Producto
impl OperacionesProducto for Producto {
    fn vender(&mut self, unidades: u32) -> bool {
        if unidades > self.cantidad {
            println!("Stock insuficiente. Solo hay {} unidades.", self.cantidad);
            return false;
        }
        self.cantidad -= unidades;
        println!("Venta de {} x {} = ${}", unidades, self.nombre, self.precio * unidades as f64);
        true
    }

    fn agregar_stock(&mut self, unidades: u32) {
        self.cantidad += unidades;
        println!("Stock actualizado: +{} {}", unidades, self.nombre);
    }

    fn mostrar(&self) {
        println!("Producto : {}", self.nombre);
        println!("Precio   : ${}", self.precio);
        println!("Stock    : {} unidades", self.cantidad);
        println!("--------------------");
    }
}

fn main() {
    // mut = la variable puede cambiar
    let mut p1 = Producto::new("Cuaderno",  3500.0, 10);
    let mut p2 = Producto::new("Lapicero",   800.0, 50);
    let mut p3 = Producto::new("Mochila",  45000.0,  5);

    println!("=== INVENTARIO INICIAL ===");
    p1.mostrar(); p2.mostrar(); p3.mostrar();

    println!("=== VENTAS ===");
    p1.vender(3);
    p2.vender(10);
    p3.vender(10); // no hay suficiente stock

    println!("\n=== INVENTARIO FINAL ===");
    p1.mostrar(); p2.mostrar(); p3.mostrar();
}


